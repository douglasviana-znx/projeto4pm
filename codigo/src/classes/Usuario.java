package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Usuario {
    private int id;
    private String nome;
    private List<ItemBiblioteca> itensEmprestados;
    private List<ItemBiblioteca> itensAtrasados;

    public Usuario(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.itensEmprestados = new ArrayList<>();
        this.itensAtrasados = new ArrayList<>();
    }
    
    public Usuario() {
    	
    }

    public void setId(int id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<ItemBiblioteca> getItensEmprestados() {
        return itensEmprestados;
    }

    public List<ItemBiblioteca> getItensAtrasados() {
        return itensAtrasados;
    }

    public void emprestarItem(ItemBiblioteca item) {
        try {
            validarEmprestimo(item);
            itensEmprestados.add(item);
            item.realizarEmprestimo();
            System.out.println("Item emprestado para: " + nome);
        } catch (EmprestimoException e) {
            System.out.println("Erro ao tentar fazer o empréstimo: " + e.getMessage());
        }
    }

    private void validarEmprestimo(ItemBiblioteca item) throws EmprestimoException {
        if (itensEmprestados.contains(item)) {
            throw new EmprestimoException("Você já possui esse item emprestado.");
        }

        if (item.getQntExemplares() == 0) {
            throw new EmprestimoException("Não há exemplares disponíveis para empréstimo.");
        }

        if (itensEmprestados.size() >= 3) {
            throw new EmprestimoException("Você já possui 3 itens em sua posse.");
        }

        if (item.estaAtrasado()) {
            throw new EmprestimoException("Você possui algum livro em atraso.");
        }
    }

    public void devolverItem(ItemBiblioteca item) {
		// Lógica para devolver um item à biblioteca
        if (itensEmprestados.contains(item)) {
            itensEmprestados.remove(item);
            item.realizarDevolucao();
        }
    }

    public boolean verificarAtrasos() {
        // Lógica para verificar itens em atraso
        for (ItemBiblioteca item : itensEmprestados) {
            if (item.estaAtrasado()) {
                itensAtrasados.add(item);
                return true;
                
            }else {
            	return false;
            }
        }
		return false;
    }
    
    
}
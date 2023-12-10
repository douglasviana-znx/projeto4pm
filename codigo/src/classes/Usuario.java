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
        // Lógica para emprestar um item ao usuário
        if (item.disponivelEmprestimo()) {
            itensEmprestados.add((ItemBiblioteca) item);
            item.realizarEmprestimo();
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
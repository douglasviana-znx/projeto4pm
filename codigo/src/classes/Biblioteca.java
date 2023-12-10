package classes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Biblioteca {
    static List<ItemBiblioteca> itensBiblioteca;
    static List<Usuario> usuarios;

    public Biblioteca() {
        this.itensBiblioteca = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }
    
    public void relatorioQuantidadeEmprestimos() {
        System.out.println("Relatório por item - Quantidade de vezes emprestado:");
        for (ItemBiblioteca item : itensBiblioteca) {
            int emprestimos = contarEmprestimos(item);
            System.out.println("Item: " + item.getTitulo() + " - Empréstimos: " + emprestimos);
        }
    }

    private int contarEmprestimos(ItemBiblioteca item) {
        int emprestimos = 0;
        for (Usuario usuario : usuarios) {
            emprestimos += contarEmprestimosDoItemPorUsuario(item, usuario);
        }
        return emprestimos;
    }

    private int contarEmprestimosDoItemPorUsuario(ItemBiblioteca item, Usuario usuario) {
        return (int) usuario.getItensEmprestados().stream()
                .filter(i -> i.getId() == item.getId())
                .count();
    }

    public void relatorioItensPorUsuario() {
        System.out.println("\nRelatório por usuário - Itens emprestados:");
        for (Usuario usuario : usuarios) {
            System.out.println("Usuário: " + usuario.getNome());
            listarItensEmprestadosUsuario(usuario);
        }
    }

    private void listarItensEmprestadosUsuario(Usuario usuario) {
        for (ItemBiblioteca item : usuario.getItensEmprestados()) {
            System.out.println(" - " + item.getTitulo());
        }
    }

    public void cadastrarItem(ItemBiblioteca item) {
        itensBiblioteca.add(item);
        System.out.println("Item cadastrado na biblioteca: " + item.getTitulo());
    }

    public void removerItem(ItemBiblioteca item) {
        itensBiblioteca.remove(item);
        System.out.println("Item removido da biblioteca: " + item.getTitulo());
    }

    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("Usuário cadastrado na biblioteca: " + usuario.getNome());
    }

    public void removerUsuario(Usuario usuario) {
        usuarios.remove(usuario);
        System.out.println("Usuário removido da biblioteca: " + usuario.getNome());
    }

   

    public void listarUsuarios() {
        System.out.println("Lista de usuários da biblioteca:");
        for (Usuario usuario : usuarios) {
            System.out.println("ID: " + usuario.getId() + " | Nome: " + usuario.getNome());
        }
    }
    
    public static Usuario buscarPorId(int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
            	System.out.println("Usuario encontrado");
                return usuario;
            }else {
            	System.out.println("Usuario nao encontrado.");
            }
        }
        return null; // Retorna null se o usuário não for encontrado
    }
    public List<ItemBiblioteca> pesquisarPorTitulo() {
        return itensBiblioteca.stream()
                .sorted(Comparator.comparing(ItemBiblioteca::getTitulo))
                .collect(Collectors.toList());
    }

    // Método para pesquisar itens por autor
    public List<ItemBiblioteca> pesquisarPorAutor() {
        return itensBiblioteca.stream()
                .sorted(Comparator.comparing(ItemBiblioteca::getAutor))
                .collect(Collectors.toList());
    }

    // Método para pesquisar itens por ano de publicação
    public List<ItemBiblioteca> pesquisarPorAno() {
        return itensBiblioteca.stream()
                .sorted(Comparator.comparingInt(ItemBiblioteca::getAnoPublicacao))
                .collect(Collectors.toList());
    }

    // Método para pesquisar itens por tipo (exemplo: livro, revista, etc.)
    public List<ItemBiblioteca> pesquisarPorTipo(String tipo) {
        return itensBiblioteca.stream()
                .filter(item -> item.getClass().getSimpleName().equalsIgnoreCase(tipo))
                .collect(Collectors.toList());
    }

    
    public static Item buscarPorIdItem( int id) {
        for (ItemBiblioteca item : itensBiblioteca) {
            if (item.getId() == id) {
            	System.out.println("Item encontrado.");
                return (Item) item;
            }else {
            	System.out.println("Item nao encontrado.");
            }
        }
        return null; // Retorna null se o item não for encontrado
    }
}
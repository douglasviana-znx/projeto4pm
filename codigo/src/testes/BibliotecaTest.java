package testes;
import classes.Biblioteca;
import classes.EmprestimoException;
import classes.Item;
import classes.Usuario;
import classes.EmprestimoException;

import static org.junit.Assert.*;
import org.junit.Test;

public class BibliotecaTest {

    @Test
    public void testCadastrarItem() {
        // Cria uma biblioteca
        Biblioteca biblioteca = new Biblioteca();

        // Cadastra um item
        Item item = new Item(1, "Livro", "Autor 1", 2000, 3, true, 10);
        biblioteca.cadastrarItem(item);

        // Verifica se o item está na biblioteca
        assertEquals(item, biblioteca.buscarPorIdItem(1));
    }

    @Test
    public void testRemoverItem() {
        // Cria uma biblioteca
        Biblioteca biblioteca = new Biblioteca();

        // Cadastra e remove um item
        Item item = new Item(1, "Livro", "Autor 1", 2000, 3, true, 10);
        biblioteca.cadastrarItem(item);
        biblioteca.removerItem(item);

        // Verifica se o item foi removido
        assertNull(biblioteca.buscarPorIdItem(1));
    }

    @Test
    public void testCadastrarUsuario() {
        // Cria uma biblioteca
        Biblioteca biblioteca = new Biblioteca();

        // Cadastra um usuário
        Usuario usuario = new Usuario(1, "Usuário 1");
        biblioteca.cadastrarUsuario(usuario);

        // Verifica se o usuário está na biblioteca
        assertEquals(usuario, biblioteca.buscarPorId(1));
    }

    // Testes similares para outras funcionalidades...
    
    @Test
    public void testAdicaoItemBiblioteca() {
        Biblioteca biblioteca = new Biblioteca();
        Item item = new Item(1, "Livro", "Autor 1", 2000, 3, true, 10);

        biblioteca.cadastrarItem(item);

        assertEquals(item, biblioteca.buscarPorIdItem(1));
    }

    @Test
    public void testRemocaoItemBiblioteca() {
        Biblioteca biblioteca = new Biblioteca();
        Item item = new Item(1, "Livro", "Autor 1", 2000, 3, true, 10);

        biblioteca.cadastrarItem(item);
        biblioteca.removerItem(item);

        assertNull(biblioteca.buscarPorIdItem(1));
    }

    @Test
    public void testEmprestimoItemUsuario() {
        Biblioteca biblioteca = new Biblioteca();
        Item item = new Item(1, "Livro", "Autor 1", 2000, 3, true, 10);
        Usuario usuario = new Usuario(1, "Usuário 1");

        biblioteca.cadastrarItem(item);
        biblioteca.cadastrarUsuario(usuario);

        usuario.emprestarItem(item);

        assertTrue(usuario.getItensEmprestados().contains(item));
    }

    @Test
    public void testRelatorioQuantidadeEmprestimos() {
        // Implemente o teste do relatório por item aqui
        // Verifique se a contagem de empréstimos por item está correta
    }

    @Test
    public void testPesquisaPorTitulo() {
        Biblioteca biblioteca = new Biblioteca();
        Item item = new Item(1, "Livro", "Autor 1", 2000, 3, true, 10);

        biblioteca.cadastrarItem(item);

        assertEquals(item, biblioteca.pesquisarPorTitulo().get(0));
    }
    
    @Test
    public void testarEmprestimoItemRepetido() {
        Usuario usuario = new Usuario(1, "Usuário Teste");
        ItemBiblioteca item1 = new Item(1, "Livro", "Autor 1", 2000, 3, true, 10);
        
        // Empresta o item pela primeira vez (deve ser bem-sucedido)
        try {
            usuario.emprestarItem(item1);
        } catch (EmprestimoException e) {
            fail("Não deveria lançar uma exceção para o primeiro empréstimo.");
        }

        // Tenta emprestar o mesmo item novamente (deve lançar EmprestimoException)
        try {
            usuario.emprestarItem(item1);
            fail("Deveria lançar uma exceção para item repetido.");
        } catch (EmprestimoException e) {
            // Sucesso: a exceção foi lançada corretamente.
            System.out.println("Exceção capturada: " + e.getMessage());
        }
    }
}
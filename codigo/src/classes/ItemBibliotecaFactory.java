package classes;

public interface ItemBibliotecaFactory {
    ItemBiblioteca criarItemBiblioteca(int id, String tipo, String titulo, String autor, int anoPublicacao, int qntExemplares, boolean emprestavel, int diasPrazo);
}
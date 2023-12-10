package classes;

public interface ItemBiblioteca {
    int getId();
    String getTitulo();
    String getAutor();
    int getAnoPublicacao();
    int getQntExemplares();
    boolean isEmprestavel();
    int getDiasPrazo();
	int getQuantidadeDisponivel();
	boolean disponivelEmprestimo();
	void realizarEmprestimo();
	void realizarDevolucao();
	boolean estaAtrasado();
 }


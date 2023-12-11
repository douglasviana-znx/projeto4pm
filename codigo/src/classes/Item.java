package classes;

public class Item implements ItemBiblioteca {
    private int id;
    public void setId(int id) {
		this.id = id;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public void setAnoPublicacao(int anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}

	public void setQntExemplares(int qntExemplares) {
		this.qntExemplares = qntExemplares;
	}
	
	


	private String titulo;
    private String autor;
    private int anoPublicacao;
    private int qntExemplares;

    public Item(int id, String titulo, String autor, int anoPublicacao, int qntExemplares, boolean emprestavel, int diasPrazo) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.qntExemplares = qntExemplares;
    }
    
    public Item() {
    	
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getTitulo() {
        return titulo;
    }

    @Override
    public String getAutor() {
        return autor;
    }

    @Override
    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    @Override
    public int getQntExemplares() {
        return qntExemplares;
    }


	@Override
	public int getQuantidadeDisponivel() {
		return 0;
	}

	@Override
	public boolean estaAtrasado() {
		return false;
	}

	@Override
	public int getDiasPrazo() {
				return 0;
	}

	@Override
	public boolean disponivelEmprestimo() {
		return false;
	}

	@Override
	public boolean isEmprestavel() {
		return false;
	}

	@Override
	public void realizarEmprestimo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void realizarDevolucao() {
		// TODO Auto-generated method stub
		
	}
	
}
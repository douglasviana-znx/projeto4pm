package classes;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
    	Biblioteca biblioteca = new Biblioteca();
    	Item item1 = new Item(1, "Livro", "Autor 1", 2000, 3, true, 10);
        Item item2 = new Item(2, "Revista", "Autor 2", 2005, 2, false, 0);
        Item item3 = new Item(3, "Tese", "Autor 3", 1999, 3, false, 0);
        Item item4 = new Item(4, "CD", "Autor 2", 2005, 4, true, 10);
        Usuario usuario1 = new Usuario(1, "Usuário 1");
        Usuario usuario2 = new Usuario(2, "Usuário 2");
        Usuario usuario3 = new Usuario(3, "Usuário 3");
        Usuario usuario4 = new Usuario(4, "Usuário 4");

        biblioteca.cadastrarItem(item1);
        biblioteca.cadastrarItem(item2);
        biblioteca.cadastrarItem(item3);
        biblioteca.cadastrarItem(item4);
        biblioteca.cadastrarUsuario(usuario1);
        biblioteca.cadastrarUsuario(usuario2);
        biblioteca.cadastrarUsuario(usuario3);
        biblioteca.cadastrarUsuario(usuario4);
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("### Menu Principal ###");
            System.out.println("1. Gerenciar Itens da Biblioteca");
            System.out.println("2. Gerenciar Usuários");
            System.out.println("3. Pesquisar Itens");
            System.out.println("4. Empréstimo de Itens");
            System.out.println("5. Emitir Relatórios");
            System.out.println("6. Sair do Sistema");
            System.out.print("Escolha a opção desejada: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                	System.out.println("1. Adicionar item");
                    System.out.println("2. Remover item");
                    Scanner caseone = new Scanner(System.in);
                    if(caseone.equals(1)) {
                    	Item novoItem = new Item();
                    	System.out.println("Digite o nome do item");
                        String nome = MyIO.readString();
                        novoItem.setTitulo(nome);
                        double doubleRandomNumber = Math.random() * 5;
                        int randomNumber = (int)doubleRandomNumber;
                        novoItem.setId(randomNumber);
                        biblioteca.cadastrarItem(novoItem);
                        System.out.println("Digite o nome do autor");
                        String autor = MyIO.readString();
                        System.out.println("Qual o ano da publicação?");
                        int ano = MyIO.readInt();
                        biblioteca.cadastrarItem(novoItem);
                        System.out.println("Item" +novoItem.getTitulo()+ "cadastrado");
                        
                    }else if(caseone.equals(2)) {
                    	System.out.println("Digite o id do item");
                    	int id = MyIO.readInt();
                    	Item itemEncontrado = biblioteca.buscarPorIdItem(id);
                    	biblioteca.removerItem(itemEncontrado);
                    	System.out.println("Item:"+itemEncontrado+" removido");
                    }
                    else {
                    	System.out.println("Comando inválido");
                    }
                    break;
                 
                case 2:
                    // Opção para gerenciar usuários
                	
                	System.out.println("1. Adicionar usuario");
                    System.out.println("2. Remover usuário");
                    System.out.println("3. Notificar usuário ");
                    Scanner casetwo = new Scanner(System.in);
                    if(casetwo.equals(1)) {
                    	Usuario novoUsuario = new Usuario();
                    	System.out.println("Digite o nome do usuario");
                        String nome = MyIO.readString();
                        novoUsuario.setNome(nome);
                        double doubleRandomNumber = Math.random() * 5;
                        int randomNumber = (int)doubleRandomNumber;
                        novoUsuario.setId(randomNumber);
                        biblioteca.cadastrarUsuario(novoUsuario);
                        System.out.println("Usuario cadastrado.");
                    }else if(casetwo.equals(2)) {
                    	System.out.println("Digite o id do usuário");
                    	int id = MyIO.readInt();
                    	Usuario usuarioEncontrado = Biblioteca.buscarPorId(id);
                    	biblioteca.removerUsuario(usuarioEncontrado);
                    	System.out.println("Usuario "+usuarioEncontrado.getNome()+ "encontrado.");
                    }else if(casetwo.equals(3)) {
                    	System.out.println("Verifique os atrasos de um usuário. Digite o nome:");
                    	int id = MyIO.readInt();
                    	Usuario usuarioEncontrado = biblioteca.buscarPorId(id);
                    	if(usuarioEncontrado.verificarAtrasos() == true) {
                    		System.out.println("Usuario tem atrasos.");
                    	}
                    }else {
                    	System.out.println("Comando inválido");
                    }
                    break;
                case 3:
                	 Scanner scanner1 = new Scanner(System.in);

                     System.out.println("Selecione o critério de pesquisa:");
                     System.out.println("1. Por título");
                     System.out.println("2. Por autor");
                     System.out.println("3. Por ano de publicação");
                     System.out.println("4. Por tipo de item");
                     int opcao1 = scanner1.nextInt();

                     switch (opcao1) {
                         case 1:
                             System.out.println("Pesquisa por título:");
                             for (ItemBiblioteca item : biblioteca.pesquisarPorTitulo()) {
                                 System.out.println(item.getTitulo());
                             }
                             break;

                         case 2:
                             System.out.println("Pesquisa por autor:");
                             for (ItemBiblioteca item : biblioteca.pesquisarPorAutor()) {
                                 System.out.println(item.getAutor());
                             }
                             break;

                         case 3:
                             System.out.println("Pesquisa por ano de publicação:");
                             for (ItemBiblioteca item : biblioteca.pesquisarPorAno()) {
                                 System.out.println(item.getAnoPublicacao());
                             }
                             break;

                         case 4:
                             System.out.println("Pesquisa por tipo (exemplo: Livro):");
                             scanner1.nextLine(); // Consumir a quebra de linha pendente
                             String tipo = scanner1.nextLine();
                             for (ItemBiblioteca item : biblioteca.pesquisarPorTipo(tipo)) {
                                 System.out.println(item.getTitulo());
                             }
                             break;

                         default:
                             System.out.println("Opção inválida.");
                             break;
                     }
                 
                    
                    break;
                case 4:
                	// Simulando empréstimo de um item pelo usuário
                    System.out.println("Empréstimo de item:");
                    System.out.println("Selecione o item a ser emprestado (digite o ID):");
                    int itemID = MyIO.readInt();
                    ItemBiblioteca itemSelecionado = biblioteca.buscarPorIdItem(itemID);

                    if (itemSelecionado != null && itemSelecionado.isEmprestavel()) {
                        System.out.println("Selecione o usuário para empréstimo (digite o ID):");
                        int userID = MyIO.readInt();
                        Usuario usuarioSelecionado = biblioteca.buscarPorId(userID);

                        if (usuarioSelecionado != null) {
                            usuarioSelecionado.emprestarItem(itemSelecionado);
                            System.out.println("Item emprestado para: " + usuarioSelecionado.getNome());
                        } else {
                            System.out.println("Usuário não encontrado.");
                        }
                    } else {
                        System.out.println("Item não pode ser emprestado.");
                    }
                
                    break;
                case 5:
                    // Opção para emitir relatórios
                	
                	System.out.println("Relatório por item - Quantidade de vezes emprestado:");
                    List<ItemBiblioteca> itensOrdenadosPorAno = biblioteca.pesquisarPorAno();
                    for (ItemBiblioteca item : itensOrdenadosPorAno) {
                        int quantidadeEmprestimos = 0;

                        for (Usuario usuario : biblioteca.usuarios) {
                            for (ItemBiblioteca emprestado : usuario.getItensEmprestados()) {
                                if (emprestado.getId() == item.getId()) {
                                    quantidadeEmprestimos++;
                                }
                            }
                        }
                        System.out.println("Item: " + item.getTitulo() + " - Empréstimos: " + quantidadeEmprestimos);
                    }

                    // Relatório por usuário
                    System.out.println("\nRelatório por usuário - Itens emprestados:");
                    for (Usuario usuario : biblioteca.usuarios) {
                        System.out.println("Usuário: " + usuario.getNome());
                        List<ItemBiblioteca> itensEmprestados = usuario.getItensEmprestados()
                                .stream()
                                .sorted(Comparator.comparing(ItemBiblioteca::getTitulo))
                                .collect(Collectors.toList());

                        for (ItemBiblioteca item : itensEmprestados) {
                            System.out.println(" - " + item.getTitulo());
                        }
                    }
                    break;
                case 6:
                    System.out.println("Saindo do Sistema. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Escolha novamente.");
            }
        } while (opcao != 6);
        scanner.close();
    }
}

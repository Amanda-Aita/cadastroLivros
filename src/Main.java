import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Livro> listaLivro = new ArrayList<>();

        System.out.println("Bem vindo ao sistema de cadastro de Livros do Sebo");

        Scanner scanner = new Scanner(System.in);

        int opcao;

        do {

            System.out.println("Escolha uma opção: 1 - Cadastrar / 2 - Listar Livros / 0 - Sair");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 0:
                    System.out.println("Saindo ...");

                    break;


                case 1:
                    System.out.println("Cadastrar");

                    Livro novoLivro = new Livro();
                    Autor novoAutor = new Autor();

                    System.out.println("Livro que você deseja cadastrar foi lançado a mais de 5 anos  [S/N]" );
                    String testeLancamentoLivro = scanner.next();

                    if (testeLancamentoLivro.equalsIgnoreCase("S")){
                        System.out.println("Qual titulo do livro: ");
                        novoLivro.titulo = scanner.next();

                        System.out.println("Qual é o preço do livro ?");
                        novoLivro.preco = scanner.nextInt();

                        System.out.println("Qual é a data do lançamento do livro ?");
                        LocalDate dateLancamento = LocalDate.parse(scanner.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                        System.out.println("Qual nome do autor ?");
                        novoAutor.nomeAutor = scanner.next();

                        System.out.println("Qual local nasceu o autor ?");
                        novoAutor.localNasc = scanner.next();

                        novoLivro.autor = novoAutor;
                        listaLivro.add(novoLivro);

                        System.out.println("Cadastro realizado com sucesso !");
                        break;
                    }else {
                        System.out.println("O sistema so permite cadastro de livros com mais de 5 anos de lançamenton !");
                        break;
                    }

                    // Fim case 1


                case 2:
                    System.out.println("Listar Livros");

                    if (listaLivro.size() > 0){
                        for (Livro cadaLivro : listaLivro) {
                            System.out.println("Titulo: " + cadaLivro.titulo);
                            System.out.println("Preço: " + cadaLivro.preco);
                            System.out.println("Autor: " + cadaLivro.autor.nomeAutor);

                        }
                    }else {
                        System.out.println("nenhum livro cadastrado !");

                    }


                    break;


                default:
                    System.out.println("Opção invalida !");
                    break;

            }
        } while (opcao != 0);
    }
}
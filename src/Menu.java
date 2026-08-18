import java.util.Scanner;

public class Menu {

    private final CatalogoJogos catalogo;
    private final Scanner scanner;

    public Menu() {
        this.catalogo = new CatalogoJogos();
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {

        int opcao = -1;

        while (opcao != 0) {

            exibirMenu();

            opcao = lerInteiro("Escolha uma opção: ");

            System.out.println();

            switch (opcao) {

                case 1:
                    cadastrarJogo();
                    break;

                case 2:
                    removerJogo();
                    break;

                case 3:
                    buscarJogo();
                    break;

                case 4:
                    catalogo.listar();
                    break;

                case 5:
                    catalogo.mostrarStatus();
                    break;

                case 6:
                    navegarCatalogo();
                    break;

                case 0:
                    System.out.println(
                            "Encerrando o GameChain..."
                    );
                    break;

                default:
                    System.out.println(
                            "Opção inválida."
                    );
            }
        }
    }


    // =========================
    // MENU PRINCIPAL
    // =========================

    private void exibirMenu() {

        System.out.println(
                "\n=== GAMECHAIN ==="
        );

        System.out.println(
                "1 - Cadastrar jogo"
        );

        System.out.println(
                "2 - Remover jogo"
        );

        System.out.println(
                "3 - Buscar jogo"
        );

        System.out.println(
                "4 - Mostrar catálogo"
        );

        System.out.println(
                "5 - Mostrar status"
        );

        System.out.println(
                "6 - Navegar pelo catálogo"
        );

        System.out.println(
                "0 - Sair"
        );
    }


    // =========================
    // CADASTRO
    // =========================

    private void cadastrarJogo() {

        System.out.println(
                "=== CADASTRAR JOGO ==="
        );

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Gênero: ");
        String genero = scanner.nextLine();

        System.out.print("Plataforma: ");
        String plataforma = scanner.nextLine();

        int ano = lerInteiro("Ano: ");

        double nota = lerDouble("Nota: ");

        Jogo jogo = new Jogo(
                nome,
                genero,
                plataforma,
                ano,
                nota
        );

        catalogo.inserirOrdenado(jogo);

        System.out.println(
                "\nJogo cadastrado com sucesso!"
        );
    }


    // =========================
    // REMOÇÃO
    // =========================

    private void removerJogo() {

        if (catalogo.estaVazio()) {

            System.out.println(
                    "O catálogo está vazio."
            );

            return;
        }

        System.out.print(
                "Digite o nome do jogo que deseja remover: "
        );

        String nome = scanner.nextLine();

        boolean removido =
                catalogo.removerPorNome(nome);

        if (removido) {

            System.out.println(
                    "Jogo removido com sucesso!"
            );

        } else {

            System.out.println(
                    "Jogo não encontrado."
            );
        }
    }


    // =========================
    // BUSCA
    // =========================

    private void buscarJogo() {

        if (catalogo.estaVazio()) {
            System.out.println("O catálogo está vazio.");
            return;
        }

        System.out.print("Digite o nome do jogo: ");
        String nome = scanner.nextLine();

        Jogo encontrado = catalogo.buscarPorNome(nome);

        if (encontrado == null) {
            System.out.println("Jogo não encontrado.");
            return;
        }

        System.out.println("\n=== JOGO ENCONTRADO ===");
        System.out.println("Nome: " + encontrado.getNome());
        System.out.println("Gênero: " + encontrado.getGenero());
        System.out.println("Plataforma: " + encontrado.getPlataforma());
        System.out.println("Ano: " + encontrado.getAno());
        System.out.println("Nota: " + encontrado.getNota());
    }

    // =========================
    // NAVEGAÇÃO
    // =========================

    private void navegarCatalogo() {

        if (catalogo.estaVazio()) {

            System.out.println(
                    "O catálogo está vazio."
            );

            return;
        }

        No atual = catalogo.getInicio();

        int opcao = -1;

        while (opcao != 0) {

            mostrarJogoAtual(atual);

            System.out.println(
                    "\n1 - Próximo jogo"
            );

            System.out.println(
                    "2 - Jogo anterior"
            );

            System.out.println(
                    "0 - Voltar ao menu"
            );

            opcao = lerInteiro(
                    "Escolha uma opção: "
            );

            switch (opcao) {

                case 1:
                    atual = atual.getProximo();
                    break;

                case 2:
                    atual = atual.getAnterior();
                    break;

                case 0:
                    break;

                default:
                    System.out.println(
                            "Opção inválida."
                    );
            }
        }
    }


    private void mostrarJogoAtual(No atual) {

        Jogo jogo = atual.getJogo();

        System.out.println(
                "\n=============================="
        );

        System.out.println(
                "       JOGO ATUAL"
        );

        System.out.println(
                "=============================="
        );

        System.out.println(
                "Nome: " + jogo.getNome()
        );

        System.out.println(
                "Gênero: " + jogo.getGenero()
        );

        System.out.println(
                "Plataforma: " + jogo.getPlataforma()
        );

        System.out.println(
                "Ano: " + jogo.getAno()
        );

        System.out.println(
                "Nota: " + jogo.getNota()
        );
    }


    // =========================
    // LEITURA DE NÚMEROS
    // =========================

    private int lerInteiro(String mensagem) {

        while (true) {

            try {

                System.out.print(mensagem);

                return Integer.parseInt(
                        scanner.nextLine()
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Digite um número inteiro válido."
                );
            }
        }
    }


    private double lerDouble(String mensagem) {

        while (true) {

            try {

                System.out.print(mensagem);

                String entrada =
                        scanner.nextLine()
                                .replace(",", ".");

                return Double.parseDouble(entrada);

            } catch (NumberFormatException e) {

                System.out.println(
                        "Digite um número válido."
                );
            }
        }
    }
}
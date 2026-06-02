import java.util.Scanner;

public class AgendaContatos {

    static Contato[] contatos = new Contato[100];
    static int total = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== AGENDA DE CONTATOS ===");
            System.out.println("1 - Adicionar contato");
            System.out.println("2 - Listar contatos");
            System.out.println("3 - Buscar contato");
            System.out.println("4 - Alterar contato");
            System.out.println("5 - Excluir contato");
            System.out.println("6 - Relatório");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch(opcao) {
                case 1:
                    adicionarContato(sc);
                    break;

                case 2:
                    listarContatos();
                    break;

                case 3:
                    buscarContato(sc);
                    break;

                case 4:
                    alterarContato(sc);
                    break;

                case 5:
                    excluirContato(sc);
                    break;

                case 6:
                    relatorio();
                    break;

                case 0:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while(opcao != 0);

        sc.close();
    }

    public static void adicionarContato(Scanner sc) {

        if(total >= contatos.length) {
            System.out.println("Agenda cheia!");
            return;
        }

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Telefone: ");
        String telefone = sc.nextLine();

        System.out.print("E-mail: ");
        String email = sc.nextLine();

        if(nome.isEmpty() || telefone.isEmpty() || email.isEmpty()) {
            System.out.println("Nenhum campo pode ficar vazio!");
            return;
        }

        contatos[total] = new Contato(nome, telefone, email);
        total++;

        System.out.println("Contato cadastrado com sucesso!");
    }

    public static void listarContatos() {

        if(total == 0) {
            System.out.println("Nenhum contato cadastrado.");
            return;
        }

        for(int i = 0; i < total; i++) {
            System.out.println("\nContato " + (i + 1));
            System.out.println("Nome: " + contatos[i].getNome());
            System.out.println("Telefone: " + contatos[i].getTelefone());
            System.out.println("E-mail: " + contatos[i].getEmail());
        }
    }

    public static void buscarContato(Scanner sc) {

        System.out.print("Digite o nome: ");
        String nome = sc.nextLine();

        for(int i = 0; i < total; i++) {
            if(contatos[i].getNome().equalsIgnoreCase(nome)) {

                System.out.println("\nContato encontrado:");
                System.out.println("Nome: " + contatos[i].getNome());
                System.out.println("Telefone: " + contatos[i].getTelefone());
                System.out.println("E-mail: " + contatos[i].getEmail());

                return;
            }
        }

        System.out.println("Contato não encontrado.");
    }

    public static void alterarContato(Scanner sc) {

        System.out.print("Nome do contato: ");
        String nome = sc.nextLine();

        for(int i = 0; i < total; i++) {

            if(contatos[i].getNome().equalsIgnoreCase(nome)) {

                System.out.print("Novo telefone: ");
                contatos[i].setTelefone(sc.nextLine());

                System.out.print("Novo e-mail: ");
                contatos[i].setEmail(sc.nextLine());

                System.out.println("Contato atualizado!");
                return;
            }
        }

        System.out.println("Contato não encontrado.");
    }

    public static void excluirContato(Scanner sc) {

        System.out.print("Nome do contato: ");
        String nome = sc.nextLine();

        for(int i = 0; i < total; i++) {

            if(contatos[i].getNome().equalsIgnoreCase(nome)) {

                for(int j = i; j < total - 1; j++) {
                    contatos[j] = contatos[j + 1];
                }

                contatos[total - 1] = null;
                total--;

                System.out.println("Contato removido!");
                return;
            }
        }

        System.out.println("Contato não encontrado.");
    }

    public static void relatorio() {

        System.out.println("\n=== RELATÓRIO ===");
        System.out.println("Total de contatos cadastrados: " + total);
    }
}

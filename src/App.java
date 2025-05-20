import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ListaDeContatos lista = new ListaDeContatos();
        try (Scanner sc = new Scanner(System.in)) {
            char opcao;
            
            do {
                System.out.println("\n--- MENU AGENDA ---");
                System.out.println("1 - Criar contato");
                System.out.println("2 - Listar contatos");
                System.out.println("3 - Alterar contato (por Nome ou ID)");
                System.out.println("4 - Apagar contato (por Nome ou ID)");
                System.out.println("5 - Restaurar contato (por Nome ou ID)");
                System.out.println("6 - Buscar por nome");
                System.out.println("7 - Buscar por email");
                System.out.println("8 - Buscar por WhatsApp");
                System.out.println("0 - Sair");
                System.out.print("Escolha: ");
                opcao = sc.next().charAt(0);
                sc.nextLine(); // limpar buffer
                
                switch (opcao) {
                    case '1' -> {
                        System.out.print("Nome: ");
                        String nome = sc.nextLine();
                        System.out.print("Email: ");
                        String email = sc.nextLine();
                        System.out.print("WhatsApp: ");
                        String whatsApp = sc.nextLine();
                        lista.criarContato(nome, email, whatsApp);
                    }
                    case '2' -> lista.listarContatos();
                    case '3' -> {
                        Contato c = buscarContatoPorNomeOuId(lista, sc, "alterar");
                        if (c != null) {
                            System.out.print("Novo nome: ");
                            String novoNome = sc.nextLine();
                            System.out.print("Novo email: ");
                            String novoEmail = sc.nextLine();
                            System.out.print("Novo WhatsApp: ");
                            String novoWhatsApp = sc.nextLine();
                            c.alterarContato(novoNome, novoEmail, novoWhatsApp);
                            System.out.println("Contato alterado com sucesso.");
                        } else {
                            System.out.println("Contato não encontrado.");
                        }
                    }
                    case '4' -> {
                        Contato c = buscarContatoPorNomeOuId(lista, sc, "apagar");
                        if (c != null) {
                            c.apagarContato();
                            System.out.println("Contato apagado com sucesso.");
                        } else {
                            System.out.println("Contato não encontrado.");
                        }
                    }
                    case '5' -> {
                        Contato c = buscarContatoPorNomeOuId(lista, sc, "restaurar");
                        if (c != null) {
                            c.restaurarContato();
                            System.out.println("Contato restaurado com sucesso.");
                        } else {
                            System.out.println("Contato não encontrado.");
                        }
                    }
                    case '6' -> {
                        System.out.print("Nome: ");
                        String nome = sc.nextLine();
                        Contato c = lista.buscarContatoPorNome(nome);
                        if (c != null) c.mostrarStatus();
                        else System.out.println("Contato não encontrado.");
                    }
                    case '7' -> {
                        System.out.print("Email: ");
                        String email = sc.nextLine();
                        Contato c = lista.buscarContatoPorEmail(email);
                        if (c != null) c.mostrarStatus();
                        else System.out.println("Contato não encontrado.");
                    }
                    case '8' -> {
                        System.out.print("WhatsApp: ");
                        String whatsApp = sc.nextLine();
                        Contato c = lista.buscarContatoPorWhatsApp(whatsApp);
                        if (c != null) c.mostrarStatus();
                        else System.out.println("Contato não encontrado.");
                    }
                    case '0' -> System.out.println("Saindo...");
                    default -> System.out.println("Opção inválida.");
                }
                
            } while (opcao != '0');
        }
    }

    private static Contato buscarContatoPorNomeOuId(ListaDeContatos lista, Scanner sc, String acao) {
        System.out.printf("Deseja %s por:\n1 - Nome\n2 - ID\nEscolha: ", acao);
        String escolha = sc.nextLine();
        Contato c = null;

        switch (escolha) {
            case "1" -> {
                System.out.print("Digite o nome: ");
                String nome = sc.nextLine().trim();
                c = lista.buscarContatoPorNome(nome);
            }
            case "2" -> {
                try {
                    System.out.print("Digite o ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    c = lista.buscarContatoPorId(id);
                } catch (NumberFormatException e) {
                    System.out.println("ID inválido.");
                }
            }
            default -> System.out.println("Opção inválida.");
        }

        return c;
    }
}
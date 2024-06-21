import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DatabaseConnection dbConnection = new DatabaseConnection();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Consultar Cliente");
            System.out.println("3 - Atualizar Cliente");
            System.out.println("4 - Excluir Cliente");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarCliente(scanner, dbConnection);
                    break;
                case 2:
                    consultarCliente(scanner, dbConnection);
                    break;
                case 3:
                    atualizarCliente(scanner, dbConnection);
                    break;
                case 4:
                    excluirCliente(scanner, dbConnection);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    dbConnection.close();
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void cadastrarCliente(Scanner scanner, DatabaseConnection dbConnection) {
        System.out.println("Cadastro de Cliente:");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Cidade: ");
        String cidade = scanner.nextLine();
        System.out.print("Estado: ");
        String estado = scanner.nextLine();
        System.out.print("CEP: ");
        String cep = scanner.nextLine();
        
        Cliente cliente = new Cliente(0, nome, email, telefone, endereco, cidade, estado, cep, null);
        dbConnection.inserirCliente(cliente);
    }

    private static void consultarCliente(Scanner scanner, DatabaseConnection dbConnection) {
        System.out.println("Consulta de Cliente:");
        System.out.print("ID do Cliente: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consumir a nova linha
        
        Cliente cliente = dbConnection.consultarCliente(id);
        if (cliente != null) {
            System.out.println(cliente);
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private static void atualizarCliente(Scanner scanner, DatabaseConnection dbConnection) {
        System.out.println("Atualização de Cliente:");
        System.out.print("ID do Cliente: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        Cliente cliente = dbConnection.consultarCliente(id);
        if (cliente != null) {
            System.out.print("Nome (" + cliente.getNome() + "): ");
            String nome = scanner.nextLine();
            System.out.print("Email (" + cliente.getEmail() + "): ");
            String email = scanner.nextLine();
            System.out.print("Telefone (" + cliente.getTelefone() + "): ");
            String telefone = scanner.nextLine();
            System.out.print("Endereço (" + cliente.getEndereco() + "): ");
            String endereco = scanner.nextLine();
            System.out.print("Cidade (" + cliente.getCidade() + "): ");
            String cidade = scanner.nextLine();
            System.out.print("Estado (" + cliente.getEstado() + "): ");
            String estado = scanner.nextLine();
            System.out.print("CEP (" + cliente.getCep() + "): ");
            String cep = scanner.nextLine();

            cliente.setNome(nome.isEmpty() ? cliente.getNome() : nome);
            cliente.setEmail(email.isEmpty() ? cliente.getEmail() : email);
            cliente.setTelefone(telefone.isEmpty() ? cliente.getTelefone() : telefone);
            cliente.setEndereco(endereco.isEmpty() ? cliente.getEndereco() : endereco);
            cliente.setCidade(cidade.isEmpty() ? cliente.getCidade() : cidade);
            cliente.setEstado(estado.isEmpty() ? cliente.getEstado() : estado);
            cliente.setCep(cep.isEmpty() ? cliente.getCep() : cep);

            dbConnection.atualizarCliente(cliente);
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private static void excluirCliente(Scanner scanner, DatabaseConnection dbConnection) {
        System.out.println("Exclusão de Cliente:");
        System.out.print("ID do Cliente: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        dbConnection.excluirCliente(id);
    }
}

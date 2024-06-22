package sistema_vendas;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static ClienteDAO clienteDAO = new ClienteDAO();
    private static ProdutoDAO produtoDAO = new ProdutoDAO();
    private static VendaDAO vendaDAO = new VendaDAO();

    public static void main(String[] args) {
        int opcao;
        do {
            exibirMenu();
            System.out.print("Digite a opção desejada: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    consultarClientes();
                    break;
                case 3:
                    atualizarCliente();
                    break;
                case 4:
                    excluirCliente();
                    break;
                case 5:
                    cadastrarProduto();
                    break;
                case 6:
                    consultarProdutos();
                    break;
                case 7:
                    atualizarProduto();
                    break;
                case 8:
                    excluirProduto();
                    break;
                case 9:
                    cadastrarVenda();
                    break;
                case 10:
                    consultarVendas();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n=== Menu ===");
        System.out.println("1. Cadastrar Cliente");
        System.out.println("2. Consultar Clientes");
        System.out.println("3. Atualizar Cliente");
        System.out.println("4. Excluir Cliente");
        System.out.println("5. Cadastrar Produto");
        System.out.println("6. Consultar Produtos");
        System.out.println("7. Atualizar Produto");
        System.out.println("8. Excluir Produto");
        System.out.println("9. Cadastrar Venda");
        System.out.println("10. Consultar Vendas");
        System.out.println("0. Sair");
        System.out.println("============");
    }

    private static void cadastrarCliente() {
        System.out.print("Nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.print("Email do cliente: ");
        String email = scanner.nextLine();
        clienteDAO.cadastrarCliente(nome, email);
    }

    private static void consultarClientes() {
        List<Cliente> clientes = clienteDAO.consultarClientes();
        System.out.println("\n=== Clientes ===");
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }

    private static void atualizarCliente() {
        System.out.print("ID do cliente a ser atualizado: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner
        System.out.print("Novo nome do cliente: ");
        String novoNome = scanner.nextLine();
        System.out.print("Novo email do cliente: ");
        String novoEmail = scanner.nextLine();
        clienteDAO.atualizarCliente(id, novoNome, novoEmail);
    }

    private static void excluirCliente() {
        System.out.print("ID do cliente a ser excluído: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner
        clienteDAO.excluirCliente(id);
    }

    private static void cadastrarProduto() {
        System.out.print("Nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("Preço do produto: ");
        double preco = scanner.nextDouble();
        produtoDAO.cadastrarProduto(nome, preco);
    }

    private static void consultarProdutos() {
        List<Produto> produtos = produtoDAO.consultarProdutos();
        System.out.println("\n=== Produtos ===");
        for (Produto produto : produtos) {
            System.out.println(produto);
        }
    }

    private static void atualizarProduto() {
        System.out.print("ID do produto a ser atualizado: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner
        System.out.print("Novo nome do produto: ");
        String novoNome = scanner.nextLine();
        System.out.print("Novo preço do produto: ");
        double novoPreco = scanner.nextDouble();
        produtoDAO.atualizarProduto(id, novoNome, novoPreco);
    }

    private static void excluirProduto() {
        System.out.print("ID do produto a ser excluído: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner
        produtoDAO.excluirProduto(id);
    }

    private static void cadastrarVenda() {
        System.out.print("ID do cliente: ");
        int clienteId = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner
        System.out.print("ID do produto: ");
        int produtoId = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner
        System.out.print("Quantidade: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner
        vendaDAO.cadastrarVenda(clienteId, produtoId, quantidade);
    }

    private static void consultarVendas() {
        List<Venda> vendas = vendaDAO.consultarVendas();
        System.out.println("\n=== Vendas ===");
        for (Venda venda : vendas) {
            System.out.println(venda);
        }
    }
}

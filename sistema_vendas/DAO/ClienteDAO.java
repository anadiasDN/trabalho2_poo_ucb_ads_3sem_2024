package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import sistema_vendas.Cliente;

public class ClienteDAO {
    private Connection connection;

    public ClienteDAO() {
        connection = MySQLConnector.getConnection();
    }

    public void cadastrarCliente(String nome, String email) {
        String sql = "INSERT INTO cliente (nome, email) VALUES (?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, nome);
            pstmt.setString(2, email);
            pstmt.executeUpdate();
            System.out.println("Cliente cadastrado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar cliente: " + e.getMessage());
        }
    }
    
    public List<Cliente> consultarClientes() {
    List<Cliente> clientes = new ArrayList<>();
    String sql = "SELECT * FROM cliente";
    try (Statement stmt = connection.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {
        while (rs.next()) {
            Cliente cliente = new Cliente();
            cliente.setId(rs.getInt("id"));
            cliente.setNome(rs.getString("nome"));
            cliente.setEmail(rs.getString("email"));
            clientes.add(cliente);
        }
    } catch (SQLException e) {
        System.err.println("Erro ao consultar clientes: " + e.getMessage());
    }
    return clientes;
}

public void atualizarCliente(int id, String nome, String email) {
    String sql = "UPDATE cliente SET nome = ?, email = ? WHERE id = ?";
    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
        pstmt.setString(1, nome);
        pstmt.setString(2, email);
        pstmt.setInt(3, id);
        pstmt.executeUpdate();
        System.out.println("Cliente atualizado com sucesso!");
    } catch (SQLException e) {
        System.err.println("Erro ao atualizar cliente: " + e.getMessage());
    }
}

public void excluirCliente(int id) {
    String sql = "DELETE FROM cliente WHERE id = ?";
    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
        System.out.println("Cliente excluído com sucesso!");
    } catch (SQLException e) {
        System.err.println("Erro ao excluir cliente: " + e.getMessage());
    }
}

}

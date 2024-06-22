package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import sistema_vendas.Venda;

public class VendaDAO {
    private Connection connection;

    public VendaDAO() {
        connection = MySQLConnector.getConnection();
    }

    public void cadastrarVenda(int clienteId, int produtoId, int quantidade) {
        String sql = "INSERT INTO venda (cliente_id, produto_id, quantidade) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, clienteId);
            pstmt.setInt(2, produtoId);
            pstmt.setInt(3, quantidade);
            pstmt.executeUpdate();
            System.out.println("Venda cadastrada com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar venda: " + e.getMessage());
        }
    }

        public List<Venda> consultarVendas() {
    List<Venda> vendas = new ArrayList<>();
    String sql = "SELECT * FROM venda";
    try (Statement stmt = connection.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {
        while (rs.next()) {
            Venda venda = new Venda();
            venda.setId(rs.getInt("id"));
            venda.setClienteId(rs.getInt("cliente_id"));
            venda.setProdutoId(rs.getInt("produto_id"));
            venda.setQuantidade(rs.getInt("quantidade"));
            vendas.add(venda);
        }
    } catch (SQLException e) {
        System.err.println("Erro ao consultar vendas: " + e.getMessage());
    }
    return vendas;
}

public void atualizarVenda(int id, int clienteId, int produtoId, int quantidade) {
    String sql = "UPDATE venda SET cliente_id = ?, produto_id = ?, quantidade = ? WHERE id = ?";
    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
        pstmt.setInt(1, clienteId);
        pstmt.setInt(2, produtoId);
        pstmt.setInt(3, quantidade);
        pstmt.setInt(4, id);
        pstmt.executeUpdate();
        System.out.println("Venda atualizada com sucesso!");
    } catch (SQLException e) {
        System.err.println("Erro ao atualizar venda: " + e.getMessage());
    }
}

public void excluirVenda(int id) {
    String sql = "DELETE FROM venda WHERE id = ?";
    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
        System.out.println("Venda excluída com sucesso!");
    } catch (SQLException e) {
        System.err.println("Erro ao excluir venda: " + e.getMessage());
    }
}

}

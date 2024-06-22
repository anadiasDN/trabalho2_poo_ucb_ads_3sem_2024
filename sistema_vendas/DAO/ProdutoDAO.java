package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import sistema_vendas.Produto;

public class ProdutoDAO {
    private Connection connection;

    public ProdutoDAO() {
        connection = MySQLConnector.getConnection();
    }

    public void cadastrarProduto(String nome, double preco) {
        String sql = "INSERT INTO produto (nome, preco) VALUES (?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, nome);
            pstmt.setDouble(2, preco);
            pstmt.executeUpdate();
            System.out.println("Produto cadastrado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar produto: " + e.getMessage());
        }
    }

        public List<Produto> consultarProdutos() {
    List<Produto> produtos = new ArrayList<>();
    String sql = "SELECT * FROM produto";
    try (Statement stmt = connection.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {
        while (rs.next()) {
            Produto produto = new Produto();
            produto.setId(rs.getInt("id"));
            produto.setNome(rs.getString("nome"));
            produto.setPreco(rs.getDouble("preco"));
            produtos.add(produto);
        }
    } catch (SQLException e) {
        System.err.println("Erro ao consultar produtos: " + e.getMessage());
    }
    return produtos;
}

public void atualizarProduto(int id, String nome, double preco) {
    String sql = "UPDATE produto SET nome = ?, preco = ? WHERE id = ?";
    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
        pstmt.setString(1, nome);
        pstmt.setDouble(2, preco);
        pstmt.setInt(3, id);
        pstmt.executeUpdate();
        System.out.println("Produto atualizado com sucesso!");
    } catch (SQLException e) {
        System.err.println("Erro ao atualizar produto: " + e.getMessage());
    }
}

public void excluirProduto(int id) {
    String sql = "DELETE FROM produto WHERE id = ?";
    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
        System.out.println("Produto excluído com sucesso!");
    } catch (SQLException e) {
        System.err.println("Erro ao excluir produto: " + e.getMessage());
    }
}

}

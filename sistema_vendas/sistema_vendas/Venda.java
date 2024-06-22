package sistema_vendas;

public class Venda {
    private int id;
    private Cliente cliente;
    private Produto produto;
    private int quantidade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getClienteId() {
        return cliente;
    }

    public void setClienteId(Cliente cliente) {
        this.cliente = cliente;
    }

    public Produto getProdutoId() {
        return produto;
    }

    public void setProdutoId(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Venda [id=" + id + ", cliente=" + cliente + ", produto=" + produto + ", quantidade=" + quantidade + "]";
    }
}

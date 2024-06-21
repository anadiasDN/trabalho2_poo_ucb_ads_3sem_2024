public class Pedido {
    private int id;
    private int clienteId;
    private String dataPedido;
    private double total;
    private String status;

    public Pedido(int id, int clienteId, String dataPedido, double total, String status) {
        this.id = id;
        this.clienteId = clienteId;
        this.dataPedido = dataPedido;
        this.total = total;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public int getClienteId() {
        return clienteId;
    }

    public String getDataPedido() {
        return dataPedido;
    }

    public double getTotal() {
        return total;
    }

    public String getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public void setDataPedido(String dataPedido) {
        this.dataPedido = dataPedido;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

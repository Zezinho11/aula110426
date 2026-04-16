package Domain.Enteties;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pedido {
    private int number;
    private Client cliente;
    private List<Product> produtos;
    private String stories;
    private double total;


    public Pedido(int number, Client cliente) {
        if (cliente == null){
            throw new IllegalArgumentException("Cliente é obrigatório.");
        }
        this.number = number;
        this.cliente = cliente;
        this.produtos = new ArrayList<Product>();
        this.stories = "ABREDO";
        this.total = 0.0;
    }
    public void addProduct(Product produto) {
        if (produto == null ){
            throw new IllegalArgumentException("Nome de produto é necessário");
        }
        if (!produto.temEstoque()) {
            throw new IllegalArgumentException("Produto em falta no estoque");
        }
        produtos.add(produto);
        total += produto.getPreco();
        produto.retirarEstoque();
    }

    public void fechar() {
        if (produtos.isEmpty()) {
            throw new IllegalArgumentException("É necessário ao menos um produto para realizar o pedido.");
        }
        if (total > 500) {
            total *= 0.9;
        }
        stories = "FERRADO";
    }

    public void cancelar(){
        if (stories.equals("CANCELADO")){
            throw new IllegalArgumentException("Pedido já cancelado.");
        }
        stories = "CANCELADO";
    }

    public int getNumber() {return number;}
    public Client getCliente() {return cliente;}
    public List<Product> getProdutos() {return Collections.unmodifiableList(produtos);}
    public String getStories() {return stories;}
    public double getTotal() {return total;}




}

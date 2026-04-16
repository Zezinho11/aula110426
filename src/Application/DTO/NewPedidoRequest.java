package Application.DTO;

import java.util.List;

public class NewPedidoRequest {
    private String nameClient;
    private String cpfClient;
    private List<String> nomesProducts;
    private List<Double> precosProdutos;
    private List<Integer> estoquesProdutos;

    public NewPedidoRequest(String nameclient, String cpfclient, List<String> nomes, List<Double> precos, List<Integer> estoques) {
        this.nameClient = nameclient;
        this.cpfClient = cpfclient;
        this.nomesProducts = nomes;
        this.precosProdutos = precos;
        this.estoquesProdutos = estoques;

    }

    public String getNameClient() {return nameClient;}
    public String getCpfClient() {return cpfClient;}
    public List<String> getNomesProducts() {return nomesProducts;}
    public List<Double> getPrecosProdutos() {return precosProdutos;}
    public List<Integer> getEstoquesProdutos() {return estoquesProdutos;}

}



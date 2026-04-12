package Domain.Enteties;

public class Product {
    private String name;
    private double preco;
    private int estoque;

    public Product(String name, double preco,int estoque){
    if (name == null || name.trim().isEmpty()){
        throw new IllegalArgumentException("nome é obrigatório.");
    }
    if (preco <= 0) {
        throw new IllegalArgumentException("Preço deve ser maior que R$0,00.");

    }

    this.name = name;
    this.preco = preco;
    this.estoque = estoque;


    }







}




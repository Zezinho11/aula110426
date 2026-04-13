package Domain.Enteties;

public class Client {
    private String name;
    private String cpf;


    public Client(String name, String cpf){
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do cliente é obrigatório");
        }
        if (cpf == null || cpf.trim().isEmpty()) {
            throw new IllegalArgumentException("CPF é Obrigatório");
        }
        this.name = name;
        this.cpf = cpf;
    }

    public String getName() {return name;}
    public String getCpf() {return cpf;}
}
package Application.usercases;

import Application.DTO.NewPedidoRequest;
import Domain.Enteties.Client;
import Domain.Enteties.Pedido;
import Domain.Enteties.Product;
import Domain.Repositories.PedidoRepository;

import java.util.List;

public class NewPedidoUseCase {
    private final PedidoRepository pedidoRepository;

    public NewPedidoUseCase(PedidoRepository pedidoRepository){
        this.pedidoRepository = pedidoRepository;
    }

    public Pedido executar (NewPedidoRequest request) {
        validarRequest(request);

        Client client = new Client(request.getNameClient(), request.getCpfClient());
        Pedido pedido = new Pedido(pedidoRepository.proximoNumero(), client);

        List<String> names = request.getNomesProducts();
        List<Double> precos = request.getPrecosProdutos();
        List<Integer> estoques = request.getEstoquesProdutos();

        for (int i = 0; i < names.size(); i++) {
            Product product = new Product(names.get(i), precos.get(i), estoques.get(i));
            pedido.addProduct(product);
        }

        pedido.fechar();
        pedidoRepository.salvar(pedido);
        return pedido;

    }

    private void validarRequest(NewPedidoRequest request){
        if (request == null){
            throw new IllegalArgumentException("Erro na requisição.");
        }
        if (request.getNomesProducts() == null || request.getNomesProducts().isEmpty()) {
            throw new IllegalArgumentException("Informe ao menos um produto.");
        }
        if (!(request.getNomesProducts().size() != request.getPrecosProdutos().size()
                && request.getNomesProducts().size() != request.getEstoquesProdutos().size())) {
            throw new IllegalArgumentException("dados de produtos são inconsistentes.");
        }





    }


}

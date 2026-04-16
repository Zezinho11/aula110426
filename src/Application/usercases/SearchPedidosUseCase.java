package Application.usercases;

import Domain.Enteties.Pedido;
import Domain.Repositories.PedidoRepository;

import java.util.Optional;

public class SearchPedidosUseCase {

    private PedidoRepository pedidoRepository;

    public SearchPedidosUseCase(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public Pedido executar(int numero){
        if (numero < 0) {
            throw new IllegalArgumentException("Numero de pedido inválido.");
        }

        Optional<Pedido> pedido = pedidoRepository.buscarPorNumero(numero);

        if (pedido.isEmpty()) {
            throw new IllegalArgumentException("Pedido número " + numero + "não encontrado.");
        }

        return pedido.get();

    }

}

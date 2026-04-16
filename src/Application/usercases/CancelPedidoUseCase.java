package Application.usercases;

import Domain.Enteties.Pedido;
import Domain.Repositories.PedidoRepository;

import java.util.Optional;

public class CancelPedidoUseCase {

    private final PedidoRepository pedidoRepository;

    public CancelPedidoUseCase(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    // CancelPedidoUseCase.java
    public Pedido executar(int numero) {
        Optional<Pedido> pedidoOpt = pedidoRepository.buscarPorNumero(numero);

        if (pedidoOpt.isEmpty())
            throw new IllegalArgumentException("Pedido número " + numero + " não encontrado.");

        Pedido pedido = pedidoOpt.get();
        pedido.cancelar();
        pedidoRepository.atualizar(pedido);
        return pedido;
    }
}

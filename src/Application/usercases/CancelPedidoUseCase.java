package Application.usercases;

import Domain.Enteties.Pedido;
import Domain.Repositories.PedidoRepository;

import java.util.Optional;

public class CancelPedidoUseCase {

    private final PedidoRepository pedidoRepository;

    public CancelPedidoUseCase(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public Pedido executar(int numero) {
        if (numero < 0) {
            throw new IllegalArgumentException("Numero do pedido inválido");
        }

        Optional<Pedido> pedidoOpt = pedidoRepository.buscarPorNumero(numero);

        if (pedidoOpt.isEmpty()) {
            throw new IllegalArgumentException("pedido número " + numero + " não encontrado");
        }

        Pedido pedido = pedidoOpt.get();
        pedido.cancelar();
        return pedido;

    }





}

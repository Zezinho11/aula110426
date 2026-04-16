package Application.usercases;

import Domain.Enteties.Pedido;
import Domain.Repositories.PedidoRepository;

import java.util.List;

public class ListPedidosUseCase {
    private PedidoRepository pedidoRepository;

    public ListPedidosUseCase(PedidoRepository pedidoRepository) {this.pedidoRepository = pedidoRepository;}

    public List<Pedido> executar() { return pedidoRepository.listar(); }
}

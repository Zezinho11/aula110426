package ordersystemclean;

import Domain.Enteties.Pedido;
import Domain.Repositories.PedidoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PedidoRepositoryMemory implements PedidoRepository {

    private List<Pedido> pedidos = new ArrayList<>();
    public void salvar(Pedido pedido) {
        pedidos.add(pedido);
    }

    public List<Pedido> listar() {
        return pedidos;
    }

    public int proximoNumero() {
        return pedidos.size();
    }

    public Optional<Pedido> buscarPorNumero(int numero) {
        return pedidos.stream()
                .filter(pedido -> pedido.getNumber() == numero)
                .findFirst();
    }
}



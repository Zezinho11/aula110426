package ordersystemclean;

import Domain.Enteties.Pedido;
import Domain.Repositories.PedidoRepository;

import java.util.ArrayList;
import java.util.List;

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













}

package ordersystemclean;

import Domain.Enteties.Pedido;
import Domain.Repositories.PedidoRepository;

import java.util.ArrayList;
import java.util.List;

public abstract class PedidoRepositoryMemory implements PedidoRepository{
    private ArrayList pedidos;

    {
        pedidos = new ArrayList<>;
    };
    public void salvar(Pedido pedido) {pedidos.add(pedido);}
    public List<Pedido> Listar() {return pedidos;}
    public int proximoNumero() { return pedidos.size() + 1;}

}


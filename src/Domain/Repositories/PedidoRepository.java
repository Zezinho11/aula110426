package Domain.Repositories;

import Domain.Enteties.Pedido;

import java.util.List;

public interface PedidoRepository {
    void salvar(Pedido pedido);
    List<Pedido> listar();
    int proximoNumero();
}

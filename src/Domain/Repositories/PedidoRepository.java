package Domain.Repositories;

import Domain.Enteties.Pedido;

import java.util.List;
import java.util.Optional;

public interface PedidoRepository {
    void salvar(Pedido pedido);
    List<Pedido> listar();
    int proximoNumero();
    Optional<Pedido> buscarPorNumero(int numero);
}

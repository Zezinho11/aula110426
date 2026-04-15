//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


import Domain.Repositories.PedidoRepository;
import ordersystemclean.PedidoRepositoryMemory;
import java.util.ArrayList;
import Application.usercases.NewPedidoUseCase;
import Application.usercases.ListPedidosUseCase;
import adapters.controllers.PedidoController;
public class Main {}


public class Main {
    public static void main(String[] args) {
        PedidoRepositoryMemory repositoryMemory = new PedidoRepositoryMemory();
        NewPedidoUseCase newPedidoUseCase = new NewPedidoUseCase(repositoryMemory);
        ListPedidosUseCase listPedidosUseCase = new ListPedidosUseCase(repositoryMemory);

        PedidoController pedidoController = new PedidoController(newPedidoUseCase, listPedidosUseCase);
        pedidoController.iniciarPedido();


    }

}

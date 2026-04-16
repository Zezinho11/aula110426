//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


import Application.usercases.*;
import Domain.Repositories.PedidoRepository;
import ordersystemclean.PedidoRepositoryMemory;
import java.util.ArrayList;

import adapters.controllers.PedidoController;



public class Main {
    public static void main(String[] args) {
        PedidoRepositoryMemory repositoryMemory = new PedidoRepositoryMemory();


        NewPedidoUseCase newPedidoUseCase = new NewPedidoUseCase(repositoryMemory);
        ListPedidosUseCase listPedidosUseCase = new ListPedidosUseCase(repositoryMemory);
        SearchPedidosUseCase searchPedidosUseCase = new SearchPedidosUseCase(repositoryMemory);
        CancelPedidoUseCase cancelPedidoUseCase = new CancelPedidoUseCase(repositoryMemory);
        ReportPedidoUseCase reportPedidoUseCase = new ReportPedidoUseCase(repositoryMemory);

        PedidoController pedidoController = new PedidoController(newPedidoUseCase, listPedidosUseCase, searchPedidosUseCase, cancelPedidoUseCase, reportPedidoUseCase);
        pedidoController.iniciarPedido();

    }

}

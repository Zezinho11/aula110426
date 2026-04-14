package adapters.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Application.DTO.NewPedidoRequest;
import Application.usercases.ListPedidosUseCase;
import Application.usercases.NewPedidoUseCase;
import Domain.Enteties.Pedido;
import Domain.Enteties.Product;


public class PedidoController {
    private NewPedidoUseCase newPedidoUseCase;
    private ListPedidosUseCase listPedidosUseCase;
    private Scanner scanner = new Scanner(System.in);

     public PedidoController(NewPedidoUseCase newPedidoUseCase, ListPedidosUseCase listPedidosUseCase ){
         this.newPedidoUseCase = newPedidoUseCase;
         this.listPedidosUseCase = listPedidosUseCase;
     }

     public void iniciarPedido(){
         int opcao;


         do {
             System.out.println("\n===== SISTEMA PARA PEDIDOS - BY JOSÉ SUZUKI =====");
             System.out.println("1 - Criar novo pedido");
             System.out.println("2 - Listar pedidos criados");
             System.out.println("0 - Sair");
             System.out.print("escolha uma opção acima: ");

             try {
                 opcao = Integer.parseInt(scanner.nextLine());
             } catch (Exception e) {
                 opcao = -1;
             }



             }

         }


     }



}

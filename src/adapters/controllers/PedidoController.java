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


     }



}

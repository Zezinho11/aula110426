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

             switch (opcao) {
                 case 1:
                     criarPedido();
                     break;
                 case 2:
                     listarPedidos();
                     break;
                 case 0:
                     System.out.println("Finalizando sistema...");
                     break;
                 default:
                     System.out.println("Opção invalida!");
             }
         } while (opcao !=0);

         }

        private void criarPedido(){
         try{
             System.out.println("Digite o nome do cliente: ");
             String nameclient = scanner.nextLine();

             System.out.println("Digite o CPF do cliente: ");
             String cpfclient = scanner.nextLine();

             List<String> nomes = new ArrayList<>();
             List<Double>precos = new ArrayList<>();
             List<Integer> estoques = new ArrayList<>();

             String continue;
             do {
                 System.out.println("Digite o nome do produto: ");
                 nomes.add(scanner.nextLine());

                 System.out.println("Digite o preço do produto: ");
                 precos.add(Double.parseDouble(scanner.nextLine()));

                 System.out.println("Estoque disponível do produto: ");
                 estoques.add(Integer.parseInt(scanner.nextLine()));

                 System.out.println("Deseja Adicionar outro produto? (s/n)");
                 continue =  scanner.nextLine();

             } while (continue.equalsIgnoreCase("s"));

             NewPedidoRequest request = new NewPedidoRequest(nameclient, cpfclient, nomes, precos, estoques);

             Pedido pedido = newPedidoUseCase.executar(request);

             System.out.println("\nPedido realizado com sucesso!");
             System.out.println("Número: " + pedido.getNumber());
             System.out.println("Cliente: " + pedido.getCliente().getName());
             System.out.println("Status: " + pedido.getStories());
             System.out.println("Total final do pedido: R$" + pedido.getTotal());

        } catch (Exception e) {
             System.out.println("Erro ao criar pedido: "  + e.getMessage());
         }
     }













}

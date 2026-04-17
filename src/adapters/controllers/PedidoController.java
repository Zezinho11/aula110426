package adapters.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Application.DTO.NewPedidoRequest;
import Application.usercases.ListPedidosUseCase;
import Application.usercases.NewPedidoUseCase;
import Application.usercases.SearchPedidosUseCase;
import Application.usercases.CancelPedidoUseCase;
import Application.usercases.ReportPedidoUseCase;
import Application.usercases.ReportPedidoResponse;
import Domain.Enteties.Pedido;
import Domain.Enteties.Product;


public class PedidoController {
    private NewPedidoUseCase newPedidoUseCase;
    private ListPedidosUseCase listPedidosUseCase;
    private SearchPedidosUseCase searchPedidosUseCase;
    private CancelPedidoUseCase cancelPedidoUseCase;
    private ReportPedidoUseCase reportPedidoUseCase;
    private Scanner scanner = new Scanner(System.in);

     public PedidoController(NewPedidoUseCase newPedidoUseCase, ListPedidosUseCase listPedidosUseCase, SearchPedidosUseCase searchPedidosUseCase,
                             CancelPedidoUseCase cancelPedidoUseCase, ReportPedidoUseCase reportPedidoUseCase ) {
         this.newPedidoUseCase = newPedidoUseCase;
         this.listPedidosUseCase = listPedidosUseCase;
         this.searchPedidosUseCase = searchPedidosUseCase;
         this.cancelPedidoUseCase = cancelPedidoUseCase;
         this.reportPedidoUseCase = reportPedidoUseCase;
     }

     public void iniciarPedido(){
         int opcao;


         do {
             System.out.println("\n===== SISTEMA PARA PEDIDOS - BY JOSÉ SUZUKI =====");
             System.out.println("1 - Criar novo pedido");
             System.out.println("2 - Listar pedidos criados");
             System.out.println("3 - Buscar Pedido");
             System.out.println("4 - Cancelar Pedido");
             System.out.println("5 - Relatório Resumido");
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
                 case 3:
                     buscarPedido();
                     break;
                 case 4:
                     cancelarPedido();
                     break;
                 case 5:
                     exibirRelatorio();
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

             String continuar;
             do {
                 System.out.println("Digite o nome do produto: ");
                 nomes.add(scanner.nextLine());

                 System.out.println("Digite o preço do produto: ");
                 precos.add(Double.parseDouble(scanner.nextLine()));

                 System.out.println("Estoque disponível do produto: ");
                 estoques.add(Integer.parseInt(scanner.nextLine()));

                 System.out.println("Deseja Adicionar outro produto? (s/n)");
                 continuar =  scanner.nextLine();

             } while (continuar.equalsIgnoreCase("s"));

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

     private void listarPedidos(){
         List<Pedido> pedidos = listPedidosUseCase.executar();

         if(pedidos.isEmpty()){
             System.out.println("Nenhum pedido cadastrado!");
             return;
         }

         System.out.println("\n===== LISTA DE PEDIDOS DO SISTEMA =====");
         for (Pedido pedido : pedidos) {
             System.out.println("\nPedido número: " + pedido.getNumber());
             System.out.println("Cliente: " + pedido.getCliente().getName());
             System.out.println("CPF: " + pedido.getCliente().getCpf() );
             System.out.println("Status: " + pedido.getStories());
             System.out.println("Produtos: " + pedido.getProdutos());
             for (Product produto : pedido.getProdutos()) {
                 System.out.println("- " + produto.getName() + "| R$ " + produto.getPreco());
             }
             System.out.println("Total final do pedido: R$" + pedido.getTotal());

         }


     }

     private void buscarPedido(){
         try {
             System.out.println("Digite o número do pedido: ");
             int numero = Integer.parseInt(scanner.nextLine());

             Pedido pedido = searchPedidosUseCase.executar(numero);

             System.out.println("\nPedido encontrado:");
             System.out.println("Número: " + pedido.getNumber());
             System.out.println("Cliente: " + pedido.getCliente().getName());
             System.out.println("Status: " + pedido.getStories());
             System.out.println("Total do pedido: R$" + pedido.getTotal());
         } catch (Exception e) {
             System.out.println("Erro ao buscar pedido: " + e.getMessage());
         }
     }

    private void cancelarPedido(){
         try {
              System.out.print("Digite o número do pedido para cancelar: ");
              int numero = Integer.parseInt(scanner.nextLine());

              Pedido pedido = cancelPedidoUseCase.executar(numero);

              System.out.println("\n Pedido número " + pedido.getNumber() + " cancelado com sucesso!");
              System.out.println("Status: " + pedido.getStories());
         }catch (Exception e) {
             System.out.println("Erro ao cancelar pedido: " + e.getMessage());
         }
    }

    private void exibirRelatorio(){
         ReportPedidoResponse report = reportPedidoUseCase.executar();

         System.out.println("\n===== RELÁTORIO DE PEDIDOS =====");
         System.out.println("Total de pedidos:     " + report.getTotalPedidos());
         System.out.println("Pedidos cancelados:   " + report.getTotalcancelados());
         System.out.println("Receita confirmada:   R$" + report.getTotalReceita());
         System.out.println("Receita cancelada:    R$" + report.getTotalReceitaCancelada());
    }





}

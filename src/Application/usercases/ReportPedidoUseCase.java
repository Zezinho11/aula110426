package Application.usercases;
import Domain.Enteties.Pedido;
import Domain.Repositories.PedidoRepository;
import java.util.List;

public class ReportPedidoUseCase {

        private final PedidoRepository pedidoRepository;

        public ReportPedidoUseCase(PedidoRepository pedidoRepository) {
            this.pedidoRepository = pedidoRepository;
        }

        public ReportPedidoResponse executar(){
            List<Pedido> pedidos = pedidoRepository.listar();

            int totalPedidos = 0;
            int totalcancelados = 0;
            double totalReceita = 0;
            double totalReceitaCancelada = 0;

            for (Pedido pedido : pedidos) {
            totalPedidos++;
            if (pedido.getStories().equals("CANCELADO")) {
                totalcancelados++;
                totalReceitaCancelada += pedido.getTotal();
            } else {
                totalReceita += pedido.getTotal();
            }

            }
            return new ReportPedidoResponse(totalPedidos, totalcancelados,  totalReceita, totalReceitaCancelada);

        }













}

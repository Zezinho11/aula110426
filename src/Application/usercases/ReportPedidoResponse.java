package Application.usercases;

public class ReportPedidoResponse {

    private final int totalPedidos;
    private final int totalcancelados;
    private final double totalReceita;
    private final double totalReceitaCancelada;


    public ReportPedidoResponse(int totalPedidos, int totalcancelados, double totalReceita, double totalReceitaCancelada) {
        this.totalPedidos = totalPedidos;
        this.totalcancelados = totalcancelados;
        this.totalReceita = totalReceita;
        this.totalReceitaCancelada = totalReceitaCancelada;
    }



    public int getTotalPedidos()  {
        return totalPedidos;
    }

    public int getTotalcancelados()  {
        return totalcancelados;
    }

    public double getTotalReceita()  {
        return totalReceita;
    }

    public double getTotalReceitaCancelada()  {
        return totalReceitaCancelada;
    }

}

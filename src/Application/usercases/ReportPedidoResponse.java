package Application.usercases;

public class ReportPedidoResponse {

    private final int totalPedidos;
    private final int totalcancelados;
    private final int totalReceita;
    private final int totalReceitaCancelada;


    public ReportPedidoResponse(int totalPedidos, int totalcancelados, int totalReceita, int totalReceitaCancelada) {
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

    public int getTotalReceita()  {
        return totalReceita;
    }

    public int getTotalReceitaCancelada()  {
        return totalReceitaCancelada;
    }

}

package Bean;

import Controle.Cadastro;
import Entidade.CadastroVeiculos;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class VeiculosServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            String vmarca = request.getParameter("marca");
            String vmodelo = request.getParameter("modelo");
            double vpreco = Double.parseDouble(request.getParameter("preco"));

            // Debugging logs
            System.out.println("Marca: " + vmarca);
            System.out.println("Modelo: " + vmodelo);
            System.out.println("Preco: " + vpreco);

            Cadastro cadastro = new Cadastro();
            cadastro.setMarca(vmarca);
            cadastro.setModelo(vmodelo);
            cadastro.setPreco(vpreco);

            CadastroVeiculos cadastroVeiculos = new CadastroVeiculos();
            cadastroVeiculos.inserirCarro(cadastro);

            request.setAttribute("marca", vmarca);
            request.setAttribute("modelo", vmodelo);
            request.setAttribute("preco", vpreco);
            request.getRequestDispatcher("resultado.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Formato de preço inválido: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao processar a solicitação: " + e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}

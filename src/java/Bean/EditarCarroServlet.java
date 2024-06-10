package Bean;

import Controle.Cadastro;
import Entidade.CadastroVeiculos;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "EditarCarroServlet", urlPatterns = {"/editarCarroServlet"})
public class EditarCarroServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            // Obtendo os parâmetros do formulário
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            String marca = request.getParameter("marca");
            String modelo = request.getParameter("modelo");
            double preco = Double.parseDouble(request.getParameter("preco"));

            // Criando um objeto Cadastro com os dados do formulário
            Cadastro carro = new Cadastro();
            carro.setCodigo(codigo);
            carro.setMarca(marca);
            carro.setModelo(modelo);
            carro.setPreco(preco);

            // Instanciando a classe responsável pelo acesso ao banco de dados
            CadastroVeiculos dao = new CadastroVeiculos();

            // Chamando o método para atualizar o carro no banco de dados
            try {
                dao.atualizarVeiculo(carro);
                // Redirecionando de volta para a página de listagem de carros após a atualização
                response.sendRedirect("listarCarros.jsp");
            } catch (SQLException e) {
                // Caso ocorra algum erro durante a atualização, imprime o erro na página
                out.println("Erro ao atualizar carro: " + e.getMessage());
            }
        }
    }
}

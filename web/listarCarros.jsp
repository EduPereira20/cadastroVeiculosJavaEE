<%@page import="java.util.List"%>
<%@page import="Entidade.CadastroVeiculos"%>
<%@page import="Controle.Cadastro"%>
<%@page import="Bean.ServletDeletaVeiculo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
    integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A=="
    crossorigin="anonymous" referrerpolicy="no-referrer" />
  <link rel="icon" type="image/x-icon" href="../Assests/nova-car-logo.svg">
  <link rel="stylesheet" href="style/listar.css">
  <link rel="stylesheet" href="style/modalDelete.css">
  <title>Listar carro</title>
</head>

<body>
  <div class="nav">
    <div class="navBar">
      <img src="Assests/car-logo.png" alt="logo" class="logo">
      <div class="links">
        <a href="index.jsp">BEM VINDOS</a>
        <a href="cadastro.jsp">ADICIONAR</a>
        <a href="listarCarros.jsp">CARROS</a>
      </div>
    </div>
  </div>
  <div class="table">
    <div class="info-table">
      <table class="fl-table">
        <thead>
          <tr>
            <th>ID</th>
            <th>MARCA</th>
            <th>MODELO</th>
            <th>PREÇO</th>
            <th>DATA DE COMPRA</th>
            <th>AÇÃO</th>
          </tr>
        </thead>
        <tbody>
          <%
            CadastroVeiculos cadastroVeiculos = new CadastroVeiculos();
            List<Cadastro> carros = cadastroVeiculos.listarCarros();
            for (Cadastro carro : carros) {
          %>
          <tr>
            <td><%= carro.getCodigo() %></td>
            <td><%= carro.getMarca() %></td>
            <td><%= carro.getModelo() %></td>
            <td>R$ <%= carro.getPreco() %></td>
            <td><%= carro.getDataCadastro() %></td>
            <td>
              <a href="editarCarro.jsp?codigo=<%= carro.getCodigo() %>">
                <i class="fa-solid fa-pen-to-square" style="font-size: 20px; color: #f3df04; margin-right: 10px;"></i>
              </a>
              <a href="#" class="delete-icon" data-id="<%= carro.getCodigo() %>">
                <i class="fa-solid fa-trash" style="font-size: 20px; color: #e30505;"></i>
              </a>
            </td>
          </tr>
          <%
            }
          %>
        </tbody>
      </table>
    </div>
  </div>
  <div id="deleteModal" class="modal">
    <div class="modal-content">
      <span class="close">&times;</span>
      <p>Tem certeza que deseja deletar este item?</p>
      <button id="confirmDelete" class="confirm-btn">Confirmar</button>
      <button id="cancelDelete" class="cancel-btn">Cancelar</button>
    </div>
  </div>

  <script src="JS/modalDelete.js"></script>
</body>

</html>

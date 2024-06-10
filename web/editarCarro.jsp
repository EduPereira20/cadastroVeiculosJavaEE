<%-- 
    Document   : editarCarro
    Created on : 9 de jun. de 2024, 13:30:53
    Author     : 55619
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="../Assests/nova-car-logo.svg">
    <link rel="stylesheet" href="style/editar.css">
    <title>Editar carro</title>
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

    <div class="home-edit">
        <div class="form-edit">
            <div class="form">
                <h1>EDITAR CARRO</h1>
                <form action="editarCarroServlet" method="post">
                    <!-- Adicione um campo oculto para enviar o código do carro -->
                    <input type="hidden" name="codigo" value="<%= request.getParameter("codigo") %>">
                    <p>Marca:</p> <input class="input-box" type="text" name="marca" placeholder="Digite a nova marca do carro" ><br>
                    <p>Modelo:</p> <input class="input-box" type="text" name="modelo" placeholder="Digite o novo modelo do carro" ><br>
                    <p>Preço:</p> <input class="input-box" type="number" name="preco" placeholder="Digite o novo valor do carro" ><br>

                    <div class="btn-button">
                        <button class="btn" type="submit">Editar carro</button>
                        <a href="../pages/listarCarros.jsp" class="btn-cancelar" type="button">Cancelar</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
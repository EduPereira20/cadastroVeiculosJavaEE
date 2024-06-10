<%-- 
    Document   : resultado
    Created on : 7 de jun. de 2024, 13:55:15
    Author     : 55619
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style/sucesso.css">
    <title>Document</title>
</head>

<body>
    <div class="nav">
        <div class="navBar">
            <img src="Assests/car-logo.png" alt="logo" class="logo">
            <div class="links">
                <a href="../index.html">HOME</a>
                <a href="pages/addCarro.html">ADICIONAR</a>
                <a href="../pages/listarCarros.html">CARROS</a>
            </div>
        </div>
    </div>

    <div class="sucesso">
        <div class="frase-sucesso">
            <h4>PARABÉNS!</h4>
                <h1>CARRO ADICIONADO <br><span>COM SUCESSO!!</span><br></h1>
            <div class="btn-button">
                <a href="listarCarros.jsp" class="btn" type="button">Ver carro</a>
            </div>
        </div>
    </div>
</body>

</html>

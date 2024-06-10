<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style/style.css">
    <title>BsbCars</title>
    
    <style>
        .home{
	width: 100%;
	height: 100vh;
        display: table;
        background: url('Assests/carroImgFundo.jpg') no-repeat bottom center scroll;
	background-position: center;
	background-size: cover;
	display: flex;
        justify-content: center;
        align-items: center;
        background-image: linear-gradient(rgba(0, 0, 0, 0.75), rgba(0, 0, 0, 0.75)), url('Assests/carroImgFundo.jpg');
        background-position: center;
        background-size: cover;
}
        </style>
</head>
<body>
    <div class="nav">
        <div class="navBar">
            <img src="Assests/car-logo.png" alt="logo" class="logo" style="width: 10rem;">
            <div class="links">
                <a href="index.jsp">BEM VINDOS</a>
                <a href="cadastro.jsp">ADICIONAR</a>
                <a href="listarCarros.jsp">CARROS</a>
            </div>
        </div>
    </div>
    <div class="home">
        <form action="VeiculosServlet" class="formulario">
            <div class="info">
                <h1>ADICIONAR CARRO</h1>
                <p>Marca:</p> <input class="input-box" type="text" name="marca" placeholder="Digite a marca do carro"
                    required><br>
                <p>Modelo:</p> <input class="input-box" type="text" name="modelo" placeholder="Digite o modelo do carro"
                    required><br>
                <p>preço:</p> <input class="input-box" type="number" name="preco" placeholder="Digite o valor do carro"
                    required><br>

                <div class="btn-button">
                    <button class="btn" type="submit">Adicionar carro</button>
                </div>
            </div>
        </form>
    </div>
</body>

</html>
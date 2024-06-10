DROP DATABASE LojaCarros;

CREATE DATABASE LojaCarros;
USE LojaCarros;


DROP TABLE Carros;
CREATE TABLE Carros (
    Codigo INT AUTO_INCREMENT PRIMARY KEY,
    Marca VARCHAR(50) NOT NULL,
    Modelo VARCHAR(50) NOT NULL,
    PrecoMercado DECIMAL(10, 2) NOT NULL,
    DataCadastro DATE NOT NULL
    );

INSERT INTO Carros (Marca, Modelo, PrecoMercado, DataCadastro) VALUES
('Toyota', 'Supra', 1400000.00, '2023-07-01'),
('Nissan', 'GTR R35', 1579000.00, '2023-07-02'),
('Hyundai', 'HB20', 84390.00, '2024-01-24'),
('Chevrolet', 'Opala',8500.00 , '2024-03-04');

SELECT * FROM Carros;



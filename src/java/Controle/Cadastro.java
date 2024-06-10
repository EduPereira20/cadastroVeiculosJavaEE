package Controle;

import java.sql.Date;

public class Cadastro {
    private int codigo;
    private String marca;
    private String modelo;
    private double preco;
    private Date dataCadastro; // Se necessário, mesmo que não utilize diretamente

    // Construtor padrão
    public Cadastro() {
    }

    // Construtor com parâmetros
    public Cadastro(int codigo, String marca, String modelo, double preco, Date dataCadastro) {
        this.codigo = codigo;
        this.marca = marca;
        this.modelo = modelo;
        this.preco = preco;
        this.dataCadastro = dataCadastro;
    }

    // Getters e Setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}

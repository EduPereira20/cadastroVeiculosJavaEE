package Entidade;

import Controle.Cadastro;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;

public class CadastroVeiculos extends DAO {

    public void inserirCarro(Cadastro carro) {
        String query = "INSERT INTO Carros (Marca, Modelo, PrecoMercado, DataCadastro) VALUES (?, ?, ?, ?)";
        PreparedStatement pst = null;

        try {
            abrirBanco();
            pst = getConnection().prepareStatement(query);
            pst.setString(1, carro.getMarca());
            pst.setString(2, carro.getModelo());
            pst.setDouble(3, carro.getPreco());
            pst.setDate(4, new java.sql.Date(Calendar.getInstance().getTimeInMillis())); // Data atual

            pst.executeUpdate();
            System.out.println("Carro inserido com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir carro: " + e.getMessage());
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                fecharBanco();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }
    }

    public List<Cadastro> listarCarros() {
        String query = "SELECT Codigo, Marca, Modelo, PrecoMercado, DataCadastro FROM Carros";
        List<Cadastro> carros = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            abrirBanco();
            pst = getConnection().prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                Cadastro carro = new Cadastro();
                carro.setCodigo(rs.getInt("Codigo"));
                carro.setMarca(rs.getString("Marca"));
                carro.setModelo(rs.getString("Modelo"));
                carro.setPreco(rs.getDouble("PrecoMercado"));
                carro.setDataCadastro(rs.getDate("DataCadastro"));

                carros.add(carro);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar carros: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
                fecharBanco();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }

        return carros;
    }

    public void deletarCarro(int codigo) {
        String query = "DELETE FROM Carros WHERE Codigo = ?";
        PreparedStatement pst = null;

        try {
            abrirBanco();
            pst = getConnection().prepareStatement(query);
            pst.setInt(1, codigo);

            int rowsAffected = pst.executeUpdate();
            if (rowsAffected == 0) {
                throw new SQLException("No rows affected, carro with id " + codigo + " might not exist");
            }
            System.out.println("Carro deletado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao deletar carro: " + e.getMessage());
            throw new RuntimeException("Erro ao deletar carro", e);
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                fecharBanco();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }
    }

    public Cadastro obterDetalhesCarro(int codigo) {
        String query = "SELECT Marca, Modelo, PrecoMercado FROM Carros WHERE Codigo = ?";
        PreparedStatement pst = null;
        ResultSet rs = null;
        Cadastro carro = new Cadastro();

        try {
            abrirBanco();
            pst = getConnection().prepareStatement(query);
            pst.setInt(1, codigo);
            rs = pst.executeQuery();

            if (rs.next()) {
                carro.setMarca(rs.getString("Marca"));
                carro.setModelo(rs.getString("Modelo"));
                carro.setPreco(rs.getDouble("PrecoMercado"));
            } else {
                throw new SQLException("Carro não encontrado com o código: " + codigo);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao obter detalhes do carro: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
                fecharBanco();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }

        return carro;
    }
    
    public void atualizarVeiculo(Cadastro veiculo) throws SQLException {
        String query = "UPDATE Carros SET Marca=?, Modelo=?, PrecoMercado=? WHERE Codigo=?";
        PreparedStatement pst = null;

        try {
            abrirBanco();
            pst = getConnection().prepareStatement(query);
            pst.setString(1, veiculo.getMarca());
            pst.setString(2, veiculo.getModelo());
            pst.setDouble(3, veiculo.getPreco());
            pst.setInt(4, veiculo.getCodigo());

            int rowsAffected = pst.executeUpdate();
            if (rowsAffected == 0) {
                throw new SQLException("Nenhum registro atualizado, veículo com código " + veiculo.getCodigo() + " pode não existir.");
            }
            System.out.println("Veículo atualizado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar veículo: " + e.getMessage());
            throw e; // Lança a exceção para ser tratada pela chamada da função
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                fecharBanco();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }
    }
}

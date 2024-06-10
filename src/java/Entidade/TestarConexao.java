
package Entidade;

import java.sql.SQLException;


public class TestarConexao {
    
    public static void main(String[] args) throws SQLException {
      DAO cx = new DAO();
      cx.abrirBanco();
    }
    
}

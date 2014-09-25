package testes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class testeComandos {
    public static void main(String[] args) {
        String SQL="CREATE TABLE CIDADE ("
                + "CD_CIDADE INTEGER NOT NULL,"
                + "NM_CIDADE VARCHAR(100) NOT NULL,"
                + "DS_SIGLA CHAR(2) NOT NULL,"
                + "CONSTRAINT PK_CIDADE PRIMARY KEY(CD_CIDADE))";
        try {
            PreparedStatement ps = conexao.conexaoBanco.getConnection().prepareStatement(SQL);
            ps.execute();
            System.out.println("Comando SQL executado."); 
       } catch (SQLException ex) {
            System.out.println("Erro SQL: "+ex.getMessage());
        }
        
    }
}

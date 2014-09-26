package testes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class testeFuncionario {
    public static void main(String[] args) {
        String SQL="CREATE TABLE FUNCIONARIO ("
                + "CD_FUNCIONARIO INTEGER NOT NULL,"
                + "NM_FUNCIONARIO VARCHAR(100) NOT NULL,"
                + "DS_ENDERECO VARCHAR(100) NOT NULL,"
                + "VL_SALARIO DOUBLE NOT NULL,"
                + "CD_CIDADE INTEGER NOT NULL,"
                + "CONSTRAINT PK_FUNCIONARIO PRIMARY KEY(CD_FUNCIONARIO),"
                + "CONSTRAINT FK_FUN_CID FOREIGN KEY (CD_CIDADE) "
                + "REFERENCES CIDADE(CD_CIDADE))";
        try {
            PreparedStatement ps = conexao.conexaoBanco.getConnection().prepareStatement(SQL);
            ps.execute();
            System.out.println("Comando SQL executado."); 
            
       } catch (SQLException ex) {
            System.out.println("Erro SQL: "+ex.getMessage());
        }
        
    }
}

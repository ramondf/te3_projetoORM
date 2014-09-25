package testes;

import DAO.cidadeDAO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.cidade;

public class testeComandos {
    public static void main(String[] args) {
        String SQL="CREATE TABLE CIDADE ("
                + "CD_CIDADE INTEGER NOT NULL,"
                + "NM_CIDADE VARCHAR(100) NOT NULL,"
                + "DS_SIGLA CHAR(2) NOT NULL,"
                + "CONSTRAINT PK_CIDADE PRIMARY KEY(CD_CIDADE))";
        try {
           // PreparedStatement ps = conexao.conexaoBanco.getConnection().prepareStatement(SQL);
            //ps.execute();
            //System.out.println("Comando SQL executado."); 
            cidadeDAO dao = new cidadeDAO();
            //dao.addCidade(new cidade(0, "Criciúma", "SC"));
            //dao.addCidade(new cidade(0, "São Paulo", "SP"));
            //dao.addCidade(new cidade(0, "Içara", "SC"));
            dao.updateCidade(new cidade(2, "ribeirão preto", "sp"));
       } catch (SQLException ex) {
            System.out.println("Erro SQL: "+ex.getMessage());
        }
        
    }
}

package testes;

import DAO.cidadeDAO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
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
            
           /* dao.addCidade(new cidade(0, "Excluir", "sc"));
            System.out.println(dao.removeCidade(new cidade(4, "asa", "sc"))
            ? "foi removido"
                    : "não remoido") ;
            
            int numero = dao.updateCidade(new cidade(99, "ribeirão preto", "sp"));
            System.out.println("Atualizados: "+numero); */
          
            /*cidade Cidade = dao.getCidade(3);
            System.out.println(Cidade.getCodigo()+"\t"+
                    Cidade.getNome()+"\t"+
                    Cidade.getSigla());          */
            
            /*List<cidade> list = dao.getCidadeList();
            for (cidade objeto:list){
                System.out.println(objeto.getCodigo()+"\t"+
                        objeto.getNome()+"\t"+
                        objeto.getSigla());
            }*/
            
            List<cidade> list = dao.getCidadeList("%CRI%");
            for (cidade objeto:list){
                System.out.println(objeto.getCodigo()+"\t"+
                        objeto.getNome()+"\t"+
                        objeto.getSigla());
            }
            
            
       } catch (SQLException ex) {
            System.out.println("Erro SQL: "+ex.getMessage());
        }
        
    }
}

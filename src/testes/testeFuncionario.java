package testes;
import DAO.cidadeDAO;
import DAO.funcionarioDAO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import modelo.cidade;
import modelo.funcionario;
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
           // PreparedStatement ps = conexao.conexaoBanco.getConnection().prepareStatement(SQL);
            // ps.execute();
            
            // ADD
            funcionarioDAO dao = new funcionarioDAO();
            /*System.out.println(dao.addFuncionario(new funcionario(0, "Funcionario B",
                    "Rua tal 3",
                    3000,
                    new cidadeDAO().getCidade(1))));
            System.out.println("Comando SQL executado."); */
            
            //Atualizar
            /*System.out.println(dao.updateFuncionario(new funcionario(1, 
                    "outro nome",
                    "outro endereço",
                    999,
                    new cidadeDAO().getCidade(3))));*/
            // deletar
           // System.out.println(dao.removeFuncionario(new funcionario(15, "a", "a", 1, new cidadeDAO().getCidade(1))));
            //select por FK
            /*funcionario f = dao.getFuncionario(2);
            if (f == null){
                System.out.println("nao existe");
            }
            else{
                System.out.println(f.getCodigo()+"\t"+
                        f.getNome()+"\t"+
                        f.getEndereco()+"t"+
                        f.getSalario()+"\t"+
                        f.getCidade().getNome()+"-"+
                        f.getCidade().getSigla());
            }*/
            List<funcionario> list = dao.getFuncionarioList();
            for (funcionario objeto: list){
                System.out.println(objeto.getCodigo()+"\t"+
                        objeto.getNome()+"\t"+
                        objeto.getSalario()+"\t"+
                        objeto.getCidade().getNome());
            }
            
       } catch (SQLException ex) {
            System.out.println("Erro SQL: "+ex.getMessage());
        }  
    }
}

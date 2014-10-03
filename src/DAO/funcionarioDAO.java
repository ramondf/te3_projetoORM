package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import modelo.funcionario;

public class funcionarioDAO extends genericDAO{
    public int addFuncionario(funcionario Funcionario) throws SQLException{
        Funcionario.setCodigo(super.getProximo("FUNCIONARIO", "CD_FUNCIONARIO"));
        String SQL="INSERT INTO FUNCIONARIO VALUES (?,?,?,?,?)";
        super.executeUpdate(SQL, Funcionario.getCodigo(),
                Funcionario.getNome(),
                Funcionario.getEndereco(),
                Funcionario.getSalario(),
                Funcionario.getCidade().getCodigo());
        
        return(Funcionario.getCodigo());
    }
    
    public int updateFuncionario(funcionario Funcionario) throws SQLException{
        String SQL="UPDATE FUNCIONARIO SET NM_FUNCIONARIO=?,"
                + "DS_ENDERECO=?,"
                + "VL_SALARIO=?,"
                + "CD_CIDADE=?"
                + " WHERE CD_FUNCIONARIO=?";
        super.executeUpdate(SQL, Funcionario.getNome(),
                Funcionario.getEndereco(),
                Funcionario.getSalario(),
                Funcionario.getCidade().getCodigo(),
                Funcionario.getCodigo());
        return Funcionario.getCodigo();
    }
    
    public boolean removeFuncionario(funcionario Funcionario) throws SQLException{
        String SQL="DELETE FROM FUNCIONARIO WHERE CD_FUNCIONARIO=?";
        return (super.executeUpdate(SQL, Funcionario.getCodigo())>0);
        
    }
    
    public funcionario getFuncionario (int pk) throws SQLException{
        String SQL="SELECT * FROM FUNCIONARIO WHERE CD_FUNCIONARIO=?";
        ResultSet rs = super.executeQuery(SQL, pk);
        funcionario retorno =null;
        
        if (rs.next()){
            retorno=populateFuncionario(rs);
        }
        return (retorno);
    }
    
    public List<funcionario> getFuncionarioList() throws SQLException{
        String SQL="SELECT * FROM FUNCIONARIO ORDER BY NM_FUNCIONARIO";
        List<funcionario> lista = new LinkedList<>();
        ResultSet rs = super.executeQuery(SQL);
        while(rs.next()){
            lista.add(populateFuncionario(rs));
        }
        return (lista);
    }
    
    public static funcionario populateFuncionario(ResultSet rs) throws SQLException{
        return (new funcionario(
        rs.getInt("CD_FUNCIONARIO"),
                rs.getString("NM_FUNCIONARIO"),
                rs.getString("DS_ENDERECO"),
                rs.getDouble("VL_SALARIO"),
                new cidadeDAO().getCidade(rs.getInt("CD_CIDADE"))));
    }
}

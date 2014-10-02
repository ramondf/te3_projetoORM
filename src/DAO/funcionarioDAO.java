package DAO;

import java.sql.SQLException;
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
}

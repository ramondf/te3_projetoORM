package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class genericDAO {
    public Statement getStatement() throws SQLException{
        return (conexao.conexaoBanco.getConnection().createStatement());
    }
    
    public PreparedStatement getStatement(String sql) throws SQLException{
        return (conexao.conexaoBanco.getConnection().prepareStatement(sql));
    }
    
    public int executeUpdate (String SQL, Object...params) throws SQLException{
        PreparedStatement ps = getStatement(SQL);
        for (int i=0; i<params.length; i++){
            ps.setObject((i+1),params[i]);            
        }
        return (ps.executeUpdate());
    }
    
    public ResultSet executeQuery(String SQL, Object...params) throws SQLException{
        PreparedStatement ps = getStatement(SQL);
        for (int i=0; i<params.length;i++){
            ps.setObject((i+1), params[i]);
            
        }
        return (ps.executeQuery());
    }
    
    public int getProximo(String tabela, String pk) throws SQLException{
        String SQL="SELECT MAX ("+pk+") AS MAIOR FROM "+tabela;
        ResultSet rs = executeQuery(SQL);
        int codigo = (rs.next() ? rs.getInt("MAIOR") : 0);
        return (++codigo);
    }
}

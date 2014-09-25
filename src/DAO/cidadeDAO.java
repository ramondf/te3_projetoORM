package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.cidade;

public class cidadeDAO extends genericDAO{
    // adicionar
    
    // atualizar
    
    // remover
    
    //pesquisa por FK
    
    // lista de cidades  com filtro pelo nome
    public int addCidade(cidade Cidade) throws SQLException{
        Cidade.setCodigo(super.getProximo("CIDADE", "CD_CIDADE"));
        String SQL="INSERT INTO CIDADE VALUES(?,?,?)";
        super.executeUpdate(SQL, Cidade.getCodigo(),
                Cidade.getNome(),
                Cidade.getSigla());
        return (Cidade.getCodigo());
    }
    
    public int updateCidade(cidade Cidade) throws SQLException{
        String SQL="UPDATE CIDADE SET NM_CIDADE=?, DS_SIGLA=? "
                + "WHERE CD_CIDADE=?";
        return super.executeUpdate(SQL, Cidade.getNome(),
                Cidade.getSigla(),
                Cidade.getCodigo());
    }
    
    public boolean removeCidade(cidade Cidade) throws SQLException{
        String SQL="DELETE FROM CIDADE WHERE CD_CIDADE=?";
        return (super.executeUpdate(SQL, Cidade.getCodigo()) > 0);
    }
    
    public cidade getCidade(int pk) throws SQLException{
        cidade Cidade = null;
        String SQL = "SELECT * FROM CIDADE WHERE CD_CIDADE=?";
        ResultSet rs = super.executeQuery(SQL, pk);
        if (rs.next()){
            Cidade = populateCidade(rs);
        }
        return Cidade;
    }
    
    public static cidade populateCidade(ResultSet rs) throws SQLException{
        return (new cidade(rs.getInt("CD_CIDADE"),
        rs.getString("NM_CIDADE"),
        rs.getString("DS_SIGLA")));
    }
}

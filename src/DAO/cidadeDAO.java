package DAO;

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
}

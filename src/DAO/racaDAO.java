package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import modelo.raca;
import tipos.tipoEspecie;

public class racaDAO extends genericDAO{
    public int addRaca(raca Raca) throws SQLException{
        Raca.setCodigo(super.getProximo("RACA", "CD_RACA"));
       String SQL="INSERT INTO RACA VALUES(?,?,?)";
        super.executeUpdate(SQL, Raca.getCodigo(),
                Raca.getNome(),
                Raca.getEspecie().getTipo());
        return (Raca.getCodigo()); 
    }
    public int updateRaca(raca Raca) throws SQLException{
        String SQL="UPDATE RACA SET NM_RACA=?, TP_ESPECIE=? "
                + "WHERE CD_RACA=?";
        return super.executeUpdate(SQL, Raca.getNome(),
                Raca.getEspecie().getTipo(),
                Raca.getCodigo());
    }
    
    
    public boolean removeRaca(raca Raca) throws SQLException{
        String SQL="DELETE FROM RACA WHERE CD_RACA=?";
        return (super.executeUpdate(SQL, Raca.getCodigo()) > 0);
    }
    
    public raca getRaca(int pk) throws SQLException{
        raca Raca = null;
        String SQL = "SELECT * FROM RACA WHERE CD_RACA=?";
        ResultSet rs = super.executeQuery(SQL, pk);
        if (rs.next()){
            Raca = populateRaca(rs);
        }
        return Raca;
    }
    
    public List<raca> getRacaList() throws SQLException{
        List<raca> list = new LinkedList<>();
        String SQL="SELECT * FROM RACA ORDER BY NM_RACA";
        ResultSet rs = super.executeQuery(SQL);
        while (rs.next()){
            list.add(populateRaca(rs));
        }
        
        return list;
    }
    
    public List<raca> getRacaList(String procura) throws SQLException{
        List<raca> list = new LinkedList<>();
        String SQL="SELECT * FROM RACA WHERE NM_RACA LIKE ? ORDER BY NM_RACA";
        ResultSet rs = super.executeQuery(SQL, procura);
        while(rs.next()){
            list.add(populateRaca(rs));
        }
        return list;
    }
    
    public static raca populateRaca(ResultSet rs) throws SQLException{
        raca Raca = new raca();
        Raca.setCodigo(rs.getInt("CD_RACA"));
        Raca.setNome(rs.getString("NM_RACA"));
        
        // converter string que vem do banco ENUM
        
        for (tipoEspecie tipo:tipoEspecie.values()){
            if (tipo.getTipo().equals(rs.getString("TP_ESPECIE"))){
                Raca.setEspecie(tipo);
            }
        }

        return (Raca);        
    }
}

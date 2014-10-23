package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import modelo.animal;
import tipos.tipoGenero;

    
public class animalDAO extends genericDAO{
    public int addAnimal(animal Animal) throws SQLException{
        Animal.setCodigo(super.getProximo("ANIMAL", "CD_ANIMAL"));
       String SQL="INSERT INTO ANIMAL VALUES(?,?,?,?,?,?)";
        super.executeUpdate(SQL, Animal.getCodigo(),
                Animal.getNome(),
                Animal.getDataNascimento());
                Animal.getProprietario();
                Animal.getGenero().getTipo();
                Animal.getRaca().getCodigo();
        return (Animal.getCodigo()); 
    }
    public int updateAnimal(animal Animal) throws SQLException{
        String SQL="UPDATE ANIMAL SET NM_ANIMAL=?, DT_NASCIMENTO=?, NM_PROPRIETARIO=?, TP_GENERO=?, CD_RACA=? "
                + "WHERE CD_RACA=?";
        return super.executeUpdate(SQL, Animal.getNome(),
                Animal.getDataNascimento(),
                Animal.getProprietario(),
                Animal.getGenero(),
                Animal.getRaca().getCodigo(),
                Animal.getCodigo());
    }
    
    
    public boolean removeAnimal(animal Animal) throws SQLException{
        String SQL="DELETE FROM ANIMAL WHERE CD_ANIMAL=?";
        return (super.executeUpdate(SQL, Animal.getCodigo()) > 0);
    }
    
    public animal getAnimal(int pk) throws SQLException{
        animal Animal = null;
        String SQL = "SELECT * FROM ANIMAL WHERE CD_ANIMAL=?";
        ResultSet rs = super.executeQuery(SQL, pk);
        if (rs.next()){
            Animal = populateAnimal(rs);
        }
        return Animal;
    }
    
    public List<animal> getAnimalList() throws SQLException{
        List<animal> list = new LinkedList<>();
        String SQL="SELECT * FROM ANIMAL ORDER BY NM_ANIMAL";
        ResultSet rs = super.executeQuery(SQL);
        while (rs.next()){
            list.add(populateAnimal(rs));
        }
        
        return list;
    }
    
    public List<animal> getAnimalList(String procura) throws SQLException{
        List<animal> list = new LinkedList<>();
        String SQL="SELECT * FROM ANIMAL WHERE NM_ANIMAL LIKE ? ORDER BY NM_ANIMAL";
        ResultSet rs = super.executeQuery(SQL, procura);
        while(rs.next()){
            list.add(populateAnimal(rs));
        }
        return list;
    }
    
    public static animal populateAnimal(ResultSet rs) throws SQLException{
        animal Animal = new animal();
        Animal.setCodigo(rs.getInt("CD_ANIMAL"));
        Animal.setNome(rs.getString("NM_ANIMAL"));
        Animal.setDataNascimento(rs.getDate("DT_NASCIMENTO"));
        Animal.setProprietario(rs.getString("NM_PROPRIETARIO"));
        Animal.setRaca(new racaDAO().getRaca(rs.getInt("CD_RACA")));
        for (tipoGenero tipo : tipoGenero.values()){
            if (tipo.getTipo().equals(rs.getString("TP_GENERO"))){
                Animal.setGenero(tipo);
            }
        }        
        return (Animal);
      
    }
}

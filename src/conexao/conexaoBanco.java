package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexaoBanco {
    private static Connection conn=null;

    public conexaoBanco() {
    }
    
    private static void conectaBanco(){
        String url="jdbc:mysql://localhost:3306/bancoorm";
        String usr="root";
        String pwd="123456";
        
        try {
            conn=DriverManager.getConnection(url, usr, pwd);
            System.out.println("Banco conectado.");
            
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar no banco: "+ex.getMessage());
        }
    }
    public static Connection getConnection(){
        if (conn==null){
            conectaBanco();
        }
        return (conn);        
    }
}

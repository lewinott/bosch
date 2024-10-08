package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexaoDB {
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection (
                    "jdbc:mysql://localhost:3306/delivery?user=root&password=Gatinha2." );
        }catch (SQLException e){
            System.out.println("Erro ao conectar ao banco: "+ e.getMessage());
            return null;
        }
    }
}

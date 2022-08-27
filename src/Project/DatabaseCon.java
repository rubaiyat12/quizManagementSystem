
package Project;

import java.sql.Connection;
import java.sql.DriverManager;


public class DatabaseCon {
    public static void main(String[] args){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/qems","root","raha");
            System.out.print("conection establish");
            
        }catch(Exception e){
            
            System.out.print(e);
        }
    }
}

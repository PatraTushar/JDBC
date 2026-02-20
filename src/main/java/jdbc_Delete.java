import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class jdbc_Delete {

    public static void main(String[] args) throws Exception {

        String email = "riya@gmail.com";

        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println(" Driver loaded successfully ");


        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true", "root", "root");

        PreparedStatement ps = con.prepareStatement(" delete from register where email=? ");
        ps.setString(1,email);

        int count= ps.executeUpdate();

        if (count>0){

            System.out.println(" deletion successful ");
        }

        else System.out.println(" deletion failed ");






    }
}

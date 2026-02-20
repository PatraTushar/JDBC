import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Jdbc_Update {

    public static void main(String[] args) throws Exception {


        String city = "Mumbai";
        String email = "rahul@gmail.com";

        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println(" Driver loaded successfully ");

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true", "root", "root");

        PreparedStatement ps = con.prepareStatement(" update register set city=? where email=? ");
        ps.setString(1, city);
        ps.setString(2, email);

        int count = ps.executeUpdate();
        if (count > 0) {
            System.out.println(" update successfully ");
        } else System.out.println(" updation failed ");

        con.close();


    }
}

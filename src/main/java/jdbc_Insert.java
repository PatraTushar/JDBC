import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class jdbc_Insert {

    public static void main(String[] args) {

        String name = "Riya";
        String gmail = "riya@gmail.com";
        String password = "riya748";
        String gender = "Female";
        String city = "Chennai";

        try {
            // 1. Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully!");


            // 2. Get connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true", "root", "root");


            //  3. create statement
            // PreparedStatement ps = con.prepareStatement("insert into register values('"+name+"','"+gmail+"','"+password+"','"+gender+"','"+city+"')");

            PreparedStatement ps = con.prepareStatement("INSERT INTO register VALUES(?, ?, ?, ?, ?)");
            ps.setString(1, name);
            ps.setString(2, gmail);
            ps.setString(3, password);
            ps.setString(4, gender);
            ps.setString(5, city);

            // 4.Execute sql statement
            int i = ps.executeUpdate();

            if (i > 0) {
                System.out.println(" success ");
            } else {

                System.out.println(" fail ");
            }


        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found!");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();

        }


    }
}

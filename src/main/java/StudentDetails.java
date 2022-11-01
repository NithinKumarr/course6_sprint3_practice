import java.sql.*;

public class StudentDetails {
    public void getAllStudentDetails() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/School", "root", "Bunny@123");
            String sql = "select * from Student";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next())
            {
                //System.out.println(resultSet.getString(1)+" "+resultSet.getInt(2)+" "+resultSet.getString(3)+" "+resultSet.getInt(4));
                System.out.format(resultSet.getString(1), resultSet.getInt(2), resultSet.getString(3), resultSet.getInt(4));
            }
        }
        catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        StudentDetails studentDetails = new StudentDetails();
        studentDetails.getAllStudentDetails();
    }
}
package Library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection_database {
    public static Connection Provide_Connection() {

        try {
            String url = "jdbc:mysql://localhost:3307/library";
            String password = "9170196068";
            String user = "root";

            Connection connection = DriverManager.getConnection(url, user, password);
            return connection;
        } catch (SQLException e) {
            return null;
        }
    }
}

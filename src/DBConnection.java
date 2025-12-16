import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

        private static final String URL = "jdbc:mysql://localhost:3306/miami_car?serverTimezone=Europe/Madrid";
        private static final String USER = "root";
        private static final String PASSWORD = "root"; // pon tu contraseña si tienes

        public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }
}

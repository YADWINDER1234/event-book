package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    // Railway DB connection logic
    private static final String DEFAULT_URL = "jdbc:mysql://shortline.proxy.rlwy.net:39622/railway?useSSL=false&allowPublicKeyRetrieval=true";
    private static final String DEFAULT_USER = "root";

    public static Connection getConnection() throws SQLException {
        String dbUrl = System.getenv("MYSQL_URL");
        String dbUser = System.getenv("MYSQL_USER");
        String dbPassword = System.getenv("MYSQL_PASSWORD");
        if (dbPassword == null || dbPassword.isEmpty()) {
            dbPassword = System.getenv("MYSQL_ROOT_PASSWORD");
        }

        // Use Railway env variables if available, otherwise local defaults
        String url = (dbUrl != null && !dbUrl.isEmpty()) ? dbUrl : DEFAULT_URL;
        String user = (dbUser != null && !dbUser.isEmpty()) ? dbUser : DEFAULT_USER;
        String password = dbPassword;

        return DriverManager.getConnection(url, user, password);
    }
}

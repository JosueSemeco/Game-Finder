package gameFinder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB_Connection {
    private static final String DB_URL = "jdbc:sqlite:src/database.db";  // Ruta relativa a la base de datos

    public static Connection connect() {
        Connection conn = null;
        try {
            // Cargar el controlador JDBC de SQLite
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(DB_URL);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("SQLite JDBC driver not found. Add the JAR to the classpath.");
        }
        return conn;
    }

    public static void insertScore(String usuario, int puntuacion) {
        String sql = "INSERT INTO Record(usuario, puntuacion) VALUES(?, ?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, usuario);
            pstmt.setInt(2, puntuacion);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updateScoreIfHigher(String usuario, int nuevaPuntuacion) {
        String selectSql = "SELECT puntuacion FROM Record WHERE usuario = ?";
        String updateSql = "UPDATE Record SET puntuacion = ? WHERE usuario = ?";

        try (Connection conn = connect();
             PreparedStatement selectPstmt = conn.prepareStatement(selectSql)) {

            selectPstmt.setString(1, usuario);
            ResultSet rs = selectPstmt.executeQuery();

            if (rs.next()) {
                int puntuacionActual = rs.getInt("puntuacion");
                if (nuevaPuntuacion > puntuacionActual) {
                    try (PreparedStatement updatePstmt = conn.prepareStatement(updateSql)) {
                        updatePstmt.setInt(1, nuevaPuntuacion);
                        updatePstmt.setString(2, usuario);
                        updatePstmt.executeUpdate();
                    }
                }
            } else {
                insertScore(usuario, nuevaPuntuacion);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
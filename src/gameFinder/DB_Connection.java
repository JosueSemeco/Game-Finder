package gameFinder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DB_Connection {
    private static final String DB_URL = "jdbc:sqlite:database.db";  // Ruta relativa a la base de datos

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

    public static List<UserScore> getUserScores() {
        String sql = "SELECT id, usuario, puntuacion FROM Record ORDER BY puntuacion DESC";
        List<UserScore> userScores = new ArrayList<>();

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String usuario = rs.getString("usuario");
                int puntuacion = rs.getInt("puntuacion");
                userScores.add(new UserScore(id, usuario, puntuacion));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return userScores;
    }

    public static void deleteUserScore(int id) {
        String sql = "DELETE FROM Record WHERE id = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

class UserScore {
    private int id;
    private String usuario;
    private int puntuacion;

    public UserScore(int id, String usuario, int puntuacion) {
        this.id = id;
        this.usuario = usuario;
        this.puntuacion = puntuacion;
    }

    public int getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public int getPuntuacion() {
        return puntuacion;
    }
}
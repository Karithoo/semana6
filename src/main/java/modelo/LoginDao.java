package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.Conexion;

public class LoginDao {
	
    public static int validar(String user, String pass) {
        Connection con = null;
        Conexion cn = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String us = "";
        int valido = 0;
        String sql = "SELECT * FROM db.login WHERE user = ? AND pass = ?";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();

            while (rs.next()) {
                us = rs.getString("user");
            }

            // Verificar si el usuario es "admin"
            if ("admin".equals(us)) {
                valido = 1;
            } else {
                valido = 0;
            }
        } catch (SQLException e) {
            e.printStackTrace(); // En una aplicación real, considera manejar la excepción de manera apropiada
        } finally {
            // Cerrar recursos en un bloque finally para asegurar que se cierren incluso si ocurre una excepción
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace(); // Manejar adecuadamente las excepciones al cerrar recursos
            }
        }

        return valido;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class SQLUsuario {

    private static Connection Conexion1;

    public void mysql_connection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Conexion1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "usertienda", "root", "");
            System.out.println("Se ha iniciado la conexión con el servidor a la base usuarios de forma exitosa");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SQLCatalogo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SQLCatalogo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void close_connection() {
        try {
            Conexion1.close();
            System.out.println("Se ha finalizado la conexion con el servidor");
        } catch (SQLException ex) {
            Logger.getLogger(SQLCatalogo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean login(String user, String pass) {
        ResultSet rs = null;
        try {

            String Query = "SELECT id, usuario, contraseña, nombre FROM usuarios WHERE BINARY usuario = '" + user + "'";
            Statement st = Conexion1.createStatement();
            rs = st.executeQuery(Query);

            if (rs.next()) {
                System.out.println(rs.getString("nombre"));
                System.out.println(rs.getString("usuario"));
                if (user.equals(rs.getString("usuario"))) {
                    if (pass.equals(rs.getString("contraseña"))) {
                        JOptionPane.showMessageDialog(null, "Usuario encontrado");
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null, "La contraseña del usuario " + user + " no coincide");
                        return false;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "El usuario " + user + " no existe");
                return false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(SQLCatalogo.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al hacer login con " + user);
        }
        return false;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class SQLCatalogo {

    private static Connection Conexion;

    public void mysql_connection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "tiendaotto", "root", "");
            System.out.println("Se ha iniciado la conexión con el servidor de forma exitosa");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SQLCatalogo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SQLCatalogo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void mysql_connection_base() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "", "root", "");
            System.out.println("Se ha iniciado la conexión con el servidor de forma exitosa");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SQLCatalogo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SQLCatalogo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean verificar_bd() {        
        try {
            ResultSet rs = Conexion.getMetaData().getCatalogs();
            while (rs.next()) {
                if ("tiendaotto".equals(rs.getString(1))) {
                 return true;   
                }
            }

        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return false;
    }

    public void close_connection() {
        try {
            Conexion.close();
            System.out.println("Se ha finalizado la conexion con el servidor");
        } catch (SQLException ex) {
            Logger.getLogger(SQLCatalogo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void create_db(String name) {
        try {
            String Query = "CREATE DATABASE " + name;
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
            JOptionPane.showMessageDialog(null, "Se ha creado la base de datos " + name + " de forma exitosa");
        } catch (SQLException ex) {
            Logger.getLogger(SQLCatalogo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void drop_db(String name) {
        try {
            String Query = "DROP DATABASE " + name;
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
            JOptionPane.showMessageDialog(null, "Se ha eliminado la base de datos " + name + " de forma exitosa");
        } catch (SQLException ex) {
            Logger.getLogger(SQLCatalogo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void create_table_db(String name) {
        try {
            String Query = "CREATE TABLE " + name + ""
                    + "(ID INT UNSIGNED AUTO_INCREMENT PRIMARY KEY , codigo VARCHAR(50), nombre VARCHAR(50), "
                    + "cantidad INT(5), precio  DECIMAL(10,2), detalle VARCHAR(50))";
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
            JOptionPane.showMessageDialog(null, "Se ha creado la tabla " + name + " de forma exitosa");
        } catch (SQLException ex) {
            Logger.getLogger(SQLCatalogo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete_table_db(String name) {
        try {
            String Query = "DROP TABLE " + name;
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
            JOptionPane.showMessageDialog(null, "Se ha eliminado la tabla " + name + " de forma exitosa");
        } catch (SQLException ex) {
            Logger.getLogger(SQLCatalogo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet search_data(String codigo) {
        ResultSet rs = null;
        try {
            String Query = "SELECT * FROM productos WHERE codigo =" + codigo;
            Statement st = Conexion.createStatement();
            rs = st.executeQuery(Query);
            JOptionPane.showMessageDialog(null, "Se ha realizado la busqueda");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la busqueda");
        }
        return rs;
    }

    public void insert_data(String table_name, String codigo, String nombre, int cantidad, Double precio, String detalle) {
        try {
            String Query = "INSERT INTO " + table_name + "(codigo,nombre,cantidad,precio,detalle) VALUES("
                    + "\"" + codigo + "\","
                    + "\"" + nombre + "\","
                    + "\"" + cantidad + "\","
                    + "\"" + precio + "\","
                    + "\"" + detalle + "\")";

            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
            JOptionPane.showMessageDialog(null, "Datos almacenados de forma exitosa");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en el almacenamiento de datos");
        }
    }

    public void modify_data(String newid, String newcodigo, String newnombre, String newcantidad, String newprecio, String newdetalle) {
        try {
            String Query = " Update productos SET codigo='" + newcodigo + "',nombre='" + newnombre + "', cantidad = '" + newcantidad
                    + "', precio = '" + newprecio + "', detalle = '" + newdetalle + "' where id = " + newid;
            PreparedStatement pst = Conexion.prepareStatement(Query);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se ha modificado de forma exitosa");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar");
        }
    }

    public void delete_data(String codigo) {
        try {
            String Query = "DELETE FROM productos WHERE codigo =" + codigo;
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
            JOptionPane.showMessageDialog(null, "Datos eliminados de forma exitosa");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar los datos");
        }
    }

    public ResultSet charge_table() {
        ResultSet rs = null;
        try {

            String Query = "SELECT codigo, nombre, cantidad, precio, detalle FROM productos";
            Statement st = Conexion.createStatement();
            rs = st.executeQuery(Query);

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }

        return rs;
    }

    public ResultSet clickear(String identificador) {

        ResultSet rs = null;
        Statement st = null;

        try {
            String Query = "SELECT id, codigo, nombre, cantidad, precio, detalle FROM productos WHERE codigo = " + identificador;
            st = Conexion.createStatement();
            rs = st.executeQuery(Query);
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return rs;
    }

}

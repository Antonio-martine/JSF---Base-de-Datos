
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import models.Usuarios;

public class ConexionDao {
    Connection con;
    Statement stm;
    ResultSet rs;
    
    public void conectar(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ingenieriadgs","root","root");
            stm = con.createStatement();
        } catch (ClassNotFoundException err) {
            System.out.println("Error al conectar a la bd: "+err);
        }catch (SQLException err){
            System.out.println("Error en los parametrod de la BD: "+err);
        }
    }
    public void desconectar(){
        try {
            con.close();
            System.out.println("Desconexión correcta de la BD");
        } catch (SQLException err) {
            System.out.println("Error al desconectar la BD: "+err);
        }
    }
    
    /*Insetar nuevo usuario*/
    public void Insertar_usuario(Usuarios usuario){
        conectar();
        String sql ="insert into usuario (nombre,apellido,sexo,email,contraseña) values ('"+usuario.getNombre()+"','"+usuario.getApellido()+"','"+usuario.getSexo()+"','"
                +usuario.getEmail()+"','"+usuario.getContraseña()+"')";
        try {
            stm.executeUpdate(sql);
            System.out.println("Envio de datos correcto... ");
        } catch (SQLException err) {
            System.out.println("Error al envisar los datos, revisar conexion (insertar_usuario)... ");
        }
        desconectar(); 
    }
}

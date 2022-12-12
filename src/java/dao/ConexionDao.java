
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Computadoras;
import models.Usuarios;
import util.DataConnect;

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
    
    /*Insetar nuevo dispositivo*/
    public void Insertar_computadora(Computadoras computadora){
        conectar();
        String sql ="insert into computadora (tipo,marca,modelo,descripcion,costo) values ('"+computadora.getTipo()+"','"+computadora.getMarca()+"','"+computadora.getModelo()+"','"
                +computadora.getDescripcion()+"','"+computadora.getCosto()+"')";
        try {
            stm.executeUpdate(sql);
            System.out.println("Envio de datos correcto... ");
        } catch (SQLException err) {
            System.out.println("Error al envisar los datos, revisar conexion (insertar_usuario)... ");
        }
        desconectar(); 
    }
    
    /*Mostrar dispositivos*/
    public List<Computadoras> getComputadoras() throws SQLException{
        conectar();
        String sql = "select * from computadora order by idComputadora";
        rs = stm.executeQuery(sql);
        List<Computadoras> listaComputadoras = new ArrayList<Computadoras>();
        while(rs.next()){
            Computadoras computadora = new Computadoras();
            computadora.setIdComputadora(rs.getInt("idComputadora"));
            computadora.setTipo(rs.getString("tipo"));
            computadora.setMarca(rs.getString("marca"));
            computadora.setModelo(rs.getString("modelo"));
            computadora.setDescripcion(rs.getString("descripcion"));
            computadora.setCosto(rs.getDouble("costo"));
            listaComputadoras.add(computadora);
        }
        desconectar();
        return listaComputadoras;
    }
    
    public void modificar_computadora(Computadoras computadora){
        conectar();
        String sql="update computadora set tipo='"+computadora.getTipo()+"',marca= '"+computadora.getMarca()+"',"
                + "modelo= '"+computadora.getModelo()+"',descripcion= '"+computadora.getDescripcion()+"',costo= '"
                +computadora.getCosto()+"' where (idComputadora ='"+computadora.getIdComputadora()+"')";
        try {
            stm.executeUpdate(sql);
            System.out.println("Datos modeficados correctamente");
        } catch (SQLException err) {
            System.out.println("Error al modificar el dato: "+err);
        }
    }
    
    public void elimidar_computadora(Computadoras computadora){
        conectar();
        String sql = "delete from computadora where idComputadora= "+computadora.getIdComputadora();
        try {
            stm.executeUpdate(sql);
            System.out.println("Dato eliminado correctamente");
        } catch (SQLException err) {
            System.out.println("Datos no eliminado: "+err);
        }
        desconectar();
    }
    
    /*Consultar*/
    public static boolean validate(String user, String password) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        try{
            con = DataConnect.getConnection();
            String sql ="select email, contraseña from usuario where email = ? and contraseña = ?";
            ps=con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, password);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                return true;
            }
        }catch (SQLException ex){
            System.out.println("Login error: "+ex.getMessage());
            return false;
        }finally{
            DataConnect.close(con);
        }
        return false;
    }
    
    
}

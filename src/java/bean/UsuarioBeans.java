/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.ConexionDao;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import models.Usuarios;

@ManagedBean
@RequestScoped
public class UsuarioBeans {

    private int contador;
    private Usuarios usuario;
    
    public UsuarioBeans() {
        usuario = new Usuarios();
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public void clearBean(){
        usuario.setIdUsuario(0);
        usuario.setNombre("");
        usuario.setApellido("");
        usuario.setSexo("");
        usuario.setEmail("");
        usuario.setContraseña("");
    }
    
    public void insertar() throws SQLException{
        ConexionDao conexion = new ConexionDao();
        conexion.Insertar_usuario(usuario);
        conexion = new ConexionDao();
        clearBean();
    }
    
    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
    
    
}


package bean;

import dao.ConexionDao;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import models.Computadoras;

@ManagedBean
@RequestScoped
public class ComputadoraBeans { 

    private int contador; 
    private List<Computadoras> listaComputadoras;
    private Computadoras computadora;
    
    public ComputadoraBeans() {
        computadora = new Computadoras();
    }

    public List<Computadoras> getListaComputadoras() throws SQLException{
        ConexionDao conexion = new ConexionDao();
        listaComputadoras = conexion.getComputadoras();
        return listaComputadoras;
    }

    public void setListaComputadoras(List<Computadoras> listaComputadoras) {
        this.listaComputadoras = listaComputadoras;
    }

    public Computadoras getComputadora() {
        return computadora;
    }

    public void setComputadora(Computadoras computadora) {
        this.computadora = computadora;
    }
    
    public void clearBean(){
        Computadoras computadora = new Computadoras();
        computadora.setIdComputadora(0);
        computadora.setTipo("");
        computadora.setMarca("");
        computadora.setModelo("");
        computadora.setDescripcion("");
        computadora.setCosto(0.0);
    }
    
    public void insertar() throws SQLException{
        ConexionDao conexion = new ConexionDao();
        conexion.Insertar_computadora(computadora);
        computadora = new Computadoras();
        clearBean();
    }
    
    public void modificar() throws SQLException{
        ConexionDao conexion = new ConexionDao();
        conexion.modificar_computadora(computadora);
        computadora = new Computadoras();
        clearBean();
    }
    
    public void eliminar(Computadoras computadora) throws SQLException{
        ConexionDao conexion = new ConexionDao();
        conexion.elimidar_computadora(computadora);
        computadora = new Computadoras();
        clearBean();
    }

    public int getContador() {
        contador = contador+1;
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
 
    
}

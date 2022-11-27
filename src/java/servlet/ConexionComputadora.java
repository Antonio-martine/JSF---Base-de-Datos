
package servlet;

import dao.ConexionDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Computadoras;

@WebServlet(name = "ConexionComputadora", urlPatterns = {"/ConexionComputadora"})
public class ConexionComputadora extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                response.setContentType("text/html;charset=UTF-8");
                try (PrintWriter out = response.getWriter()) {
                    out.print("Comprobando conexion ... ");
                    ConexionDao conexion = new ConexionDao();
                    conexion.conectar();
                    out.print("Envio de datos ... ");
                    Computadoras computadora =  new Computadoras();
                    computadora.setTipo("Laptop");
                    computadora.setMarca("DELL");
                    computadora.setModelo("E5520");
                    computadora.setDescripcion("Computadora negra con microprocesador Core I5");
                    computadora.setCosto(4500.20);
                    conexion.Insertar_computadora(computadora);
                    out.print("Envio de datos correctamente ... ");
                    conexion.desconectar();
                    out.print("Desconectado de la BD ... ");
                }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

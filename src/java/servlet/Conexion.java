package servlet;

import dao.ConexionDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Usuarios;

@WebServlet(name = "Conexion", urlPatterns = {"/Conexion"})
public class Conexion extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                response.setContentType("text/html;charset=UTF-8");
                try (PrintWriter out = response.getWriter()) {
                    out.print("Probando conexion... ");
                    ConexionDao conexion = new ConexionDao();
                    conexion.conectar();
                    out.print("Desconectando... ");
                    conexion.desconectar();
                    out.print("Desconectado de Mysql... ");
                    
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

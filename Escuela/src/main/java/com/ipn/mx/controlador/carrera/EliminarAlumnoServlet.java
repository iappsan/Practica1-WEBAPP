package com.ipn.mx.controlador.carrera;

import com.ipn.mx.modelo.dao.Alumno;
import com.ipn.mx.modelo.dao.CarreraDAO;
import com.ipn.mx.modelo.dto.AlumnoDTO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author deb
 */
public class EliminarAlumnoServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String idToDelete = request.getParameter("id");
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Eliminar carrera</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css' rel='stylesheet'>");
            out.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js' ></script>");

            Alumno dao = new Alumno();
            AlumnoDTO dto = new AlumnoDTO();
            dto.getEntidad().setIdAlumno(Long.parseLong(idToDelete));  //Recibiendo el id
            out.println("<div class='container'>");
            out.println("<h1>" + "Se ha eliminado el alumno seleccionada" + "</h1>");
            try {
                dao.delete(dto);
            } catch (SQLException ex) {
                Logger.getLogger(EliminarCarreraServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            out.println("<div class='alert alert-primary' role='alert'>");
            out.println("<h2> Registro eliminado satisfactoriamente </h2>");
            out.println("</div>");
            out.println("<a href='ListadoServlet' class='btn btn-primary'>Ver Listado de Carreras actual </a>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

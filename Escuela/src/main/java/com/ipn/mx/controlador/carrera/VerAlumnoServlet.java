package com.ipn.mx.controlador.carrera;

import com.ipn.mx.modelo.dao.Alumno;
import com.ipn.mx.modelo.dto.AlumnoDTO;
import jakarta.servlet.ServletException;
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
public class VerAlumnoServlet extends HttpServlet {
   
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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css' rel='stylesheet'>");
            out.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js' ></script>");

            out.println("<title>Ver Alumno</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container'>																																													");
            out.println("            <nav class='navbar navbar-expand-lg navbar-light bg-light'>																																	");
            out.println("                <div class='container-fluid'>                                                                                                                                                              ");
            out.println("                    <a class='navbar-brand' href='./'>Escuela</a>                                                                                                                                           ");
            out.println("                    <button class='navbar-toggler' type='button' data-bs-toggle='collapse' data-bs-target='#navbarNav' aria-controls='navbarNav' aria-expanded='false' aria-label='Toggle navigation'>     ");
            out.println("                        <span class='navbar-toggler-icon'></span>                                                                                                                                          ");
            out.println("                    </button>                                                                                                                                                                              ");
            out.println("                    <div class='collapse navbar-collapse' id='navbarNav'>                                                                                                                                  ");
            out.println("                        <ul class='navbar-nav'>                                                                                                                                                            ");
            out.println("                            <li class='nav-item'>                                                                                                                                                          ");
            out.println("                                <a class='nav-link' href='./carrera/nuevo.html'>Agregar Carrera</a>                                                                                                        ");
            out.println("                                <!-- <a class='nav-link' href='./CarreraServlet'>Carrera</a>-->                                                                                                            ");
            out.println("                            </li>                                                                                                                                                                          ");
            out.println("                            <li class='nav-item'>                                                                                                                                                          ");
            out.println("                                <a class='nav-link' href='ListadoServlet'>Listado de Carreras</a>                                                                                                          ");
            out.println("                            </li>                                                                                                                                                                          ");
            out.println("                        </ul>                                                                                                                                                                              ");
            out.println("                    </div>                                                                                                                                                                                 ");
            out.println("                </div>                                                                                                                                                                                     ");
            out.println("            </nav>                                                                                                                                                                                         ");
            out.println("</div>");
            
            out.println("<div class='container'>");
            out.println("<h1>Estos son los datos del Alumno Seleccionado</h1>");

            // Recibiendo el ID para mostrar el registro correspondiente 
            String idVerAlumno = request.getParameter("id");
            AlumnoDTO dto = new AlumnoDTO();
            AlumnoDTO dtoToShow = new AlumnoDTO();    //Guardará el registro que encuentre dada la CONSULTA SQL en la línea 56 
            dto.getEntidad().setIdAlumno(Long.parseLong(idVerAlumno));
            Alumno dao = new Alumno();
            try {
                dtoToShow = dao.read(dto);  //

                out.println("<h2>Id:" + dtoToShow.getEntidad().getIdCarrera() + "</h2>");
                out.println("<h2>Nombre: " + dtoToShow.getEntidad().getNombreAlumno()+ "</h2>");
                out.println("<h2>Apellido paterno: " + dtoToShow.getEntidad().getPaternoAlumno()+ "</h2>");
                out.println("<h2>Apellido materno: " + dtoToShow.getEntidad().getMaternoAlumno()+ "</h2>");
                out.println("<h2>Correo: " + dtoToShow.getEntidad().getEmailAlumno() + "</h2>");
                out.println("<h2>ID de carrera: " + dtoToShow.getEntidad().getIdCarrera()+ "</h2>");

            } catch (SQLException ex) {
                Logger.getLogger(VerCarreraServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            out.println("<a href='ListadoServletAlumno' class='btn btn-primary'> Ver Listado de Alumnos</a>");
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

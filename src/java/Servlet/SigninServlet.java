package Servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import User.UserDAO;
import User.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import note.noteDAO;
import note.noteDTO;

/**
 *
 * @author LAPTOP
 */
public class SigninServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        String user = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");

//            RequestDispatcher rd1 = request.getRequestDispatcher("menu.html");
//            rd1.include(request, response);
        if (action != null && action.equals("logout")) {
            HttpSession session = request.getSession(false);

            if (session != null) {
                session.invalidate();
            }

        } else {

            log("Debug user : " + user + " " + password);

            if (user == null && password == null) {

                log("Debug user : Go to login " + user + " " + password);
                RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
                rd.forward(request, response);
            } else {

                log("Debug user : Go to here " + user + " " + password);
                UserDAO userDAO = new UserDAO();
                UserDTO userDTO = userDAO.login(user, password);

                if (userDTO != null) {
                    
                    noteDAO noteDAO = new noteDAO();
                    Long userID = userDTO.getId();
                    List<noteDTO> list = noteDAO.list(userID);
                    
                    HttpSession session = request.getSession(true);
                    session.setAttribute("list", list);
                    session.setAttribute("usersession", userDTO);
                    RequestDispatcher rd = request.getRequestDispatcher("note.jsp");
                    rd.forward(request, response);

                } else {
                    request.setAttribute("error", "Wrong username or password");
                    RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                    rd.forward(request, response);
                }
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
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
     *
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
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

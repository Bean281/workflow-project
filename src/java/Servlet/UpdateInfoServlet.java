/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import User.SignUpCreateError;
import User.UserDAO;
import User.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author LAPTOP
 */
@WebServlet(name = "UpdateInfoServlet", urlPatterns = {"/UpdateInfoServlet"})
public class UpdateInfoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession(false);
        UserDTO currentUser = null;

        if (session != null) {
            currentUser = (UserDTO) session.getAttribute("usersession");
        }

        //chỉ cho phép khi đã login --> chặn lại khi copy link ra page mới 
        log("Debug: " + currentUser);
        if (currentUser == null) {
            log("Debug: Redirect to login page" + currentUser);
            response.sendRedirect("SigninServlet");
            return;
        }

        String url = "account_management.jsp";
        Long id = null;
        try {
            id = Long.parseLong(request.getParameter("id"));
        } catch (NumberFormatException ex) {
            System.out.println(ex);
        }
        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        String fullname = request.getParameter("txtFullname");
        String email = request.getParameter("txtEmail");
        boolean foundError = false;
        SignUpCreateError errors = new SignUpCreateError();

        try {
            UserDAO dao = new UserDAO();
            System.out.println(id);
            UserDTO user = null;
            if (id != null) {
                user = dao.load(id);
            }
            request.setAttribute("object", user);

            if (username.trim().length() < 6 || username.trim().length() > 20) {
                foundError = true;
                errors.setUsernameLengthError("Username is required input from 6 to 20 chars");
            }
            if (password.trim().length() < 6 || password.trim().length() > 30) {
                foundError = true;
                errors.setPasswordLengthError("Password is required input from 6 to 30 chars");
            }
            if (fullname.trim().length() < 6 || fullname.trim().length() > 50) {
                foundError = true;
                errors.setFullnameLengthError("Fullname is required input from 6 to 50 chars");
            }

            boolean checkEmail = dao.emailValidator(email);
            if (!checkEmail) {
                foundError = true;
                errors.setEmailValidateError("Email is not valid!");
            }
            if (foundError) {
                request.setAttribute("SIGNUP_ERRORS", errors);
            } else {
                boolean result = dao.updateInfo(id, username, fullname, password, email);
                if (result) {
                    System.out.println("Update thanh cong");
                    RequestDispatcher rd = request.getRequestDispatcher("ShowInformationServlet");
                    rd.forward(request, response);
                }
            }

        } catch (SQLException ex) {
            log("UpdateServlet_SQL" + ex.getMessage());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
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

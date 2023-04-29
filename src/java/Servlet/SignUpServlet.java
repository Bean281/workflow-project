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
import static java.lang.System.out;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LAPTOP
 */
@WebServlet(name = "SignUpServlet", urlPatterns = {"/SignUpServlet"})
public class SignUpServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String url = "sign_up.jsp";
        
        Long id = null;
            try {
                id = Long.parseLong(request.getParameter("id"));
            } catch (NumberFormatException ex) {
                System.out.println(ex);
            }
        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        String fullname = request.getParameter("txtFullname");
        String confirm = request.getParameter("txtConfirm");
        String email = request.getParameter("txtEmail");
        boolean foundError = false;
        SignUpCreateError errors = new SignUpCreateError();
        
        try {
            if (username.trim().length() < 6 || username.trim().length() > 20) {
                foundError = true;
                errors.setUsernameLengthError("Username is required input from 6 to 20 chars");
            }
            if (password.trim().length() < 6 || password.trim().length() > 30) {
                foundError = true;
                errors.setPasswordLengthError("Password is required input from 6 to 30 chars");
            } else if (!confirm.trim().equals(password.trim())) {
                foundError = true;
                errors.setConfirmNotMatched("Confirm must match password");
            }
            if (fullname.trim().length() < 6 || fullname.trim().length() >50) {
                foundError = true;
                errors.setFullnameLengthError("Fullname is required input from 6 to 50 chars");
            }
            UserDAO dao = new UserDAO();
            UserDTO dto = new UserDTO(id, username, password, fullname, email);
            boolean duplicate = dao.checkDuplicateUsername(username);
            if (duplicate) {
                foundError = true;
                errors.setUsernameIsExisted(username + " is existed!");
            }
            
            boolean checkEmail = dao.emailValidator(email);
            if (!checkEmail) {
                foundError = true;
                errors.setEmailValidateError("Email is not valid!");
            }
            
            
            if (foundError) {
                request.setAttribute("SIGNUP_ERRORS", errors);
            } else {
                
                boolean result = dao.signUp(dto);
                if (result) {
                    url = "login.jsp";
                }
            }
        } catch (SQLException ex) {
            String msg = ex.getMessage();
            log("CreateNewAccountServlet_SQL " + msg);
//            if (msg.contains("duplicate")) {
//                errors.setUsernameIsExisted(username + " is existed");
//                request.setAttribute("SIGNUP_ERRORS", errors);
//            } 
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

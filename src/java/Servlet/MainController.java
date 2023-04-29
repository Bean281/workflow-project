package Servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LAPTOP
 */
public class MainController extends HttpServlet {

    private static final String ERROR = "login.jsp";
    private static final String SIGNIN_ACTION = "SigninServlet";
    private static final String SIGNUP_ACTION = "SignUpServlet";
    private static final String ACCOUNT_INFO = "ShowInformationServlet";
    private static final String UPDATE_ACTION = "UpdateInfoServlet";
    private static final String DELETE_ACTION = "DeleteAccountServlet";
    private static final String EDIT_PAGE = "account_management.jsp";
    private static final String RETURN_NOTE = "note.jsp";
    private static final String VIEWNOTE_ACTION = "ViewNoteServlet";
    private static final String ADDNOTE_ACTION = "AddNoteServlet";
    private static final String ADDNOTE_PAGE = "addNoteList.jsp";
    private static final String SEARCHNOTE_ACTION = "SearchNoteServlet";
    private static final String SAVENOTE_ACTION = "SavingNoteServlet";
    private static final String EDITNOTE_ACTION = "EditNoteServlet";
    private static final String EDITNOTE_PAGE = "editNoteList.jsp";
    private static final String DELETENOTE_ACTION = "DeleteNoteServlet";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = SIGNIN_ACTION;

        try {
            String action = request.getParameter("action");
            if (action == null) {
            } else if (action.equals("sign_in")) {
                url = SIGNIN_ACTION;
            } else if (action.equals("sign_up")) {
                url = SIGNUP_ACTION;
            } else if (action.equals("logout")) {
                url = SIGNIN_ACTION;
            } else if (action.equals("account_info")) {
                url = ACCOUNT_INFO;
            } else if (action.equals("update_info")) {
                url = UPDATE_ACTION;
            } else if (action.equals("delete")) {
                url = DELETE_ACTION;
            } else if (action.equals("edit_info")) {
                url = EDIT_PAGE;
            } else if (action.equals("Return")) {
                url = RETURN_NOTE;
            } else if (action.equals("view")) {
                url = VIEWNOTE_ACTION;
            } else if (action.equals("add")) {
                url = ADDNOTE_PAGE;
            } else if (action.equals("addNote")) {
                url = ADDNOTE_ACTION;
            } else if (action.equals("search")) {
                url = SEARCHNOTE_ACTION;
            } else if (action.equals("saving")) {
                url = SAVENOTE_ACTION;
            } else if (action.equals("editNote")) {
                url = EDITNOTE_PAGE;
            } else if (action.equals("editingNote")) {
                url = EDITNOTE_ACTION;
            } else if (action.equals("deleteNote")) {
                url = DELETENOTE_ACTION;
            }

            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        } catch (Exception e) {
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import note.noteDAO;
import note.noteDTO;

/**
 *
 * @author Walking Bag
 */
@WebServlet(name = "DeleteNoteServlet", urlPatterns = {"/DeleteNoteServlet"})
public class DeleteNoteServlet extends HttpServlet {

    private static final String LOADNOTE_ACTION = "LoadNoteServlet";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Long noteID = Long.parseLong(request.getParameter("id"));
        Long userID = Long.parseLong(request.getParameter("userid"));

        System.out.println("noteID: " + noteID);
        System.out.println("userID: " + userID);

        noteDAO noteDAO = new noteDAO();

        boolean result = noteDAO.delete(noteID);

        noteDTO note = new noteDTO();

        if (result) {
            //Delete doesn't need to show the deleted note.
            note.setUserid(userID);
            System.out.println("userID: " + note.getUserid());
            System.out.println("noteID: " + note.getId());

            request.setAttribute("noteInformation", note);

            RequestDispatcher rd = request.getRequestDispatcher(LOADNOTE_ACTION);
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

package CountdownTimer;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class TodoListServletCustomClock extends HttpServlet {
    
    private ArrayList<String> todoItems = new ArrayList<String>();
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("todoItems", todoItems);
        RequestDispatcher view = request.getRequestDispatcher("CustomizeTimer.jsp");
        view.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null || action.equals("")) {
            response.sendRedirect("TodoListServletCustomClock");
            return;
        }
        switch (action) {
            case "add":
                String todoItem = request.getParameter("todoItem");
                todoItems.add(todoItem);
                break;
            case "delete":
                int index = Integer.parseInt(request.getParameter("index"));
                todoItems.remove(index);
                break;
            default:
                break;
        }
        response.sendRedirect("TodoListServletCustomClock");
    }
}

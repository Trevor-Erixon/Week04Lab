package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;

/**
 *
 * @author Trevor Erixon
 */
public class NoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        
        String titleMessage = "This is the title";
        String contentsMessage = "Contents go here";
        
        Note note = new Note(titleMessage, contentsMessage);
        
        request.setAttribute("titleMessage", note.getTitle());
        request.setAttribute("contentsMessage", note.getContents());
        
        String status = request.getParameter("edit");
        boolean isEdit = status != null;
        
        if (!isEdit)
        {
            getServletContext().getRequestDispatcher("/WEB-INF/viewNote.jsp")
                .forward(request, response);
            return;
        }
               
        getServletContext().getRequestDispatcher("/WEB-INF/editNote.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        
        getServletContext().getRequestDispatcher("/WEB-INF/viewNote.jsp")
                .forward(request, response);
    }

}

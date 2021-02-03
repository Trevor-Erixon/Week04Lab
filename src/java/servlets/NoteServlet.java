package servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(new File(path)));
            
            String title = br.readLine();
            String contents = br.readLine();
            
            if (title == null || title.equals(""))
            {
                title = "This is the title";
            }
            
            if (contents == null || contents.equals(""))
            {
                contents = "Contents go here";
            }
            
            Note note = new Note(title, contents);
            request.setAttribute("note", note);
            
            br.close();
        }
        catch (IOException e)
        {
            
        }
        
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
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        
        try
        {            
            String title = (String) request.getParameter("title");
            String contents = (String) request.getParameter("contents");
            
            Note note = new Note(title, contents);
            request.setAttribute("note", note);
            
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));
            
            //pw.write(title);
            //pw.write(contents);
            pw.println(title);
            pw.println(contents);
            
            pw.close();

        }
        catch (IOException e)
        {
            doGet(request, response);
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/viewNote.jsp")
                .forward(request, response);
        
    }

}

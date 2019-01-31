/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package josblog.controllers;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import the Engine clas
import josblog.controllers.Engine;

/**
 *
 * @author Josiah Thobejane
 */
public class SubmitArticle extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
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
            out.println("<title>Servlet SubmitArticle</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SubmitArticle at " + request.getContextPath() + "</h1>");
            out.println("<h4>Article: " + request.getParameter("ArticleTitle") + "..has been submitted</h4>");
            out.println("</body>");
            out.println("</html>");
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
        
        //create a Engine objects to access the Engine variables
        Engine engine = new Engine();
        
        try {
            LocalDate date = LocalDate.now();
            PreparedStatement ps = engine.conn.prepareStatement("INSERT INTO articles (ArticleAuthor, ArticleTitle, ArticleImage, ArticleBody, ArticleDate) VALUES (?, ?, ?, ?, ?)");
            int articleId = 1;
            
            String articleImageLocation = null;
            //ps.setInt(1, Integer.parseInt(request.getParameter("ArticleID")));
            ps.setString(1, request.getParameter("ArticleAuthor"));
            ps.setString(2, request.getParameter("ArticleTitle"));
            ps.setString(3, request.getParameter(articleImageLocation));
            ps.setString(4, request.getParameter("ArticleBody"));
            ps.setString(5, date.toString());
            
            ps.executeUpdate();
            
            //after executing all neccessary commands, close the connection
            engine.conn.close();
        } catch (SQLException ex)
        {
            PrintWriter errorMessage = response.getWriter();
            errorMessage.println("There's an error in your stoep: " + ex);
            System.out.print(ex);
        }
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

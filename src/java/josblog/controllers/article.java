/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package josblog.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import josblog.controllers.Engine;
/**
 *
 * @author Josiah Thobejane
 */
public class article extends HttpServlet {

    String articleID;
    String articleTitle;
    String articleAuthor;
    String articleBody;
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
           
            articleBody =  articleBody.replaceAll("\\n", "<br>");
            
            request.setAttribute("articleTitle", articleTitle);
            request.setAttribute("articleBody", articleBody);
            request.setAttribute("articleAuthor", articleAuthor);
            //send the article data to articles.JSP
            RequestDispatcher dispatcher = request.getRequestDispatcher("articles.jsp");
            dispatcher.forward(request, response);

            
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
        //some weird code
            Engine engine = new Engine();
            try {
                articleID = request.getParameter("id");
                PreparedStatement ps = engine.conn.prepareStatement("SELECT * FROM articles WHERE ArticleID=" + articleID);
                ResultSet results = ps.executeQuery();

                while(results.next())
                {
                    articleAuthor = results.getString("ArticleAuthor");
                    articleTitle = results.getString("ArticleTitle");
                    articleBody = results.getString("ArticleBody")  ;
                }
                System.out.println("TITLE: " + articleTitle);
                processRequest(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(article.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            
        
    }
*/
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

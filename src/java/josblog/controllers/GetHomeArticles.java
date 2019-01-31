/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package josblog.controllers;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Josiah Thobejane
 */
public class GetHomeArticles extends Engine {

    public String articleID;
    public String articleTitle;
    public String articleAuthor;
    public String articleBody;
    public String articleDate;
    
    public void getArticles()
    {
        try {
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM articles");
        ResultSet results = ps.executeQuery();
        
        while(results.next())
        {
            articleID = results.getString("ArticleID");
            articleTitle = results.getString("ArticleTitle");
            articleDate = results.getString("ArticleDate");
            articleAuthor = results.getString("ArticleAuthor");
            articleBody = results.getString("ArticleBody");
                    //  .substring(0, 100) + "...";
        }
    } catch(SQLException ex)
    {
        Logger.getLogger(article.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
}

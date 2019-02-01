<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="josblog.controllers.*, java.sql.*"%>
<%! public String articleID, articleTitle, articleAuthor, articleDate, articleBody;%>
<!DOCTYPE html>
<html>
    <head>
        <title>Blog | Josiah Thobejane</title>
        
        <link rel="stylesheet" href="assets/css/bulma.css">        
    </head>
    
    <body>
        <nav class="navbar is-dark is-fluid ">
            <div class="container">
		<div class="navbar-brand">
                    <a class="navbar-item" href="/">
                        Josiah Thobejane
			<!--<img src="img/mf-logo.svg" alt="Josiah Thobejane | Java Developer, Designer &amp; Mentor" height="48">-->
                    </a>
		</div>
		<div class="navbar-menu" id="navMenu">
                    <div class="navbar-end">			
			<div class="navbar-item">
                            <p class="control"><a class="button is-white" href="#"><span>Say Hello</span></a></p>
			</div>
                    </div>
		</div>
            </div>
        </nav>
        
        
        <!-- intro section 
        <section class="hero is-light is-small is-bold has-text-centered">
            <div class="hero-body">
		<div class="container">
                    <div class="columns is-centered">
			<div class="column">
                            <h1 class="title is-spaced is-size-1-desktop is-size-2-tablet is-size-3-mobile">Java Developer &amp; Designer</h1>
                            <h2 class="subtitle is-size-4-desktop">I love to code and design simple things.</h2>
			</div>
                    </div>
		</div>
            </div>						
	</section>-->
        
        <!-- NEWS SECTION -->
        <section class="is-light container is-fluid" style="margin-top: 20px;">
            <div style="margin: 5px;">
                <div class="columns is-center">
                    <% Engine engine = new Engine();
                        try {
                            PreparedStatement ps = engine.conn.prepareStatement("SELECT * FROM articles");
                            ResultSet results = ps.executeQuery();

                            while(results.next())
                            {
                                articleID = results.getString("ArticleID");
                                articleTitle = results.getString("ArticleTitle");
                                articleDate = results.getString("ArticleDate");
                                articleAuthor = results.getString("ArticleAuthor");
                                //assuming no one would write an article with less than 80 characters
                                articleBody = results.getString("ArticleBody").substring(0, 80) + "..."; 
                    %>
                                <!-- THE CODE -->
                                <div class="column is-4">
                                    <div class="card">
                                        <div class="card-image">
                                            <figure class="image ">
                                                <img src="assets/img/2.jpg"/>
                                            </figure>
                                        </div>
                                        <div class="card-content">
                                            <div class="media">                                    
                                                <div class="media-content">
                                                    <p><a class="title is-4" href="article?id=<%= articleID %>  "><%= articleTitle %></a></p>
                                                    <p class="subtitle is-6"><%= articleAuthor + " // " + articleDate %></p>
                                                </div>
                                            </div>

                                            <div class="content"><%= articleBody %></div>                                   
                                            <p class="control"><a class="button " href="article?id=<%= articleID %>"><span>Read more   </span></a></p>
                                        </div>
                                    </div>
                                </div> 
                        
                    <%
                            }
                        } catch(SQLException ex)
                        {

                        }
                    %>
                </div>
            </div>
        </section>        
    </body>
</html>
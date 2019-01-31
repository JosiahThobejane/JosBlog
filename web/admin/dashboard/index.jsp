<%-- 
    Document   : index
    Created on : 08 Dec 2018
    Author     : Josiah
--%>

<%@page import="java.time.LocalDate"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="josblog.controllers.SubmitArticle" %>
<%! LocalDate date = LocalDate.now(); %>
<!DOCTYPE html>
<html>
    <head>
        <title>Blog | Josiah Thobejane</title>
        
        <link rel="stylesheet" href="../../assets/css/bulma.css">        
    </head>
    
    <body>
        <nav class="navbar is-dark">
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
                
        <!-- NEWS SECTION -->
        <section class="is-light container-fluid" style="margin-top: 20px;">
            <div class="container is-fullhd" >
                <div class="columns is-center">
                    <div class="column is-8">
                        <div class="card">                            
                            <div class="card-content">
                                <div class="media">                                    
                                    <div class="media-content">
                                        <p><a class="title is-4" href="#">Welcome, write a blog:</a></p>
                                        <p><a class="subtitle is-7"><%= date %></a></p>
                                    </div>
                                </div>
                                
                                <form class="content is-centered" method="POST"  action="http://localhost:8080/JosBlog/SubmitArticle">
                                    <div class="columns">
                                        <div class="column is-8">
                                            <input type="text" name="ArticleTitle" class="input has-background-light" placeholder="Article title here">
                                        </div>
                                        <div class="column is-4">
                                            <input type="text" name="ArticleAuthor" class="input has-background-light" placeholder="Article title here">
                                        </div>
                                        
                                    </div>
                                    <div class="columns">
                                        <div class="column is-8">
                                            <input class="is-full" type="file" name="articleImage" size="100">
                                        </div>
                                        
                                        <div class="column is-4">
                                            <input type="number" name="ArticleID" class="input has-background-light" placeholder="Article ID">
                                        </div>
                                    </div>
                                    <div class="mt-4 ">
                                        <label for="articlebody" class="title is-6">Write Your Article Here: </label>
                                        <textarea row="20" name="ArticleBody" id="articlebody" class="textarea"></textarea>
                                    </div>
                                    
                                    <input type="submit" value="SUBMIT" class="button is-black">
                                </form>
                            </div>
                        </div>
                    </div>
                
                    
                    <div class="column is-4">
                        <div class="card">
                            <div class="card-content">
                                <div class="media">                                    
                                    <div class="media-content">
                                        <p><a class="title is-4" href="#">The new laptop</a></p>                     
                                    </div>
                                </div>

                                <div class="content">
                                    JosC laptop is the greatest of all time
                                    <br>                                    
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
      </body>
</html>

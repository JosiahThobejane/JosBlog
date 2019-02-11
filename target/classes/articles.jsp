<%-- 
    Document   : article
    Created on : Jan 29, 2019, 6:56:02 PM
    Author     : Josiah Thobejane
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Josiah Thobejane Blog | ${articleTitle}</title>
        
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.4/css/bulma.min.css">
    </head>
    <body>
        <nav class="navbar is-dark">
            <div class="container">
            <div class="navbar-brand">
                <a class="navbar-item" href="/JosBlog">
                Josiah Thobejane | Blog 
                </a>
            </div>
            <div class="navbar-menu" id="navMenu">
                <div class="navbar-end">									
                    <div class="navbar-item">						
                        <p class="control"><a class="button is-dark " href="http://josiahthobejane.co.za" ><span>HOME</span></a></p>
                    </div>					
                </div>
            </div>
            </div>
	</nav>

	<div class="container" style="margin-top: 10px;">
            
            <div class="columns">
                <div class="column is-8">
                    <img src="assets/img/2.jpg" alt="placeholder" />
                </div>
                <div class="column is-4">
                    
                </div>
            </div>

            <!-- The Article Title -->
            <h2 class="my-2 is-size-4-desktop title">${articleTitle}</h2>
            <!-- The Article-->
            <div class="columns">
                <div class="column is-6 is-centered">
                    <p class="is-size-5-desktop my-4">${articleBody}</p>
                </div>
            </div>
            
	</div>
    </body>
</html>

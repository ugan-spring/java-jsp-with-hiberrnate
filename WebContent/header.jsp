<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>New Tech Book</title>
<style type="text/css">
    body{        
        padding-top: 60px;
        padding-bottom: 40px;
        background: aqua;
    }
    .fixed-header, .fixed-footer{
        width: 100%;
        position: fixed;        
        background: blue;
        padding: 10px 0;
        color: #fff;
    }
    .fixed-header{
        top: 0;
    }
    .fixed-footer{
        bottom: 0;
    }
    .container{
        width: 80%;
        margin: 0 auto; /* Center the DIV horizontally */
    }
    nav a{
        color: #fff;
        text-decoration: none;
        padding: 7px 25px;
        display: inline-block;
    }
</style>
</head>
<body>
    <div class="fixed-header">
        <div class="container">
            <nav>
                <a href="index.jsp">Home</a>
                <a href="aboutUs.jsp">About Us</a>
                  <a href="registration.jsp">Sign Up</a>
                   <a href="login.jsp">Log In</a>
            </nav>
        </div>
    </div>  
    <div class="fixed-footer">
        <div class="container">Copyright &copy; 2018 New Tech Book</div>        
    </div>
</body>
</html>
     


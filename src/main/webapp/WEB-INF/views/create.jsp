<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Create Room</title>
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
</head>
<body>
<nav class="navbar navbar-inverse navbar-light">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">Its Partner App</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="/rooms">Все комнаты</a></li>
                <li class="active"><a href="/create">Создать комнату</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container">
    <div class="main">
        <div class="col-md-12">
            <c class="card">
                <form action="/create" method="POST">
                    <label for="name">Name</label>
                    <input type="text" name="name" id="name"><br>
                    <label for="country">Country</label>
                    <select name="country">
                        <option value="">Choose country</option>
                        <option value="Belarus">Belarus</option>
                        <option value="Russia">Russia</option>
                        <option value="Ukraine">Ukraine</option>
                        <option value="Usa">USA</option>
                    </select>
                    <br>
                    <label for="light">Light</label>
                    <select name="light">
                        <option value="true">On</option>
                        <option value="false">Off</option>
                    </select>
                    <br>
                    <input type="submit" class="btn btn-primary" value="Add new room">
                </form>
                </c>
            </div>
        </div>
    </div>

</body>
</html>

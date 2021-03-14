<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
    <title>All Rooms</title>
</head>
<body>
<nav class="navbar navbar-inverse navbar-light">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">Its Partner App</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/rooms">Все комнаты</a></li>
                <li><a href="/create">Создать комнату</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="wrapper ">
    <div class="content">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <div class="card">
                        <div class="card-header card-header-primary">
                            <h4 class="card-title ">Rooms</h4>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table">
                                    <thead class=" text-primary">
                                    <th>Name</th>
                                    <th>Country</th>
                                    <th>Light</th>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="room" items="${roomList}">
                                        <tr>
                                            <td>${room.name}</td>
                                            <td>${room.country}</td>
                                            <td>${room.light}</td>
                                            <td>
                                                <a href="/${room.id}" class="btn btn-success">Go!</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

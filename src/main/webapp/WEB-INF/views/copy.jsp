<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
    <title>Room</title>
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/sockjs-client/sockjs.min.js"></script>
    <script src="/webjars/stomp-websocket/stomp.min.js"></script>
    <script src="app.js"></script>
</head>
<body onload="openConnection();" onunload="closeConnection();">
<nav class="navbar navbar-inverse navbar-light">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">Its Partner App</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="/rooms">Все комнаты</a></li>
                <li><a href="/create">Создать комнату</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <div class="main">
        <div class="col-md-12">
            <div class="card">
                <h4>Добро пожаловать в команту ${room.name}</h4>
                <h4>Страна: ${room.country}</h4>
                <c:if test="${not room.light}">
                    <h4>Свет выключен</h4>
                    <input type="submit" class="btn btn-success" value="Включить свет!" onclick="start()"/>
                </c:if>
                <c:if test="${room.light}">
                    <h4>Свет включен</h4>
                    <input type="submit" class="btn btn-success" value="Выключить свет!" id="send"/>
                </c:if>
            </div>
        </div>
    </div>
</div>
<table id="conversation" class="table table-striped">
    <thead>
    <tr>
        <th>Greetings</th>
    </tr>
    </thead>
    <tbody id="greetings">
    </tbody>
</table>
</body>
</html>

<noscript><h2 style="color: #ff0000">Seems your browser doesn't support Javascript! Websocket relies on Javascript being
    enabled. Please enable
    Javascript and reload this page!</h2></noscript>
<div id="main-content" class="container">
    <div class="row">
        <div class="col-md-6">
            <form class="form-inline">
                <div class="form-group">
                    <label for="name">What is your name?</label>
                    <input type="text" id="name" class="form-control" placeholder="Your name here...">
                </div>
                <button id="send" class="btn btn-default" type="submit">Send</button>
            </form>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <table id="conversation" class="table table-striped">
                <thead>
                <tr>
                    <th>Greetings</th>
                </tr>
                </thead>
                <tbody id="greetings">
                </tbody>
            </table>
        </div>
    </div>
</div>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Room</title>
    <link href="/webjars/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.2.1/dist/jquery.min.js" type="text/javascript"></script>
    <script src="https://cdn.jsdelivr.net/npm/sockjs-client@1.4.0/dist/sockjs.min.js" type="text/javascript" ></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js" type="text/javascript"></script>
    <script type="text/javascript">
        var stompClient = null;

        function connect() {
            var socket = new SockJS('/gs-guide-websocket');
            stompClient = Stomp.over(socket);
            stompClient.connect({}, function (frame) {
                console.log('Connected: ' + frame);
                stompClient.subscribe('/topic/greetings', function (greeting) {
                    showGreeting(greeting.body);
                });
            });
        }

        function disconnect() {
            if (stompClient !== null) {
                stompClient.disconnect();
            }
            setConnected(false);
            console.log("Disconnected");
        }

        function sendName(){
            stompClient.send("/app/hello", {}, ${room.id});
        }

        function showGreeting(message) {
            document.getElementById('user_payment_sum').innerHTML = message;
        }

        $(function () {
            $("form").on('submit', function (e) {
                e.preventDefault();
            });
            $( "#send" ).click(function() { sendName(); });
        });
    </script>
</head>
<body onload="connect();" onunload="disconnect();">
<nav class="navbar navbar-inverse navbar-light">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">Its Partner App</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="/rooms">All rooms</a></li>
                <li><a href="/create">Create room</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <div class="main">
        <div class="col-md-12">
            <div class="card">
                <h4>Welcome to the room ${room.name}</h4>
                <h4>Country: ${room.country}</h4>
                <h4>Light: <span id="user_payment_sum">${room.light}</span></h4>
                <input type="submit" class="btn btn-success" value="On/off" id="send"/>
            </div>
        </div>
    </div>
</div>
</body>
</html>

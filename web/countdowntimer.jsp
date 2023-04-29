<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Pomodoro Timer</title>
        <link rel="stylesheet" href="css/style.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                var originalTitle = document.title;
                var intervalId = null;
                var isRunning = false;
                var remainingTime = 0;
                var countdownTime = 1500000; // 25 minutes in milliseconds

                function startTimer() {
                    isRunning = true;
                    startTime = new Date().getTime();
                    if (remainingTime <= 0) {
                        remainingTime = countdownTime;
                    }
                    intervalId = setInterval(function () {
                        var currentTime = new Date().getTime();
                        var elapsedTime = currentTime - startTime;
                        remainingTime = remainingTime - elapsedTime;
                        if (remainingTime <= 0) {
                            remainingTime = 0;
                            alert('Times up');
                            stopTimer();
                        }
                        displayTime(remainingTime);
                        startTime = currentTime;
                    }, 1000);
                }


                function stopTimer() {
                    clearInterval(intervalId);
                    isRunning = false;
                    document.title = originalTitle;
                }

                function resetTimer() {
                    stopTimer();
                    remainingTime = countdownTime;
                    displayTime(remainingTime);
                }

                function displayTime(time) {
                    var minutes = Math.floor(time / 60000);
                    var seconds = ((time % 60000) / 1000).toFixed(0);
                    $("#timer").html(minutes + ":" + (seconds < 10 ? '0' : '') + seconds);
                    var newTitle = minutes + ":" + (seconds < 10 ? '0' : '') + seconds + " - Start working";
                    document.title = newTitle;
                }

                $("#start-btn").click(function () {
                    if (!isRunning) {
                        startTimer();
                    }
                });

                $("#pause-btn").click(function () {
                    if (isRunning) {
                        stopTimer();
                    }
                });

                $("#reset-btn").click(function () {
                    resetTimer();
                });
            });
        </script>
        <style>
            table{
                display: flex;
                justify-content: center;
                align-items: center;
                border: 1px;
            }
            .constructor{
                max-width: 450px;
            }
            .td{
                border: none;
                font-size: 1.75em;
                margin-top: 1em;
                resize: none;
                height: 80vh;
                width: 100%;
                max-width: 150px;
                min-height: auto;
            }
        </style>

    </head>
    <body>
        <div style="display: flex">
            <div id="navbar">
                <div class="return">
                    <form action="MainController" method="POST">
                        <input style="background-color: #046b63; width: 150%; height: 50px; font-family: monospace ;border: hidden; border-radius: 5px" type="submit" name="action" value="Return">
                    </form>
                </div>
                <a class="underlineHover" id="pomodoro-btn" href="countdowntimer.jsp">Pomodoro Timer</a>
                <a class="underlineHover" id="short-break-btn" href="5minsBreak.jsp">5 Minutes Break</a>
                <a class="underlineHover" id="long-break-btn" href="10minsBreak.jsp">10 Minutes Break</a>
                <a class="underlineHover" id="customize-btn" href="CustomizeTimer.jsp">Customize Timer</a>
            </div>
        </div> 
        <div class="inside">
            <div class="display-text">
                <div  id="timer">25:00</div>
                <div id="buttons">
                    <button id="start-btn">Start</button>
                    <button id="pause-btn">Pause</button>
                    <button id="reset-btn">Reset</button>
                </div> 
            </div>
        </div>
        <div class="inside">
            <h2 style="padding-top: 20px;">Todo List</h2>
            <div style="margin-bottom: 10px;">
                <form method="POST" action="TodoListServlet">
                    <input class="fadeIn second" type="hidden" name="action" value="add">
                    <input class="add-button" type="text" name="todoItem" required>
                    <input class="add-button" type="submit" value="Add">
                </form>
            </div>
            <table>
                <c:forEach items="${todoItems}" var="item" varStatus="status">
                    <tr>
<!--                        <td>${status.index+1}. ${item}</td>-->
                        <td> ${item}</td>
                        <!--                        <td><input type="radio" name="complete"/>Complete</td>-->
                        <td>
                            <form>
                                <input type="checkbox" name="completed" value="true">Complete
                            </form>
                        </td>
                        <td>
                            <form method="POST" action="TodoListServlet">
                                <input type="hidden" name="index" value="${status.index}">
                                <input type="hidden" name="action" value="delete">
                                <input class="add-button" type="submit" value="Delete">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>

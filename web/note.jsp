<%-- 
    Document   : note
    Created on : Apr 23, 2023, ??? PM
    Author     : Walking Bag
--%>
<%@page import="note.noteDTO"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Preview of Notetaking</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/template.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">    
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <style>
            a, a:hover{
                text-decoration: none;
                color: white;   
            }

            #hiddenButton {
                display: none;

            }

            .btn1{
                padding: 5px;
                margin-left: 10px;
            }

            .btn-color {
                border-color: #23a097;
                background-color: #23a097;
                color: white;
                transition: background-color 0.4s ease-in-out;
            }

            .btn-color:hover{
                border-color: #046b63;
                background-color: #0ccfbf;
            }

            .noteObject{
                border-radius: 7px;
                background-color: #1f2937;
                transition: background-color 0.3s ease-in;
            }

            .noteObject:hover{
                border-radius: 7px;
                background-color: #34455d;
                transition: background-color 0.3s ease-in;
            }
        </style>
    </head>
    <body>
        <div class="notes" id="app">
            <div class="noteSidebar">
                <form action="MainController" method="POST">
                    <div class="searchBar">
                        <div class="dropdown">
                            <button class="glyphicon glyphicon-align-justify btn btn-info dropdown-toggle" type="button" data-toggle="dropdown">
                                <span class="caret"></span></button>
                            <ul class="dropdown-menu">
                                <li><a href="countdowntimer.jsp">Timer</a></li>
                                <li><a href="MainController?action=account_info&id=${sessionScope.usersession.id}">User</a></li>
                            </ul>
                        </div>
                        <form action="MainController" method="POST">
                            <div class="input-group">
                                <input type="hidden" name="action" value="search" />
                                <input type="hidden" name="userID" value="${sessionScope.usersession.id}" />
                                <input type="search" class="form-control rounded" placeholder="Search" aria-label="Search" aria-describedby="search-addon" name="txtSearchValue" value="${param.txtSearchValue}"/>                      
                            </div>                            
                        </form>
                    </div>
                </form>
                <br>
                <!--ADD function-->
                <form action="MainController" method="POST">
                    <input type="hidden" name="action" value="add" />
                    <input type="hidden" name="userid" value="${sessionScope.usersession.id}" />
                    <button class="buttonAdd" type="submit" name="action">Add note!</button>
                </form>

                <button class="buttonAdd" type="button" onclick="document.getElementById('hiddenButton').click()">Save!</button>
                <div class="noteList">
                    <c:set var="result" value="${requestScope.searchResult}"></c:set>
                    <c:set var= "list" value="${sessionScope.list}"></c:set>
                    <c:choose>
                        <c:when test="${empty result}">
                            <c:forEach var="note" items="${list}">
                                <a href="MainController?action=view&id=${note.id}">
                                    <!--Auto turns all of the note on the side to links.-->
                                    <div class="noteList">
                                        <div class="noteObject">
                                            <div class="noteSmall-title">${note.title}</div>
                                            <div class="noteSmall-body">${note.noteInfo}</div>
                                            <div class="noteSmall-timeStamp">${note.timestamp}</div>
                                        </div>
                                    </div>
                                    <div style="display: flex;">
                                        <form action="MainController?action=editNote&id=${note.id}&userid=${note.userid}&title=${note.title}&noteInfo=${note.noteInfo}" 
                                              method="POST">
                                            <input class="btn btn-success btn1 btn-color" type="submit" value="Edit" />
                                        </form>
                                        <form action="MainController" method="POST">
                                            <input type="hidden" name="id" value="${note.id}" />
                                            <input type="hidden" name="userid" value="${note.userid}" />
                                            <input type="hidden" name="action" value="deleteNote" />
                                            <input class="btn btn-success btn1 btn-color" type="submit" value="Delete" />
                                        </form>
                                    </div>
                                </a>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <c:forEach var="note" items="${result}">
                                <a href="MainController?action=view&id=${note.id}">
                                    <!--Auto turns all of the note on the side to links.-->
                                    <div class="noteList">
                                        <div class="noteObject">
                                            <div class="noteSmall-title">${note.title}</div>
                                            <div class="noteSmall-body">${note.noteInfo}</div>
                                            <div class="noteSmall-timeStamp">${note.timestamp}</div>
                                        </div>
                                    </div>
                                    <div style="display: flex;">
                                        <form action="MainController?action=editNote&id=${note.id}&userid=${note.userid}&title=${note.title}&noteInfo=${note.noteInfo}" 
                                              method="POST">
                                            <input class="btn btn-success btn1 btn-color" type="submit" value="Edit" />
                                        </form>
                                        <form action="MainController" method="POST">
                                            <input type="hidden" name="id" value="${note.id}" />
                                            <input type="hidden" name="userid" value="${note.userid}" />
                                            <input type="hidden" name="action" value="deleteNote" />
                                            <input class="btn btn-success btn1 btn-color" type="submit" value="Delete" />
                                        </form>
                                    </div>
                                </a>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>

            <c:if test="${not empty sessionScope.note}">
                <c:set var="note" value="${sessionScope.note}" />
                <div class="noteView">
                    <form action="MainController" method="post">
                        <input type="text" name="noteTitle" class="noteTitle" value="${note.title}" placeholder="Add something here..." />
                        <br/>
                        <textarea name="content" class="noteInput" placeholder="Lorem ipsum...">${note.content}</textarea>
                        <input type="hidden" name="noteid" value="${note.id}" />
                        <input type="hidden" name="userid" value="${note.userid}" />
                        <input id="hiddenButton" type="submit" value="saving" name="action" />
                    </form>
                </div>
            </c:if>
        </div>
    </body>
</html>

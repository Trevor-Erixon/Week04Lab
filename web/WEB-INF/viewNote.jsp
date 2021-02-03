<%-- 
    Document   : viewNote
    Created on : Feb 1, 2021, 11:29:33 AM
    Author     : Trevor Erixon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Note Keeper</title>
    </head>
    <body>
        <form>
            <h1>Simple Note Keeper</h1>
            <h2>View Note</h2>
            <p><b>Title: </b> ${note.title}</p>
            <p><b>Contents: </b></p>
            <p>${note.contents}</p>
            <p><a href="note?edit">Edit</a>
        </form>
    </body>
</html>

<%-- 
    Document   : editNote
    Created on : Feb 1, 2021, 11:30:08 AM
    Author     : Trevor Erixon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Note Keeper Edit</title>
    </head>
    <body>
        <form method="post" action="/note?edit">
            <h1>Simple Note Keeper</h1>
            <h2>View Note</h2>
            <p><b>Title: </b><input type="text" value=${titleMessage}></p>
            <p><b>Contents: </b><textarea rows="4" cols="20">${contentsMessage}</textarea></p>
            <input type="submit" value="Save">
        </form>
    </body>
</html>

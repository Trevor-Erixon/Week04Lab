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
        <form method="post" action="">
            <h1>Simple Note Keeper</h1>
            <h2>Edit Note</h2>
            <p><b>Title: </b><input type="text" name="title" value=${note.title}></p>
            <p><b>Contents: </b><textarea name="contents" rows="4" cols="20">${note.contents}</textarea></p>
            <input type="submit" value="Save">
        </form>
    </body>
</html>

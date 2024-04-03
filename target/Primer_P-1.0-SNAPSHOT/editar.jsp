<%@page import="com.emergentes.modelo.Estudiante"%>
<%
        Estudiante reg = (Estudiante) request.getAttribute("miobjest");
 %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1">
                    <tr>
                        <th>
                            <p>Primer Parcial  TEM-742 <br> Nombre: Jhon Deymar Quispe Velarde <br> Carnet: 13550043 </p>
                        </th>
                    </tr>
            </table>
        <h1>Registro de Estudiante</h1>
        <form action="MainServlet" method="post">
            <table>
                <tr>
                    <td>Id</td>
                    <td><input type="text" name="Id" value="<%= reg.getId() %>" size="2" readonly></td>
                </tr> 
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="Nombre" value="<%= reg.getNombre() %>"></td>
                </tr> 
                <tr>
                    <td>P1</td>
                    <td><input type="text" name="P1" value="<%= reg.getP1() %> "></td>
                </tr> 
                <tr>
                    <td>P2</td>
                    <td><input type="text" name="P2" value="<%= reg.getP2() %> "></td>
                </tr> 
                <tr>
                    <td>EF</td>
                    <td><input type="text" name="EF" value=" <%= reg.getEF() %>"></td>
                </tr> 
                <tr>
                    <td>Nota</td>
                    <td><input type="text" name="Nota" value="<%= reg.getNota() %>"></td>
                </tr> 
                <tr>
                    <td></td>
                    <td><input type="submit"  value="Enviar"></td>
                </tr> 
            </table>
        </form>
    </body>
</html>

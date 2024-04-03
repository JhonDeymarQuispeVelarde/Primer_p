<%@page import="com.emergentes.modelo.Estudiante"%>
<%@page import="java.util.ArrayList"%>
<%
    if (session.getAttribute("lista") == null) {
        ArrayList<Estudiante> lisAux = new ArrayList<Estudiante>();
        session.setAttribute("lista", lisAux);
    }
    ArrayList<Estudiante> lista = (ArrayList<Estudiante>) session.getAttribute("lista");

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Primer Parcial</title>
    </head>
    <body>
            <table border="1">
                    <tr>
                        <th>
                            <p>Primer Parcial  TEM-742 <br> Nombre: Jhon Deymar Quispe Velarde <br> Carnet: 13550043 </p>
                        </th>
                    </tr>
            </table>
        <h1>Registro de Calificaciones</h1>
        <a href="MainServlet?op=Nuevo">Nuevo Estudiante</a>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>P1</th>
                <th>P2</th>
                <th>EF</th>
                <th>Nota</th>
                <th></th>
                <th></th>
            </tr>
            <%
                if (lista != null) {
                        for(Estudiante item : lista) {
             %>
            <tr>
                <td><%= item.getId() %></td>
                <td><%= item.getNombre() %></td>
                <td><%= item.getP1() %></td>
                <td><%= item.getP2() %></td>
                <td><%= item.getNota() %></td>
                <td>
                    <a href="MainServlet?op=editar&id=<%= item.getId() %>">Editar</a>
                </td>
                <td>
                    <a href="MainServlet?op=eliminar&Id=<%= item.getId() %>"
                       onclick="return (confirm('Esta Segurito de eliminar a este estudiante... '))"
                       >Eliminar</a>
                </td>
                <td></td>
            </tr>
            <%
                                } 
                    }
             %>
        </table>
    </body>
</html>

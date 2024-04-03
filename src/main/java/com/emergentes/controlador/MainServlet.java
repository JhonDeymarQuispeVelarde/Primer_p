package com.emergentes.controlador;

import com.emergentes.modelo.Estudiante;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "MainServlet", urlPatterns = {"/MainServlet"})
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
            String op = request.getParameter("op");
            Estudiante objest = new Estudiante();
            int Id, pos;
            HttpSession ses = request.getSession();
            ArrayList<Estudiante> lista = (ArrayList<Estudiante>)ses.getAttribute("listaest");
                switch(op) {
                  case "Nuevo" :
                    request.setAttribute("miobjest", objest);
                    request.getRequestDispatcher("editar.jsp").forward(request, response);
                    break;
                case "Editar" :
                    Id = Integer.parseInt(request.getParameter("Id"));
                    pos = buscarPorIndice(request, Id);
                    objest = lista.get(pos);
                    request.setAttribute("miobjest", objest);
                    request.getRequestDispatcher("editar.jsp").forward(request, response);
                    break;
                case "Eliminar" :
                    Id = Integer.parseInt(request.getParameter("Id"));
                    pos = buscarPorIndice(request, Id);
                    if(pos >= 0) {
                        lista.remove(pos);
                    }
                    request.setAttribute("listaest", lista);
                    response.sendRedirect("index.jsp");
                    break;
                default :
            }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        int Id = Integer.parseInt(request.getParameter("Id"));
        HttpSession ses = request.getSession();
        ArrayList<Estudiante> lista = (ArrayList<Estudiante>)ses.getAttribute("listaest");
        Estudiante objest = new Estudiante ();
        objest.setId(Id);
        objest.setNombre(request.getParameter("Nombre"));
        objest.setP1(Integer.parseInt(request.getParameter("P1")));
        objest.setP2(Integer.parseInt(request.getParameter("P2")));
        objest.setEF(Integer.parseInt(request.getParameter("EF")));
        objest.setNota(Integer.parseInt(request.getParameter("Nota")));
        
       if(Id == 0) {
          int idNuevo = obtenerId (request);
           objest.setId(idNuevo);
           lista.add (objest);
        }
        else{
          int pos = buscarPorIndice(request, Id);
          lista.set(pos, objest);
        } 
        
        request.setAttribute("listaest", lista);
        response.sendRedirect("index.jsp");
    }
    
    public int buscarPorIndice(HttpServletRequest request, int Id) {
        HttpSession ses = request.getSession();
        ArrayList<Estudiante> lista = (ArrayList<Estudiante>)ses.getAttribute("listaest");
        
        int pos = -1;
        
        if(lista != null) {
            for(Estudiante ele : lista){
                ++pos;
                if(ele.getId() == Id) {
                    break;
                }
            }
        }
        return pos;
    }
    
    public int obtenerId(HttpServletRequest request){
        HttpSession ses = request.getSession();
        ArrayList<Estudiante> lista = (ArrayList<Estudiante>) ses.getAttribute("listaest");
           int idn = 0;
           for (Estudiante ele : lista) {
             idn = ele.getId();
          }
        return idn + 1;
    }
}

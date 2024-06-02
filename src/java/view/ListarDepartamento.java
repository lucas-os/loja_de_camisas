/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package view;

import controller.DepartamentoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Departamento;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "ListarDepartamento", urlPatterns = {"/ListarDepartamento"})
public class ListarDepartamento extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        List<String> lista;
        int i =1;
        DepartamentoDAO dao;
        Departamento obj;
        String nome;
        int aux=0;
        
        try{
            dao= new DepartamentoDAO();
            lista= new ArrayList<String>();
            obj= dao.consultaCodigo(i);
            /*nome=obj.getNome();
            lista.add(0, nome);*/
            
            while(obj!=null){
                obj= dao.consultaCodigo(i); //Alimenta o obj com o nome e o codigo do departamento com codigo = i;
                if(obj!=null)
                {
                    nome=obj.getNome();
                    lista.add((i-1), nome);//Adiciona na lista
                    i++;
                }
            }

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListarDepartamento</title>");  
            out.println("<link rel='stylesheet' href='css/menu.css' />");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.println("</head>");
            out.println("<body>");
            
            
            //out.println(nome);
            aux=i-1;
            i=0;
            while(i<aux){
                out.println("<div class='xura'>");
                out.println("<center><a href='ListarProdutoDep?txtDep="+(i+1)+"' target='corpo' style='text-decoration: none;'><h1 style='color: white;'>"+ lista.get(i) +"</h1></a></center>");
                out.println("</div>");
                i++;
            }
            out.println("</body>");
            out.println("</html>");
        }catch(Exception ex){
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Erro ListarDepartamento</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Erro: ListarDepartamento: " + ex.getMessage()+ "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

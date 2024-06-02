/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package view;

import controller.ProdutoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aluno
 */
@WebServlet(name = "ListarProdutoDep", urlPatterns = {"/ListarProdutoDep"})
public class ListarProdutoDep extends HttpServlet {

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
        
        PrintWriter out = response.getWriter();
        ResultSet tabela;
        int codDep, colunas=0;
        ProdutoDAO dao;
        
        try {
            codDep = Integer.parseInt(request.getParameter("txtDep"));
            dao = new ProdutoDAO();
            tabela = dao.consultaDep(codDep); 
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListarProdutoDep</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<table border='1'>");
            out.println("<tbody>");
            out.println("<tr>");
            
            while(tabela.next())
            {
                colunas++;
                out.println("<td>");
                out.println("<form action = 'Controlador' method = 'post' >");
                out.println("<input type='text' name = 'txtCodigo' value = '" + tabela.getInt(1) + "' hidden />");
                out.println("<img src= 'imagem/" + tabela.getString("imagem") + "' width = '170' height ='150' /> <br/> ");
                out.println("<h2>" + tabela.getString(2) +  "</h2>");
                out.println("<h2>Preço: " + tabela.getDouble(3) + " </h2>");
                out.println("Quantidade: <input type='text' name = 'txtQtde' value = '1' <br/> ");
                out.println("<input type = 'submit' name = 'b1' value = 'Comprar' />");
                out.println("</form>");
                out.println("</td>");
                if(colunas == 3)
                {
                    out.println("</tr><tr>");
                    colunas=0;
                }
            }
            out.println("</tr>");
            out.println("</tbody>");
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        }
        catch(Exception ex)
        {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListarProdutoDep</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Erro: "+ ex.getMessage()+" </h1>");
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

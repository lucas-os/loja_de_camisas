package view;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import controller.ClienteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;
import model.Cliente;

/**
 *
 * @author aluno
 */
@WebServlet(urlPatterns = {"/Cadastrar"})
public class Cadastrar extends HttpServlet {

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
        Cliente obj;
        ClienteDAO dao;
        int qtde;
        
        try {
            obj = new Cliente();
            obj.setNome(request.getParameter("txtNome"));
            obj.setLogin(request.getParameter("txtLogin"));
            obj.setSenha(request.getParameter("txtSenha"));
            dao = new ClienteDAO();
            qtde = dao.gravar(obj);
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Gravar</title>");
            out.println("</head>");
            out.println("<body>");
            if (qtde > 0) {
                out.println("<h1 align='center'> Tudo certo.</h1>");
                out.println("<h3 align='center'> Sua conta foi cadastrada com sucesso.</h3>");
                out.println("<center><button style='background-color: #42b72a; border: none; padding: 15px; width: 78%; border-radius: 10px; cursor: pointer; padding-left: 8px; padding-right: 8px;'><a href='ListarProdutoDep?txtDep=1    ' style='color: white; font-size: 15px; text-decoration: none; padding: 15px; width: 100%; border-radius: 10px; padding-left: 16px; padding-right: 16px; font-family: 'Titillium Web', sans-serif;'>Fechar</a></button></center>");
            } 
            else 
            {
                out.println("<h1>Erro ao cadastrar.</h1>");
            }
            out.println("</body>");
            out.println("</html>");
        } 
        catch (Exception ex) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Lista de erros</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Erro: " + ex.getMessage() + "</h1>");
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

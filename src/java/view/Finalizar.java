/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package view;

import controller.ItemDAO;
import controller.ProdutoDAO;
import controller.VendaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Cliente;
import model.Item;
import model.Produto;
import model.Venda;

/**
 *
 * @author aluno
 */
@WebServlet(name = "Finalizar", urlPatterns = {"/Finalizar"})
public class Finalizar extends HttpServlet {

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
        response.setCharacterEncoding("UTF-8");
        
        PrintWriter out = response.getWriter();
        HttpSession sessao;
        ArrayList<Produto> lista;
        Item objItem;
        ItemDAO daoItem;
        Venda objVenda;
        VendaDAO daoVenda;
        Cliente objCliente;

        double total = 0;
        try {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Finalizar</title>");
            out.println("</head>");
            out.println("<body>");
            sessao = request.getSession(true);
            objCliente = (Cliente) sessao.getAttribute("usuario");
            if (objCliente == null) {
                out.println("<h1> Faça o Login!!!</h1>");
            } else {
                lista = (ArrayList<Produto>) sessao.getAttribute("carrinho");
                if ((lista == null) || (lista.isEmpty())) {
                    out.println("<h1> Carrinho vazio.</h1>");
                } else {
                    objVenda = new Venda();
                    objVenda.setCodcli(objCliente.getCodigo());
                    for (Produto objP : lista) {
                        total += objP.getPreco() * objP.getQtde();
                    }
                    objVenda.setTotal(total);
                    daoVenda = new VendaDAO();
                    daoVenda.gravar(objVenda);
                    objItem = new Item();
                    daoItem = new ItemDAO();
                    for (Produto objP : lista) {
                        objItem.setCodproduto(objP.getCodigo());
                        objItem.setQtde(objP.getQtde());
                        objItem.setPrecounit(objP.getPreco());
                        objItem.setCodvenda(objVenda.getCodigo());
                        daoItem.gravar(objItem);
                    }
                    sessao.removeAttribute("carrinho");
                    out.println("<h1> Venda Registrada com sucesso.</h1>");

                }

            }

            out.println("</body>");
            out.println("</html>");
        } catch (Exception ex) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Finalizar</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Finalizar at " + ex.getMessage() + "</h1>");
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

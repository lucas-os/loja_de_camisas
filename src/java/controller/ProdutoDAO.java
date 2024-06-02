/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.ResultSet;
import model.Banco;
import model.Produto;

/**
 *
 * @author aluno
 */
public class ProdutoDAO {
    
    public ResultSet consultaDep(int dep) throws Exception
    {
        Banco bb;
        try
        {
            bb = new Banco();
            bb.comando = Banco.conexao.prepareStatement("select codigo, descricao, preco, qtde, imagem, coddep from produto where coddep = ? order by 2");
            bb.comando.setInt(1, dep);
            bb.tabela = bb.comando.executeQuery();
            Banco.conexao.close();
            return(bb.tabela);
        }
        catch(Exception ex)
        {
            throw new Exception("Erro ao consultaDep :" + ex.getMessage());
        }
    }
    
    public Produto consultaCodigo(int codigo) throws Exception
    {
        Banco bb;
        Produto obj = null;
        try
        {
            obj = new Produto();
            bb = new Banco();
            bb.comando = Banco.conexao.prepareStatement("select codigo, descricao, preco, qtde, imagem, coddep from produto where codigo = ?");
            bb.comando.setInt(1, codigo);
            bb.tabela = bb.comando.executeQuery();
            if(bb.tabela.next())
            {
                obj = new Produto();
                obj.setCodigo(bb.tabela.getInt(1));
                obj.setDescricao(bb.tabela.getString(2));
                obj.setPreco(bb.tabela.getDouble(3));
                obj.setQtde(bb.tabela.getInt(4));
                obj.setImagem(bb.tabela.getString(5));
                obj.setCoddep(bb.tabela.getInt(6));
            }
            Banco.conexao.close();
            return(obj);
        }
        catch(Exception ex)
        {
            throw new Exception("Erro ao consultaDep :" + ex.getMessage());
        }
    }
}

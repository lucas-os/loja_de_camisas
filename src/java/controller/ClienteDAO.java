/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.ResultSet;
import model.Banco;
import model.Cliente;
import model.Produto;

/**
 *
 * @author aluno
 */
public class ClienteDAO {
    
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
    
    public Cliente Logar(String login, String senha) throws Exception
    {
        Banco bb;
        Cliente obj = null;
        try
        {
            bb = new Banco(); 
            bb.comando = Banco.conexao.prepareStatement("select codigo,nome, login from cliente where login = ? and senha = ?");
            bb.comando.setString(1, login);
            bb.comando.setString(2, senha);
            bb.tabela = bb.comando.executeQuery();
            if(bb.tabela.next())
            {
                obj = new Cliente();
                obj.setCodigo(bb.tabela.getInt(1));
                obj.setNome(bb.tabela.getString(2));
                obj.setLogin(bb.tabela.getString(3));
            }
            Banco.conexao.close();
            return(obj);
        }
        catch(Exception ex)
        {
            throw new Exception("Erro ao consultaDep :" + ex.getMessage());
        }
    }
    
    public int gravar(Cliente obj) throws Exception 
    {  //avisa que seu método dispara excessões
        Banco bb;
        int qtde=0; //armazena a quantidade de registros alterados
        try {
            bb = new Banco();
            // ? -> é o campo do sql
            bb.comando=Banco.conexao.prepareStatement("Insert into cliente(nome, login, senha) values(?, ?, ?);");
            bb.comando.setString(1, obj.getNome());
            bb.comando.setString(2, obj.getLogin()); //1 -> refere-se à primeria interrogação
            bb.comando.setString(3, obj.getSenha());
            qtde = bb.comando.executeUpdate(); //serve para inser, update e delete
            Banco.conexao.close();
            return(qtde);
        }
        catch (Exception ex) {
            throw new Exception("Erro ao gravar: " + ex.getMessage());
        }
    }
    
    public Cliente consultar(int codigo) throws Exception
    {
        Banco bb;
        Cliente obj = null;
        try
        {
            obj = new Cliente();
            bb = new Banco();
            bb.comando = Banco.conexao.prepareStatement("select login, senha from cliente where codigo = ?");
            bb.comando.setInt(1, codigo);
            bb.tabela = bb.comando.executeQuery();
            if(bb.tabela.next())
            {
                obj = new Cliente();
                obj.setCodigo(bb.tabela.getInt(1));
                obj.setNome(bb.tabela.getString(2));
                obj.setLogin(bb.tabela.getString(3));
                obj.setSenha(bb.tabela.getString(4));
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

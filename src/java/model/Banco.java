/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author aluno
 */
public class Banco {
    //conexao com o banco
    public static Connection conexao; //static para nao repetir conexao
    public PreparedStatement comando; //envia sql para o banco
    public ResultSet tabela; //tabela de dados / armazena os dados que vem do banco
    
    public Banco() throws Exception
    {
        try
        {   //registra o driver, informa que vai utiliza-lo
            Class.forName("org.postgresql.Driver");
            
            //testa se a conexao nao foi instanciada (sempre em primeiro)
            if((conexao == null) || (conexao.isClosed()))
            {
                conexao = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/LPB", "postgres", "ifsp");
            }
        }
        catch(Exception ex)
        {
            throw new Exception("Erro na conexao com o banco: " + ex.getMessage());
        }
    }
    
}

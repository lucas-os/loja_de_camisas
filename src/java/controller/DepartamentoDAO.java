/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.ResultSet;
import model.Banco;
import model.Departamento;

/**
 *
 * @author Desktop
 */
public class DepartamentoDAO {
    
    public Departamento consultaCodigo(int codigo) throws Exception{
        Banco bb;
        Departamento obj=null;
        try{
            bb = new Banco();
            bb.comando=Banco.conexao.prepareStatement(
   "select codigo,nome from departamento where codigo=?");
            bb.comando.setInt(1, codigo);
            bb.tabela= bb.comando.executeQuery();
            if(bb.tabela.next()){ //caso a consultra retornou algo
                obj = new Departamento();
                obj.setCodigo(bb.tabela.getInt(1));
                obj.setNome(bb.tabela.getString(2));
            }
            Banco.conexao.close();
            return(obj);
        }
        catch(Exception ex){
            throw new Exception("Erro ao consultaCodigo do departamento no DEPARTAMENTODAO :"+ ex.getMessage());
        }
    }
    
}

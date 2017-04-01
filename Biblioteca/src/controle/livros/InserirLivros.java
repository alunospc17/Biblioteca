/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controle.livros;

import modelo.ExecutarSql;

/**
 *
 * @author Francislene
 */
public class InserirLivros {
    public InserirLivros(String sql){
        //System.out.print(sql);
        ExecutarSql execut =  new ExecutarSql();
        execut.executar(sql);        
    }
   
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controle.livros;

import modelo.ExecutarSql;

/**
 *
 * @author Dauane
 */
public class AtualizarLivros {
     public AtualizarLivros(String sql) {
        System.out.println("query " +sql);
        ExecutarSql execut = new ExecutarSql();
        execut.executar(sql);
    }
}

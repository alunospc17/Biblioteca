/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controle;

import modelo.ExecutarSql;

/**
 *
 * @author aluno
 */
public class Atualizar {
    public Atualizar(String sql) {
        System.out.println(sql);
        ExecutarSql execut = new ExecutarSql();        
        execut.executar(sql);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controle.emprestimos;

import modelo.ExecutarSql;

/**
 *
 * @author aluno
 */
public class AtualizarEmprestimo {
    public AtualizarEmprestimo(String sql) {
        System.out.println(sql);
        ExecutarSql execut = new ExecutarSql();
        
        execut.executar(sql);
    }
}
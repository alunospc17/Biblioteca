/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controle;

import modelo.ExecutarSql;

/**
 *
 * @author Dauane, Cristiano GD
 */
public class Inserir {
    public Inserir(String sql) {
        System.out.print(sql);
        ExecutarSql execut = new ExecutarSql();
        execut.executar(sql);
    }   
}
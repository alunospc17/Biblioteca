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
    public InserirLivros(Livros lv){
        String query = "INSERT INTO `bibliotecaej`.`livros` (`id`, `genero`, `titulo`, `autor`, `prateleira`, `quantidade`, `bibliotecario`, `data`) VALUES (NULL, 'drama', 'joao e maria', 'cristiano', '12', '10', 'dauane', '2017-03-18 00:00:00')";
    
        ExecutarSql execut =  new ExecutarSql();
        execut.executar(query);
        //concerta inset e insatanciar o inset no cadastrar
    }
   
}

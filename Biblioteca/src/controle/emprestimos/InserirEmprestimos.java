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
public class InserirEmprestimos {
   
public InserirEmprestimos (Emprestimos emp ){
    
String query="INSERT INTO `bibliotecaej`.`emprestimos` (`id`, `nome`, `serie`, `livro`, `data_emprestimos`, `data_devolucao`) VALUES ('', 'bruna', '3', 'fallen', '2017-03-10 00:00:00', '2017-03-17 00:00:00')";
   
  ExecutarSql execut = new ExecutarSql();
  execut.executar(query);
  // Consertar insert e instânciar insert e cadastrar.//
  
    }
    
}

//
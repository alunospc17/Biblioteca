/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import static modelo.Configuracoes.quantidade;

/**
 *
 * @author Cristiano GD
 */
public class ExecutarSql {
    
    public void executar(String comando){
        int n = JOptionPane.showConfirmDialog(  
                    null,
                    "Continuar?!" ,
                    "",
                    JOptionPane.YES_NO_OPTION);

        if(n == JOptionPane.YES_OPTION)
        {
            try
            {
                //System.out.println("SQL= "+comando);
                ConexaoBD conexao = ConexaoBD.getConexao();
                Statement stmt = ConexaoBD.con.createStatement();
                //looping
                if(Configuracoes.quantidade >1){
                for(int i = 1; i<=Configuracoes.quantidade; i++){                    
                stmt.executeUpdate(comando);
                }
              } else{
                stmt.executeUpdate(comando);
                }
                stmt.close();
                conexao.fecharConexao();
                if(Configuracoes.atualizarLivroId_emprestimo){
                    AtualizarLivroId_emprestimo();
                }
            }
            catch( java.sql.SQLException e )
            {
                //System.err.printf("\nExceção: %s\n"+comando, e);
                throw new java.lang.RuntimeException(e.getMessage());
            }
            JOptionPane.showMessageDialog(null, "Executando...");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Cancelado");
        }       
    }
    
    private void AtualizarLivroId_emprestimo(){
        String query = "UPDATE livros SET "
                + "`situacao` = '"+Configuracoes.situacao_livro
                + "' WHERE id = "+Configuracoes.id_livro;
        
        //System.out.printf("UpdateForno: "+query);
        try {
            ConexaoBD conexao = ConexaoBD.getConexao();
            Statement stmt = ConexaoBD.con.createStatement();
            stmt.executeUpdate(query);
            stmt.close();
            conexao.fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(ExecutarSql.class.getName()).log(Level.SEVERE, null, ex);
        }     
        LimparDados();
    }
    
    public void LimparDados(){
        //Configuracoes.conectado=false;
        Configuracoes.atualizarLivroId_emprestimo=false;
        Configuracoes.id_livro="";
        Configuracoes.situacao_livro="";
        JOptionPane.showMessageDialog(null, "Configurações padrão!");
    }
}

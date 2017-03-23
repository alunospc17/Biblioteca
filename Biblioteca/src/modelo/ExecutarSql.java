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
                ConexaoBD conexao = ConexaoBD.getConexao(0);
                Statement stmt = ConexaoBD.con.createStatement();
                stmt.executeUpdate(comando);
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
        String query = "UPDATE forno SET "
                + "`situacao_forno` = '"+0
                + "' WHERE id_forno = "+0;
        
        //System.out.printf("UpdateForno: "+query);
        try {
            ConexaoBD conexao = ConexaoBD.getConexao(0);
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
        Configuracoes.conectado=false;
        Configuracoes.atualizarLivroId_emprestimo=false;
        JOptionPane.showMessageDialog(null, "Configurações padrão!");
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
    
    public void LimparDados(){
        Configuracoes.conectado=false;
        JOptionPane.showMessageDialog(null, "Configurações padrão!");
    }
}

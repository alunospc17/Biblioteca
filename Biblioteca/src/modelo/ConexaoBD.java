/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Cristiano GD
 */
public class ConexaoBD {
    private static ConexaoBD instancia;
    public static Connection con = null;    
    
    public static String hostname = "";
    private String host = "";
    private String database = "";
    private String url = "";
    private String usuario_bd = "";
    private String senha_bd = "";

    private ConexaoBD()
    {
        //System.err.println("ConexaoBD: "+ index);        
        hostname ="localhost";
        host ="localhost/";
        database = "bibliotecaej";
        url = "jdbc:mysql://"+host+database;
        usuario_bd = "root";
        senha_bd = "qwe123";
        //JOptionPane.showMessageDialog(null, "Conectando ao bd localhost!");
        try
        {
            //Class.forName("org.gjt.mm.mysql.Driver").newInstance();
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(url,usuario_bd,senha_bd);
        }catch( ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex )
        {
            System.err.printf("\nExceção: %s\n", ex);
            JOptionPane.showMessageDialog(null, "Erro ao conectar: "+ex);
            //System.exit(0);
            throw new java.lang.RuntimeException("Erro ao conectar 2");
        }
    }

    public static ConexaoBD getConexao()
    {
        try
        {
            if(con == null){
               instancia = new ConexaoBD();
            }
            return instancia;
        }catch( Exception ex ){
            System.err.printf("\nExceção: %s\n", ex);
            JOptionPane.showMessageDialog(null, "Erro ao conectar: "+ex);
            //System.exit(0);
            throw new java.lang.RuntimeException("Erro ao conectar 1");
        }
    }

    public void fecharConexao()
    {
        try{
            if(con != null){
                con.close();
                con = null;
            }
        } catch (Exception ex)
        {
            System.err.printf("\nExceção: %s\n", ex);
            JOptionPane.showMessageDialog(null, "Conexão fechada! "+ex);
            throw new java.lang.RuntimeException("Erro ao conectar 3");
        }
    }

    public ResultSet consultaSql(String comando)
    {
        try
        {
            Statement stmt = con.createStatement();
            return stmt.executeQuery(comando);
        }
        catch( java.sql.SQLException ex )
        {
            System.err.printf("\nExceção: %s\n", ex);
            throw new java.lang.RuntimeException(ex.getMessage());
        }
    }
}

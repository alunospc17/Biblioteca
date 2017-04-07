/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package visao.login;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import modelo.ConexaoBD;
import modelo.Configuracoes;
import visao.livros.GerenciarLivros;



/**
 *
 * @author Cristiano
 */
public class Login extends javax.swing.JFrame {

    //variaveis
    String nome_empresa = "Empresa Madeira Carvão SA";
    
    /** Creates new form Login */
    public Login() {
        initComponents();
       // ValidadeLogin();
    }
    
    private void ValidadeLogin(){
        String options[] = {"sim","não","talvez"};
        try
        {
            //DefaultTableModel dtm = (DefaultTableModel) jTableUsuario.getModel();
            String query = "Select validade from empresas where nome_empresa = '"+nome_empresa+"'";
            ConexaoBD con = ConexaoBD.getConexao();

            ResultSet rs = con.consultaSql(query);
            rs.first();

            //data hoje
            Timestamp data_hj = new Timestamp(System.currentTimeMillis());
            //System.out.println("Data hj: "+data_hj+" validade: "+rs.getTimestamp("validade")+" : "+rs.getTimestamp("validade").after(data_hj));
            DateFormat data_format = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss"); 
            if(rs.getTimestamp("validade").after(data_hj)){
                //ControlePrincipal.validade = data_format.format(rs.getTimestamp("validade"));
                //JOptionPane.showMessageDialog(null, "Verificando validade!"+ControlePrincipal.validade);
            }else{
                JOptionPane.showMessageDialog(null, "Erro, prazo de validade do sistema vencido, contate os administradores!"
                        + "\n"
                        + "\n Cristiano G. Duarte, Fone(wtz): +55 32 98435-6738, Email: cristiano_crgd@yahoo.com.br"
                        + "\n ou"
                        + "\n ***************************");
                System.exit(0);
            }
            con.fecharConexao();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Empresa Invalida! "+ex);                    
        }
    }
    
    public void SystemIn(){
        try
        {
            String query = "Select * from usuarios where login = '"+jTextFieldUsuario.getText()+"'";
            ConexaoBD con = ConexaoBD.getConexao();

            ResultSet rs = con.consultaSql(query);
            rs.first();
            JOptionPane.showMessageDialog(null, "Conectando "+ConexaoBD.hostname);
            if(jTextFieldUsuario.getText().equals(rs.getString("login")) && jTextFieldSenha.getText().equals(rs.getString("senha"))){ 
                    String id = rs.getString("id");              
                    
                    Configuracoes.login_usuario = rs.getString("login");  
                    Configuracoes.tipo_usuario = rs.getString("tipo");   
                    
                    //JOptionPane.showMessageDialog(null, "Logado!"+login+tipo+usuario.getNome_usuario()+usuario.getId_tipo());  
                   CarregaTela(Configuracoes.tipo_usuario);  
                }else{
                    JOptionPane.showMessageDialog(null, "Erro senha invalida!");
                }
            con.fecharConexao();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Usuario Invalido!");                    
        }
    }
    
    public void CarregaTela(String tipo){
        switch (tipo) {
            case "adm":
                JOptionPane.showMessageDialog(null, "Logando Sistema Escolar"); 
                GerenciarLivros g = new GerenciarLivros();
                g.setVisible(true);
                break;
            case "op1":
                break;
            case "op2":
                break;
            case "op3":
                break;
            case "op4":
                break;
        }
        this.setVisible(false);
        dispose();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldUsuario = new javax.swing.JTextField();
        jButtonLogar = new javax.swing.JButton();
        jTextFieldSenha = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setMinimumSize(new java.awt.Dimension(225, 225));
        jPanel1.setPreferredSize(new java.awt.Dimension(225, 225));

        jLabel2.setText("Usuario");

        jLabel3.setText("Senha");

        jButtonLogar.setText("Logar");
        jButtonLogar.setPreferredSize(new java.awt.Dimension(100, 50));
        jButtonLogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogarActionPerformed(evt);
            }
        });

        jLabel1.setFont(jLabel1.getFont().deriveFont((jLabel1.getFont().getStyle() | java.awt.Font.ITALIC) | java.awt.Font.BOLD, jLabel1.getFont().getSize()+9));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Login");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 65, Short.MAX_VALUE)
                .addComponent(jButtonLogar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldUsuario)
                            .addComponent(jTextFieldSenha))))
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(jButtonLogar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(6, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogarActionPerformed
        // TODO add your handling code here:        
        SystemIn();
    }//GEN-LAST:event_jButtonLogarActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLogar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jTextFieldSenha;
    private javax.swing.JTextField jTextFieldUsuario;
    // End of variables declaration//GEN-END:variables

}

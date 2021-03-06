/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AlterarUsuario.java
 *
 * Created on 28/11/2010, 17:05:28
 */

package visao.usuarios;
import controle.Atualizar;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cristiano GD
 */
public class AlterarUsuario extends javax.swing.JFrame {    
    //variaveis
    private String id;

    /** Creates new form Alterar_Usuarios
     * @param id
     * @param login
     * @param tipo */
    public AlterarUsuario(String id, String login, String tipo) {
        initComponents();
        this.id = id;
        jTextFieldLogin.setText(login);
        jComboBoxTipo.setSelectedItem(tipo);
    }

    private AlterarUsuario() {
        throw new UnsupportedOperationException("Not yet implemented");
    }   
    
    private void AlterarDados(){
        String sql = "UPDATE usuarios SET "+
            "`login` = '"+jTextFieldLogin.getText()+"'," +
            "`senha` = '"+jTextFieldSenha.getText()+"'," +
            "`tipo` = '"+jComboBoxTipo.getSelectedItem().toString()+ 
            "' WHERE `id` ='"+id+"'"; 

        Atualizar atualizar = new Atualizar(sql);

        try {
            new GerenciarUsuarios().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(AlterarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    } 

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldLogin = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldSenha = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButtonAlterar = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();
        jComboBoxTipo = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(jLabel1.getFont().deriveFont(jLabel1.getFont().getStyle() | java.awt.Font.BOLD, jLabel1.getFont().getSize()+4));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Alterar Usuario");
        jLabel1.setPreferredSize(new java.awt.Dimension(150, 25));

        jLabel2.setFont(jLabel2.getFont().deriveFont(jLabel2.getFont().getSize()+1f));
        jLabel2.setText("Login:");
        jLabel2.setPreferredSize(new java.awt.Dimension(100, 25));

        jTextFieldLogin.setFont(jTextFieldLogin.getFont().deriveFont(jTextFieldLogin.getFont().getSize()+1f));
        jTextFieldLogin.setPreferredSize(new java.awt.Dimension(100, 25));

        jLabel3.setFont(jLabel3.getFont().deriveFont(jLabel3.getFont().getSize()+1f));
        jLabel3.setText("Senha:");
        jLabel3.setPreferredSize(new java.awt.Dimension(100, 25));

        jTextFieldSenha.setFont(jTextFieldSenha.getFont().deriveFont(jTextFieldSenha.getFont().getSize()+1f));
        jTextFieldSenha.setPreferredSize(new java.awt.Dimension(100, 25));

        jLabel4.setFont(jLabel4.getFont().deriveFont(jLabel4.getFont().getSize()+1f));
        jLabel4.setText("Tipo:");
        jLabel4.setPreferredSize(new java.awt.Dimension(100, 25));

        jButtonAlterar.setFont(jButtonAlterar.getFont().deriveFont(jButtonAlterar.getFont().getSize()+4f));
        jButtonAlterar.setText("Salvar");
        jButtonAlterar.setPreferredSize(new java.awt.Dimension(200, 50));
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });

        jButtonVoltar.setFont(jButtonVoltar.getFont().deriveFont(jButtonVoltar.getFont().getSize()+4f));
        jButtonVoltar.setText("Voltar");
        jButtonVoltar.setPreferredSize(new java.awt.Dimension(200, 50));
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        jComboBoxTipo.setFont(jComboBoxTipo.getFont().deriveFont(jComboBoxTipo.getFont().getSize()+4f));
        jComboBoxTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-", "usr", "adm" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBoxTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jTextFieldLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(10, 10, 10))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
        AlterarDados();
    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        try {
            new GerenciarUsuarios().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(AlterarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlterarUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JComboBox jComboBoxTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextFieldLogin;
    private javax.swing.JTextField jTextFieldSenha;
    // End of variables declaration//GEN-END:variables

}

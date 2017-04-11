/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package visao.emprestimos;

import controle.Atualizar;
import visao.usuarios.GerenciarUsuarios;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import modelo.ConexaoBD;
import modelo.Configuracoes;
import modelo.GerarTabela;
import visao.livros.GerenciarLivros;

/**
 *
 * @author Weverton, Ney, Vanderlea
 */
public class GerenciarEmprestimos extends javax.swing.JFrame {

    /**
     * Creates new form gerenciar
     */
    public GerenciarEmprestimos() {       
         initComponents();
        if(!Configuracoes.tipo_usuario.equals("adm")){
           jMenuItemUsuarios.setEnabled(false);
        }
         CarregarNome();
    }
    
    private void CarregarNome(){
        jLabelNome.setText("Olá, "+Configuracoes.login_usuario);
        PreencherTabela();
    }
    
    private void PreencherTabela(){
        DateFormat data_formato = new SimpleDateFormat("dd/MM/yyyy");
        ArrayList linhas = new ArrayList();
        String[] colunas = new String[] { 
            "id",
            "nome_aluno",
            "serie_aluno",
            "nome_livro",
            "data_emprestimo",
            "data_devolucao",
            "devolvido",  
            "id_livro"
        };
        //String query = "SELECT * FROM emprestimos ORDER BY devolvido ASC, data_devolucao DESC";
        String query = "SELECT * FROM emprestimos where devolvido = 'nao' ORDER BY data_devolucao ASC";
        int tamanho = 0;       
        ConexaoBD con = ConexaoBD.getConexao();        
        ResultSet rs = con.consultaSql(query);
        
        try {
            while(rs.next()){
                linhas.add(new Object[]{
                    rs.getString("id"),//0
                    rs.getString("nome_aluno"),//1
                    rs.getString("serie_aluno"),//2
                    rs.getString("nome_livro"),//3
                    data_formato.format(rs.getTimestamp("data_emprestimo")),//4
                    data_formato.format(rs.getTimestamp("data_devolucao")),//5
                    rs.getString("devolvido"),//6         
                    rs.getString("id_livro")//7
                });
                tamanho++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(GerenciarEmprestimos.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao preencher a tabela! "+ex);
        }
        
        GerarTabela modelo = new GerarTabela(linhas, colunas);
        jTableEmprestimos.setModel(modelo);
        
        jTableEmprestimos.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTableEmprestimos.getColumnModel().getColumn(1).setPreferredWidth(200);
        jTableEmprestimos.getColumnModel().getColumn(3).setPreferredWidth(200);
        
        jTableEmprestimos.getTableHeader().setReorderingAllowed(false);
        jTableEmprestimos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTableEmprestimos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        //duplo click
        jTableEmprestimos.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                    if(e.getClickCount() == 2){
                        //System.out.println("duplo-clique detectado");
                        AlterarInfo();
                    }
                }
            }); 
        con.fecharConexao();        
    }
    
    private void AlterarInfo(){
        if(jTableEmprestimos.getSelectedRow()>=0)//verifica se a linha a ser alterada esta marcada
        {
            int linha = jTableEmprestimos.getSelectedRow();
            String id = jTableEmprestimos.getValueAt(linha, 0).toString();
            String nome_aluno = jTableEmprestimos.getValueAt(linha, 1).toString();
            String serie_aluno = jTableEmprestimos.getValueAt(linha, 2).toString();
            String nome_livro = jTableEmprestimos.getValueAt(linha, 3).toString();

            new AlterarEmprestimo(id, nome_aluno, serie_aluno, nome_livro).setVisible(true);
            dispose();
        }else JOptionPane.showMessageDialog(null, "Selecione uma linha!");
    }
    
    private void DevolverLivro(){
        if(jTableEmprestimos.getSelectedRow()>=0)//verifica se a linha a ser alterada esta marcada
        {
            int linha = jTableEmprestimos.getSelectedRow();
            String id = jTableEmprestimos.getValueAt(linha, 0).toString();
            String sql ="UPDATE `emprestimos` SET `devolvido` = 'sim' WHERE `id` = "+id ;                
            Configuracoes.atualizarLivroId_emprestimo = true;
            Configuracoes.situacao_livro = "livre";
            Configuracoes.id_livro = jTableEmprestimos.getValueAt(linha, 7).toString();
            Atualizar atualizar = new Atualizar(sql);

            new GerenciarEmprestimos().setVisible(true);
            this.dispose();
        }else JOptionPane.showMessageDialog(null, "Selecione uma linha!");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        button1 = new java.awt.Button();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableEmprestimos = new javax.swing.JTable();
        jButtonAlterar = new javax.swing.JButton();
        jButtonDevolver = new javax.swing.JButton();
        jLabelNome = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItemGerenciarLivre = new javax.swing.JMenuItem();
        jMenuItemUsuarios = new javax.swing.JMenuItem();
        jMenuItemLogout = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        button1.setLabel("button1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(jLabel1.getFont().deriveFont(jLabel1.getFont().getStyle() | java.awt.Font.BOLD, jLabel1.getFont().getSize()+5));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gerenciamento de Emprestimos");
        jLabel1.setPreferredSize(new java.awt.Dimension(250, 25));

        jTableEmprestimos.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), new java.awt.Color(153, 153, 153)));
        jTableEmprestimos.setFont(jTableEmprestimos.getFont().deriveFont(jTableEmprestimos.getFont().getSize()+1f));
        jTableEmprestimos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableEmprestimos);

        jButtonAlterar.setFont(jButtonAlterar.getFont().deriveFont(jButtonAlterar.getFont().getSize()+4f));
        jButtonAlterar.setText("Alterar");
        jButtonAlterar.setPreferredSize(new java.awt.Dimension(200, 50));
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });

        jButtonDevolver.setFont(jButtonDevolver.getFont().deriveFont(jButtonDevolver.getFont().getSize()+4f));
        jButtonDevolver.setText("Devolver");
        jButtonDevolver.setPreferredSize(new java.awt.Dimension(200, 50));
        jButtonDevolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDevolverActionPerformed(evt);
            }
        });

        jLabelNome.setFont(jLabelNome.getFont().deriveFont(jLabelNome.getFont().getSize()+1f));
        jLabelNome.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelNome.setText("Ola, ...");
        jLabelNome.setPreferredSize(new java.awt.Dimension(100, 25));

        jMenu2.setText("Menu");

        jMenuItemGerenciarLivre.setText("Livros");
        jMenuItemGerenciarLivre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGerenciarLivreActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemGerenciarLivre);

        jMenuItemUsuarios.setText("Usuarios");
        jMenuItemUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemUsuariosActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemUsuarios);

        jMenuItemLogout.setText("Logout");
        jMenuItemLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemLogoutActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemLogout);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Sobre");

        jMenuItem5.setText("Info");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonDevolver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)
                    .addComponent(jLabelNome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabelNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonDevolver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
        AlterarInfo();
    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void jButtonDevolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDevolverActionPerformed
        DevolverLivro();
    }//GEN-LAST:event_jButtonDevolverActionPerformed

    private void jMenuItemGerenciarLivreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGerenciarLivreActionPerformed
        GerenciarLivros gl=new GerenciarLivros();
        gl.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItemGerenciarLivreActionPerformed

    private void jMenuItemLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemLogoutActionPerformed
        visao.login.Login login=new visao.login.Login();
        login.setVisible(true);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemLogoutActionPerformed

    private void jMenuItemUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemUsuariosActionPerformed
        try {
            new GerenciarUsuarios().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(GerenciarEmprestimos.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_jMenuItemUsuariosActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        JOptionPane.showMessageDialog(null, "Desenvolvido por PRONATEC-Técnico em Informática 2015-2017"
                + "\nAlunos: Dauane, Darciney, Francislene, Lúcios, Talles, Vanderléa, Weverton."
                + "\nEscola Estadual Emílio Jardim.");
    }//GEN-LAST:event_jMenuItem5ActionPerformed

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
            java.util.logging.Logger.getLogger(GerenciarEmprestimos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GerenciarEmprestimos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GerenciarEmprestimos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GerenciarEmprestimos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GerenciarEmprestimos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonDevolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItemGerenciarLivre;
    private javax.swing.JMenuItem jMenuItemLogout;
    private javax.swing.JMenuItem jMenuItemUsuarios;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableEmprestimos;
    // End of variables declaration//GEN-END:variables
}

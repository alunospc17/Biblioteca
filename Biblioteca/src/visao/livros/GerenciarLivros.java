/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package visao.livros;

import visao.usuarios.GerenciarUsuarios;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import modelo.ConexaoBD;
import modelo.Configuracoes;
import modelo.GerarTabela;
import visao.emprestimos.CadastrarEmprestimos;
import visao.emprestimos.GerenciarEmprestimos;

/**
 *
 * @author Francislene, Dauane ,Cristiano GD
 */
public class GerenciarLivros extends javax.swing.JFrame {

    int maior=0;
    /**
     * Creates new form GerenciamentoDeLivros
     */
    public GerenciarLivros() {
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
        //Date data = new Date();
        ArrayList linhas = new ArrayList();
        String[] colunas = new String[] { 
            "id",
            "titulo",
            "autor",
            "genero",
            "prateleira",
            "bibliotecario",
            "data",
            "situacao"
        };       
        String query = "Select * from livros where titulo like '%"+jTextFieldBuscar.getText()+"%' ORDER BY situacao DESC";
        int tamanho = 0;       
        ConexaoBD con = ConexaoBD.getConexao();        
        ResultSet rs = con.consultaSql(query);
        
        try {
            while(rs.next()){
                linhas.add(new Object[]{
                    rs.getString("id"),//0
                    rs.getString("titulo"),//1
                    rs.getString("autor"),//2
                    rs.getString("genero"),//3
                    rs.getString("prateleira"),//4
                    rs.getString("bibliotecario"),//5
                    data_formato.format(rs.getTimestamp("data")),//6
                    rs.getString("situacao")//7
                });  
                tamanho++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(GerenciarLivros.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao preencher a tabela! "+ex);
        }
        
        GerarTabela modelo = new GerarTabela(linhas, colunas);
        jTableLivros.setModel(modelo);
        
        jTableLivros.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTableLivros.getColumnModel().getColumn(1).setPreferredWidth(200);
        jTableLivros.getColumnModel().getColumn(2).setPreferredWidth(200);
        
        jTableLivros.getTableHeader().setReorderingAllowed(false);
        jTableLivros.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTableLivros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        //duplo click
        jTableLivros.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                    if(e.getClickCount() == 2){
                        //System.out.println("duplo-clique detectado");
                       // AlterarInfo();
                    }
                }
            }); 
        con.fecharConexao();       
    }
    
    private void EditarInfoLivro(){
        if(jTableLivros.getSelectedRow()>=0)//verifica se a linha a ser alterada esta marcada
        {
            int linha = jTableLivros.getSelectedRow();
            String id = jTableLivros.getValueAt(linha, 0).toString();
            String titulo = jTableLivros.getValueAt(linha, 1).toString();
            String autor = jTableLivros.getValueAt(linha, 2).toString();
            String genero = jTableLivros.getValueAt(linha, 3).toString();
            int prateleira = Integer.valueOf(jTableLivros.getValueAt(linha, 4).toString());
            String bibliotecario = jTableLivros.getValueAt(linha, 5).toString();
            String data = jTableLivros.getValueAt(linha, 6).toString();
            String situacao = jTableLivros.getValueAt(linha, 7).toString();

            new AlterarLivros (id, titulo, autor, genero, prateleira, bibliotecario, data, situacao).setVisible(true);
            this.dispose();
        }else JOptionPane.showMessageDialog(null, "Selecione uma linha!");
    }

private void EmprestarLivro(){
        if(jTableLivros.getSelectedRow()>=0)//verifica se a linha a ser alterada esta marcada
        {
            int linha = jTableLivros.getSelectedRow();            
            if(jTableLivros.getValueAt(linha, 7).toString().equals("livre")){
                Configuracoes.id_livro = jTableLivros.getValueAt(linha, 0).toString();
                String titulo = jTableLivros.getValueAt(linha, 1).toString();
                Configuracoes.situacao_livro = "emprestado";
                Configuracoes.atualizarLivroId_emprestimo=true; 
                new CadastrarEmprestimos (titulo).setVisible(true);
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(null, "Exemplar emprestado!");
            }            
        }else {
            JOptionPane.showMessageDialog(null, "Selecione uma linha!");
        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldBuscar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableLivros = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabelNome = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemEmprestimos = new javax.swing.JMenuItem();
        jMenuItemUsuarios = new javax.swing.JMenuItem();
        jMenuItemLogout = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(jLabel1.getFont().deriveFont(jLabel1.getFont().getStyle() | java.awt.Font.BOLD, jLabel1.getFont().getSize()+4));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gerenciamento de Livros");
        jLabel1.setPreferredSize(new java.awt.Dimension(100, 25));

        jLabel2.setFont(jLabel2.getFont().deriveFont(jLabel2.getFont().getSize()+1f));
        jLabel2.setText("Título do Livro:");
        jLabel2.setPreferredSize(new java.awt.Dimension(100, 25));

        jTextFieldBuscar.setFont(jTextFieldBuscar.getFont().deriveFont(jTextFieldBuscar.getFont().getSize()+1f));
        jTextFieldBuscar.setPreferredSize(new java.awt.Dimension(100, 25));

        jButton1.setFont(jButton1.getFont().deriveFont(jButton1.getFont().getSize()+1f));
        jButton1.setText("Buscar");
        jButton1.setPreferredSize(new java.awt.Dimension(100, 25));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTableLivros.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), new java.awt.Color(153, 153, 153)));
        jTableLivros.setFont(jTableLivros.getFont().deriveFont(jTableLivros.getFont().getSize()+1f));
        jScrollPane1.setViewportView(jTableLivros);

        jButton2.setFont(jButton2.getFont().deriveFont(jButton2.getFont().getSize()+4f));
        jButton2.setText("Emprestar");
        jButton2.setPreferredSize(new java.awt.Dimension(200, 50));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(jButton3.getFont().deriveFont(jButton3.getFont().getSize()+4f));
        jButton3.setText("Cadastrar");
        jButton3.setPreferredSize(new java.awt.Dimension(200, 50));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(jButton4.getFont().deriveFont(jButton4.getFont().getSize()+4f));
        jButton4.setText("Alterar");
        jButton4.setPreferredSize(new java.awt.Dimension(200, 50));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabelNome.setFont(jLabelNome.getFont().deriveFont(jLabelNome.getFont().getSize()+1f));
        jLabelNome.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelNome.setText("Ola, ...");
        jLabelNome.setPreferredSize(new java.awt.Dimension(100, 25));

        jMenu1.setText("Menu");

        jMenuItemEmprestimos.setText("Emprestimos");
        jMenuItemEmprestimos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEmprestimosActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemEmprestimos);

        jMenuItemUsuarios.setText("Usuarios");
        jMenuItemUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemUsuariosActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemUsuarios);

        jMenuItemLogout.setText("Logout");
        jMenuItemLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemLogoutActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemLogout);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Sobre");

        jMenuItem6.setText("Info");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelNome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabelNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        CadastrarLivros cl = new CadastrarLivros();
        cl.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        EmprestarLivro();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        PreencherTabela();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        EditarInfoLivro();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jMenuItemEmprestimosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEmprestimosActionPerformed
        GerenciarEmprestimos ge=new GerenciarEmprestimos();
        ge.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItemEmprestimosActionPerformed

    private void jMenuItemLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemLogoutActionPerformed
        visao.login.Login login=new visao.login.Login();
        login.setVisible(true); 
        this.dispose();
    }//GEN-LAST:event_jMenuItemLogoutActionPerformed

    private void jMenuItemUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemUsuariosActionPerformed
        try {
            new GerenciarUsuarios().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(GerenciarLivros.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_jMenuItemUsuariosActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        JOptionPane.showMessageDialog(null, "Desenvolvido por PRONATEC-Técnico em Informática 2015-2017"
            + "\nAlunos: Dauane, Darciney, Francislene, Lúcios, Talles, Vanderléa, Weverton."
            + "\nEscola Estadual Emílio Jardim.");
    }//GEN-LAST:event_jMenuItem6ActionPerformed

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
            java.util.logging.Logger.getLogger(GerenciarLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GerenciarLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GerenciarLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GerenciarLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GerenciarLivros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItemEmprestimos;
    private javax.swing.JMenuItem jMenuItemLogout;
    private javax.swing.JMenuItem jMenuItemUsuarios;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableLivros;
    private javax.swing.JTextField jTextFieldBuscar;
    // End of variables declaration//GEN-END:variables
}

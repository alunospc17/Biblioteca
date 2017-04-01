/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package visao.livros;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import modelo.ConexaoBD;
import modelo.Configuracoes;
import modelo.GerarTabela;
import visao.emprestimos.CadastrarEmprestimos;

/**
 *
 * @author Francislene, Dauane ,Cristiano GD
 */
public class GerenciarLivros extends javax.swing.JFrame {

    /**
     * Creates new form GerenciamentoDeLivros
     */
    public GerenciarLivros() {
        initComponents();
        PreencherTabela();
    }
     private void PreencherTabela(){
        ArrayList linhas = new ArrayList();
        String[] colunas = new String[] { 
            "id",
            "genero",
            "titulo",
            "autor",
            "prateleira",
            "bibliotecario",
            "data",
            "situacao"
        };
        String query = "Select * from livros where titulo like '%"+jTextFieldBuscar.getText()+"%'";
        int tamanho = 0;       
        ConexaoBD con = ConexaoBD.getConexao();        
        ResultSet rs = con.consultaSql(query);
        
        try {
            while(rs.next()){
                linhas.add(new Object[]{
                    rs.getString("id"),
                    rs.getString("genero"),
                    rs.getString("titulo"),
                    rs.getString("autor"),
                    rs.getString("prateleira"),
                    rs.getString("bibliotecario"),
                    rs.getString("data"),
                    rs.getString("situacao")
                });
                tamanho++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(GerenciarLivros.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao preencher a tabela! "+ex);
        }
        
        GerarTabela modelo = new GerarTabela(linhas, colunas);
        jTableLivros.setModel(modelo);
        for(int i=0;i<colunas.length;i++){
            if(colunas[i].length()<=8){                
                jTableLivros.getColumnModel().getColumn(i).setPreferredWidth(colunas[i].length()*25);
            }else if(colunas[i].length()>8 && colunas[i].length()<=15){
                jTableLivros.getColumnModel().getColumn(i).setPreferredWidth(colunas[i].length()*20);
            }else{
               jTableLivros.getColumnModel().getColumn(i).setPreferredWidth(colunas[i].length()*15);
            }
            /*jTableUsuario.getColumnModel().getColumn(0).setMinWidth(0);     
            jTableUsuario.getColumnModel().getColumn(0).setPreferredWidth(0);  
            jTableUsuario.getColumnModel().getColumn(0).setMaxWidth(0);
            jTableUsuario.getColumnModel().getColumn(0).setResizable(false);*/
            //System.out.println("Indice: "+i+" - "+ colunas[i].length());
        }
        jTableLivros.getTableHeader().setReorderingAllowed(false);
        jTableLivros.setAutoResizeMode(jTableLivros.AUTO_RESIZE_OFF);
        jTableLivros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        //duplo click
        jTableLivros.addMouseListener(new MouseAdapter(){
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
            String genero = jTableLivros.getValueAt(linha, 1).toString();
            String titulo = jTableLivros.getValueAt(linha, 2).toString();
            String autor = jTableLivros.getValueAt(linha, 3).toString();
            String prateleira = jTableLivros.getValueAt(linha, 4).toString();
            String bibliotecario = jTableLivros.getValueAt(linha, 5).toString();
            String data = jTableLivros.getValueAt(linha, 6).toString();
            String situacao = jTableLivros.getValueAt(linha, 7).toString();

            new AlterarLivros (id, genero, titulo, autor, prateleira, bibliotecario, data, situacao).setVisible(true);
            dispose();
        }else JOptionPane.showMessageDialog(null, "Selecione uma linha!");
    }

private void EmprestarLivro(){
        if(jTableLivros.getSelectedRow()>=0)//verifica se a linha a ser alterada esta marcada
        {
            int linha = jTableLivros.getSelectedRow();
            Configuracoes.id_livro = jTableLivros.getValueAt(linha, 0).toString();
            String titulo = jTableLivros.getValueAt(linha, 2).toString();
            Configuracoes.situacao_livro = "emprestado";
            Configuracoes.atualizarLivroId_emprestimo=true;
            new CadastrarEmprestimos (titulo).setVisible(true);
            dispose();
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldBuscar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableLivros = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Livros Literários da EEEJ");

        jLabel2.setText("Título do Livro:");

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTableLivros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Gênero", "Título", "Autor", "Quantidade", "Prateleira"
            }
        ));
        jScrollPane1.setViewportView(jTableLivros);
        if (jTableLivros.getColumnModel().getColumnCount() > 0) {
            jTableLivros.getColumnModel().getColumn(5).setResizable(false);
        }

        jButton2.setText("Emprestar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Cadastrar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Alterar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Remover");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(139, 139, 139)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jButton2)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3)
                                .addGap(31, 31, 31)
                                .addComponent(jButton4)
                                .addGap(137, 137, 137)
                                .addComponent(jButton5)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldBuscar)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1))
                            .addComponent(jScrollPane1))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton5)
                    .addComponent(jButton4))
                .addGap(26, 26, 26))
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
        // TODO add your handling code here:
        PreencherTabela();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        EditarInfoLivro();
    }//GEN-LAST:event_jButton4ActionPerformed

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
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableLivros;
    private javax.swing.JTextField jTextFieldBuscar;
    // End of variables declaration//GEN-END:variables
}

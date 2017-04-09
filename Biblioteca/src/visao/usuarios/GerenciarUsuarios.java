/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * GerenciarUsuarios.java
 * Cristiano GD
 * Created on 28/11/2010, 15:49:22
 */

package visao.usuarios;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import modelo.ConexaoBD;
import modelo.Configuracoes;
import modelo.GerarTabela;
import visao.emprestimos.GerenciarEmprestimos;
import visao.livros.GerenciarLivros;

/**
 *
 * @author Cristiano
 */
public class GerenciarUsuarios extends javax.swing.JFrame {

    //variables
    
    /** Creates new form CadastroUsuarios
     * @throws java.sql.SQLException */
    public GerenciarUsuarios() throws SQLException {
        initComponents(); 
        //this.setExtendedState(MAXIMIZED_BOTH);
        //jButtonExcluir.setVisible(false);   
        CarregarNome();
    } 
    private void CarregarNome(){
        jLabelNome.setText(Configuracoes.login_usuario);
        PreencherTabela();
    } 
    
    /**
     * 
     */
    private void PreencherTabela(){
        ArrayList linhas = new ArrayList();
        String[] colunas = new String[] { 
            "id",
            "login",
            "tipo"
        };
        String query = "Select * from usuarios";
        int tamanho = 0;       
        ConexaoBD con = ConexaoBD.getConexao();        
        ResultSet rs = con.consultaSql(query);
        
        try {
            while(rs.next()){
                linhas.add(new Object[]{
                    rs.getString("id"),
                    rs.getString("login"),
                    rs.getString("tipo")
                });
                tamanho++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(GerenciarUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao preencher a tabela! "+ex);
        }
        
        GerarTabela modelo = new GerarTabela(linhas, colunas);
        jTableUsuario.setModel(modelo);
        for(int i=0;i<colunas.length;i++){
            if(colunas[i].length()<=8){                
                jTableUsuario.getColumnModel().getColumn(i).setPreferredWidth(colunas[i].length()*25);
            }else if(colunas[i].length()>8 && colunas[i].length()<=15){
                jTableUsuario.getColumnModel().getColumn(i).setPreferredWidth(colunas[i].length()*20);
            }else{
                jTableUsuario.getColumnModel().getColumn(i).setPreferredWidth(colunas[i].length()*15);
            }
            /*jTableUsuario.getColumnModel().getColumn(0).setMinWidth(0);     
            jTableUsuario.getColumnModel().getColumn(0).setPreferredWidth(0);  
            jTableUsuario.getColumnModel().getColumn(0).setMaxWidth(0);
            jTableUsuario.getColumnModel().getColumn(0).setResizable(false);*/
            //System.out.println("Indice: "+i+" - "+ colunas[i].length());
        }
        
        jTableUsuario.getTableHeader().setReorderingAllowed(false);
        jTableUsuario.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTableUsuario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        //duplo click
        jTableUsuario.addMouseListener(new MouseAdapter(){
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
    
    private void InserirInfo(){
        new InserirUsuario().setVisible(true);
        dispose();
    }
    
    private void AlterarInfo(){
        if(jTableUsuario.getSelectedRow()>=0)//verifica se a linha a ser alterada esta marcada
        {
            int linha = jTableUsuario.getSelectedRow();
            String id = jTableUsuario.getValueAt(linha, 0).toString();
            String login = jTableUsuario.getValueAt(linha, 1).toString();
            String tipo = jTableUsuario.getValueAt(linha, 2).toString();

            new AlterarUsuario(id, login, tipo).setVisible(true);
            dispose();
        }else JOptionPane.showMessageDialog(null, "Selecione uma linha!");
    }
    
    private void ExcluirInfo(){
        if(jTableUsuario.getSelectedRow()>=0) {
            int linha = jTableUsuario.getSelectedRow();
            String id_usuario = jTableUsuario.getValueAt(linha, 0).toString();
            new ExcluirUsuario(id_usuario).setVisible(true);
            this.setVisible(false);
            dispose();
        }else JOptionPane.showMessageDialog(null, "Selecione uma linha!");
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableUsuario = new javax.swing.JTable();
        jButtonCadastrar = new javax.swing.JButton();
        jButtonAlterar = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabelNome = new javax.swing.JLabel();
        jMenuBar5 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenuItemEmprestimos = new javax.swing.JMenuItem();
        jMenuItemLivros = new javax.swing.JMenuItem();
        jMenuItemLogout = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(jLabel1.getFont().deriveFont(jLabel1.getFont().getStyle() | java.awt.Font.BOLD, jLabel1.getFont().getSize()+4));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gerenciamento de Usuarios");
        jLabel1.setPreferredSize(new java.awt.Dimension(100, 25));

        jTableUsuario.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), new java.awt.Color(153, 153, 153)));
        jTableUsuario.setFont(jTableUsuario.getFont().deriveFont(jTableUsuario.getFont().getSize()+1f));
        jScrollPane1.setViewportView(jTableUsuario);

        jButtonCadastrar.setFont(jButtonCadastrar.getFont().deriveFont(jButtonCadastrar.getFont().getSize()+4f));
        jButtonCadastrar.setText("Cadastrar");
        jButtonCadastrar.setPreferredSize(new java.awt.Dimension(200, 50));
        jButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarActionPerformed(evt);
            }
        });

        jButtonAlterar.setFont(jButtonAlterar.getFont().deriveFont(jButtonAlterar.getFont().getSize()+4f));
        jButtonAlterar.setText("Alterar");
        jButtonAlterar.setPreferredSize(new java.awt.Dimension(200, 50));
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });

        jButton4.setFont(jButton4.getFont().deriveFont(jButton4.getFont().getSize()+4f));
        jButton4.setText("Excluir");
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

        jMenu5.setText("Menu");

        jMenuItemEmprestimos.setText("Emprestimos");
        jMenuItemEmprestimos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEmprestimosActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItemEmprestimos);

        jMenuItemLivros.setText("Livros");
        jMenuItemLivros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemLivrosActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItemLivros);

        jMenuItemLogout.setText("Logout");
        jMenuItemLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemLogoutActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItemLogout);

        jMenuBar5.add(jMenu5);

        jMenu6.setText("Sobre");

        jMenuItem8.setText("Desenvolvido pelos alunos Dauane, Francislene e Lúcios do Pronatec 2015-2017 da Escola Estadual Emílio Jardim.");
        jMenu6.add(jMenuItem8);

        jMenuBar5.add(jMenu6);

        setJMenuBar(jMenuBar5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jButtonAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jLabelNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemEmprestimosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEmprestimosActionPerformed
        GerenciarEmprestimos ge=new GerenciarEmprestimos();
        ge.setVisible(true);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemEmprestimosActionPerformed

    private void jMenuItemLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemLogoutActionPerformed
        visao.login.Login login=new visao.login.Login();
        login.setVisible(true);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemLogoutActionPerformed

    private void jButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarActionPerformed
        InserirInfo();
    }//GEN-LAST:event_jButtonCadastrarActionPerformed

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
        AlterarInfo();
    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //ExcluirInfo();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jMenuItemLivrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemLivrosActionPerformed
        GerenciarLivros gl = new GerenciarLivros();
        gl.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItemLivrosActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new GerenciarUsuarios().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(GerenciarUsuarios.class.getName()).log(Level.SEVERE, null, ex);               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonCadastrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar5;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItemEmprestimos;
    private javax.swing.JMenuItem jMenuItemLivros;
    private javax.swing.JMenuItem jMenuItemLogout;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableUsuario;
    // End of variables declaration//GEN-END:variables

}
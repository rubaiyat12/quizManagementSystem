
package home;

import java.sql.*;
import Project.ConnectionProvider;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

public class updateQuestion extends javax.swing.JFrame {

   
    public updateQuestion() {
        initComponents();
        clearText();
        updateTable();
    }

    private void updateTable(){
        try
        {
            Connection con=ConnectionProvider.getCon();
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from question");
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private void clearText(){
        questionName.setText("");
        option1.setText("");
        option2.setText("");
        option3.setText("");
        option4.setText("");
        answer.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        close = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        clear = new javax.swing.JButton();
        update = new javax.swing.JButton();
        questionName = new javax.swing.JTextField();
        option1 = new javax.swing.JTextField();
        option2 = new javax.swing.JTextField();
        option3 = new javax.swing.JTextField();
        option4 = new javax.swing.JTextField();
        answer = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setLocation(new java.awt.Point(150, 180));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home/Update Question.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        jLabel2.setFont(new java.awt.Font("Algerian", 1, 40)); // NOI18N
        jLabel2.setText("Update Question");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 11, -1, -1));

        close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home/Close.png"))); // NOI18N
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });
        getContentPane().add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(1094, 11, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 86, 1197, 10));

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("Question Name:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 14, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setText("Option 1:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 45, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setText("Option 2:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 84, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setText("Option 3:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 123, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel7.setText("Option 4:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 157, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel8.setText("Answer:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 194, -1, -1));

        clear.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        clear.setText("Clear");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        jPanel1.add(clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 249, -1, -1));

        update.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPanel1.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 249, -1, -1));

        questionName.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jPanel1.add(questionName, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 11, 553, -1));

        option1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jPanel1.add(option1, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 45, 553, -1));

        option2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jPanel1.add(option2, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 84, 553, -1));

        option3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jPanel1.add(option3, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 123, 553, -1));

        option4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jPanel1.add(option4, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 157, 553, -1));

        answer.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jPanel1.add(answer, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 191, 553, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 298, 1180, 171));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 1200, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        adminHome.open=0;
        setVisible(false);
    }//GEN-LAST:event_closeActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int i=jTable1.getSelectedRow();
        TableModel model=jTable1.getModel();
        questionName.setText(model.getValueAt(i, 1).toString());
        option1.setText(model.getValueAt(i, 2).toString());
        option2.setText(model.getValueAt(i, 3).toString());
        option3.setText(model.getValueAt(i, 4).toString());
        option4.setText(model.getValueAt(i, 5).toString());
        answer.setText(model.getValueAt(i, 6).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        clearText();
        jTable1.getSelectionModel().clearSelection();
    }//GEN-LAST:event_clearActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        
        if(jTable1.getSelectionModel().isSelectionEmpty()){
            JFrame jf=new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf, "Please select any question for update!");
        }
        else{
            int row =jTable1.getSelectedRow();
            String cellId=jTable1.getModel().getValueAt(row, 0).toString();
            int id=Integer.parseInt(cellId);
            String name=questionName.getText();
            String opt1=option1.getText();
            String opt2=option2.getText();
            String opt3=option3.getText();
            String opt4=option4.getText();
            String ans=answer.getText();
            JFrame jf=new JFrame();
            jf.setAlwaysOnTop(true);
            int a=JOptionPane.showConfirmDialog(jf, "Are you sure want to update this ?","Select",JOptionPane.YES_NO_OPTION);
            if(a==0){
                if(name.isEmpty()||opt1.isEmpty()||opt2.isEmpty()||opt3.isEmpty()||opt4.isEmpty()||ans.isEmpty()){
                 
                    jf.setAlwaysOnTop(true);
                    JOptionPane.showMessageDialog(jf, "All field will be fullfiled !");
                }
                else{
                    try{
                        Connection con=ConnectionProvider.getCon();
                        PreparedStatement ps=con.prepareStatement("update question set name=?,opt1=?,opt2=?,opt3=?,opt4=?,answer=? where id=?");
                
                        ps.setString(1, name);
                        ps.setString(2, opt1);
                        ps.setString(3, opt2);
                        ps.setString(4, opt3);
                        ps.setString(5, opt4);
                        ps.setString(6, ans);
                        ps.setInt(7, id);
                        ps.executeUpdate();
            
                        jf.setAlwaysOnTop(true);
                        JOptionPane.showMessageDialog(jf, "Successfully updated");
                        clearText();
                        jTable1.getSelectionModel().clearSelection();
                        updateTable();
                        
                    }
                    catch(Exception ex){
                        
                        jf.setAlwaysOnTop(true);
                        JOptionPane.showMessageDialog(jf, ex);
                    }
                }
            }
        }
    }//GEN-LAST:event_updateActionPerformed

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
            java.util.logging.Logger.getLogger(updateQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(updateQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(updateQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(updateQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new updateQuestion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField answer;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton clear;
    private javax.swing.JButton close;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField option1;
    private javax.swing.JTextField option2;
    private javax.swing.JTextField option3;
    private javax.swing.JTextField option4;
    private javax.swing.JTextField questionName;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}

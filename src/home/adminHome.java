
package home;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class adminHome extends javax.swing.JFrame {
public static int open=0;
    
    public adminHome() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        addNewQuestion = new javax.swing.JMenu();
        updateQuestion = new javax.swing.JMenu();
        allQuestion = new javax.swing.JMenu();
        deleteQuestion = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        logout = new javax.swing.JMenu();
        exit = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(149, 175, 192));
        setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(149, 175, 192));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home/index background.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -100, -1, -1));

        jMenuBar1.setBackground(new java.awt.Color(238, 90, 36));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Navigation Bar", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 24), new java.awt.Color(196, 229, 56))); // NOI18N

        addNewQuestion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home/add new question.png"))); // NOI18N
        addNewQuestion.setText("Add New Question");
        addNewQuestion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addNewQuestion.setMargin(new java.awt.Insets(0, 5, 0, 30));
        addNewQuestion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addNewQuestionMouseClicked(evt);
            }
        });
        jMenuBar1.add(addNewQuestion);

        updateQuestion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home/Update Question.png"))); // NOI18N
        updateQuestion.setText("Update Question");
        updateQuestion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        updateQuestion.setMargin(new java.awt.Insets(0, 5, 0, 30));
        updateQuestion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateQuestionMouseClicked(evt);
            }
        });
        jMenuBar1.add(updateQuestion);

        allQuestion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home/all questions.png"))); // NOI18N
        allQuestion.setText("All Question");
        allQuestion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        allQuestion.setMargin(new java.awt.Insets(0, 5, 0, 30));
        allQuestion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                allQuestionMouseClicked(evt);
            }
        });
        jMenuBar1.add(allQuestion);

        deleteQuestion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home/delete Question.png"))); // NOI18N
        deleteQuestion.setText("Delete Question");
        deleteQuestion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        deleteQuestion.setMargin(new java.awt.Insets(0, 5, 0, 30));
        deleteQuestion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteQuestionMouseClicked(evt);
            }
        });
        jMenuBar1.add(deleteQuestion);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home/all student result.png"))); // NOI18N
        jMenu6.setText("All Student Result");
        jMenu6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenu6.setMargin(new java.awt.Insets(0, 5, 0, 30));
        jMenu6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu6MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu6);

        logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home/Logout.png"))); // NOI18N
        logout.setText("Logout");
        logout.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        logout.setMargin(new java.awt.Insets(0, 5, 0, 30));
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
            }
        });
        jMenuBar1.add(logout);

        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home/Close.png"))); // NOI18N
        exit.setText("Exit");
        exit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        exit.setMargin(new java.awt.Insets(0, 5, 0, 30));
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
        });
        jMenuBar1.add(exit);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
        JFrame jf=new JFrame();
        jf.setAlwaysOnTop(true);
        int a=JOptionPane.showConfirmDialog(jf, "Do you really want to Logout","Select",JOptionPane.YES_NO_OPTION);
        if(a==0){
            setVisible(false);
            new index().setVisible(true);
        }
    }//GEN-LAST:event_logoutMouseClicked

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
        JFrame jf=new JFrame();
        jf.setAlwaysOnTop(true);
        int a=JOptionPane.showConfirmDialog(jf, "Do you really want to Exit Application","Select",JOptionPane.YES_NO_OPTION);
        if(a==0){
            System.exit(0);
        }
    }//GEN-LAST:event_exitMouseClicked

    private void addNewQuestionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addNewQuestionMouseClicked
        if(open==0){
            new addNewQuestion().setVisible(true);
            open=1;
        }
        else{
            JFrame jf=new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf, "One form is already open");
        }
    }//GEN-LAST:event_addNewQuestionMouseClicked

    private void updateQuestionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateQuestionMouseClicked
        if(open==0){
            new updateQuestion().setVisible(true);
            open=1;
        }
        else{
            JFrame jf=new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf, "One form is already open");
        }
    }//GEN-LAST:event_updateQuestionMouseClicked

    private void allQuestionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_allQuestionMouseClicked
        if(open==0){
            new allQuestion().setVisible(true);
            open=1;
        }
        else{
            JFrame jf=new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf, "One form is already open");
        }
    }//GEN-LAST:event_allQuestionMouseClicked

    private void deleteQuestionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteQuestionMouseClicked
       if(open==0){
            new deleteQuestion().setVisible(true);
            open=1;
        }
        else{
            JFrame jf=new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf, "One form is already open");
        }
    }//GEN-LAST:event_deleteQuestionMouseClicked

    private void jMenu6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu6MouseClicked
        // TODO add your handling code here:
         if(open==0){
            new allStudentResult().setVisible(true);
            open=1;
        }
        else{
            JFrame jf=new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf, "One form is already open");
        }
    }//GEN-LAST:event_jMenu6MouseClicked

    
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
            java.util.logging.Logger.getLogger(adminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu addNewQuestion;
    private javax.swing.JMenu allQuestion;
    private javax.swing.JMenu deleteQuestion;
    private javax.swing.JMenu exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu logout;
    private javax.swing.JMenu updateQuestion;
    // End of variables declaration//GEN-END:variables
}

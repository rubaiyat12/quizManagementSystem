
package home;
import Project.ConnectionProvider;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;


public class quizExamStudent extends javax.swing.JFrame {
    public String fstCheck;
    public String questionId;
    public String answer;
    public int min=0;
    public int sec=0;
    public int marks=0;
    public String totalNoQuestion="";
    public int finalNoQuestion;
    public int ans;
    
    public void answerCheck(){
        String studentAnswer="";
        if(radioOption1.isSelected()){
            studentAnswer=radioOption1.getText();
        }
        else if(radioOption2.isSelected()){
            studentAnswer=radioOption2.getText();
        }
        else if(radioOption3.isSelected()){
            studentAnswer=radioOption3.getText();
        }
        else if(radioOption4.isSelected()){
            studentAnswer=radioOption4.getText();
        }
        if(studentAnswer.equals(answer)){
            marks=marks+1;
            String marks1=String.valueOf(marks);
            showMarks.setText(marks1);
        }
        //question no change
        int questionId1=Integer.parseInt(questionId);
        questionId1=questionId1+1;
        questionId=String.valueOf(questionId1);
        
        //clear question optionbtn
        radioOption1.setSelected(false);
        
        radioOption2.setSelected(false);
        radioOption3.setSelected(false);
        radioOption4.setSelected(false);
            
        
        
        //last question hide next button
        if(questionId.equals(totalNoQuestion)){
            nextBtn.setVisible(false);
                
        }
             
            
        
        
        
        
        
    }
    
    public void submit(){
        String rollNo=showRollNo.getText();
        answerCheck();
        try{
            Connection con =ConnectionProvider.getCon();
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
    ResultSet.CONCUR_READ_ONLY);
            st.executeUpdate("update student set marks='"+marks+"' where rollNo='"+rollNo+"'");
            String marks1=String.valueOf(marks);
            setVisible(false);
            if(fstCheck.equals("1")){
                 new successfullySubmitted(rollNo,marks1,totalNoQuestion,finalNoQuestion).setVisible(true);
            }
            else if(totalNoQuestion.equals(String.valueOf(finalNoQuestion))){
                
                new HardLevel(rollNo, marks1,ans, totalNoQuestion, finalNoQuestion).setVisible(true);
            }
            else{
                
                new MediumLevel(rollNo, marks1,ans, totalNoQuestion, finalNoQuestion).setVisible(true);
            }
           
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    public void question(){
        try{
            Connection con =ConnectionProvider.getCon();
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
    ResultSet.CONCUR_READ_ONLY);
            
            
            
            ResultSet rsl=st.executeQuery("select * from question where id ='"+questionId+"'");
            while(rsl.next()){
             showQNo.setText(rsl.getString(1));
             showQuestion.setText(rsl.getString(2));
             radioOption1.setText(rsl.getString(3));
             radioOption2.setText(rsl.getString(4));
             radioOption3.setText(rsl.getString(5));
             radioOption4.setText(rsl.getString(6));
             answer=rsl.getString(7);
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }
    public quizExamStudent() {
        initComponents();
    }
    Timer time;
     public quizExamStudent(String rollNo1,String sQ,String endQ,int finalQ) {
        initComponents();
        fstCheck=sQ;
        questionId=sQ;
        totalNoQuestion=endQ;
        finalNoQuestion=finalQ;
        int a=Integer.parseInt(fstCheck);
        int b=Integer.parseInt(totalNoQuestion);
        ans=b-a+1;
        
        showRollNo.setText(rollNo1);
        //date
        
        SimpleDateFormat dFormat =new SimpleDateFormat("dd-MM-yyyy");
        Date date=new Date();
        showDate.setText(dFormat.format(date));
        
        // first question and student details
        
        try{
            Connection con =ConnectionProvider.getCon();
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
    ResultSet.CONCUR_READ_ONLY);
            
            ResultSet rs=st.executeQuery("select *from student where rollNo='"+rollNo1+"'");
            
            while(rs.next()){
                showName.setText(rs.getString(2));
            }
            
            ResultSet rsl=st.executeQuery("select * from question where id ='"+questionId+"'");
            while(rsl.next()){
             showQNo.setText(rsl.getString(1));
             showQuestion.setText(rsl.getString(2));
             radioOption1.setText(rsl.getString(3));
             radioOption2.setText(rsl.getString(4));
             radioOption3.setText(rsl.getString(5));
             radioOption4.setText(rsl.getString(6));
             answer=rsl.getString(7);
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        //get total question
//        try{
//             Connection con =ConnectionProvider.getCon();
//            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
//    ResultSet.CONCUR_READ_ONLY);
//            ResultSet rs1=st.executeQuery("select count(id) from question");
//            if(rs1.first()){
//                int noQ=rs1.getInt(1);
//            totalNoQuestion=String.valueOf(noQ);
//            
//            }
//            
//        }
//        catch(Exception ex){
//            JOptionPane.showMessageDialog(null, ex);
//        }
        showTotalQuestion.setText(String.valueOf(ans));
           
        if(questionId.equals(totalNoQuestion)){
            nextBtn.setVisible(false);
                
        }
        //time program
         setLocationRelativeTo(this);
         time=new Timer(1000,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showSecond.setText(String.valueOf(sec));
                showMin.setText(String.valueOf(min));
                if(sec==60){
                    sec=0;
                    min++;
                    if(min==10){
                        time.stop();
                        answerCheck();
                        submit();
                    }
                }
                sec++;
            }
        });
         time.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        showDate = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        showMin = new javax.swing.JLabel();
        showSecond = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        showRollNo = new javax.swing.JLabel();
        showTotalQuestion = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        showName = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        showQNo = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        showMarks = new javax.swing.JLabel();
        showQuestion = new javax.swing.JLabel();
        radioOption2 = new javax.swing.JRadioButton();
        radioOption4 = new javax.swing.JRadioButton();
        radioOption3 = new javax.swing.JRadioButton();
        radioOption1 = new javax.swing.JRadioButton();
        nextBtn = new javax.swing.JButton();
        submitBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 255, 102));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home/index student.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        jLabel2.setText("welcome");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel3.setText("Date : ");

        showDate.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        showDate.setText("jLabel4");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel5.setText("Total Time : ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel6.setText("Time Taken : ");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel7.setText("10 Min");

        showMin.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        showMin.setText("00");

        showSecond.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        showSecond.setText("00");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(316, 316, 316)
                .addComponent(jLabel3)
                .addGap(46, 46, 46)
                .addComponent(showDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 255, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addGap(52, 52, 52)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(showMin)
                        .addGap(18, 18, 18)
                        .addComponent(showSecond)))
                .addGap(93, 93, 93))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(showSecond)
                                        .addComponent(showMin))
                                    .addComponent(jLabel6)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(showDate))))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 110));

        jPanel3.setBackground(new java.awt.Color(102, 255, 51));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Roll Number:");

        showRollNo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        showRollNo.setText("1999");

        showTotalQuestion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        showTotalQuestion.setText("10");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setText("Name: ");

        showName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        showName.setText("Sakil");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setText("Question Number:");

        showQNo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        showQNo.setText("00");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setText("Total Question:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel18.setText("Your Marks:");

        showMarks.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        showMarks.setText("00");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel13)
                            .addComponent(jLabel10))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(showName)
                            .addComponent(showTotalQuestion)
                            .addComponent(showRollNo)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(showMarks)
                            .addComponent(showQNo))))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(showRollNo))
                .addGap(86, 86, 86)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(showName))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(showTotalQuestion)
                    .addComponent(jLabel17))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(showQNo))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(showMarks))
                .addContainerGap(373, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 300, 660));

        showQuestion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        showQuestion.setText("Question Demo");
        jPanel1.add(showQuestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, -1, -1));

        radioOption2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        radioOption2.setText("jRadioButton1");
        radioOption2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioOption2ActionPerformed(evt);
            }
        });
        jPanel1.add(radioOption2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, -1, -1));

        radioOption4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        radioOption4.setText("jRadioButton1");
        radioOption4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioOption4ActionPerformed(evt);
            }
        });
        jPanel1.add(radioOption4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 380, -1, -1));

        radioOption3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        radioOption3.setText("jRadioButton1");
        radioOption3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioOption3ActionPerformed(evt);
            }
        });
        jPanel1.add(radioOption3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 310, -1, -1));

        radioOption1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        radioOption1.setText("jRadioButton1");
        radioOption1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioOption1ActionPerformed(evt);
            }
        });
        jPanel1.add(radioOption1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 190, -1, -1));

        nextBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        nextBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home/Next.png"))); // NOI18N
        nextBtn.setText("Next");
        nextBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextBtnActionPerformed(evt);
            }
        });
        jPanel1.add(nextBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 530, -1, -1));

        submitBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        submitBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home/save.png"))); // NOI18N
        submitBtn.setText("Submit");
        submitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBtnActionPerformed(evt);
            }
        });
        jPanel1.add(submitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 530, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nextBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextBtnActionPerformed
        answerCheck();
        question();
    }//GEN-LAST:event_nextBtnActionPerformed

    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBtnActionPerformed
        // TODO add your handling code here:
        int a=JOptionPane.showConfirmDialog(null, "Do you really want to Submit","Select",JOptionPane.YES_NO_OPTION);
        if(a==0){
            answerCheck();
            submit();
        }
    }//GEN-LAST:event_submitBtnActionPerformed

    private void radioOption1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioOption1ActionPerformed
        // TODO add your handling code here:
        if(radioOption1.isSelected()){
            radioOption2.setSelected(false);
            radioOption3.setSelected(false);
            radioOption4.setSelected(false);
            
        }
    }//GEN-LAST:event_radioOption1ActionPerformed

    private void radioOption2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioOption2ActionPerformed
        // TODO add your handling code here:
        if(radioOption2.isSelected()){
            radioOption1.setSelected(false);
            radioOption3.setSelected(false);
            radioOption4.setSelected(false);
            
        }
    }//GEN-LAST:event_radioOption2ActionPerformed

    private void radioOption3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioOption3ActionPerformed
        // TODO add your handling code here:
        if(radioOption3.isSelected()){
            radioOption2.setSelected(false);
            radioOption1.setSelected(false);
            radioOption4.setSelected(false);
            
        }
    }//GEN-LAST:event_radioOption3ActionPerformed

    private void radioOption4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioOption4ActionPerformed
        // TODO add your handling code here:
        if(radioOption4.isSelected()){
            radioOption2.setSelected(false);
            radioOption3.setSelected(false);
            radioOption1.setSelected(false);
            
        }
    }//GEN-LAST:event_radioOption4ActionPerformed

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
            java.util.logging.Logger.getLogger(quizExamStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(quizExamStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(quizExamStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(quizExamStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new quizExamStudent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton nextBtn;
    private javax.swing.JRadioButton radioOption1;
    private javax.swing.JRadioButton radioOption2;
    private javax.swing.JRadioButton radioOption3;
    private javax.swing.JRadioButton radioOption4;
    private javax.swing.JLabel showDate;
    private javax.swing.JLabel showMarks;
    private javax.swing.JLabel showMin;
    private javax.swing.JLabel showName;
    private javax.swing.JLabel showQNo;
    private javax.swing.JLabel showQuestion;
    private javax.swing.JLabel showRollNo;
    private javax.swing.JLabel showSecond;
    private javax.swing.JLabel showTotalQuestion;
    private javax.swing.JButton submitBtn;
    // End of variables declaration//GEN-END:variables
}

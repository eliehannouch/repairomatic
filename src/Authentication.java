import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement; 
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.UIManager;
import javax.swing.JOptionPane;
  
public class Authentication extends javax.swing.JFrame{
    
   Connection conn;
   PreparedStatement pst;                       // is a class used to execute SQL queries by using the JDBC package
   ResultSet rs;                               // is a object that contains the result of executing an SQL query
   boolean employee, forgot,loading = false;  // used in the control function 
   private static  String Employeename;
    public Authentication() {
        super("Authentication");
        initComponents();
        conn = connectDatabase.ConnectDb(); // connecting to the database
     
    }
    public static String getEmployeename() {
        return Employeename;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        login = new javax.swing.JButton();
        forgotPassword = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        PasswordVisibility = new javax.swing.JLabel();
        BACK_ = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Employee ID");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Password");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setText("Login");

        login.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/login.png"))); // NOI18N
        login.setText("Login");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });

        forgotPassword.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        forgotPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/forgot (2).png"))); // NOI18N
        forgotPassword.setText("Forgot Password");
        forgotPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forgotPasswordActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Security-Password-2-icon.png"))); // NOI18N

        PasswordVisibility.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Eye-2-icon-1.png"))); // NOI18N
        PasswordVisibility.setToolTipText("SHOW");
        PasswordVisibility.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PasswordVisibilityMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                PasswordVisibilityMouseReleased(evt);
            }
        });

        BACK_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rsz_1repair.png"))); // NOI18N
        BACK_.setToolTipText("Exit");
        BACK_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BACK_MouseClicked(evt);
            }
        });

        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(login)
                                .addGap(26, 26, 26)
                                .addComponent(forgotPassword))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                                    .addComponent(jPasswordField1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(PasswordVisibility, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(BACK_)
                        .addGap(127, 127, 127)
                        .addComponent(jLabel3)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(BACK_))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel3)))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(login)
                            .addComponent(forgotPassword)))
                    .addComponent(PasswordVisibility, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(462, 371));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        loading = true;
        LoginHandler();
    }//GEN-LAST:event_loginActionPerformed

    private void forgotPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forgotPasswordActionPerformed
        // TODO add your handling code here:
       forgot = true;
       control();
    }//GEN-LAST:event_forgotPasswordActionPerformed

    private void BACK_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BACK_MouseClicked
        // TODO add your handling code here:
        setVisible(false);
        Welcome w = new Welcome();
        w.setVisible(true);
    }//GEN-LAST:event_BACK_MouseClicked

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    private void PasswordVisibilityMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PasswordVisibilityMousePressed
        // TODO add your handling code here:
        jPasswordField1.setEchoChar((char)0);
    }//GEN-LAST:event_PasswordVisibilityMousePressed

    private void PasswordVisibilityMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PasswordVisibilityMouseReleased
        // TODO add your handling code here:
        jPasswordField1.setFont(new Font(Font.DIALOG_INPUT,Font.PLAIN,11));
        jPasswordField1.setEchoChar('\u25cf');
    }//GEN-LAST:event_PasswordVisibilityMouseReleased
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
             /*   if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }*/
              UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Authentication().setVisible(true);
            }
        });
    }

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BACK_;
    private javax.swing.JLabel PasswordVisibility;
    private javax.swing.JButton forgotPassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton login;
    // End of variables declaration//GEN-END:variables
   
     
    public void LoginHandler(){
        String sql="select * from Employee where EmployeeID=? and Password=?";
        try{
            
            pst = conn.prepareStatement(sql);      
            pst.setString(1,  jTextField1.getText());  // to get the user Acc Number input
            pst.setString(2,  jPasswordField1.getText());  // to get the user Pass input 
            rs = pst.executeQuery(); // method used to execute statement that returns tabular data (example select)
            if(rs.next()){           // rs is not null
                control();
                Employeename=rs.getString(2);
                rs.close();
                pst.close();
            }
            else{
                JOptionPane.showMessageDialog(null,"Incorrect Credential");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        } finally { 
            try{
                rs.close();
                pst.close();
            } catch(Exception e){
                
            }
        }
    }
    
   
    void control() {
        ArrayList<Object> a = new ArrayList<>();
        forgotpassword f = new forgotpassword();
        Loading o =null;
        a.add(f);
        a.add(o);
        for (int i = 0; i < a.size(); i++) {
            if (a.contains(f) && forgot == true) {
                setVisible(false);
                f.setVisible(true);
            } 
            else if (a.contains(o) && loading == true) {
                setVisible(false);
                o = new Loading();
                o.setUpLoading();
                o.setVisible(true);
            }
        }
    }

}

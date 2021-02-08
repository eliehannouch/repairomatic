
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Dashboard extends javax.swing.JFrame {
    public int month, year, day;
    public Dashboard() {
        super("DashBoard");
        initComponents();
        Calendar();
        Welcome();
        hover();
    }

    public void Welcome() {
        employeeName.setText("Welcome " + Authentication.getEmployeename());
    }

    public void Calendar() {
        Calendar cal = new GregorianCalendar();
        month = cal.get(Calendar.MONTH);
        year = cal.get(Calendar.YEAR);
        day = cal.get(Calendar.DAY_OF_MONTH);
        date.setText(+day + "-" + (month + 1) + "-" + year);
    }
    
    public void hover() {
        addACase.setToolTipText("Add a Case");
        addNewCustomer3.setToolTipText("New Customer");
        bill.setToolTipText("Payment");
        search.setToolTipText("Search");
        waitingList.setToolTipText("Waiting List");
        completedTask.setToolTipText("Completed Cases");
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        addACase = new javax.swing.JButton();
        waitingList = new javax.swing.JButton();
        search = new javax.swing.JButton();
        addNewCustomer3 = new javax.swing.JButton();
        completedTask = new javax.swing.JButton();
        bill = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        employeeName = new javax.swing.JTextField();
        date = new javax.swing.JTextField();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Dashboard");

        addACase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add-file.png"))); // NOI18N
        addACase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addACaseActionPerformed(evt);
            }
        });

        waitingList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/waiting-list.png"))); // NOI18N
        waitingList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                waitingListActionPerformed(evt);
            }
        });

        search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/searchuser.png"))); // NOI18N
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        addNewCustomer3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/addcustomer.png"))); // NOI18N
        addNewCustomer3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewCustomer3ActionPerformed(evt);
            }
        });

        completedTask.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/completedtask.png"))); // NOI18N
        completedTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                completedTaskActionPerformed(evt);
            }
        });

        bill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bill.png"))); // NOI18N
        bill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                billActionPerformed(evt);
            }
        });

        logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout.png"))); // NOI18N
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        employeeName.setEditable(false);
        employeeName.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        employeeName.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        employeeName.setBorder(null);

        date.setEditable(false);
        date.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        date.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        date.setBorder(null);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(addNewCustomer3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(499, 499, 499))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(addACase, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(completedTask, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(89, 89, 89)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(waitingList, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(bill, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(82, 82, 82))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(employeeName, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(30, 30, 30)
                                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(employeeName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addComponent(waitingList, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addNewCustomer3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addACase, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(completedTask, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bill, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(84, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(736, 451));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void dateActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_dateActionPerformed
    }// GEN-LAST:event_dateActionPerformed

    private void employeeNameActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_employeeNameActionPerformed

    }// GEN-LAST:event_employeeNameActionPerformed

    private void addACaseActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_addACaseActionPerformed
        setVisible(false);
        addCase ob = new addCase();
        ob.setVisible(true);
    }// GEN-LAST:event_addACaseActionPerformed

    private void waitingListActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_waitingListActionPerformed
        setVisible(false);
        waitingList ob = new waitingList();
        ob.setVisible(true);
    }// GEN-LAST:event_waitingListActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_searchActionPerformed
        setVisible(false);
        searchCustomer ob = new searchCustomer();
        ob.setVisible(true);
    }// GEN-LAST:event_searchActionPerformed

    private void addNewCustomer3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_addNewCustomer3ActionPerformed
        setVisible(false);
        newCustomer ob = new newCustomer();
        ob.setVisible(true);
    }// GEN-LAST:event_addNewCustomer3ActionPerformed

    private void completedTaskActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_completedTaskActionPerformed
        setVisible(false);
        CompletedCases ob = new CompletedCases();
        ob.setVisible(true);
    }// GEN-LAST:event_completedTaskActionPerformed

    private void billActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_billActionPerformed
        setVisible(false);
        payment ob = new payment();
        ob.setVisible(true);
    }// GEN-LAST:event_billActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_logoutActionPerformed
        int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to log out?", " Logout Confirmation", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            setVisible(false);
            Authentication ob = new Authentication();
            ob.setVisible(true);
        }
    }// GEN-LAST:event_logoutActionPerformed

    
    public static void main(String args[]) {
      
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
               
                UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addACase;
    private javax.swing.JButton addNewCustomer3;
    private javax.swing.JButton bill;
    private javax.swing.JButton completedTask;
    private javax.swing.JTextField date;
    private javax.swing.JTextField employeeName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JButton logout;
    private javax.swing.JButton search;
    private javax.swing.JButton waitingList;
    // End of variables declaration//GEN-END:variables

}

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

class CompletedTask {

    private String ID;
    private String name;
    private String phoneNumber;
    private String cases;
    private String payment;

    public CompletedTask() {
        ID = null;
        name = null;
        payment = null;
        cases = null;
    }

    public CompletedTask(String ID, String name, String phoneNumber, String cases, String payment) {
        this.ID = ID;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.cases = cases;
        this.payment = payment;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCases() {
        return cases;
    }

    public String getPayment() {
        return payment;
    }

}

class CompletedNode {

    CompletedTask p;
    CompletedNode next;

    CompletedNode() {
        p = null;
        next = null;

    }

    CompletedNode(CompletedTask p) {
        this.p = p;
        this.next = null;
    }

    public CompletedTask getP() {
        return p;
    }

    public CompletedNode getNext() {
        return next;
    }

    public void setP(CompletedTask p) {
        this.p = p;
    }

    public void setNext(CompletedNode next) {
        this.next = next;
    }

}

class CompletedStack {

    CompletedNode top;
    int currentSize = 0;

    int getSize() {
        return currentSize;
    }

    boolean isEmpty() {
        if (top == null) {
            return true;
        } else {
            return false;
        }
    }

    void push(CompletedTask p) {
        CompletedNode stackNode = new CompletedNode(p);
        if (isEmpty()) {
            top = stackNode;
        } else {
            CompletedNode temp = top;
            top = stackNode;
            stackNode.setNext(temp);
        }
        currentSize++;
    }

    CompletedNode get() {
        if (isEmpty()) {
            System.out.println("The Stack is underflow");
            return null;
        } else {
            return top;
        }
    }

}

public class CompletedCases extends javax.swing.JFrame {
    Connection conn;
    ResultSet rs;
    PreparedStatement pst;
    public CompletedCases() {
        super("CompletedCases");
        initComponents();
        conn = connectDatabase.ConnectDb();
        viewCompletedCases();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        s = new javax.swing.JTextField();
        search = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        goBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 28)); // NOI18N
        jLabel1.setText("Completed Cases");

        s.setForeground(new java.awt.Color(153, 153, 153));
        s.setText("Please Search By ID");
        s.setToolTipText("");
        s.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                sFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                sFocusLost(evt);
            }
        });
        s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sActionPerformed(evt);
            }
        });

        search.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.gif"))); // NOI18N
        search.setText("Search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Phone number", "Case", "Payment"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(50);
            jTable1.getColumnModel().getColumn(1).setMinWidth(100);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
        }

        goBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back24.png"))); // NOI18N
        goBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(s, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(search))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(goBack, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(195, 195, 195)
                                .addComponent(jLabel1)))
                        .addGap(0, 265, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(goBack, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(s, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(758, 407));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_sActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
       searchInCompletedCases();
    }//GEN-LAST:event_searchActionPerformed

    private void goBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBackActionPerformed
        back();
    }//GEN-LAST:event_goBackActionPerformed

    private void sFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sFocusGained
        focusGained();

    }//GEN-LAST:event_sFocusGained

    private void sFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sFocusLost
        focusLost();
    }//GEN-LAST:event_sFocusLost

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
               /* if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }*/
                UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CompletedCases.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CompletedCases.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CompletedCases.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CompletedCases.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CompletedCases().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton goBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField s;
    private javax.swing.JButton search;
    // End of variables declaration//GEN-END:variables

    //----------------------------------------------- Design  ------------------------------------------------------ //
    void focusGained() {
        if (s.getText().equals("Please Search By ID")) {
            s.setText("");
            s.setForeground(Color.BLACK);
        }
    }

    void focusLost() {
        if (s.getText().isEmpty()) {
            s.setForeground(Color.GRAY);
            s.setText("Please Search By ID");
        }
    }
        //----------------------------------------------- End Design  ------------------------------------------------------ //

    CompletedStack cs = new CompletedStack();
    DefaultTableModel t;

    void viewCompletedCases() {  // call in constructor

        String sql = "select * from CompletedTask";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {

                CompletedTask wi = new CompletedTask(rs.getString("ID"), rs.getString("Name"), rs.getString("PhoneNumber"), rs.getString("CaseDetails"), rs.getString("Payment"));
                cs.push(wi);

                // String array for storing data from queue into jTable
                String[] tData = {cs.get().getP().getID(), cs.get().getP().getName(), cs.get().getP().getPhoneNumber(), cs.get().getP().getCases(), cs.get().getP().getPayment()};
                t = (DefaultTableModel) jTable1.getModel();

                // add string array into jTable table
                t.addRow(tData);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {
            }
        }
    }

    void searchInCompletedCases() {
        t.setRowCount(0);
        String sql = "select * from CompletedTask where ID=?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, s.getText());
            rs = pst.executeQuery();
            while (rs.next()) {

                String id = rs.getString("ID");
                String Name = rs.getString("Name");
                String Phone = rs.getString("PhoneNumber");
                String cases = rs.getString("CaseDetails");
                String pay = rs.getString("Payment");

                // String array for storing data into jTable
                String[] tData = {id, Name, Phone, cases, pay};
                t = (DefaultTableModel) jTable1.getModel();

                // add string array into jtable table
                t.addRow(tData);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {

            }
        }
    }
    
    void back() {
        setVisible(false);
        Dashboard ob = new Dashboard();
        ob.setVisible(true);
        
    }

}

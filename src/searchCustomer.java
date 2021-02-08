import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
 
public class searchCustomer extends javax.swing.JFrame {
    Connection conn;
    ResultSet rs;
    PreparedStatement pst;
    public searchCustomer() {
        super("searchCustomer");
        initComponents();
        conn = connectDatabase.ConnectDb();
        view(); 
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Search_JTable = new javax.swing.JTable();
        ID = new javax.swing.JRadioButton();
        name = new javax.swing.JRadioButton();
        goBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("Search");

        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Search by:");

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.gif"))); // NOI18N
        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Search_JTable.setAutoCreateRowSorter(true);
        Search_JTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "First Name", "Last Name", "Email", "Phone Number", "Address"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Search_JTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(Search_JTable);
        if (Search_JTable.getColumnModel().getColumnCount() > 0) {
            Search_JTable.getColumnModel().getColumn(1).setMinWidth(100);
            Search_JTable.getColumnModel().getColumn(2).setMinWidth(100);
            Search_JTable.getColumnModel().getColumn(3).setMinWidth(200);
            Search_JTable.getColumnModel().getColumn(4).setMinWidth(100);
            Search_JTable.getColumnModel().getColumn(5).setMinWidth(100);
        }

        buttonGroup1.add(ID);
        ID.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        ID.setText("ID");

        buttonGroup1.add(name);
        name.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        name.setText("First Name");
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });

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
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 789, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(goBack, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(273, 273, 273)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(40, 40, 40)
                        .addComponent(ID)
                        .addGap(18, 18, 18)
                        .addComponent(name)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(goBack, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ID)
                    .addComponent(name))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(43, 43, 43)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(825, 403));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_searchActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        // TODO add your handling code here:
         search();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void goBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBackActionPerformed
        back();
    }//GEN-LAST:event_goBackActionPerformed

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
              /*  if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;}*/
                UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
                
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(searchCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(searchCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(searchCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(searchCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new searchCustomer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton ID;
    private javax.swing.JTable Search_JTable;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton goBack;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton name;
    private javax.swing.JTextField search;
    // End of variables declaration//GEN-END:variables

    DefaultTableModel t;
    
    void view(){ // call in constructor
        
         String sql="select * from Customer";
        try {
             pst = conn.prepareStatement(sql); 
             rs = pst.executeQuery();
           while(rs.next()){
               String id = rs.getString("CustomerID");
               String FN = rs.getString("FirstName");
               String LN = rs.getString("LastName");
               String Email = rs.getString("Email");
               String Phone = rs.getString("Phone");
               String Address = rs.getString("Address");
               
               // String array for storing data into jTable
               String[] tData = {id,FN,LN,Email,Phone,Address};
               t = (DefaultTableModel) Search_JTable.getModel();
               
               // add string array into jtable table
               t.addRow(tData);  
           } 
        }catch(Exception e){
              JOptionPane.showMessageDialog(null,e);
    }   finally{
            try{
                rs.close();
                pst.close();
            }catch(Exception e){
                
            }
        }
    }
    
    void search() {
        
        if(ID.isSelected()== false && name.isSelected()==false){
            
            JOptionPane.showMessageDialog(null, "Choose one of the options before searching.");
            
        }else{

        t.setRowCount(0);

        if (ID.isSelected()) {

            String sql = "select * from Customer where CustomerID=?";
            try {
                pst = conn.prepareStatement(sql);
                pst.setString(1, search.getText());
                rs = pst.executeQuery();
                while (rs.next()) {

                    String id = rs.getString("CustomerID");
                    String FN = rs.getString("FirstName");
                    String LN = rs.getString("LastName");
                    String Email = rs.getString("Email");
                    String Phone = rs.getString("Phone");
                    String Address = rs.getString("Address");

                    // String array for storing data into jTable
                    String[] tData = {id, FN, LN, Email, Phone, Address};
                    t = (DefaultTableModel) Search_JTable.getModel();

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
        if (name.isSelected()) {

            String sql = "select * from Customer where FirstName=?";
            try {
                pst = conn.prepareStatement(sql);
                pst.setString(1, search.getText());
                rs = pst.executeQuery();
                while (rs.next()) {

                    String id = rs.getString("CustomerID");
                    String FN = rs.getString("FirstName");
                    String LN = rs.getString("LastName");
                    String Email = rs.getString("Email");
                    String Phone = rs.getString("Phone");
                    String Address = rs.getString("Address");

                    // String array for storing data into jTable
                     Vector td = new Vector();
                     td.add(id);
                     td.add(FN);
                     td.add(LN);
                     td.add(Email);
                     td.add(Phone);
                     td.add(Address);
                    t = (DefaultTableModel) Search_JTable.getModel();

                    // add string array into jtable table
                    t.addRow(td);

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

    }
    }

    void back() {
        setVisible(false);
        Dashboard ob = new Dashboard();
        ob.setVisible(true);
    }

}

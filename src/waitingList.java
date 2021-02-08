import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;


class waitingInfo{
    private String ID;
    private String FullName;
    private String PhoneNumber;
    private String Case;
    private String Payment;
    private boolean Done;

    public waitingInfo(String ID, String FullName, String PhoneNumber, String Case, String Payment, boolean Done) {
        this.ID = ID;
        this.FullName = FullName;
        this.PhoneNumber = PhoneNumber;
        this.Case = Case;
        this.Payment = Payment;
        this.Done = Done;
    }
    
    public waitingInfo(String ID, String FullName, String PhoneNumber, String Case, String Payment) {
        this.ID = ID;
        this.FullName = FullName;
        this.PhoneNumber = PhoneNumber;
        this.Case = Case;
        this.Payment = Payment;
    }

    public waitingInfo() {
        ID=null;
        FullName=null;
        PhoneNumber=null;
        Case=null;
        Payment=null;
        Done=false;
    }

    public String getID() {
        return ID;
    }

    public String getFullName() {
        return FullName;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getCase() {
        return Case;
    }

    public String getPayment() {
        return Payment;
    }

    public boolean isDone() {
        return Done;
    }
    
}

class waitingNode{
    
    waitingNode next;
    waitingInfo W;

    public waitingNode() {
        next=null;
        W=null;
    }
    
    public waitingNode(waitingInfo W){
        this.W=W;
        next=null;
    }

    public waitingNode getNext() {
        return next;
    }

    public waitingInfo getW() {
        return W;
    }

    public void setNext(waitingNode next) {
        this.next = next;
    }

    public void setW(waitingInfo W) {
        this.W = W;
    }
    
}

class Queue {

    waitingNode front;
    waitingNode rear;
    int currentSize;

    Queue() {
        front = null;
        rear = null;
        currentSize = 0;
    }

    int getSize() {
        return currentSize;
    }

    boolean isEmpty() {
        return front == null;
    }

    void enQueue(waitingInfo data) {
        waitingNode node = new waitingNode(data);
        if (isEmpty()) {
            front = node;
            rear = node;
            currentSize++;
            return;
        }
        rear.setNext(node);
        rear = node;
        currentSize++;
    }
    
     void deQueue(waitingInfo data) {
        waitingNode node = new waitingNode(data);
        if (isEmpty()) {
            front = node;
            rear = node;
            currentSize++;
            return;
        }
        rear.setNext(node);
        rear = node;
        currentSize++;
    }

    waitingNode get() {
        if (isEmpty()) {
            System.out.println("EMPTY");
            return null;
        } else {
            return rear;
        }
    }
}


public class waitingList extends javax.swing.JFrame {
    Connection conn;
    ResultSet rs;
    PreparedStatement pst;
    PreparedStatement pstD;
    public static final String ACCOUNT_SID = "AC7b1892d1b0e07b777b456195ba45b920";
    public static final String AUTH_TOKEN  = "c258d6d11645f0228bfcfa1f509501e2";
    
    public waitingList() {
        super("waitingList");
        initComponents();
        conn = connectDatabase.ConnectDb();
        view();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("Waiting List");

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Full Name", "Phone Number", "Case", "Payment", "Done"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(100);
            jTable1.getColumnModel().getColumn(1).setMinWidth(100);
            jTable1.getColumnModel().getColumn(2).setMinWidth(100);
            jTable1.getColumnModel().getColumn(3).setMinWidth(300);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setMinWidth(25);
        }

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/floppy-disk.png"))); // NOI18N
        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back24.png"))); // NOI18N
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 919, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(back)
                        .addGap(306, 306, 306)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(40, 40, 40)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(955, 428));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        
        if (check()== true && save == false) {

            int reply = JOptionPane.showConfirmDialog(null, "Do you want to save changes ?", " Save Confirmation",
                    JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                removeThenAdd();
                setVisible(false);
                Dashboard ob = new Dashboard();
                ob.setVisible(true);
            } else {
                setVisible(false);
                Dashboard ob = new Dashboard();
                ob.setVisible(true);
            }
            
        } else {
            setVisible(false);
            Dashboard ob = new Dashboard();
            ob.setVisible(true);
        }
    }//GEN-LAST:event_backActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        removeThenAdd();
    }//GEN-LAST:event_jButton1ActionPerformed

    
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
                    break;
                }*/
              UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(waitingList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(waitingList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(waitingList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(waitingList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new waitingList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    DefaultTableModel t;
    Queue q = new Queue();
    Queue p= new Queue();
    
    void view(){
        
        String sql="select * from Temp";
        try {
             pst = conn.prepareStatement(sql); 
             rs = pst.executeQuery();
           while(rs.next()){
               
               waitingInfo wi = new waitingInfo(rs.getString("ID"),rs.getString("Name"),rs.getString("PhoneNumber1"),rs.getString("CaseD"),rs.getString("Payment"));
               q.enQueue(wi);
               
               // String array for storing data from queue into jTable
               String[] tData = {q.get().getW().getID(),q.get().getW().getFullName(),q.get().getW().getPhoneNumber(),q.get().getW().getCase(),q.get().getW().getPayment()};
               t = (DefaultTableModel) jTable1.getModel();
               
               // add string array into jTable table
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
    
    boolean save = false;
    
    boolean check() {
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            Boolean isChecked = jTable1.isCellSelected(i, 5);
            if (isChecked) {
                return true;
            }
        }
        return false;
    }
  
    void removeThenAdd() {
        t = (DefaultTableModel) jTable1.getModel();
        for (int i = 0; i < t.getRowCount(); i++) {
            Boolean isChecked = jTable1.isCellSelected(i, 5);
            if (isChecked) {
                waitingInfo wi = new waitingInfo(jTable1.getValueAt(i, 0).toString(), jTable1.getValueAt(i, 1).toString(), jTable1.getValueAt(i, 2).toString(), jTable1.getValueAt(i, 3).toString(), jTable1.getValueAt(i, 4).toString());
                String id = jTable1.getValueAt(i, 0).toString();
                p.deQueue(wi);
                String sql = "insert into CompletedTask(ID,Name,PhoneNumber,CaseDetails,Payment) values (?,?,?,?,?)";
                String sqlD = "delete from Temp where ID=? ";
                try {
                    pst = conn.prepareStatement(sql);
                    pst.setString(1, p.get().getW().getID());
                    pst.setString(2, p.get().getW().getFullName());
                    pst.setString(3, p.get().getW().getPhoneNumber());
                    pst.setString(4, p.get().getW().getCase());
                    pst.setString(5, p.get().getW().getPayment());
                    pst.execute();

                    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
                    Message.creator(new com.twilio.type.PhoneNumber("+96171838034"),new com.twilio.type.PhoneNumber("+12517650730"),
                            "\nHello " + jTable1.getValueAt(i, 1).toString() + ", your device is fully repaired.\nKindly pass by to recover it. \nThank you for choosing Repairomatic!").create();
                    
                    t.removeRow(i);
                    pstD = conn.prepareStatement(sqlD);
                    pstD.setString(1, id);
                    pstD.execute();
                    save = true;

                    JOptionPane.showMessageDialog(null, "Saved");
                } catch (HeadlessException | SQLException e) {
                    JOptionPane.showMessageDialog(null, e);
                }

            }
        }
    }


}

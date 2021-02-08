import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

class PaymentInfo {

    private String ID;
    private String name;
    private String payment;
    private String service;
    private String tax;
    private String total;

    public PaymentInfo() {
        ID = null;
        name = null;
        payment = null;
        service = null;
        tax = null;
        total = null;
    }

    public PaymentInfo(String ID, String name, String payment, String service, String tax, String total) {
        this.ID = ID;
        this.name = name;
        this.payment = payment;
        this.service = service;
        this.tax = tax;
        this.total = total;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getPayment() {
        return payment;
    }

    public String getService() {
        return service;
    }

    public String getTax() {
        return tax;
    }

    public String getTotal() {
        return total;
    }

}

class paymentNode {

    PaymentInfo p;
    paymentNode next;

    paymentNode() {
        p = null;
        next = null;

    }

    paymentNode(PaymentInfo p) {
        this.p = p;
        this.next = null;
    }

    public PaymentInfo getP() {
        return p;
    }

    public paymentNode getNext() {
        return next;
    }

    public void setP(PaymentInfo p) {
        this.p = p;
    }

    public void setNext(paymentNode next) {
        this.next = next;
    }

}
 class paymentStack {
    paymentNode top;
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

    void push(PaymentInfo p) {
        paymentNode stackNode = new paymentNode(p);
        if (isEmpty()) {
            top = stackNode;
        } else {
            paymentNode temp = top;  
            top = stackNode;
            stackNode.setNext(temp);
        }
        currentSize++;
    }
   paymentNode get() {
        if (isEmpty()) {
            System.out.println("The Stack is underflow");
            return null;
        } else {
            return top;
        }
    }

 }

public class payment extends javax.swing.JFrame {

    Connection conn;
    ResultSet rs;
    PreparedStatement pst;
    paymentStack ps= new paymentStack();
    

    public payment() {
        super("Payment");
        initComponents();
        conn = connectDatabase.ConnectDb();
        Calendar();
    }
    public int month, year, day;

    public void Calendar() {
        Calendar cal = new GregorianCalendar();   // new calendar object from the calendar package
        month = cal.get(Calendar.MONTH);     //  get the system month
        year = cal.get(Calendar.YEAR);      //  get the system year
        day = cal.get(Calendar.DAY_OF_MONTH); // get the current day 

    }
     

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        search = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        payment = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tax = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        service = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        total = new javax.swing.JTextField();
        compute = new javax.swing.JButton();
        print = new javax.swing.JButton();
        back = new javax.swing.JButton();

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Name");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Payment");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("ID");

        search.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.gif"))); // NOI18N
        search.setText("Search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Name");

        name.setEditable(false);
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Payment");

        payment.setEditable(false);
        payment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Service");

        tax.setEditable(false);
        tax.setText("11%");
        tax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taxActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Tax");

        service.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serviceActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("Total ");

        total.setEditable(false);
        total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalActionPerformed(evt);
            }
        });

        compute.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        compute.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/money (1).png"))); // NOI18N
        compute.setText("Compute");
        compute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                computeActionPerformed(evt);
            }
        });

        print.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/printer (1).png"))); // NOI18N
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(payment, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tax, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(service, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(search, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(compute, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(19, 19, 19))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(back))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(print, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(search))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(payment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(service, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(compute))
                .addGap(18, 18, 18)
                .addComponent(print)
                .addGap(41, 41, 41))
        );

        setSize(new java.awt.Dimension(446, 481));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void paymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paymentActionPerformed

    private void taxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_taxActionPerformed

    private void serviceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serviceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_serviceActionPerformed

    private void totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        Dashboard ob = new Dashboard();
        ob.setVisible(true);
    }//GEN-LAST:event_backActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
        Search();
    }//GEN-LAST:event_searchActionPerformed

    private void computeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_computeActionPerformed
        // TODO add your handling code here:
        compute();
    }//GEN-LAST:event_computeActionPerformed

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        // TODO add your handling code here:
         PrinterJob pj = PrinterJob.getPrinterJob();
        pj.setPrintable(new InvoicePrint(),getPageFormat(pj));
        try {
            pj.print();

        }
        catch (PrinterException ex) {
            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_printActionPerformed

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
            java.util.logging.Logger.getLogger(payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new payment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton compute;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField name;
    private javax.swing.JTextField payment;
    private javax.swing.JButton print;
    private javax.swing.JButton search;
    private javax.swing.JTextField service;
    private javax.swing.JTextField tax;
    private javax.swing.JTextField total;
    // End of variables declaration//GEN-END:variables
 public void Search(){
       
        String sql="select * from Cases where ID=?";
        try {
             pst = conn.prepareStatement(sql);
             pst.setString(1, id.getText());
             rs = pst.executeQuery();
           if(rs.next()){
               name.setText(rs.getString(2)); 
               payment.setText(rs.getString(6));
               rs.close();
               pst.close();  
           } 
           else{
               JOptionPane.showMessageDialog(null, "Invalid ID");  
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
    void compute() {

        try {
            String p = payment.getText();
            String s = service.getText();
            String t = tax.getText();
            int sumBeforeTax = Integer.parseInt(p) + Integer.parseInt(s); //service+payment
            double T = Math.floor(1.11 * sumBeforeTax); //with tax 
            String Total = String.valueOf(T) + "$";
            total.setText(Total);
            insertHandler();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    void insertHandler() {

        PaymentInfo pi = new PaymentInfo(id.getText(), name.getText(), payment.getText(), service.getText(), tax.getText(), total.getText());
        ps.push(pi);
        String sql = "insert into Payment(ID,Name,Payment,Service,Total) values (?,?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, ps.get().getP().getID());
            pst.setString(2, ps.get().getP().getName());
            pst.setString(3, ps.get().getP().getPayment());
            pst.setString(4, ps.get().getP().getService());
            pst.setString(5, ps.get().getP().getTotal());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Successfull");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
 
 
 
 
 
  // method to get the page format 
     public PageFormat getPageFormat(PrinterJob pj){
          PageFormat pf = pj.defaultPage();
          Paper paper = pf.getPaper();    

           double middleHeight =8.0;  
           double headerHeight = 2.0;                
           double footerHeight = 2.0;                  
           double width = convert_CM_To_PPI(8);                             //printer know only point per inch.default value is 72ppi
           double height = convert_CM_To_PPI(headerHeight+middleHeight+footerHeight); 
           paper.setSize(width, height);
           paper.setImageableArea(0,10,width,height - convert_CM_To_PPI(1));   //define boarder size after that print area width is about 180 points
            
           pf.setOrientation(PageFormat.PORTRAIT);           //select orientation portrait or landscape but for this time portrait
           pf.setPaper(paper);    
           return pf;
         }
     // method to convert CM to PPI
      protected static double convert_CM_To_PPI(double cm) {            
	        return toPPI(cm * 0.393600787);            
            }
 
      protected static double toPPI(double inch) {            
	        return inch * 72d;            
           }
      
      public class InvoicePrint implements Printable {
    
      public int print(Graphics graphics, PageFormat pageFormat,int pageIndex) throws PrinterException {    
       int result = NO_SUCH_PAGE;   
        ImageIcon icon=new ImageIcon("C:\\Users\\elieh\\OneDrive\\Documents\\NetBeansProjects\\Repair_Managment_System\\src\\images\\rsz_1repair.png"); 
       if (pageIndex == 0) {                    
        
            Graphics2D g2d = (Graphics2D) graphics;                  
            double width = pageFormat.getImageableWidth();                    
            g2d.translate((int) pageFormat.getImageableX(),(int) pageFormat.getImageableY()); 
          
            FontMetrics metrics=g2d.getFontMetrics(new Font("Arial",Font.BOLD,7));
            int idLength=metrics.stringWidth("000");
            int amtLength=metrics.stringWidth("000000");
            int qtyLength=metrics.stringWidth("00000");
            int priceLength=metrics.stringWidth("000000");
            int prodLength=(int)width - idLength - amtLength - qtyLength - priceLength-17;
            int productPosition = 0;
            int discountPosition= prodLength+5;
            int pricePosition = discountPosition +idLength+10;
            int qtyPosition=pricePosition + priceLength + 4;
            int amtPosition=qtyPosition + qtyLength;
                
        try{
            /*Draw Header*/
            int y=20;
            int yShift = 10;
            int headerRectHeight=15;
            int headerRectHeighta=40;
            
          // Get Jlabel 
                String pn1a=jLabel2.getText();
                String pn2a=jLabel5.getText();
                String pn3a=jLabel6.getText();
                String pn4a=jLabel7.getText();
                String pn5a=jLabel8.getText();
                String pn6a=jLabel9.getText();
                String pn7a ="Date";
          
                
         //get user input
                String pp1a=id.getText();
                String pp2a=name.getText();
                String pp3a=payment.getText();
                String pp4a=service.getText();
                String pp5a=tax.getText();
                String pp6a=total.getText();
                        
                
                g2d.setFont(new Font("Monospaced",Font.PLAIN,9));
                g2d.drawImage(icon.getImage(), 90, 5, 50, 50, rootPane);y+=yShift+30; //awal nb bya3tini el space from the left - tani nb space from above - talti la space men right - last one shi khasu bel height
                g2d.drawString("-------------------------------------",12,y);y+=yShift;
                g2d.drawString("        Repairomatic S. A. L.            ",12,y);y+=yShift;
                g2d.drawString("-------------------------------------",12,y);y+=headerRectHeight;
                g2d.drawString(" "+pn7a+"                     "+day+"-"+(month+1)+"-"+year,10,y);y+=yShift;
                g2d.drawString("-------------------------------------",12,y);y+=headerRectHeight;
                g2d.drawString(" UserInfo                      Desc.     ",10,y);y+=yShift;
                g2d.drawString("-------------------------------------",10,y);y+=headerRectHeight;
                g2d.drawString(" "+pn1a+"                         "+pp1a+"  ",10,y);y+=yShift;
                g2d.drawString(" "+pn2a+"                  "+pp2a+"  ",10,y);y+=yShift;
                g2d.drawString(" "+pn3a+"                        "+pp3a+"$  ",10,y);y+=yShift;
                g2d.drawString(" "+pn4a+"                         "+pp4a+"$  ",10,y);y+=yShift;
                g2d.drawString(" "+pn5a+"                             "+pp5a+"  ",10,y);y+=yShift;
                g2d.drawString(" "+pn6a+"                       "+pp6a+"  ",10,y);y+=yShift;
                g2d.drawString("                                     ",12,y);y+=yShift;
                g2d.drawString("*************************************",10,y);y+=yShift;
                g2d.drawString(" THANK YOU FOR CHOOSING Repairomatic   ",10,y);y+=yShift;
                g2d.drawString("*************************************",10,y);y+=yShift;
 
   
    }
     catch(Exception r){
         r.printStackTrace();
     }
        result = PAGE_EXISTS;   
      }    
        return result;    
      }
   }
    
 
 
 
    
   

}

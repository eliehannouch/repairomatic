
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

class Employee {
    private String EmployeeID;
    private String Password;
    private String Gender;
    private String Address;
    private String Education;
    private String Name;
    private String DOB;
    private String Nationality;
    private String MobileNumber;
    private String State;
    private String EmpSalary;

    public Employee() {
        EmployeeID = null;
        Password = null;
        Gender = null;
        Address = null;
        Education = null;
        Name = null;
        DOB = null;
        Nationality = null;
        MobileNumber = null;
        State = null;
        EmpSalary = null;
    }
    
    public Employee(String EmployeeID, String Password, String Gender, String Address, String Education, String Name, String DOB, String Nationality, String MobileNumber, String State,String EmpSalary) {
        this.EmployeeID = EmployeeID;
        this.Password = Password;
        this.Gender = Gender;
        this.Address = Address;
        this.Education = Education;
        this.Name = Name;
        this.DOB = DOB;
        this.Nationality = Nationality;
        this.MobileNumber = MobileNumber;
        this.State = State;
        this.EmpSalary = EmpSalary;
    }

    public String getEmployeeID() {
        return EmployeeID;
    }

    public String getPassword() {
        return Password;
    }

    public String getGender() {
        return Gender;
    }

    public String getAddress() {
        return Address;
    }

    public String getEducation() {
        return Education;
    }

    public String getName() {
        return Name;
    }

    public String getDOB() {
        return DOB;
    }

    public String getNationality() {
        return Nationality;
    }

    public String getMobileNumber() {
        return MobileNumber;
    }

    public String getState() {
        return State;
    }

    public String getEmpSalary() {
        return EmpSalary;
    }
    
}

class Node {

    Node next;
    Employee e;

    Node() {
        this.e = null;
        this.next = null;
    }

    public Node(Employee e) {
        this.next = null;
        this.e = e;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Employee getE() {
        return e;
    }

    public void setE(Employee e) {
        this.e = e;
    }
}

class List {

    Node head;
    Node tail;
    int size;

    public List() {
        head = tail = null;
        size = 0;
    }

    int getSize() {
        return size;
    }

    boolean isEmpty() {
        return head == null;
    }

    void addEmployee(Employee e) {
        Node n = new Node(e);
        if (isEmpty()) {
            head = n;
            tail = head;
        } else {
            tail.setNext(n);
            tail = n;
        }
        size++;
    }

    Node get() {
        if (isEmpty()) {
            System.out.println("EMPTY LIST");
            System.exit(1); // equal to return null
        }
        return tail;
    }
}

public class EmployeeAccount extends javax.swing.JFrame {

    Connection conn;
    PreparedStatement pst;   // is a class used to execute SQL queries by using the JDBC package
    ResultSet rs;
    List emp = new List();  // this singly list is used in the create newemployee handler 
    
    public EmployeeAccount() {
        super("New Account");
        initComponents();
        RandomEmployeeID();
        conn = connectDatabase.ConnectDb();
    }

    public void clear() {
        
        password.setText("");
        address.setText("");
        name.setText("");
        nationality.setText("");
        mobileNb.setText("");
        buttonGroup1.clearSelection();
        educationLevel.setSelectedIndex(0);
        state.setSelectedIndex(0);
        dob.setCalendar(null);
        salary.setText("");
    }

    public void RandomEmployeeID() {
        Random ra = new Random();
        employeeID.setText("" + ra.nextInt(10000000 + 1));
    }

  
    public void createAccountHandler() {
        String d = ((JTextField) dob.getDateEditor().getUiComponent()).getText();  // handle the date of birth
        String edu = (String) educationLevel.getSelectedItem();  // handle the selected education level
        male.setActionCommand("Male");
        female.setActionCommand("Female");
        String g = buttonGroup1.getSelection().getActionCommand();  // handle the selected gender
        String s = (String) state.getSelectedItem();  // handle the selected state

        Employee en = new Employee(employeeID.getText(), password.getText(), g, address.getText(), edu, name.getText(), d, nationality.getText(), mobileNb.getText(), s,salary.getText());
        emp.addEmployee(en);  // insert the new employee 
        String sql = "insert into Employee(EmployeeID,Name,DOB,Password,EducationLevel,Nationality,State,Address,Gender,Mobile,Salary) values (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, emp.get().getE().getEmployeeID());
            pst.setString(2, emp.get().getE().getName());
            pst.setString(3, emp.get().getE().getDOB());
            pst.setString(4, emp.get().getE().getPassword());
            pst.setString(5, emp.get().getE().getEducation());
            pst.setString(6, emp.get().getE().getNationality());
            pst.setString(7, emp.get().getE().getState());
            pst.setString(8, emp.get().getE().getAddress());
            pst.setString(9, emp.get().getE().getGender());
            pst.setString(10,emp.get().getE().getMobileNumber());
            pst.setString(11,emp.get().getE().getEmpSalary());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Account has been Created");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void goBack() {
        setVisible(false);
        AdminPanel A = new AdminPanel();
        A.setVisible(true);

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        employeeID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        password = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        male = new javax.swing.JRadioButton();
        female = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        address = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        educationLevel = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        dob = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        nationality = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        mobileNb = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        state = new javax.swing.JComboBox<>();
        createAccount = new javax.swing.JButton();
        back = new javax.swing.JButton();
        clearForm = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        salary = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("New Employee");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel2.setText("Employee ID");

        employeeID.setEditable(false);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel3.setText("Password");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel4.setText("Gender");

        buttonGroup1.add(male);
        male.setText("Male");

        buttonGroup1.add(female);
        female.setText("Female");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel5.setText("Address");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel6.setText("Level Of Education");

        educationLevel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BACC 2  or equivalent", "TS", "Bachelor degree or equivlent", "Master degree" }));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel7.setText("Name");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Date of Birth");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel9.setText("Nationality");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel10.setText("Mobile #");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel11.setText("State");

        state.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Single ", "Married ", "Divorced " }));

        createAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/newaccount.png"))); // NOI18N
        createAccount.setText("Create");
        createAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createAccountActionPerformed(evt);
            }
        });

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        clearForm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Actions-edit-clear-icon.png"))); // NOI18N
        clearForm.setText("Clear");
        clearForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearFormActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel12.setText("Salary");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(305, 305, 305)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(createAccount)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(52, 52, 52)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(employeeID)
                                    .addComponent(password)
                                    .addComponent(address)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(male)
                                        .addGap(18, 18, 18)
                                        .addComponent(female)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(educationLevel, 0, 159, Short.MAX_VALUE)
                                    .addComponent(salary))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel7))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(dob, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(nationality)
                                            .addComponent(mobileNb)
                                            .addComponent(state, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(back)
                                .addGap(37, 37, 37)
                                .addComponent(clearForm)))))
                .addGap(68, 68, 68))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jLabel1)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(employeeID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(dob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(male)
                    .addComponent(female)
                    .addComponent(jLabel9)
                    .addComponent(nationality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(mobileNb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(educationLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel11)
                    .addComponent(state, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createAccount)
                    .addComponent(back)
                    .addComponent(clearForm))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(779, 548));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        goBack();
    }//GEN-LAST:event_backActionPerformed

    private void clearFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearFormActionPerformed
        clear();
    }//GEN-LAST:event_clearFormActionPerformed

    private void createAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createAccountActionPerformed
        createAccountHandler();
    }//GEN-LAST:event_createAccountActionPerformed

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
            java.util.logging.Logger.getLogger(EmployeeAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeAccount().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address;
    private javax.swing.JButton back;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton clearForm;
    private javax.swing.JButton createAccount;
    private com.toedter.calendar.JDateChooser dob;
    private javax.swing.JComboBox<String> educationLevel;
    private javax.swing.JTextField employeeID;
    private javax.swing.JRadioButton female;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton male;
    private javax.swing.JTextField mobileNb;
    private javax.swing.JTextField name;
    private javax.swing.JTextField nationality;
    private javax.swing.JTextField password;
    private javax.swing.JTextField salary;
    private javax.swing.JComboBox<String> state;
    // End of variables declaration//GEN-END:variables

}

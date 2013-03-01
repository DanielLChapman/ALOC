/*     */ package view;
/*     */ 
/*     */ import control.EDS;
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.MouseAdapter;
/*     */ import java.awt.event.MouseEvent;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JMenu;
/*     */ import javax.swing.JMenuBar;
/*     */ import javax.swing.JMenuItem;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.table.DefaultTableModel;
/*     */ import javax.swing.table.TableModel;
/*     */ import model.Employee;
/*     */ 
/*     */ public class MainFrame extends JFrame
/*     */   implements ActionListener
/*     */ {
/*     */   private EDS eds;
/*     */   private LoginPanel loginPanel;
/*     */   private InputPanel inputPanel;
/*     */   private JTable displayTable;
/*     */   private String viewing;
/*     */   private JMenuBar menuBar;
/*     */   private JMenu addMenu;
/*     */   private JMenu viewMenu;
/*     */   private JMenu transactionMenu;
/*     */   private JMenuItem addUserItem;
/*     */   private JMenuItem addEquipmentItem;
/*     */   private JMenuItem addUserGroupItem;
/*     */   private JMenuItem addEmployeeItem;
/*     */   private JMenuItem addEquipmentTypeItem;
/*     */   private JMenuItem viewUsersItem;
/*     */   private JMenuItem viewEquipmentItem;
/*     */   private JMenuItem viewUserGroupsItem;
/*     */   private JMenuItem viewEmployeesItem;
/*     */   private JMenuItem transSignOutItem;
/*     */   private JMenuItem transSignInItem;
/*     */   private JMenuItem transCancelReservationItem;
/*     */ 
/*     */   public MainFrame(EDS eds)
/*     */   {
/*  41 */     super("A.L.O.C.");
/*     */ 
/*  43 */     this.eds = eds;
/*  44 */     this.viewing = "";
/*  45 */     this.loginPanel = new LoginPanel(this, eds);
/*  46 */     this.inputPanel = new InputPanel(this, eds);
/*  47 */     setDefaultCloseOperation(3);
/*  48 */     setLayout(new BorderLayout());
/*  49 */     add(this.loginPanel, "Before");
/*  50 */     this.loginPanel.setVisible(true);
/*  51 */     pack();
/*  52 */     setSize(250, 125);
/*     */   }
/*     */ 
/*     */   private void buildMenuBar()
/*     */   {
/*  58 */     this.menuBar = new JMenuBar();
/*     */ 
/*  61 */     this.addUserItem = new JMenuItem("Add New User");
/*  62 */     this.addUserItem.addActionListener(this);
/*  63 */     this.addEquipmentItem = new JMenuItem("Add New Equipment");
/*  64 */     this.addEquipmentItem.addActionListener(this);
/*  65 */     this.addUserGroupItem = new JMenuItem("Add New User Group");
/*  66 */     this.addUserGroupItem.addActionListener(this);
/*  67 */     this.addEmployeeItem = new JMenuItem("Add New Employee");
/*  68 */     this.addEmployeeItem.addActionListener(this);
/*  69 */     this.addEquipmentTypeItem = new JMenuItem("Add New Equipment Type");
/*  70 */     this.addEquipmentTypeItem.addActionListener(this);
/*     */ 
/*  72 */     this.viewUsersItem = new JMenuItem("View Users");
/*  73 */     this.viewUsersItem.addActionListener(this);
/*  74 */     this.viewEquipmentItem = new JMenuItem("View Equipment");
/*  75 */     this.viewEquipmentItem.addActionListener(this);
/*  76 */     this.viewUserGroupsItem = new JMenuItem("View User Groups");
/*  77 */     this.viewUserGroupsItem.addActionListener(this);
/*  78 */     this.viewEmployeesItem = new JMenuItem("View Employees");
/*  79 */     this.viewEmployeesItem.addActionListener(this);
/*     */ 
/*  81 */     this.transSignOutItem = new JMenuItem("Sign Out Equipment");
/*  82 */     this.transSignOutItem.addActionListener(this);
/*  83 */     this.transSignInItem = new JMenuItem("Sign In Equipment");
/*  84 */     this.transSignInItem.addActionListener(this);
/*  85 */     this.transCancelReservationItem = new JMenuItem("Cancel Reservation");
/*  86 */     this.transCancelReservationItem.addActionListener(this);
/*     */ 
/*  89 */     if (this.eds.getCurrentLogin().isManager())
/*     */     {
/*  91 */       this.addMenu = new JMenu("Add");
/*  92 */       this.addMenu.add(this.addUserItem);
/*  93 */       this.addMenu.add(this.addEquipmentItem);
/*  94 */       this.addMenu.add(this.addUserGroupItem);
/*  95 */       this.addMenu.add(this.addEmployeeItem);
/*  96 */       this.addMenu.add(this.addEquipmentTypeItem);
/*     */     }
/*     */ 
/* 100 */     this.viewMenu = new JMenu("View");
/* 101 */     this.viewMenu.add(this.viewUsersItem);
/* 102 */     this.viewMenu.add(this.viewEquipmentItem);
/* 103 */     this.viewMenu.add(this.viewUserGroupsItem);
/* 104 */     this.viewMenu.add(this.viewEmployeesItem);
/*     */ 
/* 107 */     this.transactionMenu = new JMenu("Transactions");
/* 108 */     this.transactionMenu.add(this.transSignOutItem);
/* 109 */     this.transactionMenu.add(this.transSignInItem);
/*     */ 
/* 113 */     if (this.eds.getCurrentLogin().isManager())
/*     */     {
/* 115 */       this.transactionMenu.add(this.transCancelReservationItem);
/*     */     }
/*     */ 
/* 119 */     if (this.eds.getCurrentLogin().isManager())
/*     */     {
/* 121 */       this.menuBar.add(this.addMenu);
/*     */     }
/* 123 */     this.menuBar.add(this.viewMenu);
/* 124 */     this.menuBar.add(this.transactionMenu);
/*     */ 
/* 126 */     setJMenuBar(this.menuBar);
/*     */   }
/*     */ 
/*     */   public void loadTable(String tableType)
/*     */   {
/* 134 */     this.viewing = tableType;
/*     */     Object[][] rowData;
/*     */     String[] columnNames;
/*     */     Object[][] rowData;
/* 136 */     if (tableType.equals("users"))
/*     */     {
/* 138 */       String[] columnNames = new String[3];
/* 139 */       columnNames[0] = "ID";
/* 140 */       columnNames[1] = "First Name";
/* 141 */       columnNames[2] = "Last Name";
/* 142 */       rowData = this.eds.viewUserList();
/*     */     }
/*     */     else
/*     */     {
/*     */       Object[][] rowData;
/* 144 */       if (tableType.equals("equipment"))
/*     */       {
/* 146 */         String[] columnNames = new String[3];
/* 147 */         columnNames[0] = "Tag Number";
/* 148 */         columnNames[1] = "Type";
/* 149 */         columnNames[2] = "Model";
/* 150 */         rowData = this.eds.viewEquipmentList();
/*     */       }
/*     */       else
/*     */       {
/*     */         Object[][] rowData;
/* 152 */         if (tableType.equals("usergroups"))
/*     */         {
/* 154 */           String[] columnNames = new String[1];
/* 155 */           columnNames[0] = "Name";
/* 156 */           rowData = this.eds.viewUserGroupList();
/*     */         }
/*     */         else
/*     */         {
/* 160 */           columnNames = new String[4];
/* 161 */           columnNames[0] = "Username";
/* 162 */           columnNames[1] = "First Name";
/* 163 */           columnNames[2] = "Last Name";
/* 164 */           columnNames[3] = "Manager?";
/* 165 */           rowData = this.eds.viewEmployeeList();
/*     */         }
/*     */       }
/*     */     }
/* 167 */     DefaultTableModel model = new DefaultTableModel(rowData, columnNames);
/* 168 */     this.displayTable.setModel(model);
/* 169 */     model.fireTableDataChanged();
/*     */   }
/*     */ 
/*     */   public void buildTable() {
/* 173 */     this.displayTable = new JTable()
/*     */     {
/*     */       public boolean isCellEditable(int row, int column)
/*     */       {
/* 178 */         return false;
/*     */       }
/*     */     };
/* 181 */     this.displayTable.addMouseListener(new MouseAdapter()
/*     */     {
/*     */       public void mouseClicked(MouseEvent e)
/*     */       {
/* 185 */         int row = MainFrame.this.displayTable.rowAtPoint(e.getPoint());
/* 186 */         if (row != -1)
/*     */         {
/* 188 */           if (MainFrame.this.viewing.equals("users"))
/*     */           {
/* 190 */             int userId = ((Integer)MainFrame.this.displayTable.getModel().getValueAt(row, 0)).intValue();
/* 191 */             MainFrame.this.inputPanel.viewUser(userId);
/*     */           }
/* 193 */           else if (MainFrame.this.viewing.equals("equipment"))
/*     */           {
/* 195 */             long tagNumber = ((Long)MainFrame.this.displayTable.getModel().getValueAt(row, 0)).longValue();
/* 196 */             MainFrame.this.inputPanel.viewEquipment(tagNumber);
/*     */           }
/* 198 */           else if (MainFrame.this.viewing.equals("usergroups"))
/*     */           {
/* 200 */             String name = (String)MainFrame.this.displayTable.getModel().getValueAt(row, 0);
/* 201 */             MainFrame.this.inputPanel.viewUserGroup(name);
/*     */           }
/* 203 */           else if (MainFrame.this.viewing.equals("employees"))
/*     */           {
/* 205 */             String userName = (String)MainFrame.this.displayTable.getModel().getValueAt(row, 0);
/* 206 */             MainFrame.this.inputPanel.viewEmployee(userName);
/*     */           }
/*     */         }
/*     */       }
/*     */     });
/* 211 */     Dimension tableSize = new Dimension();
/* 212 */     tableSize.setSize(getWidth() / 2, getHeight());
/* 213 */     JScrollPane scrollPane = new JScrollPane(this.displayTable);
/* 214 */     scrollPane.setPreferredSize(tableSize);
/* 215 */     add(scrollPane, "Before");
/* 216 */     loadTable("users");
/*     */   }
/*     */ 
/*     */   public void buildUI()
/*     */   {
/* 221 */     remove(this.loginPanel);
/* 222 */     buildMenuBar();
/* 223 */     setSize(1024, 768);
/* 224 */     buildTable();
/* 225 */     add(this.inputPanel, "Center");
/* 226 */     this.inputPanel.viewEmployee(this.eds.getCurrentLogin().getUsername());
/*     */   }
/*     */ 
/*     */   public void actionPerformed(ActionEvent e)
/*     */   {
/* 232 */     Object source = e.getSource();
/* 233 */     if (source.equals(this.addUserItem))
/*     */     {
/* 235 */       this.inputPanel.newUser();
/*     */     }
/* 237 */     else if (source.equals(this.addEquipmentItem))
/*     */     {
/* 239 */       this.inputPanel.newEquipment();
/*     */     }
/* 241 */     else if (source.equals(this.addUserGroupItem))
/*     */     {
/* 243 */       this.inputPanel.newUserGroup();
/*     */     }
/* 245 */     else if (source.equals(this.addEmployeeItem))
/*     */     {
/* 247 */       this.inputPanel.newEmployee();
/*     */     }
/* 249 */     else if (source.equals(this.viewUsersItem))
/*     */     {
/* 251 */       loadTable("users");
/*     */     }
/* 253 */     else if (source.equals(this.viewEquipmentItem))
/*     */     {
/* 255 */       loadTable("equipment");
/*     */     }
/* 257 */     else if (source.equals(this.viewUserGroupsItem))
/*     */     {
/* 259 */       loadTable("usergroups");
/*     */     }
/* 261 */     else if (source.equals(this.viewEmployeesItem))
/*     */     {
/* 263 */       loadTable("employees");
/*     */     }
/* 265 */     else if (source.equals(this.transSignOutItem))
/*     */     {
/* 267 */       JTextField userIdField = new JTextField();
/*     */ 
/* 269 */       JTextField tagNumberField = new JTextField();
/*     */ 
/* 272 */       JComponent[] inputs = { new JLabel("User ID"), userIdField, new JLabel("Eq. Tag No."), tagNumberField };
/*     */ 
/* 278 */       JOptionPane.showMessageDialog(null, inputs, "Equipment Sign-out", -1);
/* 279 */       int userId = Integer.parseInt(userIdField.getText());
/* 280 */       long tagNumber = Long.parseLong(tagNumberField.getText());
/*     */ 
/* 282 */       this.eds.signOutEquipment(userId, tagNumber);
/*     */     }
/* 284 */     else if (source.equals(this.transSignInItem))
/*     */     {
/* 286 */       JTextField tagNumberField = new JTextField();
/*     */ 
/* 289 */       JComponent[] input = { new JLabel("Eq. Tag No."), tagNumberField };
/*     */ 
/* 293 */       JOptionPane.showMessageDialog(null, input, "Equipment Sign-in", -1);
/* 294 */       long tagNumber = Long.parseLong(tagNumberField.getText());
/*     */ 
/* 296 */       this.eds.signInEquipment(tagNumber);
/*     */     }
/* 298 */     else if (source.equals(this.transCancelReservationItem))
/*     */     {
/* 300 */       JTextField tagNumberField = new JTextField();
/*     */ 
/* 302 */       JComponent[] input = { new JLabel("Eq. Tag No."), tagNumberField };
/*     */ 
/* 307 */       JOptionPane.showMessageDialog(null, input, "Cancel Reservation", -1);
/* 308 */       long tagNumber = Long.parseLong(tagNumberField.getText());
/* 309 */       this.eds.cancelReservation(tagNumber);
/*     */     }
/* 311 */     else if (source.equals(this.addEquipmentTypeItem))
/*     */     {
/* 313 */       JTextField eqTypeField = new JTextField();
/*     */ 
/* 315 */       JComponent[] input = { new JLabel("New Type"), eqTypeField };
/*     */ 
/* 320 */       JOptionPane.showMessageDialog(null, input, "Add New Equipment Type", -1);
/* 321 */       this.eds.addEquipmentType(eqTypeField.getText());
/*     */     }
/*     */   }
/*     */ }

/* Location:           /Users/Rusty-Mac/Downloads/ALOC_EDS/ALOC_v2.jar
 * Qualified Name:     view.MainFrame
 * JD-Core Version:    0.6.2
 */
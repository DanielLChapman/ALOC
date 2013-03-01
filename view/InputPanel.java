/*      */ package view;
/*      */ 
/*      */ import control.EDS;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.util.ArrayList;
/*      */ import java.util.List;
/*      */ import java.util.Set;
/*      */ import javax.persistence.EntityManager;
/*      */ import javax.persistence.EntityManagerFactory;
/*      */ import javax.persistence.EntityTransaction;
/*      */ import javax.persistence.Persistence;
/*      */ import javax.persistence.Query;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.GroupLayout.Alignment;
/*      */ import javax.swing.GroupLayout.ParallelGroup;
/*      */ import javax.swing.GroupLayout.SequentialGroup;
/*      */ import javax.swing.JButton;
/*      */ import javax.swing.JCheckBox;
/*      */ import javax.swing.JComboBox;
/*      */ import javax.swing.JComponent;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JOptionPane;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JScrollPane;
/*      */ import javax.swing.JTable;
/*      */ import javax.swing.JTextField;
/*      */ import javax.swing.LayoutStyle.ComponentPlacement;
/*      */ import javax.swing.table.DefaultTableModel;
/*      */ import javax.swing.table.JTableHeader;
/*      */ import javax.swing.table.TableColumn;
/*      */ import javax.swing.table.TableColumnModel;
/*      */ import model.EDSUser;
/*      */ import model.Employee;
/*      */ import model.Equipment;
/*      */ import model.EquipmentType;
/*      */ import model.UserGroup;
/*      */ 
/*      */ public class InputPanel extends JPanel
/*      */   implements ActionListener
/*      */ {
/*      */   private MainFrame parentFrame;
/*      */   private EDS eds;
/*      */   private EntityManagerFactory emf;
/*      */   private String editMode;
/*      */   private JLabel headerLabel;
/*      */   private JLabel label1;
/*      */   private JLabel label2;
/*      */   private JLabel label3;
/*      */   private JLabel label4;
/*      */   private JLabel label5;
/*      */   private JLabel typeLabel;
/*      */   private JLabel borrowedLabel;
/*      */   private JLabel permissionsLabel;
/*      */   private JTextField textField1;
/*      */   private JTextField textField2;
/*      */   private JTextField textField3;
/*      */   private JTextField textField4;
/*      */   private JCheckBox managerCheckBox;
/*      */   private JComboBox typeComboBox;
/*      */   private JButton submitButton;
/*      */   private JScrollPane scrollPane1;
/*      */   private JScrollPane borrowedScrollPane;
/*      */   private JScrollPane permissionsScrollPane;
/*      */   private JTable permissionsTable;
/*      */   private JLabel scrollPane1Label;
/*      */   private JTable table1;
/*      */   private JTable borrowedTable;
/*      */   private JButton deleteButton;
/*      */   private JButton permissionButton;
/*      */   private JButton addUserButton;
/*      */   private JButton removePermissionButton;
/*      */   private JButton removeUserButton;
/*      */ 
/*      */   public InputPanel(MainFrame parent, EDS eds)
/*      */   {
/*   74 */     this.emf = Persistence.createEntityManagerFactory("ALOCPU");
/*   75 */     this.parentFrame = parent;
/*   76 */     this.eds = eds;
/*   77 */     initComponents();
/*   78 */     this.editMode = "";
/*      */ 
/*   80 */     this.submitButton.addActionListener(this);
/*   81 */     this.deleteButton.addActionListener(this);
/*   82 */     this.permissionButton.addActionListener(this);
/*   83 */     this.removePermissionButton.addActionListener(this);
/*   84 */     this.addUserButton.addActionListener(this);
/*   85 */     this.removeUserButton.addActionListener(this);
/*      */   }
/*      */ 
/*      */   public void newUser()
/*      */   {
/*   90 */     clearFields();
/*   91 */     this.editMode = "newuser";
/*   92 */     this.headerLabel.setText("New User");
/*   93 */     this.label1.setText("Id Number");
/*   94 */     this.textField1.setEditable(true);
/*   95 */     this.label2.setText("First Name");
/*   96 */     this.label2.setVisible(true);
/*   97 */     this.textField2.setVisible(true);
/*   98 */     this.label3.setText("Last Name");
/*   99 */     this.label3.setVisible(true);
/*  100 */     this.textField3.setVisible(true);
/*  101 */     this.label4.setText("Password");
/*  102 */     this.label4.setVisible(true);
/*  103 */     this.textField4.setVisible(true);
/*  104 */     this.label5.setVisible(false);
/*  105 */     this.managerCheckBox.setVisible(false);
/*      */ 
/*  107 */     this.permissionsLabel.setVisible(false);
/*  108 */     this.permissionsScrollPane.setVisible(false);
/*  109 */     this.scrollPane1Label.setVisible(false);
/*  110 */     this.scrollPane1.setVisible(false);
/*  111 */     this.borrowedLabel.setVisible(false);
/*  112 */     this.borrowedScrollPane.setVisible(false);
/*  113 */     this.deleteButton.setVisible(false);
/*  114 */     this.permissionButton.setVisible(false);
/*  115 */     this.addUserButton.setVisible(false);
/*  116 */     this.removeUserButton.setVisible(false);
/*  117 */     this.removePermissionButton.setVisible(false);
/*  118 */     this.typeLabel.setVisible(false);
/*  119 */     this.typeComboBox.setVisible(false);
/*      */   }
/*      */ 
/*      */   public void viewUser(int idNumber)
/*      */   {
/*  124 */     clearFields();
/*  125 */     EntityManager em = this.emf.createEntityManager();
/*  126 */     EDSUser user = (EDSUser)em.find(EDSUser.class, Integer.valueOf(idNumber));
/*  127 */     this.editMode = "edituser";
/*  128 */     this.headerLabel.setText("Edit User");
/*  129 */     this.label1.setText("Id Number");
/*  130 */     this.label1.setVisible(true);
/*  131 */     this.textField1.setText(Integer.toString(user.getIdNumber().intValue()));
/*  132 */     this.textField1.setEditable(false);
/*  133 */     this.label2.setText("First Name");
/*  134 */     this.label2.setVisible(true);
/*  135 */     this.textField2.setText(user.getFirstName());
/*  136 */     this.textField2.setVisible(true);
/*  137 */     this.label3.setVisible(true);
/*  138 */     this.label3.setText("Last Name");
/*  139 */     this.textField3.setText(user.getLastName());
/*  140 */     this.textField3.setVisible(true);
/*  141 */     this.label4.setVisible(false);
/*  142 */     this.textField4.setVisible(false);
/*  143 */     this.label5.setVisible(false);
/*  144 */     this.managerCheckBox.setVisible(false);
/*  145 */     this.typeLabel.setVisible(false);
/*  146 */     this.typeComboBox.setVisible(false);
/*  147 */     this.permissionsLabel.setVisible(true);
/*  148 */     this.permissionsScrollPane.setVisible(true);
/*  149 */     Object[] columnNames = { "Type" };
/*  150 */     Object[][] rowData = new Object[user.getPermissions().size()][1];
/*  151 */     ArrayList permissions = new ArrayList(user.getPermissions());
/*  152 */     for (int i = 0; i < permissions.size(); i++)
/*      */     {
/*  154 */       rowData[i][0] = permissions.get(i);
/*      */     }
/*  156 */     this.permissionsTable.setModel(new DefaultTableModel(rowData, columnNames));
/*      */ 
/*  158 */     Object[] eqColumnNames = { "Tag Number", "Type", "Model" };
/*  159 */     rowData = new Object[user.getBorrowedEquipment().size()][3];
/*  160 */     ArrayList borrowed = new ArrayList(user.getBorrowedEquipment());
/*  161 */     for (int i = 0; i < borrowed.size(); i++)
/*      */     {
/*  163 */       rowData[i][0] = ((Equipment)borrowed.get(i)).getTagNumber();
/*  164 */       rowData[i][1] = ((Equipment)borrowed.get(i)).getType();
/*  165 */       rowData[i][2] = ((Equipment)borrowed.get(i)).getModel();
/*      */     }
/*  167 */     this.borrowedTable.setModel(new DefaultTableModel(rowData, eqColumnNames));
/*      */ 
/*  169 */     rowData = new Object[user.getReservations().size()][3];
/*  170 */     ArrayList reserved = new ArrayList(user.getReservations());
/*  171 */     for (int i = 0; i < reserved.size(); i++)
/*      */     {
/*  173 */       rowData[i][0] = ((Equipment)reserved.get(i)).getTagNumber();
/*  174 */       rowData[i][1] = ((Equipment)reserved.get(i)).getType();
/*  175 */       rowData[i][2] = ((Equipment)reserved.get(i)).getModel();
/*      */     }
/*  177 */     this.table1.setModel(new DefaultTableModel(rowData, eqColumnNames));
/*  178 */     this.scrollPane1Label.setVisible(true);
/*  179 */     this.scrollPane1Label.setText("Reserved");
/*  180 */     this.scrollPane1.setVisible(true);
/*  181 */     this.borrowedLabel.setVisible(true);
/*  182 */     this.borrowedScrollPane.setVisible(true);
/*  183 */     this.addUserButton.setVisible(false);
/*  184 */     this.removeUserButton.setVisible(false);
/*  185 */     this.removePermissionButton.setVisible(true);
/*  186 */     this.deleteButton.setVisible(true);
/*  187 */     this.submitButton.setVisible(true);
/*  188 */     this.permissionButton.setVisible(true);
/*  189 */     if (!this.eds.getCurrentLogin().isManager())
/*      */     {
/*  191 */       disablePanelControls();
/*      */     }
/*      */   }
/*      */ 
/*      */   public void newEquipment()
/*      */   {
/*  197 */     clearFields();
/*  198 */     this.editMode = "newequipment";
/*  199 */     this.headerLabel.setText("New Equipment");
/*  200 */     this.label1.setText("Tag Number");
/*  201 */     this.textField1.setEditable(true);
/*      */ 
/*  203 */     this.label2.setVisible(false);
/*  204 */     this.textField2.setVisible(false);
/*      */ 
/*  206 */     this.typeLabel.setVisible(true);
/*  207 */     this.typeComboBox.setVisible(true);
/*      */ 
/*  210 */     this.typeComboBox.removeAllItems();
/*  211 */     EntityManager em = this.emf.createEntityManager();
/*  212 */     String queryString = "select e from EquipmentType e";
/*  213 */     Query query = em.createQuery(queryString);
/*  214 */     List types = query.getResultList();
/*  215 */     for (EquipmentType type : types)
/*      */     {
/*  217 */       this.typeComboBox.addItem(type);
/*      */     }
/*  219 */     em.close();
/*      */ 
/*  221 */     this.label3.setVisible(true);
/*  222 */     this.label3.setText("Eq. Model");
/*  223 */     this.textField3.setVisible(true);
/*      */ 
/*  225 */     this.label4.setVisible(false);
/*  226 */     this.textField4.setVisible(false);
/*      */ 
/*  228 */     this.label5.setVisible(false);
/*  229 */     this.managerCheckBox.setVisible(false);
/*      */ 
/*  231 */     this.permissionsLabel.setVisible(false);
/*  232 */     this.permissionsScrollPane.setVisible(false);
/*      */ 
/*  234 */     this.scrollPane1Label.setVisible(false);
/*  235 */     this.scrollPane1.setVisible(false);
/*      */ 
/*  237 */     this.borrowedLabel.setVisible(false);
/*  238 */     this.borrowedScrollPane.setVisible(false);
/*      */ 
/*  240 */     this.deleteButton.setVisible(false);
/*  241 */     this.permissionButton.setVisible(false);
/*  242 */     this.addUserButton.setVisible(false);
/*  243 */     this.removeUserButton.setVisible(false);
/*  244 */     this.removePermissionButton.setVisible(false);
/*      */   }
/*      */ 
/*      */   public void viewEquipment(long tagNumber) {
/*  248 */     clearFields();
/*  249 */     EntityManager em = this.emf.createEntityManager();
/*  250 */     Equipment eq = (Equipment)em.find(Equipment.class, Long.valueOf(tagNumber));
/*      */ 
/*  252 */     this.editMode = "editequipment";
/*  253 */     this.headerLabel.setText("Edit Equipment");
/*  254 */     this.label1.setText("Tag Number");
/*  255 */     this.textField1.setText(Long.toString(eq.getTagNumber().longValue()));
/*  256 */     this.textField1.setEditable(false);
/*      */ 
/*  258 */     this.label2.setVisible(false);
/*  259 */     this.typeLabel.setVisible(true);
/*  260 */     this.typeComboBox.setVisible(true);
/*  261 */     String queryString = "select e from EquipmentType e";
/*  262 */     Query query = em.createQuery(queryString);
/*  263 */     List types = query.getResultList();
/*  264 */     for (EquipmentType type : types)
/*      */     {
/*  266 */       this.typeComboBox.addItem(type);
/*      */     }
/*  268 */     this.typeComboBox.setSelectedItem(eq.getType());
/*      */ 
/*  270 */     this.label3.setText("Eq. Model");
/*  271 */     this.label3.setVisible(true);
/*  272 */     this.textField3.setText(eq.getModel());
/*  273 */     this.textField3.setVisible(true);
/*      */ 
/*  275 */     this.label4.setVisible(false);
/*  276 */     this.textField4.setVisible(false);
/*      */ 
/*  278 */     this.label5.setVisible(false);
/*  279 */     this.managerCheckBox.setVisible(false);
/*      */ 
/*  281 */     this.permissionsLabel.setVisible(false);
/*  282 */     this.permissionsScrollPane.setVisible(false);
/*  283 */     this.scrollPane1Label.setVisible(false);
/*  284 */     this.scrollPane1.setVisible(false);
/*  285 */     this.borrowedLabel.setVisible(false);
/*  286 */     this.borrowedScrollPane.setVisible(false);
/*  287 */     this.permissionButton.setVisible(false);
/*  288 */     this.removePermissionButton.setVisible(false);
/*  289 */     this.addUserButton.setVisible(false);
/*  290 */     if (this.eds.getCurrentLogin().isManager())
/*      */     {
/*  292 */       this.deleteButton.setVisible(true);
/*      */     }
/*      */ 
/*  295 */     if (!this.eds.getCurrentLogin().isManager())
/*      */     {
/*  297 */       this.deleteButton.setVisible(false);
/*  298 */       this.submitButton.setVisible(false);
/*      */     }
/*  300 */     em.close();
/*      */   }
/*      */ 
/*      */   public void newUserGroup() {
/*  304 */     clearFields();
/*  305 */     this.editMode = "newusergroup";
/*  306 */     this.headerLabel.setText("New User Group");
/*  307 */     this.label1.setText("Name");
/*  308 */     this.textField1.setEditable(true);
/*  309 */     this.label2.setVisible(false);
/*  310 */     this.textField2.setVisible(false);
/*  311 */     this.label3.setVisible(false);
/*  312 */     this.textField3.setVisible(false);
/*  313 */     this.label4.setVisible(false);
/*  314 */     this.textField4.setVisible(false);
/*  315 */     this.label5.setVisible(false);
/*  316 */     this.typeLabel.setVisible(false);
/*  317 */     this.typeComboBox.setVisible(false);
/*      */ 
/*  319 */     this.permissionButton.setVisible(false);
/*  320 */     this.managerCheckBox.setVisible(false);
/*  321 */     this.permissionsLabel.setVisible(false);
/*  322 */     this.permissionsScrollPane.setVisible(false);
/*  323 */     this.scrollPane1Label.setVisible(false);
/*  324 */     this.scrollPane1.setVisible(false);
/*  325 */     this.borrowedLabel.setVisible(false);
/*  326 */     this.borrowedScrollPane.setVisible(false);
/*  327 */     this.deleteButton.setVisible(false);
/*  328 */     this.addUserButton.setVisible(false);
/*  329 */     this.removeUserButton.setVisible(false);
/*  330 */     this.removePermissionButton.setVisible(false);
/*      */   }
/*      */ 
/*      */   public void viewUserGroup(String groupName)
/*      */   {
/*  335 */     EntityManager em = this.emf.createEntityManager();
/*  336 */     clearFields();
/*  337 */     UserGroup group = (UserGroup)em.find(UserGroup.class, groupName);
/*  338 */     this.editMode = "editusergroup";
/*  339 */     this.headerLabel.setText("Edit User Group");
/*      */ 
/*  341 */     this.label1.setText("Name");
/*  342 */     this.label1.setVisible(true);
/*  343 */     this.textField1.setEditable(false);
/*  344 */     this.textField1.setText(group.getName());
/*      */ 
/*  346 */     this.label2.setVisible(false);
/*  347 */     this.textField2.setVisible(false);
/*      */ 
/*  349 */     this.label3.setVisible(false);
/*  350 */     this.textField3.setVisible(false);
/*      */ 
/*  352 */     this.label4.setVisible(false);
/*  353 */     this.textField4.setVisible(false);
/*      */ 
/*  355 */     this.label5.setVisible(false);
/*  356 */     this.managerCheckBox.setVisible(false);
/*      */ 
/*  358 */     this.typeLabel.setVisible(false);
/*  359 */     this.typeComboBox.setVisible(false);
/*      */ 
/*  361 */     this.permissionButton.setVisible(true);
/*  362 */     this.removePermissionButton.setVisible(true);
/*  363 */     this.permissionsScrollPane.setVisible(true);
/*  364 */     this.addUserButton.setVisible(true);
/*  365 */     this.removeUserButton.setVisible(true);
/*  366 */     this.permissionsLabel.setVisible(true);
/*      */ 
/*  368 */     Object[] columnNames = { "Type" };
/*  369 */     Object[][] rowData = new Object[group.getPermissions().size()][1];
/*  370 */     ArrayList permissions = new ArrayList(group.getPermissions());
/*  371 */     for (int i = 0; i < permissions.size(); i++)
/*      */     {
/*  373 */       rowData[i][0] = permissions.get(i);
/*      */     }
/*  375 */     this.permissionsTable.setModel(new DefaultTableModel(rowData, columnNames));
/*  376 */     this.permissionsTable.setVisible(true);
/*      */ 
/*  378 */     Object[] eqColumnNames = { "ID Number", "First Name", "Last Name" };
/*  379 */     rowData = new Object[group.getUsers().size()][3];
/*  380 */     ArrayList borrowed = new ArrayList(group.getUsers());
/*  381 */     for (int i = 0; i < borrowed.size(); i++)
/*      */     {
/*  383 */       rowData[i][0] = ((EDSUser)borrowed.get(i)).getIdNumber();
/*  384 */       rowData[i][1] = ((EDSUser)borrowed.get(i)).getFirstName();
/*  385 */       rowData[i][2] = ((EDSUser)borrowed.get(i)).getLastName();
/*      */     }
/*  387 */     this.table1.setModel(new DefaultTableModel(rowData, eqColumnNames));
/*  388 */     this.scrollPane1.setVisible(true);
/*  389 */     this.scrollPane1Label.setVisible(true);
/*  390 */     this.scrollPane1Label.setText("Users");
/*      */ 
/*  392 */     this.borrowedScrollPane.setVisible(false);
/*  393 */     this.borrowedLabel.setVisible(false);
/*      */ 
/*  395 */     this.deleteButton.setVisible(true);
/*      */ 
/*  397 */     if (!this.eds.getCurrentLogin().isManager())
/*      */     {
/*  399 */       disablePanelControls();
/*      */     }
/*      */   }
/*      */ 
/*      */   public void newEmployee()
/*      */   {
/*  405 */     clearFields();
/*  406 */     this.editMode = "newemployee";
/*  407 */     this.headerLabel.setText("New Employee");
/*  408 */     this.label1.setText("Username");
/*  409 */     this.textField1.setEditable(true);
/*  410 */     this.label2.setText("Password");
/*  411 */     this.label2.setVisible(true);
/*  412 */     this.textField2.setVisible(true);
/*  413 */     this.label3.setText("First Name");
/*  414 */     this.label3.setVisible(true);
/*  415 */     this.textField3.setVisible(true);
/*  416 */     this.label4.setText("Last Name");
/*  417 */     this.label4.setVisible(true);
/*  418 */     this.textField4.setVisible(true);
/*  419 */     this.label5.setVisible(true);
/*  420 */     this.label5.setText("Manager?");
/*  421 */     this.managerCheckBox.setVisible(true);
/*      */ 
/*  423 */     this.typeLabel.setVisible(false);
/*  424 */     this.typeComboBox.setVisible(false);
/*      */ 
/*  426 */     this.permissionButton.setVisible(false);
/*  427 */     this.permissionsLabel.setVisible(false);
/*  428 */     this.permissionsScrollPane.setVisible(false);
/*  429 */     this.scrollPane1Label.setVisible(false);
/*  430 */     this.scrollPane1.setVisible(false);
/*  431 */     this.borrowedLabel.setVisible(false);
/*  432 */     this.borrowedScrollPane.setVisible(false);
/*  433 */     this.deleteButton.setVisible(false);
/*  434 */     this.addUserButton.setVisible(false);
/*  435 */     this.removeUserButton.setVisible(false);
/*  436 */     this.removePermissionButton.setVisible(false);
/*      */ 
/*  438 */     if (!this.eds.getCurrentLogin().isManager())
/*      */     {
/*  440 */       disablePanelControls();
/*      */     }
/*      */   }
/*      */ 
/*      */   public void viewEmployee(String userName)
/*      */   {
/*  446 */     EntityManager em = this.emf.createEntityManager();
/*  447 */     Employee employee = (Employee)em.find(Employee.class, userName);
/*      */ 
/*  449 */     clearFields();
/*  450 */     this.editMode = "editemployee";
/*  451 */     this.headerLabel.setText("Edit Employee");
/*  452 */     this.permissionButton.setVisible(false);
/*  453 */     this.label1.setText("Username");
/*  454 */     this.textField1.setText(employee.getUsername());
/*  455 */     this.textField1.setEditable(false);
/*  456 */     this.label2.setVisible(false);
/*  457 */     this.textField2.setVisible(false);
/*  458 */     this.label3.setText("First Name");
/*  459 */     this.label3.setVisible(true);
/*  460 */     this.textField3.setText(employee.getFirstName());
/*  461 */     this.textField3.setVisible(true);
/*  462 */     this.label4.setText("Last Name");
/*  463 */     this.label4.setVisible(true);
/*  464 */     this.textField4.setText(employee.getLastName());
/*  465 */     this.textField4.setVisible(true);
/*  466 */     this.label5.setVisible(true);
/*  467 */     this.label5.setText("Manager?");
/*  468 */     this.managerCheckBox.setVisible(true);
/*  469 */     this.managerCheckBox.setSelected(employee.isManager());
/*  470 */     this.typeLabel.setVisible(false);
/*  471 */     this.typeComboBox.setVisible(false);
/*      */ 
/*  473 */     this.addUserButton.setVisible(false);
/*  474 */     this.permissionsLabel.setVisible(false);
/*  475 */     this.permissionsScrollPane.setVisible(false);
/*  476 */     this.scrollPane1Label.setVisible(false);
/*  477 */     this.scrollPane1.setVisible(false);
/*  478 */     this.borrowedLabel.setVisible(false);
/*  479 */     this.borrowedScrollPane.setVisible(false);
/*  480 */     this.deleteButton.setVisible(true);
/*  481 */     this.removePermissionButton.setVisible(false);
/*  482 */     this.removeUserButton.setVisible(false);
/*      */ 
/*  484 */     if (!this.eds.getCurrentLogin().isManager())
/*      */     {
/*  486 */       disablePanelControls();
/*      */     }
/*      */   }
/*      */ 
/*      */   public void clearFields()
/*      */   {
/*  492 */     this.textField1.setText("");
/*  493 */     this.textField2.setText("");
/*  494 */     this.textField3.setText("");
/*  495 */     this.textField4.setText("");
/*      */ 
/*  497 */     Object[][] rowData = { { "", "" } };
/*  498 */     Object[] columnTitles = { "Type" };
/*  499 */     this.permissionsTable.setModel(new DefaultTableModel(rowData, columnTitles));
/*  500 */     this.managerCheckBox.setSelected(false);
/*      */   }
/*      */ 
/*      */   public void actionPerformed(ActionEvent e)
/*      */   {
/*  506 */     if (e.getSource().equals(this.submitButton))
/*      */     {
/*  508 */       if (this.editMode.equals("edituser"))
/*      */       {
/*  510 */         EntityManager em = this.emf.createEntityManager();
/*  511 */         int id = Integer.parseInt(this.textField1.getText());
/*  512 */         EDSUser user = (EDSUser)em.find(EDSUser.class, Integer.valueOf(id));
/*  513 */         em.close();
/*  514 */         String firstName = this.textField2.getText();
/*  515 */         String lastName = this.textField3.getText();
/*  516 */         user.setFirstName(firstName);
/*  517 */         user.setLastName(lastName);
/*  518 */         this.eds.update(user);
/*  519 */         this.parentFrame.loadTable("users");
/*      */       }
/*  521 */       else if (this.editMode.equals("newuser"))
/*      */       {
/*  523 */         int id = Integer.parseInt(this.textField1.getText());
/*  524 */         String firstName = this.textField2.getText();
/*  525 */         String lastName = this.textField3.getText();
/*  526 */         String password = this.textField4.getText();
/*  527 */         if (this.eds.addUser(id, firstName, lastName, password))
/*      */         {
/*  529 */           JOptionPane.showMessageDialog(this.parentFrame, "New user created.");
/*      */         }
/*      */         else
/*      */         {
/*  533 */           JOptionPane.showMessageDialog(this.parentFrame, "That ID is already in use.");
/*      */         }
/*  535 */         clearFields();
/*      */ 
/*  537 */         this.parentFrame.loadTable("users");
/*      */       }
/*  539 */       else if (this.editMode.equals("editequipment"))
/*      */       {
/*  541 */         EntityManager em = this.emf.createEntityManager();
/*  542 */         long tagNumber = Long.parseLong(this.textField1.getText());
/*  543 */         Equipment eq = (Equipment)em.find(Equipment.class, Long.valueOf(tagNumber));
/*  544 */         em.close();
/*  545 */         String type = this.textField2.getText();
/*  546 */         String model = this.textField3.getText();
/*  547 */         eq.setType((EquipmentType)this.typeComboBox.getSelectedItem());
/*  548 */         eq.setModel(model);
/*  549 */         this.eds.update(eq);
/*      */ 
/*  551 */         this.parentFrame.loadTable("equipment");
/*      */       }
/*  553 */       else if (this.editMode.equals("newequipment"))
/*      */       {
/*  555 */         Long tagNumber = Long.valueOf(Long.parseLong(this.textField1.getText()));
/*  556 */         EquipmentType type = (EquipmentType)this.typeComboBox.getSelectedItem();
/*  557 */         String model = this.textField3.getText();
/*  558 */         if (this.eds.addEquipment(tagNumber, type, model))
/*      */         {
/*  560 */           JOptionPane.showMessageDialog(this.parentFrame, "New equipment created.");
/*      */         }
/*      */         else
/*      */         {
/*  564 */           JOptionPane.showMessageDialog(this.parentFrame, "That tag number is already in use.");
/*      */         }
/*  566 */         clearFields();
/*      */ 
/*  568 */         this.parentFrame.loadTable("equipment");
/*      */       }
/*  570 */       else if (this.editMode.equals("newusergroup"))
/*      */       {
/*  572 */         String name = this.textField1.getText();
/*  573 */         if (this.eds.addUserGroup(name))
/*      */         {
/*  575 */           JOptionPane.showMessageDialog(this.parentFrame, "New user group created.");
/*      */         }
/*      */         else
/*      */         {
/*  579 */           JOptionPane.showMessageDialog(this.parentFrame, "That group name is already in use.");
/*      */         }
/*  581 */         clearFields();
/*      */ 
/*  583 */         this.parentFrame.loadTable("usergroups");
/*      */       }
/*  585 */       else if (this.editMode.equals("editemployee"))
/*      */       {
/*  587 */         EntityManager em = this.emf.createEntityManager();
/*  588 */         String username = this.textField1.getText();
/*  589 */         Employee employee = (Employee)em.find(Employee.class, username);
/*  590 */         em.close();
/*  591 */         if (!employee.equals(this.eds.getCurrentLogin()))
/*      */         {
/*  593 */           String firstName = this.textField3.getText();
/*  594 */           String lastName = this.textField4.getText();
/*  595 */           boolean manager = this.managerCheckBox.isSelected();
/*  596 */           employee.setFirstName(firstName);
/*  597 */           employee.setLastName(lastName);
/*  598 */           employee.setManager(manager);
/*  599 */           this.eds.update(employee);
/*      */ 
/*  601 */           this.parentFrame.loadTable("employees");
/*      */         }
/*      */         else
/*      */         {
/*  605 */           JOptionPane.showMessageDialog(this.parentFrame, "You cannot edit your own account!");
/*      */         }
/*      */       }
/*  608 */       else if (this.editMode.equals("newemployee"))
/*      */       {
/*  610 */         String username = this.textField1.getText();
/*  611 */         String password = this.textField2.getText();
/*  612 */         String firstName = this.textField3.getText();
/*  613 */         String lastName = this.textField4.getText();
/*  614 */         boolean manager = this.managerCheckBox.isSelected();
/*  615 */         if (this.eds.addEmployee(username, password, firstName, lastName, manager))
/*      */         {
/*  617 */           JOptionPane.showMessageDialog(this.parentFrame, "New employee created.");
/*      */         }
/*      */         else
/*      */         {
/*  621 */           JOptionPane.showMessageDialog(this.parentFrame, "That username is already in use.");
/*      */         }
/*  623 */         clearFields();
/*      */ 
/*  625 */         this.parentFrame.loadTable("employees");
/*      */       }
/*      */     }
/*  628 */     else if (e.getSource().equals(this.deleteButton))
/*      */     {
/*  630 */       if (this.editMode.equals("edituser"))
/*      */       {
/*  632 */         this.eds.removeUser(Integer.parseInt(this.textField1.getText()));
/*  633 */         this.parentFrame.loadTable("users");
/*      */       }
/*  635 */       else if (this.editMode.equals("editusergroup"))
/*      */       {
/*  637 */         this.eds.removeUserGroup(this.textField1.getText());
/*  638 */         this.parentFrame.loadTable("usergroups");
/*      */       }
/*  640 */       else if (this.editMode.equals("editemployee"))
/*      */       {
/*  642 */         this.eds.removeEmployee(this.textField1.getText());
/*  643 */         this.parentFrame.loadTable("employees");
/*      */       }
/*  645 */       else if (this.editMode.equals("editequipment"))
/*      */       {
/*  647 */         this.eds.removeEquipment(Long.parseLong(this.textField1.getText()));
/*  648 */         this.parentFrame.loadTable("equipment");
/*      */       }
/*      */     }
/*  651 */     else if (e.getSource().equals(this.addUserButton))
/*      */     {
/*  653 */       JTextField typeField = new JTextField();
/*      */ 
/*  655 */       JComponent[] input = { new JLabel("ID Number"), typeField };
/*      */ 
/*  659 */       JOptionPane.showMessageDialog(null, input, "Add User To Group", -1);
/*  660 */       int userId = Integer.parseInt(typeField.getText());
/*  661 */       EntityManager em = this.emf.createEntityManager();
/*  662 */       em.getTransaction().begin();
/*  663 */       EDSUser user = (EDSUser)em.find(EDSUser.class, Integer.valueOf(userId));
/*  664 */       if (user != null)
/*      */       {
/*  666 */         UserGroup group = (UserGroup)em.find(UserGroup.class, this.textField1.getText());
/*  667 */         group.getUsers().add(user);
/*  668 */         em.merge(user);
/*  669 */         viewUserGroup(group.getName());
/*      */       }
/*  671 */       em.getTransaction().commit();
/*  672 */       em.close();
/*      */     }
/*  674 */     else if (e.getSource().equals(this.removeUserButton))
/*      */     {
/*  676 */       JTextField idField = new JTextField();
/*      */ 
/*  678 */       JComponent[] input = { new JLabel("ID Number"), idField };
/*      */ 
/*  682 */       JOptionPane.showMessageDialog(null, input, "Remove User From Group", -1);
/*  683 */       int userId = Integer.parseInt(idField.getText());
/*  684 */       EntityManager em = this.emf.createEntityManager();
/*  685 */       em.getTransaction().begin();
/*  686 */       EDSUser user = (EDSUser)em.find(EDSUser.class, Integer.valueOf(userId));
/*  687 */       UserGroup group = (UserGroup)em.find(UserGroup.class, this.textField1.getText());
/*  688 */       if ((user != null) && (group.getUsers().contains(user)))
/*      */       {
/*  690 */         group.getUsers().remove(user);
/*  691 */         em.merge(user);
/*  692 */         viewUserGroup(group.getName());
/*  693 */         em.getTransaction().commit();
/*  694 */         em.close();
/*      */       }
/*      */       else
/*      */       {
/*  698 */         JOptionPane.showMessageDialog(this.parentFrame, "That is not a user in the group");
/*      */       }
/*      */ 
/*      */     }
/*  702 */     else if (e.getSource().equals(this.permissionButton))
/*      */     {
/*  704 */       if (this.editMode.equals("edituser"))
/*      */       {
/*  706 */         EntityManager em = this.emf.createEntityManager();
/*  707 */         String selectSQL = "select e from EquipmentType e";
/*  708 */         Query query = em.createQuery(selectSQL);
/*  709 */         List types = query.getResultList();
/*  710 */         JComboBox typeField = new JComboBox();
/*  711 */         for (int i = 0; i < types.size(); i++)
/*      */         {
/*  713 */           typeField.addItem(types.get(i));
/*      */         }
/*      */ 
/*  716 */         JComponent[] input = { new JLabel("Type"), typeField };
/*      */ 
/*  720 */         JOptionPane.showMessageDialog(null, input, "Add New Permission", -1);
/*  721 */         EquipmentType newType = (EquipmentType)typeField.getSelectedItem();
/*  722 */         em.getTransaction().begin();
/*  723 */         EDSUser user = (EDSUser)em.find(EDSUser.class, Integer.valueOf(Integer.parseInt(this.textField1.getText())));
/*  724 */         user.getPermissions().add(newType);
/*  725 */         newType.getUsers().add(user);
/*  726 */         em.merge(user);
/*  727 */         em.merge(newType);
/*  728 */         em.getTransaction().commit();
/*  729 */         em.close();
/*  730 */         viewUser(user.getIdNumber().intValue());
/*      */       }
/*  732 */       else if (this.editMode.equals("editusergroup"))
/*      */       {
/*  734 */         EntityManager em = this.emf.createEntityManager();
/*  735 */         String selectSQL = "select e from EquipmentType e";
/*  736 */         Query query = em.createQuery(selectSQL);
/*  737 */         List types = query.getResultList();
/*  738 */         JComboBox typeField = new JComboBox();
/*  739 */         for (int i = 0; i < types.size(); i++)
/*      */         {
/*  741 */           typeField.addItem(types.get(i));
/*      */         }
/*      */ 
/*  744 */         JComponent[] input = { new JLabel("Type"), typeField };
/*      */ 
/*  748 */         JOptionPane.showMessageDialog(null, input, "Add New Permission", -1);
/*  749 */         EquipmentType newType = (EquipmentType)typeField.getSelectedItem();
/*  750 */         em.getTransaction().begin();
/*  751 */         UserGroup group = (UserGroup)em.find(UserGroup.class, this.textField1.getText());
/*  752 */         group.getPermissions().add(newType);
/*  753 */         newType.getGroups().add(group);
/*  754 */         em.merge(group);
/*  755 */         em.merge(newType);
/*  756 */         em.getTransaction().commit();
/*  757 */         em.close();
/*  758 */         viewUserGroup(group.getName());
/*      */       }
/*      */     }
/*  761 */     else if (e.getSource().equals(this.removePermissionButton))
/*      */     {
/*  763 */       if (this.editMode.equals("edituser"))
/*      */       {
/*  765 */         EntityManager em = this.emf.createEntityManager();
/*  766 */         em.getTransaction().begin();
/*  767 */         EDSUser user = (EDSUser)em.find(EDSUser.class, Integer.valueOf(Integer.parseInt(this.textField1.getText())));
/*  768 */         JComboBox typeField = new JComboBox();
/*  769 */         for (EquipmentType eqType : user.getPermissions())
/*      */         {
/*  771 */           typeField.addItem(eqType);
/*      */         }
/*      */ 
/*  774 */         JComponent[] input = { new JLabel("Type"), typeField };
/*      */ 
/*  778 */         JOptionPane.showMessageDialog(null, input, "Remove Permission", -1);
/*  779 */         EquipmentType oldType = (EquipmentType)typeField.getSelectedItem();
/*      */ 
/*  781 */         if (user.getPermissions().contains(oldType))
/*      */         {
/*  783 */           user.getPermissions().remove(oldType);
/*  784 */           oldType.getUsers().remove(user);
/*  785 */           em.merge(user);
/*  786 */           em.merge(oldType);
/*      */         }
/*  788 */         em.getTransaction().commit();
/*  789 */         em.close();
/*  790 */         viewUser(user.getIdNumber().intValue());
/*      */       }
/*  792 */       else if (this.editMode.equals("editusergroup"))
/*      */       {
/*  794 */         EntityManager em = this.emf.createEntityManager();
/*  795 */         em.getTransaction().begin();
/*  796 */         UserGroup group = (UserGroup)em.find(UserGroup.class, this.textField1.getText());
/*  797 */         JComboBox typeField = new JComboBox();
/*  798 */         for (EquipmentType eqType : group.getPermissions())
/*      */         {
/*  800 */           typeField.addItem(eqType);
/*      */         }
/*      */ 
/*  803 */         JComponent[] input = { new JLabel("Type"), typeField };
/*      */ 
/*  807 */         JOptionPane.showMessageDialog(null, input, "Remove Permission", -1);
/*  808 */         EquipmentType oldType = (EquipmentType)typeField.getSelectedItem();
/*      */ 
/*  810 */         if (group.getPermissions().contains(oldType))
/*      */         {
/*  812 */           group.getPermissions().remove(oldType);
/*  813 */           oldType.getUsers().remove(group);
/*  814 */           em.merge(group);
/*  815 */           em.merge(oldType);
/*      */         }
/*  817 */         em.getTransaction().commit();
/*  818 */         em.close();
/*  819 */         viewUserGroup(group.getName());
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   private void disablePanelControls() {
/*  825 */     this.textField1.setEditable(false);
/*  826 */     this.textField2.setEditable(false);
/*  827 */     this.textField3.setEditable(false);
/*  828 */     this.textField4.setEditable(false);
/*  829 */     this.managerCheckBox.setEnabled(false);
/*      */ 
/*  831 */     this.submitButton.setVisible(false);
/*  832 */     this.deleteButton.setVisible(false);
/*  833 */     this.permissionButton.setVisible(false);
/*  834 */     this.addUserButton.setVisible(false);
/*  835 */     this.removeUserButton.setVisible(false);
/*  836 */     this.removePermissionButton.setVisible(false);
/*      */   }
/*      */ 
/*      */   private void initComponents()
/*      */   {
/*  841 */     this.headerLabel = new JLabel();
/*  842 */     this.label1 = new JLabel();
/*  843 */     this.textField1 = new JTextField();
/*  844 */     this.label2 = new JLabel();
/*  845 */     this.textField2 = new JTextField();
/*  846 */     this.label3 = new JLabel();
/*  847 */     this.textField3 = new JTextField();
/*  848 */     this.label4 = new JLabel();
/*  849 */     this.textField4 = new JTextField();
/*  850 */     this.label5 = new JLabel();
/*  851 */     this.managerCheckBox = new JCheckBox();
/*  852 */     this.submitButton = new JButton();
/*  853 */     this.deleteButton = new JButton();
/*  854 */     this.permissionsScrollPane = new JScrollPane();
/*  855 */     this.permissionsTable = new JTable();
/*  856 */     this.permissionsLabel = new JLabel();
/*  857 */     this.scrollPane1Label = new JLabel();
/*  858 */     this.scrollPane1 = new JScrollPane();
/*  859 */     this.table1 = new JTable();
/*  860 */     this.borrowedLabel = new JLabel();
/*  861 */     this.borrowedScrollPane = new JScrollPane();
/*  862 */     this.borrowedTable = new JTable();
/*  863 */     this.permissionButton = new JButton();
/*  864 */     this.addUserButton = new JButton();
/*  865 */     this.removePermissionButton = new JButton();
/*  866 */     this.removeUserButton = new JButton();
/*  867 */     this.typeLabel = new JLabel();
/*  868 */     this.typeComboBox = new JComboBox();
/*      */ 
/*  870 */     this.headerLabel.setText("Edit");
/*      */ 
/*  872 */     this.label1.setText("Username");
/*      */ 
/*  874 */     this.label2.setText("First Name");
/*      */ 
/*  876 */     this.label3.setText("Last Name");
/*      */ 
/*  878 */     this.label4.setText("Password");
/*      */ 
/*  880 */     this.label5.setText("Manager?");
/*      */ 
/*  882 */     this.submitButton.setText("Submit");
/*      */ 
/*  884 */     this.deleteButton.setText("Delete");
/*      */ 
/*  886 */     this.permissionsTable.setModel(new DefaultTableModel(new Object[][] { { null }, { null }, { null }, { null } }, new String[] { "Type" })
/*      */     {
/*  900 */       Class[] types = { String.class };
/*      */ 
/*  904 */       boolean[] canEdit = { false };
/*      */ 
/*      */       public Class getColumnClass(int columnIndex)
/*      */       {
/*  911 */         return this.types[columnIndex];
/*      */       }
/*      */ 
/*      */       public boolean isCellEditable(int rowIndex, int columnIndex)
/*      */       {
/*  916 */         return this.canEdit[columnIndex];
/*      */       }
/*      */     });
/*  919 */     this.permissionsScrollPane.setViewportView(this.permissionsTable);
/*  920 */     this.permissionsTable.getColumnModel().getColumn(0).setResizable(false);
/*      */ 
/*  922 */     this.permissionsLabel.setText("Permissions");
/*      */ 
/*  924 */     this.scrollPane1Label.setText("Reserved");
/*      */ 
/*  926 */     this.table1.setModel(new DefaultTableModel(new Object[][] { { null, null, null }, { null, null, null }, { null, null, null } }, new String[] { "Tag Number", "Type", "Model" })
/*      */     {
/*  939 */       Class[] types = { Long.class, String.class, String.class };
/*      */ 
/*  943 */       boolean[] canEdit = { false, false, false };
/*      */ 
/*      */       public Class getColumnClass(int columnIndex)
/*      */       {
/*  950 */         return this.types[columnIndex];
/*      */       }
/*      */ 
/*      */       public boolean isCellEditable(int rowIndex, int columnIndex)
/*      */       {
/*  955 */         return this.canEdit[columnIndex];
/*      */       }
/*      */     });
/*  958 */     this.scrollPane1.setViewportView(this.table1);
/*  959 */     this.table1.getColumnModel().getColumn(0).setResizable(false);
/*  960 */     this.table1.getColumnModel().getColumn(1).setResizable(false);
/*  961 */     this.table1.getColumnModel().getColumn(2).setResizable(false);
/*      */ 
/*  963 */     this.borrowedLabel.setText("Borrowed");
/*      */ 
/*  965 */     this.borrowedTable.setModel(new DefaultTableModel(new Object[][] { { null, null, null }, { null, null, null }, { null, null, null } }, new String[] { "Tag Number", "Type", "Model" })
/*      */     {
/*  978 */       Class[] types = { Long.class, String.class, String.class };
/*      */ 
/*  982 */       boolean[] canEdit = { false, false, false };
/*      */ 
/*      */       public Class getColumnClass(int columnIndex)
/*      */       {
/*  989 */         return this.types[columnIndex];
/*      */       }
/*      */ 
/*      */       public boolean isCellEditable(int rowIndex, int columnIndex)
/*      */       {
/*  994 */         return this.canEdit[columnIndex];
/*      */       }
/*      */     });
/*  997 */     this.borrowedTable.getTableHeader().setReorderingAllowed(false);
/*  998 */     this.borrowedScrollPane.setViewportView(this.borrowedTable);
/*  999 */     this.borrowedTable.getColumnModel().getColumn(0).setResizable(false);
/* 1000 */     this.borrowedTable.getColumnModel().getColumn(1).setResizable(false);
/* 1001 */     this.borrowedTable.getColumnModel().getColumn(2).setResizable(false);
/*      */ 
/* 1003 */     this.permissionButton.setText("Add Permission");
/*      */ 
/* 1005 */     this.addUserButton.setText("Add User");
/*      */ 
/* 1007 */     this.removePermissionButton.setText("Remove Permission");
/*      */ 
/* 1009 */     this.removeUserButton.setText("Remove User");
/*      */ 
/* 1011 */     this.typeLabel.setText("Eq. Type");
/*      */ 
/* 1013 */     GroupLayout layout = new GroupLayout(this);
/* 1014 */     setLayout(layout);
/* 1015 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.headerLabel).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.scrollPane1Label).addComponent(this.scrollPane1).addComponent(this.borrowedLabel).addComponent(this.borrowedScrollPane)))).addGap(0, 0, 32767)).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(layout.createSequentialGroup().addComponent(this.label1).addGap(18, 18, 18).addComponent(this.textField1, -2, 245, -2)).addGroup(layout.createSequentialGroup().addComponent(this.label2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.textField2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.submitButton, -1, -1, 32767).addComponent(this.deleteButton, -1, -1, 32767))).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(layout.createSequentialGroup().addComponent(this.addUserButton, -2, 116, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.removeUserButton, -1, -1, 32767)).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(layout.createSequentialGroup().addComponent(this.label5).addGap(34, 34, 34).addComponent(this.managerCheckBox)).addComponent(this.permissionButton)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.removePermissionButton)).addGroup(layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.permissionsLabel).addGap(6, 6, 6))))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.permissionsScrollPane, -2, 200, -2)).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.label3).addComponent(this.label4)).addGap(12, 12, 12).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.textField3, GroupLayout.Alignment.LEADING, -1, 246, 32767).addComponent(this.textField4, GroupLayout.Alignment.LEADING))).addGroup(layout.createSequentialGroup().addComponent(this.typeLabel).addGap(18, 18, 18).addComponent(this.typeComboBox, -2, 182, -2))).addGap(0, 0, 32767))).addContainerGap()));
/*      */ 
/* 1085 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.headerLabel).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.label1).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.textField1, -2, -1, -2).addComponent(this.submitButton))).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.label2).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.textField2, -2, -1, -2).addComponent(this.deleteButton))).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.label3).addComponent(this.textField3, -2, -1, -2)).addGap(19, 19, 19).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.label4).addComponent(this.textField4, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.typeLabel).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.permissionsScrollPane, -2, 98, -2).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.managerCheckBox).addComponent(this.permissionsLabel).addComponent(this.label5)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.permissionButton).addComponent(this.removePermissionButton)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.addUserButton).addComponent(this.removeUserButton)))).addGap(8, 8, 8).addComponent(this.scrollPane1Label).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.scrollPane1, -2, 75, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.borrowedLabel).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.borrowedScrollPane, -2, 79, -2)).addComponent(this.typeComboBox, -2, -1, -2)).addGap(0, 0, 32767)));
/*      */   }
/*      */ }

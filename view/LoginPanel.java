/*     */ package view;
/*     */ 
/*     */ import control.EDS;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JPasswordField;
/*     */ import javax.swing.JTextField;
/*     */ import model.Employee;
/*     */ 
/*     */ public class LoginPanel extends JPanel
/*     */   implements ActionListener
/*     */ {
/*  12 */   final int textboxSize = 100;
/*     */   EDS eds;
/*     */   MainFrame parentFrame;
/*     */   Employee currentEmployee;
/*     */   JLabel userNameLabel;
/*     */   JTextField userNameField;
/*     */   JLabel passwordLabel;
/*     */   JPasswordField passwordField;
/*     */   JButton loginButton;
/*     */   JButton closeButton;
/*     */ 
/*     */   public LoginPanel(MainFrame parent, EDS eds)
/*     */   {
/*  35 */     this.eds = eds;
/*  36 */     this.parentFrame = parent;
/*  37 */     this.userNameLabel = new JLabel("Username");
/*  38 */     this.userNameField = new JTextField(35);
/*  39 */     this.passwordLabel = new JLabel("Password");
/*  40 */     this.passwordField = new JPasswordField(35);
/*  41 */     this.loginButton = new JButton("Login");
/*  42 */     this.loginButton.addActionListener(this);
/*  43 */     this.closeButton = new JButton("Quit");
/*  44 */     this.closeButton.addActionListener(this);
/*     */ 
/*  46 */     this.currentEmployee = null;
/*     */ 
/*  48 */     GroupLayout layout = new GroupLayout(this);
/*  49 */     setLayout(layout);
/*  50 */     layout.setAutoCreateGaps(true);
/*  51 */     layout.setAutoCreateContainerGaps(true);
/*  52 */     layout.setHorizontalGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(this.userNameLabel, -2, -1, -2).addComponent(this.passwordLabel, -2, -1, -2).addComponent(this.loginButton, -2, -1, -2)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(this.userNameField, 100, -1, 100).addComponent(this.passwordField, 100, -1, 100).addComponent(this.closeButton, -2, -1, -2)));
/*     */ 
/*  69 */     layout.setVerticalGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(this.userNameLabel, -2, -1, -2).addComponent(this.userNameField, -2, -1, -2)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(this.passwordLabel, -2, -1, -2).addComponent(this.passwordField, -2, -1, -2)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(this.loginButton, -2, -1, -2).addComponent(this.closeButton, -2, -1, -2)));
/*     */   }
/*     */ 
/*     */   public void actionPerformed(ActionEvent event)
/*     */   {
/*  92 */     if (event.getSource().equals(this.loginButton))
/*     */     {
/*  94 */       String password = String.valueOf(this.passwordField.getPassword());
/*  95 */       if (this.eds.validateLogin(this.userNameField.getText(), password))
/*     */       {
/*  97 */         this.parentFrame.buildUI();
/*     */       }
/*     */       else
/*     */       {
/* 101 */         JOptionPane.showMessageDialog(this.parentFrame, "Incorrect username or password.");
/* 102 */         this.userNameField.setText("");
/* 103 */         this.passwordField.setText("");
/*     */       }
/*     */     }
/*     */ 
/* 107 */     if (event.getSource().equals(this.closeButton))
/*     */     {
/* 109 */       this.parentFrame.dispose();
/*     */     }
/*     */   }
/*     */ }

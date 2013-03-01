/*     */ package model;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.GenerationType;
/*     */ import javax.persistence.Id;
/*     */ 
/*     */ @Entity
/*     */ public class Employee
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */ 
/*     */   @Id
/*     */   @GeneratedValue(strategy=GenerationType.AUTO)
/*     */   private String username;
/*     */   private String password;
/*     */   private String firstName;
/*     */   private String lastName;
/*     */   private boolean manager;
/*     */ 
/*     */   public static long getSerialVersionUID()
/*     */   {
/*  27 */     return 1L;
/*     */   }
/*     */ 
/*     */   public Employee()
/*     */   {
/*     */   }
/*     */ 
/*     */   public Employee(String username, String password, String firstName, String lastName, boolean manager)
/*     */   {
/*  44 */     this.username = username;
/*  45 */     this.password = password;
/*  46 */     this.firstName = firstName;
/*  47 */     this.lastName = lastName;
/*  48 */     this.manager = manager;
/*     */   }
/*     */ 
/*     */   public String toString()
/*     */   {
/*  54 */     return "model.Employee[ username=" + this.username + " ]";
/*     */   }
/*     */ 
/*     */   public String getUsername()
/*     */   {
/*  62 */     return this.username;
/*     */   }
/*     */ 
/*     */   public void setUsername(String username)
/*     */   {
/*  70 */     this.username = username;
/*     */   }
/*     */ 
/*     */   public String getPassword()
/*     */   {
/*  78 */     return this.password;
/*     */   }
/*     */ 
/*     */   public void setPassword(String password)
/*     */   {
/*  86 */     this.password = password;
/*     */   }
/*     */ 
/*     */   public String getFirstName()
/*     */   {
/*  94 */     return this.firstName;
/*     */   }
/*     */ 
/*     */   public void setFirstName(String firstName)
/*     */   {
/* 102 */     this.firstName = firstName;
/*     */   }
/*     */ 
/*     */   public String getLastName()
/*     */   {
/* 110 */     return this.lastName;
/*     */   }
/*     */ 
/*     */   public void setLastName(String lastName)
/*     */   {
/* 118 */     this.lastName = lastName;
/*     */   }
/*     */ 
/*     */   public boolean isManager()
/*     */   {
/* 126 */     return this.manager;
/*     */   }
/*     */ 
/*     */   public void setManager(boolean manager)
/*     */   {
/* 134 */     this.manager = manager;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object object)
/*     */   {
/* 141 */     if (!(object instanceof Employee))
/*     */     {
/* 143 */       return false;
/*     */     }
/* 145 */     Employee other = (Employee)object;
/* 146 */     if (((getUsername() == null) && (other.getUsername() != null)) || ((getUsername() != null) && (!this.username.equals(other.username))))
/*     */     {
/* 148 */       return false;
/*     */     }
/* 150 */     return true;
/*     */   }
/*     */ }

/* Location:           /Users/Rusty-Mac/Downloads/ALOC_EDS/ALOC_v2.jar
 * Qualified Name:     model.Employee
 * JD-Core Version:    0.6.2
 */
/*     */ package model;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.GenerationType;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.ManyToMany;
/*     */ import javax.persistence.OneToMany;
/*     */ 
/*     */ @Entity
/*     */ public class EDSUser
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */ 
/*     */   @Id
/*     */   @GeneratedValue(strategy=GenerationType.AUTO)
/*     */   private Integer idNumber;
/*     */   private String password;
/*     */   private String firstName;
/*     */   private String lastName;
/*     */ 
/*     */   @ManyToMany(mappedBy="users")
/*     */   private Set<EquipmentType> permissions;
/*     */ 
/*     */   @OneToMany(mappedBy="reservedBy")
/*     */   private Set<Equipment> reservations;
/*     */ 
/*     */   @OneToMany(mappedBy="borrowedBy")
/*     */   private Set<Equipment> borrowedEquipment;
/*     */ 
/*     */   @ManyToMany(mappedBy="users", cascade={javax.persistence.CascadeType.PERSIST})
/*     */   private Set<UserGroup> groups;
/*     */ 
/*     */   public EDSUser()
/*     */   {
/*     */   }
/*     */ 
/*     */   public EDSUser(int idNumber, String firstName, String lastName, String password)
/*     */   {
/*  48 */     this.idNumber = Integer.valueOf(idNumber);
/*  49 */     this.firstName = firstName;
/*  50 */     this.lastName = lastName;
/*  51 */     this.password = password;
/*  52 */     this.permissions = new HashSet();
/*  53 */     this.reservations = new HashSet();
/*  54 */     this.borrowedEquipment = new HashSet();
/*  55 */     this.groups = new HashSet();
/*     */   }
/*     */ 
/*     */   public Integer getIdNumber()
/*     */   {
/*  60 */     return this.idNumber;
/*     */   }
/*     */ 
/*     */   public void setIdNumber(Integer idNumber)
/*     */   {
/*  65 */     this.idNumber = idNumber;
/*     */   }
/*     */ 
/*     */   public int hashCode()
/*     */   {
/*  71 */     int hash = 0;
/*  72 */     hash += (this.idNumber != null ? this.idNumber.hashCode() : 0);
/*  73 */     return hash;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object object)
/*     */   {
/*  80 */     if (!(object instanceof EDSUser))
/*     */     {
/*  82 */       return false;
/*     */     }
/*  84 */     EDSUser other = (EDSUser)object;
/*  85 */     if (((this.idNumber == null) && (other.idNumber != null)) || ((this.idNumber != null) && (!this.idNumber.equals(other.idNumber))))
/*     */     {
/*  87 */       return false;
/*     */     }
/*  89 */     return true;
/*     */   }
/*     */ 
/*     */   public String toString()
/*     */   {
/*  95 */     return "entities.User[ idNumber=" + this.idNumber + " ]";
/*     */   }
/*     */ 
/*     */   public String getPassword()
/*     */   {
/* 103 */     return this.password;
/*     */   }
/*     */ 
/*     */   public void setPassword(String password)
/*     */   {
/* 111 */     this.password = password;
/*     */   }
/*     */ 
/*     */   public String getFirstName()
/*     */   {
/* 119 */     return this.firstName;
/*     */   }
/*     */ 
/*     */   public void setFirstName(String firstName)
/*     */   {
/* 127 */     this.firstName = firstName;
/*     */   }
/*     */ 
/*     */   public String getLastName()
/*     */   {
/* 135 */     return this.lastName;
/*     */   }
/*     */ 
/*     */   public void setLastName(String lastName)
/*     */   {
/* 143 */     this.lastName = lastName;
/*     */   }
/*     */ 
/*     */   public Set<EquipmentType> getPermissions()
/*     */   {
/* 151 */     return this.permissions;
/*     */   }
/*     */ 
/*     */   public void setPermissions(Set<EquipmentType> permissions)
/*     */   {
/* 159 */     this.permissions = permissions;
/*     */   }
/*     */ 
/*     */   public Set<Equipment> getReservations()
/*     */   {
/* 167 */     return this.reservations;
/*     */   }
/*     */ 
/*     */   public void setReservations(Set<Equipment> reservations)
/*     */   {
/* 175 */     this.reservations = reservations;
/*     */   }
/*     */ 
/*     */   public Set<Equipment> getBorrowedEquipment()
/*     */   {
/* 183 */     return this.borrowedEquipment;
/*     */   }
/*     */ 
/*     */   public void setBorrowedEquipment(Set<Equipment> borrowedEquipment)
/*     */   {
/* 191 */     this.borrowedEquipment = borrowedEquipment;
/*     */   }
/*     */ 
/*     */   public Set<UserGroup> getGroups()
/*     */   {
/* 199 */     return this.groups;
/*     */   }
/*     */ 
/*     */   public void setGroups(Set<UserGroup> groups)
/*     */   {
/* 207 */     this.groups = groups;
/*     */   }
/*     */ }

/* Location:           /Users/Rusty-Mac/Downloads/ALOC_EDS/ALOC_v2.jar
 * Qualified Name:     model.EDSUser
 * JD-Core Version:    0.6.2
 */
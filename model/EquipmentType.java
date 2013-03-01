/*     */ package model;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Set;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.GenerationType;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.JoinTable;
/*     */ import javax.persistence.ManyToMany;
/*     */ 
/*     */ @Entity
/*     */ public class EquipmentType
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */ 
/*     */   @Id
/*     */   @GeneratedValue(strategy=GenerationType.AUTO)
/*     */   private String type;
/*     */ 
/*     */   @ManyToMany(cascade={javax.persistence.CascadeType.PERSIST})
/*     */   @JoinTable(name="PERMISSIONTOUSER", joinColumns={@javax.persistence.JoinColumn(name="permissiontype", referencedColumnName="type")}, inverseJoinColumns={@javax.persistence.JoinColumn(name="userIdNumber", referencedColumnName="idNumber")})
/*     */   private Set<EDSUser> users;
/*     */ 
/*     */   @ManyToMany(cascade={javax.persistence.CascadeType.PERSIST})
/*     */   @JoinTable(name="PERMISSIONTOGROUP", joinColumns={@javax.persistence.JoinColumn(name="permissiontype", referencedColumnName="type")}, inverseJoinColumns={@javax.persistence.JoinColumn(name="groupName", referencedColumnName="name")})
/*     */   private Set<UserGroup> groups;
/*     */ 
/*     */   public static long getSerialVersionUID()
/*     */   {
/*  32 */     return 1L;
/*     */   }
/*     */ 
/*     */   public EquipmentType()
/*     */   {
/*     */   }
/*     */ 
/*     */   public EquipmentType(String type)
/*     */   {
/*  55 */     this.type = type;
/*     */   }
/*     */ 
/*     */   public int hashCode()
/*     */   {
/*  61 */     int hash = 0;
/*  62 */     hash += (getType() != null ? getType().hashCode() : 0);
/*  63 */     return hash;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object object)
/*     */   {
/*  70 */     if (!(object instanceof EquipmentType))
/*     */     {
/*  72 */       return false;
/*     */     }
/*  74 */     EquipmentType other = (EquipmentType)object;
/*  75 */     if (((getType() == null) && (other.getType() != null)) || ((getType() != null) && (!this.type.equals(other.type))))
/*     */     {
/*  77 */       return false;
/*     */     }
/*  79 */     return true;
/*     */   }
/*     */ 
/*     */   public String toString()
/*     */   {
/*  85 */     return getType();
/*     */   }
/*     */ 
/*     */   public String getType()
/*     */   {
/*  93 */     return this.type;
/*     */   }
/*     */ 
/*     */   public void setType(String type)
/*     */   {
/* 101 */     this.type = type;
/*     */   }
/*     */ 
/*     */   public Set<EDSUser> getUsers()
/*     */   {
/* 109 */     return this.users;
/*     */   }
/*     */ 
/*     */   public void setUsers(Set<EDSUser> users)
/*     */   {
/* 117 */     this.users = users;
/*     */   }
/*     */ 
/*     */   public Set<UserGroup> getGroups()
/*     */   {
/* 125 */     return this.groups;
/*     */   }
/*     */ 
/*     */   public void setGroups(Set<UserGroup> groups)
/*     */   {
/* 133 */     this.groups = groups;
/*     */   }
/*     */ }

/* Location:           /Users/Rusty-Mac/Downloads/ALOC_EDS/ALOC_v2.jar
 * Qualified Name:     model.EquipmentType
 * JD-Core Version:    0.6.2
 */
/*     */ package model;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.GenerationType;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.JoinTable;
/*     */ import javax.persistence.ManyToMany;
/*     */ 
/*     */ @Entity
/*     */ public class UserGroup
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */ 
/*     */   @Id
/*     */   @GeneratedValue(strategy=GenerationType.AUTO)
/*     */   private String name;
/*     */ 
/*     */   @ManyToMany(cascade={javax.persistence.CascadeType.PERSIST})
/*     */   @JoinTable(name="USERTOGROUP", joinColumns={@javax.persistence.JoinColumn(name="groupname", referencedColumnName="name")}, inverseJoinColumns={@javax.persistence.JoinColumn(name="userIdNumber", referencedColumnName="idNumber")})
/*     */   private Set<EDSUser> users;
/*     */ 
/*     */   @ManyToMany(mappedBy="groups")
/*     */   private Set<EquipmentType> permissions;
/*     */ 
/*     */   public static long getSerialVersionUID()
/*     */   {
/*  33 */     return 1L;
/*     */   }
/*     */ 
/*     */   public UserGroup()
/*     */   {
/*     */   }
/*     */ 
/*     */   public UserGroup(String name)
/*     */   {
/*  53 */     this.name = name;
/*  54 */     this.users = new HashSet();
/*  55 */     this.permissions = new HashSet();
/*     */   }
/*     */ 
/*     */   public String getName()
/*     */   {
/*  60 */     return this.name;
/*     */   }
/*     */ 
/*     */   public void setName(String name)
/*     */   {
/*  65 */     this.name = name;
/*     */   }
/*     */ 
/*     */   public int hashCode()
/*     */   {
/*  71 */     int hash = 0;
/*  72 */     hash += (getName() != null ? getName().hashCode() : 0);
/*  73 */     return hash;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object object)
/*     */   {
/*  80 */     if (!(object instanceof UserGroup))
/*     */     {
/*  82 */       return false;
/*     */     }
/*  84 */     UserGroup other = (UserGroup)object;
/*  85 */     if (((getName() == null) && (other.getName() != null)) || ((getName() != null) && (!this.name.equals(other.name))))
/*     */     {
/*  87 */       return false;
/*     */     }
/*  89 */     return true;
/*     */   }
/*     */ 
/*     */   public String toString()
/*     */   {
/*  95 */     return "entities.UserGroup[ name=" + getName() + " ]";
/*     */   }
/*     */ 
/*     */   public Set<EDSUser> getUsers()
/*     */   {
/* 103 */     return this.users;
/*     */   }
/*     */ 
/*     */   public void setUsers(Set<EDSUser> users)
/*     */   {
/* 111 */     this.users = users;
/*     */   }
/*     */ 
/*     */   public Set<EquipmentType> getPermissions()
/*     */   {
/* 119 */     return this.permissions;
/*     */   }
/*     */ 
/*     */   public void setPermissions(Set<EquipmentType> permissions)
/*     */   {
/* 127 */     this.permissions = permissions;
/*     */   }
/*     */ }

/* Location:           /Users/Rusty-Mac/Downloads/ALOC_EDS/ALOC_v2.jar
 * Qualified Name:     model.UserGroup
 * JD-Core Version:    0.6.2
 */
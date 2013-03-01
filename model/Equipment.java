/*     */ package model;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.GenerationType;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.ManyToOne;
/*     */ import javax.persistence.Temporal;
/*     */ import javax.persistence.TemporalType;
/*     */ 
/*     */ @Entity
/*     */ public class Equipment
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */ 
/*     */   @Id
/*     */   @GeneratedValue(strategy=GenerationType.AUTO)
/*     */   private Long tagNumber;
/*     */   private EquipmentType type;
/*     */   private String model;
/*     */ 
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date dueDate;
/*     */ 
/*     */   @ManyToOne
/*     */   @JoinColumn(name="reservedByID")
/*     */   private EDSUser reservedBy;
/*     */ 
/*     */   @ManyToOne
/*     */   @JoinColumn(name="borrowedByID")
/*     */   private EDSUser borrowedBy;
/*     */   private boolean reserved;
/*     */   private boolean borrowed;
/*     */ 
/*     */   public static long getSerialVersionUID()
/*     */   {
/*  32 */     return 1L;
/*     */   }
/*     */ 
/*     */   public Equipment()
/*     */   {
/*     */   }
/*     */ 
/*     */   public Equipment(Long tagNumber, EquipmentType type, String model)
/*     */   {
/*  57 */     this.tagNumber = tagNumber;
/*  58 */     this.type = type;
/*  59 */     this.model = model;
/*  60 */     this.reserved = false;
/*  61 */     this.borrowed = false;
/*  62 */     this.borrowedBy = null;
/*  63 */     this.reservedBy = null;
/*  64 */     this.dueDate = null;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object object)
/*     */   {
/*  70 */     if (!(object instanceof Equipment))
/*     */     {
/*  72 */       return false;
/*     */     }
/*  74 */     Equipment other = (Equipment)object;
/*  75 */     if (((getTagNumber() == null) && (other.getTagNumber() != null)) || ((getTagNumber() != null) && (!this.tagNumber.equals(other.tagNumber))))
/*     */     {
/*  77 */       return false;
/*     */     }
/*  79 */     return true;
/*     */   }
/*     */ 
/*     */   public String toString()
/*     */   {
/*  85 */     return "model.Equipment[ tagNumber=" + getTagNumber() + " ]";
/*     */   }
/*     */ 
/*     */   public Long getTagNumber()
/*     */   {
/*  93 */     return this.tagNumber;
/*     */   }
/*     */ 
/*     */   public void setTagNumber(Long tagNumber)
/*     */   {
/* 101 */     this.tagNumber = tagNumber;
/*     */   }
/*     */ 
/*     */   public EquipmentType getType()
/*     */   {
/* 109 */     return this.type;
/*     */   }
/*     */ 
/*     */   public void setType(EquipmentType type)
/*     */   {
/* 117 */     this.type = type;
/*     */   }
/*     */ 
/*     */   public String getModel()
/*     */   {
/* 125 */     return this.model;
/*     */   }
/*     */ 
/*     */   public void setModel(String model)
/*     */   {
/* 133 */     this.model = model;
/*     */   }
/*     */ 
/*     */   public Date getDueDate()
/*     */   {
/* 141 */     return this.dueDate;
/*     */   }
/*     */ 
/*     */   public void setDueDate(Date dueDate)
/*     */   {
/* 149 */     this.dueDate = dueDate;
/*     */   }
/*     */ 
/*     */   public EDSUser getReservedBy()
/*     */   {
/* 157 */     return this.reservedBy;
/*     */   }
/*     */ 
/*     */   public void setReservedBy(EDSUser reservedBy)
/*     */   {
/* 165 */     this.reservedBy = reservedBy;
/*     */   }
/*     */ 
/*     */   public EDSUser getBorrowedBy()
/*     */   {
/* 173 */     return this.borrowedBy;
/*     */   }
/*     */ 
/*     */   public void setBorrowedBy(EDSUser borrowedBy)
/*     */   {
/* 181 */     this.borrowedBy = borrowedBy;
/*     */   }
/*     */ 
/*     */   public boolean isReserved()
/*     */   {
/* 189 */     return this.reserved;
/*     */   }
/*     */ 
/*     */   public void setReserved(boolean reserved)
/*     */   {
/* 197 */     this.reserved = reserved;
/*     */   }
/*     */ 
/*     */   public boolean isBorrowed()
/*     */   {
/* 205 */     return this.borrowed;
/*     */   }
/*     */ 
/*     */   public void setBorrowed(boolean borrowed)
/*     */   {
/* 213 */     this.borrowed = borrowed;
/*     */   }
/*     */ }

/* Location:           /Users/Rusty-Mac/Downloads/ALOC_EDS/ALOC_v2.jar
 * Qualified Name:     model.Equipment
 * JD-Core Version:    0.6.2
 */
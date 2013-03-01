/*     */ package control;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import javax.persistence.EntityManager;
/*     */ import javax.persistence.EntityManagerFactory;
/*     */ import javax.persistence.EntityTransaction;
/*     */ import javax.persistence.Persistence;
/*     */ import javax.persistence.Query;
/*     */ import javax.swing.JOptionPane;
/*     */ import model.EDSUser;
/*     */ import model.Employee;
/*     */ import model.Equipment;
/*     */ import model.EquipmentType;
/*     */ import model.UserGroup;
/*     */ 
/*     */ public class EDS
/*     */ {
/*     */   private Employee currentLogin;
/*     */   private EntityManagerFactory emf;
/*     */ 
/*     */   public EDS()
/*     */   {
/*  30 */     this.emf = Persistence.createEntityManagerFactory("ALOCPU");
/*  31 */     EntityManager em = this.emf.createEntityManager();
/*     */ 
/*  34 */     em.getTransaction().begin();
/*  35 */     String selectSQL = "select e from Employee e";
/*  36 */     Query query = em.createQuery(selectSQL);
/*  37 */     List employees = query.getResultList();
/*     */ 
/*  39 */     if (employees.isEmpty())
/*     */     {
/*  41 */       Employee newAdmin = new Employee("admin", "admin", "Admin", "Admin", true);
/*  42 */       em.persist(newAdmin);
/*     */     }
/*     */ 
/*  45 */     em.getTransaction().commit();
/*  46 */     em.close();
/*     */   }
/*     */ 
/*     */   public Object[][] viewUserList()
/*     */   {
/*  51 */     EntityManager em = this.emf.createEntityManager();
/*  52 */     String selectSQL = "select u from EDSUser u";
/*  53 */     Query query = em.createQuery(selectSQL);
/*  54 */     List users = query.getResultList();
/*     */ 
/*  57 */     Object[][] table = new Object[users.size()][3];
/*  58 */     for (int i = 0; i < users.size(); i++)
/*     */     {
/*  60 */       EDSUser currUser = (EDSUser)users.get(i);
/*  61 */       table[i][0] = currUser.getIdNumber();
/*  62 */       table[i][1] = currUser.getFirstName();
/*  63 */       table[i][2] = currUser.getLastName();
/*     */     }
/*  65 */     return table;
/*     */   }
/*     */ 
/*     */   public Object[][] viewEquipmentList()
/*     */   {
/*  70 */     EntityManager em = this.emf.createEntityManager();
/*  71 */     String selectSQL = "select e from Equipment e";
/*  72 */     Query query = em.createQuery(selectSQL);
/*  73 */     List equipment = query.getResultList();
/*     */ 
/*  76 */     Object[][] table = new Object[equipment.size()][3];
/*  77 */     for (int i = 0; i < equipment.size(); i++)
/*     */     {
/*  79 */       Equipment currEquipment = (Equipment)equipment.get(i);
/*  80 */       table[i][0] = currEquipment.getTagNumber();
/*  81 */       table[i][1] = currEquipment.getType();
/*  82 */       table[i][2] = currEquipment.getModel();
/*     */     }
/*  84 */     return table;
/*     */   }
/*     */ 
/*     */   public Object[][] viewEmployeeList()
/*     */   {
/*  89 */     EntityManager em = this.emf.createEntityManager();
/*  90 */     String selectSQL = "select e from Employee e";
/*  91 */     Query query = em.createQuery(selectSQL);
/*  92 */     List employees = query.getResultList();
/*     */ 
/*  95 */     Object[][] table = new Object[employees.size()][4];
/*  96 */     for (int i = 0; i < employees.size(); i++)
/*     */     {
/*  98 */       Employee currEmployee = (Employee)employees.get(i);
/*  99 */       table[i][0] = currEmployee.getUsername();
/* 100 */       table[i][1] = currEmployee.getFirstName();
/* 101 */       table[i][2] = currEmployee.getLastName();
/* 102 */       table[i][3] = (currEmployee.isManager() ? "Yes" : "No");
/*     */     }
/* 104 */     return table;
/*     */   }
/*     */ 
/*     */   public Object[][] viewUserGroupList()
/*     */   {
/* 109 */     EntityManager em = this.emf.createEntityManager();
/* 110 */     String selectSQL = "select g from UserGroup g";
/* 111 */     Query query = em.createQuery(selectSQL);
/* 112 */     List groups = query.getResultList();
/*     */ 
/* 115 */     Object[][] table = new Object[groups.size()][1];
/* 116 */     for (int i = 0; i < groups.size(); i++)
/*     */     {
/* 118 */       UserGroup currGroup = (UserGroup)groups.get(i);
/* 119 */       table[i][0] = currGroup.getName();
/*     */     }
/* 121 */     return table;
/*     */   }
/*     */ 
/*     */   public boolean validateLogin(String username, String password)
/*     */   {
/* 126 */     EntityManager em = this.emf.createEntityManager();
/* 127 */     Employee login = (Employee)em.find(Employee.class, username);
/* 128 */     if ((login != null) && (login.getPassword().equals(password)))
/*     */     {
/* 130 */       this.currentLogin = login;
/* 131 */       return true;
/*     */     }
/* 133 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean addUser(int idNumber, String firstName, String lastName, String password)
/*     */   {
/* 138 */     EntityManager em = this.emf.createEntityManager();
/* 139 */     EDSUser user = new EDSUser(idNumber, firstName, lastName, password);
/* 140 */     if (em.find(EDSUser.class, Integer.valueOf(idNumber)) != null)
/*     */     {
/* 142 */       return false;
/*     */     }
/* 144 */     persist(user);
/* 145 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean addEquipment(Long tagNumber, EquipmentType type, String model)
/*     */   {
/* 150 */     EntityManager em = this.emf.createEntityManager();
/* 151 */     if (em.find(Equipment.class, tagNumber) != null)
/*     */     {
/* 153 */       return false;
/*     */     }
/* 155 */     Equipment eq = new Equipment(tagNumber, type, model);
/* 156 */     persist(eq);
/* 157 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean addUserGroup(String name)
/*     */   {
/* 162 */     EntityManager em = this.emf.createEntityManager();
/* 163 */     if (em.find(UserGroup.class, name) != null)
/*     */     {
/* 165 */       return false;
/*     */     }
/* 167 */     em.getTransaction().begin();
/* 168 */     UserGroup group = new UserGroup(name);
/* 169 */     persist(group);
/* 170 */     em.getTransaction().commit();
/* 171 */     em.close();
/* 172 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean addEmployee(String username, String password, String firstName, String lastName, boolean manager) {
/* 176 */     EntityManager em = this.emf.createEntityManager();
/* 177 */     if (em.find(Employee.class, username) != null)
/*     */     {
/* 179 */       return false;
/*     */     }
/* 181 */     Employee employee = new Employee(username, password, firstName, lastName, manager);
/* 182 */     persist(employee);
/* 183 */     return true;
/*     */   }
/*     */ 
/*     */   public void persist(Object object)
/*     */   {
/* 188 */     EntityManager em = this.emf.createEntityManager();
/* 189 */     em.getTransaction().begin();
/*     */     try
/*     */     {
/* 192 */       em.persist(object);
/* 193 */       em.getTransaction().commit();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 197 */       e.printStackTrace();
/* 198 */       em.getTransaction().rollback();
/*     */     }
/*     */     finally
/*     */     {
/* 202 */       em.close();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void update(Object object)
/*     */   {
/* 208 */     EntityManager em = this.emf.createEntityManager();
/* 209 */     em.getTransaction().begin();
/*     */     try
/*     */     {
/* 212 */       em.merge(object);
/* 213 */       em.getTransaction().commit();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 217 */       e.printStackTrace();
/* 218 */       em.getTransaction().rollback();
/*     */     }
/*     */     finally
/*     */     {
/* 222 */       em.close();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void signOutEquipment(int userId, long tagNumber)
/*     */   {
/* 228 */     EntityManager em = this.emf.createEntityManager();
/* 229 */     em.getTransaction().begin();
/* 230 */     EDSUser user = (EDSUser)em.find(EDSUser.class, Integer.valueOf(userId));
/* 231 */     if (user == null)
/*     */     {
/* 233 */       em.getTransaction().rollback();
/* 234 */       em.close();
/* 235 */       JOptionPane.showMessageDialog(null, "That user ID does not exist");
/* 236 */       return;
/*     */     }
/* 238 */     Equipment eq = (Equipment)em.find(Equipment.class, Long.valueOf(tagNumber));
/* 239 */     if (eq == null)
/*     */     {
/* 241 */       em.getTransaction().rollback();
/* 242 */       em.close();
/* 243 */       JOptionPane.showMessageDialog(null, "That tag number does not exist.");
/* 244 */       return;
/*     */     }
/*     */ 
/* 247 */     ArrayList permissions = new ArrayList(user.getPermissions());
/* 248 */     ArrayList currBorrowed = new ArrayList(user.getBorrowedEquipment());
/* 249 */     ArrayList groups = new ArrayList(user.getGroups());
/* 250 */     for (int i = 0; i < groups.size(); i++)
/*     */     {
/* 252 */       permissions.addAll(((UserGroup)groups.get(i)).getPermissions());
/*     */     }
/* 254 */     EquipmentType type = eq.getType();
/*     */ 
/* 256 */     if (eq.isBorrowed())
/*     */     {
/* 258 */       em.getTransaction().rollback();
/* 259 */       em.close();
/* 260 */       JOptionPane.showMessageDialog(null, "That equipment is currently unavailable.");
/* 261 */       return;
/*     */     }
/* 263 */     if ((eq.isReserved()) && (!eq.getReservedBy().equals(user)))
/*     */     {
/* 265 */       em.getTransaction().rollback();
/* 266 */       em.close();
/* 267 */       JOptionPane.showMessageDialog(null, "That equipment is reserved by another user.");
/* 268 */       return;
/*     */     }
/* 270 */     if (!permissions.contains(type))
/*     */     {
/* 272 */       em.getTransaction().rollback();
/* 273 */       em.close();
/* 274 */       JOptionPane.showMessageDialog(null, user.getFirstName() + " does not have permission to borrow " + eq.getType());
/* 275 */       return;
/*     */     }
/* 277 */     for (Equipment currEq : user.getBorrowedEquipment())
/*     */     {
/* 279 */       if (eq.getType().equals(currEq.getType()))
/*     */       {
/* 281 */         em.getTransaction().rollback();
/* 282 */         em.close();
/* 283 */         JOptionPane.showMessageDialog(null, "Users cannot borrow multiple items of the same type");
/* 284 */         return;
/*     */       }
/*     */     }
/* 287 */     eq.setBorrowedBy(user);
/* 288 */     eq.setReserved(false);
/* 289 */     eq.setReservedBy(null);
/* 290 */     if (user.getReservations().contains(eq))
/*     */     {
/* 292 */       user.getReservations().remove(eq);
/*     */     }
/* 294 */     Set borrowed = user.getBorrowedEquipment();
/* 295 */     borrowed.add(eq);
/* 296 */     user.setBorrowedEquipment(borrowed);
/* 297 */     eq.setBorrowed(true);
/* 298 */     update(user);
/* 299 */     update(eq);
/* 300 */     JOptionPane.showMessageDialog(null, "Checkout Successful.");
/* 301 */     em.getTransaction().commit();
/* 302 */     em.close();
/*     */   }
/*     */ 
/*     */   public void signInEquipment(long tagNumber)
/*     */   {
/* 307 */     EntityManager em = this.emf.createEntityManager();
/* 308 */     em.getTransaction().begin();
/* 309 */     Equipment eq = (Equipment)em.find(Equipment.class, Long.valueOf(tagNumber));
/* 310 */     if (eq != null)
/*     */     {
/* 312 */       if (!eq.isBorrowed())
/*     */       {
/* 314 */         JOptionPane.showMessageDialog(null, "That item is not checked out.");
/*     */       }
/*     */       else
/*     */       {
/* 318 */         EDSUser user = eq.getBorrowedBy();
/* 319 */         user.getBorrowedEquipment().remove(eq);
/* 320 */         eq.setBorrowed(false);
/* 321 */         eq.setBorrowedBy(null);
/*     */       }
/*     */     }
/* 324 */     em.getTransaction().commit();
/* 325 */     em.close();
/*     */   }
/*     */ 
/*     */   public void cancelReservation(long tagNumber)
/*     */   {
/* 330 */     EntityManager em = this.emf.createEntityManager();
/* 331 */     em.getTransaction().begin();
/* 332 */     Equipment eq = (Equipment)em.find(Equipment.class, Long.valueOf(tagNumber));
/* 333 */     if (eq != null)
/*     */     {
/* 335 */       if (!eq.isReserved())
/*     */       {
/* 337 */         JOptionPane.showMessageDialog(null, "That item is not reserved.");
/* 338 */         eq.setReservedBy(null);
/*     */       }
/*     */       else
/*     */       {
/* 342 */         EDSUser user = eq.getReservedBy();
/* 343 */         user.getReservations().remove(eq);
/* 344 */         eq.setReserved(false);
/* 345 */         eq.setReservedBy(null);
/* 346 */         JOptionPane.showMessageDialog(null, "Reservation removed.");
/*     */       }
/*     */     }
/* 349 */     em.getTransaction().commit();
/* 350 */     em.close();
/*     */   }
/*     */ 
/*     */   public void removeUser(int idNumber)
/*     */   {
/* 355 */     EntityManager em = this.emf.createEntityManager();
/* 356 */     em.getTransaction().begin();
/* 357 */     EDSUser user = (EDSUser)em.find(EDSUser.class, Integer.valueOf(idNumber));
/* 358 */     if ((user != null) && (user.getBorrowedEquipment().isEmpty()))
/*     */     {
/* 360 */       for (UserGroup group : user.getGroups())
/*     */       {
/* 362 */         group.getUsers().remove(user);
/* 363 */         em.merge(group);
/*     */       }
/* 365 */       em.remove(user);
/* 366 */       JOptionPane.showMessageDialog(null, "User removed.");
/*     */     }
/* 368 */     else if (!user.getBorrowedEquipment().isEmpty())
/*     */     {
/* 370 */       JOptionPane.showMessageDialog(null, "User still has borrowed equipment.");
/*     */     }
/* 372 */     em.getTransaction().commit();
/* 373 */     em.close();
/*     */   }
/*     */ 
/*     */   public void removeEquipment(long tagNumber)
/*     */   {
/* 378 */     EntityManager em = this.emf.createEntityManager();
/* 379 */     em.getTransaction().begin();
/* 380 */     Equipment eq = (Equipment)em.find(Equipment.class, Long.valueOf(tagNumber));
/* 381 */     if ((eq != null) && (!eq.isBorrowed()) && (!eq.isReserved()))
/*     */     {
/* 383 */       em.remove(eq);
/*     */     }
/* 385 */     if (eq.isBorrowed())
/*     */     {
/* 387 */       JOptionPane.showMessageDialog(null, "You cannot remove borrowed equipment.");
/*     */     }
/* 389 */     else if (eq.isReserved())
/*     */     {
/* 391 */       JOptionPane.showMessageDialog(null, "You cannot remove reserved equipment.");
/*     */     }
/* 393 */     em.getTransaction().commit();
/* 394 */     em.close();
/*     */   }
/*     */ 
/*     */   public void removeUserGroup(String name)
/*     */   {
/* 399 */     EntityManager em = this.emf.createEntityManager();
/* 400 */     em.getTransaction().begin();
/* 401 */     UserGroup group = (UserGroup)em.find(UserGroup.class, name);
/* 402 */     if (group != null)
/*     */     {
/* 404 */       for (EDSUser user : group.getUsers())
/*     */       {
/* 406 */         user.getGroups().remove(group);
/* 407 */         em.merge(user);
/*     */       }
/* 409 */       em.remove(group);
/*     */     }
/* 411 */     em.getTransaction().commit();
/* 412 */     em.close();
/*     */   }
/*     */ 
/*     */   public void removeEmployee(String username)
/*     */   {
/* 417 */     EntityManager em = this.emf.createEntityManager();
/* 418 */     em.getTransaction().begin();
/* 419 */     Employee employee = (Employee)em.find(Employee.class, username);
/* 420 */     if ((employee != null) && (!employee.equals(this.currentLogin)))
/*     */     {
/* 422 */       em.remove(employee);
/*     */     }
/* 424 */     else if (employee.equals(this.currentLogin))
/*     */     {
/* 426 */       JOptionPane.showMessageDialog(null, "You cannot delete yourself!");
/*     */     }
/* 428 */     em.getTransaction().commit();
/* 429 */     em.close();
/*     */   }
/*     */ 
/*     */   public void addEquipmentType(String type)
/*     */   {
/* 434 */     EntityManager em = this.emf.createEntityManager();
/*     */     try
/*     */     {
/* 437 */       em.getTransaction().begin();
/* 438 */       EquipmentType eqType = new EquipmentType(type);
/* 439 */       em.persist(eqType);
/* 440 */       em.getTransaction().commit();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 444 */       e.printStackTrace();
/* 445 */       em.getTransaction().rollback();
/*     */     }
/*     */     finally
/*     */     {
/* 449 */       em.close();
/*     */     }
/*     */   }
/*     */ 
/*     */   public Employee getCurrentLogin()
/*     */   {
/* 457 */     return this.currentLogin;
/*     */   }
/*     */ 
/*     */   public void setCurrentLogin(Employee currentLogin)
/*     */   {
/* 465 */     this.currentLogin = currentLogin;
/*     */   }
/*     */ }

/* Location:           /Users/Rusty-Mac/Downloads/ALOC_EDS/ALOC_v2.jar
 * Qualified Name:     control.EDS
 * JD-Core Version:    0.6.2
 */
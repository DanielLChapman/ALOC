package model;

import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Equipment.class)
public class Equipment_
{
  public static volatile SingularAttribute<Equipment, String> model;
  public static volatile SingularAttribute<Equipment, Boolean> borrowed;
  public static volatile SingularAttribute<Equipment, Long> tagNumber;
  public static volatile SingularAttribute<Equipment, EDSUser> borrowedBy;
  public static volatile SingularAttribute<Equipment, EquipmentType> type;
  public static volatile SingularAttribute<Equipment, EDSUser> reservedBy;
  public static volatile SingularAttribute<Equipment, Date> dueDate;
  public static volatile SingularAttribute<Equipment, Boolean> reserved;
}

/* Location:           /Users/Rusty-Mac/Downloads/ALOC_EDS/ALOC_v2.jar
 * Qualified Name:     model.Equipment_
 * JD-Core Version:    0.6.2
 */
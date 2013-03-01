package model;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(EDSUser.class)
public class EDSUser_
{
  public static volatile SingularAttribute<EDSUser, String> lastName;
  public static volatile SetAttribute<EDSUser, Equipment> borrowedEquipment;
  public static volatile SetAttribute<EDSUser, EquipmentType> permissions;
  public static volatile SingularAttribute<EDSUser, String> firstName;
  public static volatile SingularAttribute<EDSUser, String> password;
  public static volatile SetAttribute<EDSUser, UserGroup> groups;
  public static volatile SingularAttribute<EDSUser, Integer> idNumber;
  public static volatile SetAttribute<EDSUser, Equipment> reservations;
}

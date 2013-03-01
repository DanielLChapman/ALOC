package model;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(EquipmentType.class)
public class EquipmentType_
{
  public static volatile SetAttribute<EquipmentType, EDSUser> users;
  public static volatile SingularAttribute<EquipmentType, String> type;
  public static volatile SetAttribute<EquipmentType, UserGroup> groups;
}

/* Location:           /Users/Rusty-Mac/Downloads/ALOC_EDS/ALOC_v2.jar
 * Qualified Name:     model.EquipmentType_
 * JD-Core Version:    0.6.2
 */
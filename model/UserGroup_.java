package model;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(UserGroup.class)
public class UserGroup_
{
  public static volatile SetAttribute<UserGroup, EDSUser> users;
  public static volatile SingularAttribute<UserGroup, String> name;
  public static volatile SetAttribute<UserGroup, EquipmentType> permissions;
}

/* Location:           /Users/Rusty-Mac/Downloads/ALOC_EDS/ALOC_v2.jar
 * Qualified Name:     model.UserGroup_
 * JD-Core Version:    0.6.2
 */
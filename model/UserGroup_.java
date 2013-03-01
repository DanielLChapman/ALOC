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

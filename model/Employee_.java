package model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Employee.class)
public class Employee_
{
  public static volatile SingularAttribute<Employee, String> lastName;
  public static volatile SingularAttribute<Employee, String> username;
  public static volatile SingularAttribute<Employee, Boolean> manager;
  public static volatile SingularAttribute<Employee, String> firstName;
  public static volatile SingularAttribute<Employee, String> password;
}

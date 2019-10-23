package com.ustcinfo.entity;

/**
 * @author wangxl
 * @ClassName Student
 * @Description TODO
 * @date 2019/10/23 9:59
 */
public class Student {

  private int id;
  private String name ;
  private int age;
  private  String sex;
  private String school;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public String getSchool() {
    return school;
  }

  public void setSchool(String school) {
    this.school = school;
  }
}

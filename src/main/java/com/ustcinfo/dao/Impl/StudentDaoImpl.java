package com.ustcinfo.dao.Impl;

import com.ustcinfo.dao.BaseDao;
import com.ustcinfo.dao.StudentDao;
import com.ustcinfo.entity.Student;

import java.util.List;

/**
 * @author wangxl
 * @ClassName StudentDaoImpl
 * @Description TODO
 * @date 2019/10/23 10:50
 */
public class StudentDaoImpl extends BaseDao<Student> implements StudentDao {

  @Override
  public List<Student> getAllStudent() {
     String sql = "select * from student";
    return executeQuery(sql);
  }

  @Override
  public int insertStudent(Student student) {
    String sql = "insert into student(name,age,sex,school) values(?,?,?,?)";
    return executeUpdate(sql,new Object[]{student.getName(),student.getAge(),student.getSex(),student.getSchool()});
  }

  @Override
  public int deleteStudentById(Integer id) {
    String  sql = "delete from student where id = ?";
    return executeUpdate(sql,new Object[]{id});
  }

  @Override
  public int updateStudentById(Student student) {
    String sql = "update student set name = ? , age = ? ,sex = ? ,school = ? where id = ?";
    return executeUpdate(sql,new Object[]{student.getName(),student.getAge(),student.getSex(),student.getSchool(),student.getId()});
  }

  @Override
  public int getStudentCount() {
    String sql = "select count(*) from student";
    return getRecordCount(sql);
  }
}

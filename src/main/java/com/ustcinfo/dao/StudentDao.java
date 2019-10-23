package com.ustcinfo.dao;

import com.ustcinfo.entity.Student;
import java.util.List;

/**
 * @author wangxl
 * @ClassName StudentDao
 * @Description TODO
 * @date 2019/10/23 10:10
 */
public interface StudentDao {

  /**
   * 获取所有的学生
   * @return
   */
  List<Student> getAllStudent();

  /**
   * 添加学生
   * @param student
   * @return
   */
  int insertStudent(Student student);

  /**
   * 根据id删除学生
   * @param id
   * @return
   */
  int deleteStudentById(Integer id);

  /**
   * 根据id修改学生信息
   * @param student
   * @return
   */
  int updateStudentById(Student student);

  /**
   * 获取学生总数
   * @return
   */
  int getStudentCount();

}

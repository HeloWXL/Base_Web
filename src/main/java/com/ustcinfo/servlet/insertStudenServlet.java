package com.ustcinfo.servlet;

import com.ustcinfo.dao.Impl.StudentDaoImpl;
import com.ustcinfo.dao.StudentDao;
import com.ustcinfo.entity.Student;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangxl
 * @ClassName insertStudenServlet
 * @Description TODO
 * @date 2019/10/23 11:10
 */
@WebServlet("/insertStudent")
public class insertStudenServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //字符过滤
    request.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=utf-8");

    //返回结果
    Map<String,Object> map = new HashMap<>();
    Student student = new Student();
    //获取传入的参数
    String name =request.getParameter("name");
    String age =request.getParameter("age");
    String sex =request.getParameter("sex");
    String school =request.getParameter("school");

    //给对象赋值
    student.setAge(Integer.parseInt(age));
    student.setName(name);
    student.setSchool(school);
    student.setSex(sex);

    StudentDao studentDao = new StudentDaoImpl();
    int result = studentDao.insertStudent(student);

    if(result==1){
      map.put("code",200);
      map.put("msg","添加成功");
      map.put("data",result);
    }else{
      map.put("code",500);
      map.put("msg","添加失败");
      map.put("data",result);
    }
    //封装成json
    JSONObject json = JSONObject.fromObject(map);
    PrintWriter out = response.getWriter();
    out.print(json);
    out.flush();
    out.close();

  }
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    super.doPost(request,response);
  }
}

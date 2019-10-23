package com.ustcinfo.servlet;

import com.ustcinfo.dao.Impl.StudentDaoImpl;
import com.ustcinfo.dao.StudentDao;
import com.ustcinfo.entity.Student;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@WebServlet("/getAllStudent")
public class GetAllStudentServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      super.doGet(request,response);
  }
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //字符过滤
    request.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=utf-8");

    //返回结果
    Map<String,Object> map = new HashMap<>();

    StudentDao studentDao = new StudentDaoImpl();
    List<Student>  list = studentDao.getAllStudent();

    if(list.size()>=0){
      map.put("code",200);
      map.put("msg","返回结果成功");
      map.put("data",list);
      map.put("count",studentDao.getStudentCount());
    }else{
      map.put("code",500);
      map.put("msg","返回结果成失败");
      map.put("data",null);
    }

    JSONObject json = JSONObject.fromObject(map);
    PrintWriter out = response.getWriter();
    out.print(json.toString());
    out.flush();
    out.close();
  }
}

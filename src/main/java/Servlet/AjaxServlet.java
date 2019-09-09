package Servlet;

import com.google.gson.Gson;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AjaxServlet",urlPatterns = "/servlet/AjaxServlet")
//用来接收前端请求的控制层
public class AjaxServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        //返回从数据库中查询的数据(json的格式)
        List<User> userList = new ArrayList<>();
        //String name = new String("羡羡".getBytes("ISO-8859-1"),"utf-8");
        for (int i = 0; i <= 20; i++) {
            userList.add(new User("羡羡",i));
        }
        //把数据转换为json格式并返回
        Gson gson = new Gson();
        //json就是有格式的字符串
        String json = gson.toJson(userList);

        out.write(json);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}

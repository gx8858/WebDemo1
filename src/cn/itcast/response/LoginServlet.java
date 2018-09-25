package cn.itcast.response;
 
import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
/**
 * 处理重定向功能（重定向）
 */
 
public class LoginServlet extends HttpServlet {
 
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 1.先从客户端接收用户传过来的数据（找request对象，有方法）
         * 2.判断是否都是admin，如果都是，登陆成功，否则重定向到登录界面
         */
        // 获取用户名输入数据
        String username = req.getParameter("username");
        // 获取密码
        String password = req.getParameter("password");
        // 判断是否都是admin，如果都是，登陆成功，否则重定向到登录界面
        if ("admin".equals(username) && "admin".equals(password)) {
            // 登录成功
//          resp.setStatus(302);
//          resp.setHeader("location", "/test/html/success.html");
        	// 或
//            resp.sendRedirect("/test/html/success.html");
            
            String path = req.getContextPath();
            System.out.println(path);   // 输出：/test
            resp.sendRedirect(path + "/html/success.html");
        } else {
            // 登录失败
//          resp.setStatus(302);
//          resp.setHeader("location", "/test/html/login.html");
            resp.sendRedirect("/test/html/login.html");
        }
         
    }
     
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
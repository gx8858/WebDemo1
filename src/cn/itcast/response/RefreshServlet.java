package cn.itcast.response;
 
import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class RefreshServlet extends HttpServlet {
 
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置refresh头信息，过5秒进行跳转
    	
    	// 防止乱码
    	resp.setContentType("text/html;charset=UTF-8");
        // 向页面输出一些内容
        resp.getWriter().print("5秒后跳转");
        // 设置头信息（客户端绝对路径）
        resp.setHeader("refresh", "5;url=/test/html/success.html");
         
    }
     
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
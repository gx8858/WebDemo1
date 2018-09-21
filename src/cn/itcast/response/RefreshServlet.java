package cn.itcast.response;
 
import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class RefreshServlet extends HttpServlet {
 
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // ����refreshͷ��Ϣ����5�������ת
    	
    	// ��ֹ����
    	resp.setContentType("text/html;charset=UTF-8");
        // ��ҳ�����һЩ����
        resp.getWriter().print("5�����ת");
        // ����ͷ��Ϣ���ͻ��˾���·����
        resp.setHeader("refresh", "5;url=/test/html/success.html");
         
    }
     
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
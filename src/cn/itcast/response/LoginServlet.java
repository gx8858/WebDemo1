package cn.itcast.response;
 
import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
/**
 * �����ض����ܣ��ض���
 */
 
public class LoginServlet extends HttpServlet {
 
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 1.�ȴӿͻ��˽����û������������ݣ���request�����з�����
         * 2.�ж��Ƿ���admin��������ǣ���½�ɹ��������ض��򵽵�¼����
         */
        // ��ȡ�û�����������
        String username = req.getParameter("username");
        // ��ȡ����
        String password = req.getParameter("password");
        // �ж��Ƿ���admin��������ǣ���½�ɹ��������ض��򵽵�¼����
        if ("admin".equals(username) && "admin".equals(password)) {
            // ��¼�ɹ�
//          resp.setStatus(302);
//          resp.setHeader("location", "/test/html/success.html");
        	// ��
//            resp.sendRedirect("/test/html/success.html");
            
            String path = req.getContextPath();
            System.out.println(path);   // �����/test
            resp.sendRedirect(path + "/html/success.html");
        } else {
            // ��¼ʧ��
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
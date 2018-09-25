package cn.itcast.response;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 文件下载后台程序
 */
public class DownloadServlet extends HttpServlet {

	private static final long serialVersionUID = 4626987070464637076L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/**
		 * 分析怎么做？
		 * 	1.获取文件的输入流
		 * 	2.向客户端输出内容
		 * 	3.读写
		 */
		// 设置头信息，附件的形式打开该文件
		resp.setHeader("Content-Disposition", "attachment;filename=girl7.jpg");
		
		// 通过程序获取文件的绝对磁盘路径
		String path = getServletContext().getRealPath("/img/girl7.jpg");
		// System.out.println(path);
		// 获取img图片下的文件的路径
		InputStream in = new FileInputStream(path);
		// 向客户端输出
		OutputStream os = resp.getOutputStream();
		// 读写
		byte [] b = new byte[1024];
		int len = 0;
		while((len = in.read(b)) != -1){
			os.write(b, 0, len);
		}
		in.close();
		os.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}

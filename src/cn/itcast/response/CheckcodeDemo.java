package cn.itcast.response;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 熟悉方法
 * @author Administrator
 *
 */
public class CheckcodeDemo extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/**
		 * 1.获取画布对象
		 * 2.获取画笔对象
		 * 3.画一些东西
		 * 4.准备好一些数据
		 * 5.把内存中的画布输出到客户端上
		 */
		// 获取画布对象
		BufferedImage image = new BufferedImage(500, 400, BufferedImage.TYPE_INT_RGB);
		// 获取画笔对象
		Graphics g = image.getGraphics();
		// 设置画笔的颜色
		g.setColor(Color.RED);
		// 画一个矩形
		g.drawRect(100, 100, 150, 150);
		
		// 提前准备好数据
		String str = "abcd";
		
		g.setColor(Color.YELLOW);
		// 把字符串写到纸上
		g.drawString(str, 50, 50);
		
		// 把内存中的图片输出客户端上
		ImageIO.write(image, "jpg", response.getOutputStream());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
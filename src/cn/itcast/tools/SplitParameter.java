package cn.itcast.tools;

import java.util.Arrays;

public class SplitParameter {

	public static void main(String[] args) {

		/**
		 * 拆分参数，结果为：
		 * username 张三
		   password 123
		   sex 女
		 */
		String str = "username=张三&password=123&sex=女";
		String[] arr = str.split("&");
//		System.out.println(Arrays.toString(arr));  // [username=张三, password=123]
		for (int i = 0; i < arr.length; i++) {
			String[] arr1 = arr[i].split("=");   // arr1 [username, 张三]
			System.out.println(arr1[0] + " " + arr1[1]);
		}
	}

}

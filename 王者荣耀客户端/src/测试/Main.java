package 测试;

import 客户端.Client;

/**
 * 主类
 * @author 蔡子辉
 *
 */
public class Main {
	@SuppressWarnings("unused")
	public static void main(String [] args) {
		
		//需要服务器的正确的IP地址和端口号
        Client clientTest=new Client("172.29.17.214", 1234);
        clientTest.start();
	}
}

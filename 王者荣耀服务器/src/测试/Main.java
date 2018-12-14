package 测试;

import 服务器.Server;

/**
 * 主类
 * @author 蔡子辉
 *
 */
public class Main {
	@SuppressWarnings("unused")
	public static void main(String [] args) {
		
		Server server = new Server(1234);
        server.start();
	}
}

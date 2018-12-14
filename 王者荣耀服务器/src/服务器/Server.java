package 服务器;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import 战斗界面.BattleFrame;
import 选择界面.ChooseFrame;


public  class  Server extends Thread{
	//依附的窗体
	public static ChooseFrame chooseFrame = null;
	public static BattleFrame battleFrame = null;
	
	//发送给对方的命令
	public static String sendedOrder = "";
	//发送指令是否发生变化
	public static boolean sendedOrderIsChanged = false;
	
	//从对方接受的命令,全部保存起来，以防网速过慢造成不同步
	public static String receivedOrder = "";
	//接收指令是否发生变化
	public static boolean receivedOrderIsChanged = false;
	
	
    ServerSocket server = null;
    Socket socket = null;
    
    public Server(int port) {
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void run(){
        super.run();
        try{
            System.out.println("等待客户端连接...");
            socket = server.accept();
            new sendMessThread().start();//连接并返回socket后，再启用发送消息线程
            System.out.println(socket.getInetAddress().getHostAddress()+"成功连接！");
            InputStream in = socket.getInputStream();
            int len = 0;
            byte[] buf = new byte[1024];
            int oneOrderLength;
            
            while (receivedOrderIsChanged || (len=in.read(buf))!=-1){
            	//有新的字符串传入
            	if(receivedOrderIsChanged == false) {
            		receivedOrder = new String(buf,0,len);
            		//为了下一次循环，知道窗体成功构建
            		receivedOrderIsChanged = true;
            	}
            	
            	if(battleFrame != null) {
            		//防止多次发送的指令粘合在一起
            		//只要有指令就需要解读
            		while(receivedOrder.length() != 0) {
            			//找到总指令的第一条
            			oneOrderLength = receivedOrder.indexOf('#');
            			//解读总指令的第一个指令
            			battleFrame.panel.understandOtherRoleOrder(receivedOrder.substring(0, oneOrderLength));
            			//删除该条已执行的指令
            			receivedOrder = receivedOrder.substring(oneOrderLength+1,receivedOrder.length());
            		}
            		
            		//成功读完粘合在一起的指令
            		receivedOrderIsChanged = false;
            	}
            	
            	//不知道
            	System.out.print("");	
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //发送消息
    class sendMessThread extends Thread{
        @Override
        public void run(){
            super.run();
            OutputStream out = null;
            try{
            	//连接成功
                if(socket != null){
                	//构建窗体
                	chooseFrame = new ChooseFrame();
                	
                    out = socket.getOutputStream();
                    
                    do {
                    	//不知道为什么要这句
                    	System.out.print("");
                    	
                    	if(sendedOrderIsChanged) {
                    		//发送前添加结束符
                    		out.write((sendedOrder+"#").getBytes());
                    		sendedOrderIsChanged = false;
                    	}
                        out.flush();//清空缓存区的内容
                    }while(!sendedOrder.equals("结束"));
                    
                    try{
                        out.close();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
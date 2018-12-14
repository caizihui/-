package 战斗界面;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import 客户端.Client;
import 辅助.ComplexShell;
import 辅助.Function;
import 辅助.PictureName;
import 辅助.Point;
import 辅助.RoleName;
import 辅助.SimpleShell;
import 障碍物与地图.Map;
import 战场.Battle;
import 角色.LiPo;
import 角色.Role;

/**
 * 战斗面板类
 * @author 蔡子辉
 *
 */
public class BattlePanel extends JPanel implements KeyListener,ActionListener,MouseListener {
	/**
	 * 添加缺省串行版本
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 面板载体
	 */
	public static BattleFrame frame = null;
	
	
	//战场
	/**
	 * 战场
	 */
	public Battle battle;
	/**
	 * 提示语标签
	 */
	JLabel firstRoleButtonTipLabel;
	
	//简单攻击
	/**
	 * 简单攻击按钮容器
	 */
	Container simpleAttackContainer;
	/**
	 * 简单攻击标签提示语
	 */
	JLabel simpleAttackTipLabel;
	/**
	 * 简单攻击方向按钮
	 */
	JButton simpleAttackDirectionButton[];
	
	//复杂攻击
	/**
	 * 复杂攻击按钮容器
	 */
	Container complexAttackContainer;
	/**
	 * 复杂攻击标签提示语
	 */
	JLabel complexAttackTipLabel;
	/**
	 * 复杂攻击方向按钮
	 */
	JButton complexAttackDirectionButton[]; 
	
	//辅助变量
	/**
	 * 当前玩家正在操作的角色
	 */
	private Role operatingRole;	//当前在操作的英雄
	
	//私有方法区：
	/**
	 * 关联相关类的载体
	 */
	private void setStaticData() {
		Point.panel = this;
		Map.panel = this;
		Battle.panel = this;
		SimpleShell.panel = this;
		ComplexShell.panel = this;
	}
	
	/**
	 * 构造战场
	 * @param choosedMap 地图类型
	 */
	private void createBattle(String choosedMap) {
		battle = new Battle(choosedMap);
		Role.battle = this.battle;
		LiPo.battle = this.battle;
	}
	
	/**
	 * 创键正在操作的对象
	 * @param choosedRoleDescription
	 */
	private void createOperatingRole(String choosedRoleDescription) {
		if(Function.isLiPo(choosedRoleDescription)) {
			this.operatingRole = new LiPo(choosedRoleDescription);
		}
		
		else {
			this.operatingRole = new Role(choosedRoleDescription);
		}	
	}

	/**
	 * 构造简单攻击按钮
	 */
	private void createSimpleAttackDirectionButton() {
		//提示标签
		simpleAttackContainer = new Container();
		simpleAttackTipLabel = new JLabel("简单攻击方向：");
		simpleAttackDirectionButton = new JButton[4];
		//上
		simpleAttackDirectionButton[0] = new JButton("上");
		simpleAttackDirectionButton[0].addActionListener(this);
		simpleAttackDirectionButton[0].setFocusable(false);
		//下
		simpleAttackDirectionButton[1] = new JButton("下");
		simpleAttackDirectionButton[1].addActionListener(this);
		simpleAttackDirectionButton[1].setFocusable(false);
		//左
		simpleAttackDirectionButton[2] = new JButton("左");
		simpleAttackDirectionButton[2].addActionListener(this);
		simpleAttackDirectionButton[2].setFocusable(false);
		//右
		simpleAttackDirectionButton[3] = new JButton("右");
		simpleAttackDirectionButton[3].addActionListener(this);
		simpleAttackDirectionButton[3].setFocusable(false);
		//装入容器
		simpleAttackContainer.add(simpleAttackTipLabel);
		simpleAttackContainer.add(simpleAttackDirectionButton[0]);
		simpleAttackContainer.add(simpleAttackDirectionButton[1]);
		simpleAttackContainer.add(simpleAttackDirectionButton[2]);
		simpleAttackContainer.add(simpleAttackDirectionButton[3]);
		
		//加到面板，并设定位置
		this.add(simpleAttackContainer);
		simpleAttackContainer.setLayout(new FlowLayout());
		simpleAttackContainer.setBounds(Function.realWidthOf(620),Function.realHeightOf(770),
										Function.realWidthOf(400),Function.realHeightOf(50));
	}
	
	/**
	 * 构造柱复杂攻击按钮
	 */
	private void createComplexAttackDirectionButton() {
		if(Function.isLiPo(this.operatingRole.roleImg.getDescription())) {
			//提示标签
			complexAttackContainer = new Container();
			complexAttackTipLabel = new JLabel("复杂攻击方向：");
			complexAttackDirectionButton = new JButton[4];
			//上
			complexAttackDirectionButton[0] = new JButton("上");
			complexAttackDirectionButton[0].addActionListener(this);
			complexAttackDirectionButton[0].setFocusable(false);
			//下
			complexAttackDirectionButton[1] = new JButton("下");
			complexAttackDirectionButton[1].addActionListener(this);
			complexAttackDirectionButton[1].setFocusable(false);
			//左
			complexAttackDirectionButton[2] = new JButton("左");
			complexAttackDirectionButton[2].addActionListener(this);
			complexAttackDirectionButton[2].setFocusable(false);
			//右
			complexAttackDirectionButton[3] = new JButton("右");
			complexAttackDirectionButton[3].addActionListener(this);
			complexAttackDirectionButton[3].setFocusable(false);
			//装入容器
			complexAttackContainer.add(complexAttackTipLabel);
			complexAttackContainer.add(complexAttackDirectionButton[0]);
			complexAttackContainer.add(complexAttackDirectionButton[1]);
			complexAttackContainer.add(complexAttackDirectionButton[2]);
			complexAttackContainer.add(complexAttackDirectionButton[3]);
			
			//加到面板，并设定位置
			this.add(complexAttackContainer);
			complexAttackContainer.setLayout(new FlowLayout());
			complexAttackContainer.setBounds(Function.realWidthOf(620),Function.realHeightOf(820),
											 Function.realWidthOf(400),Function.realHeightOf(50));
		}
	}
	
	/**
	 * 玩家获胜
	 */
	private void win() {
		//销毁窗体
		frame.dispose();
		
		//弹出胜利提示框
		Font font = new Font("",Font.BOLD,Function.realWidthOf(40));
		JFrame frame = new JFrame("胜利");
		JLabel label = new JLabel("哇，太棒了，你成功了！");
		label.setFont(font);
		frame.add(label);
		frame.setSize(Function.realWidthOf(480),Function.realHeightOf(100));
		frame.setLocation(Function.realWidthOf(650),Function.realHeightOf(400));
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * 玩家失败
	 */
	private void beDefeated() {
		//销毁窗体
		frame.dispose();
		
		//弹出失败提示框
		Font font = new Font("",Font.BOLD,Function.realWidthOf(40));
		JFrame frame = new JFrame("失败");
		JLabel label = new JLabel("很遗憾，你失败了！");
		label.setFont(font);
		frame.add(label);
		frame.setSize(Function.realWidthOf(400),Function.realHeightOf(100));
		frame.setLocation(Function.realWidthOf(700),Function.realHeightOf(400));
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * 设定简单攻击按钮对应的事件
	 * @param e 监听到的对象
	 */
	private void manageSimpleAttack(ActionEvent e) {
		//上
		if(e.getSource() == simpleAttackDirectionButton[0]) {
			Client.sendedOrder = this.operatingRole.rolePosition.toString()+"向上简单攻击";
			Client.sendedOrderIsChanged = true;
			
			this.operatingRole.simpleAttack("上");
		}
		
		//下
		else if(e.getSource() == simpleAttackDirectionButton[1]) {
			Client.sendedOrder = this.operatingRole.rolePosition.toString()+"向下简单攻击";
			Client.sendedOrderIsChanged = true;
			
			this.operatingRole.simpleAttack("下");
		}
		
		//左
		else if(e.getSource() == simpleAttackDirectionButton[2]) {
			Client.sendedOrder = this.operatingRole.rolePosition.toString()+"向左简单攻击";
			Client.sendedOrderIsChanged = true;
			
			this.operatingRole.simpleAttack("左");
		}	
		
		//左
		else if(e.getSource() == simpleAttackDirectionButton[3]) {
			Client.sendedOrder = this.operatingRole.rolePosition.toString()+"向右简单攻击";
			Client.sendedOrderIsChanged = true;
			
			this.operatingRole.simpleAttack("右");
		}	
	}
	
	/**
	 * 设定复杂攻击按钮对应的事件
	 * @param e 监听到的对象
	 */
	private void manageComplexAttack(ActionEvent e) {
		LiPo li;
		
		//复杂攻击按钮--上
		if(e.getSource() == complexAttackDirectionButton[0]){
			//判断是不是李白
			if(Function.isLiPo(this.operatingRole.roleImg.getDescription())) {
				li = (LiPo)this.operatingRole;
				
				Client.sendedOrder = this.operatingRole.rolePosition.toString()+"向上复杂攻击";
				Client.sendedOrderIsChanged = true;
				
				
				li.complexAttack("上");
			}
		}
		
		//复杂攻击按钮--下
		else if(e.getSource() == complexAttackDirectionButton[1]){
			//判断是不是李白
			if(Function.isLiPo(this.operatingRole.roleImg.getDescription())) {
				li = (LiPo)this.operatingRole;

				Client.sendedOrder = this.operatingRole.rolePosition.toString()+"向下复杂攻击";
				Client.sendedOrderIsChanged = true;
				
				li.complexAttack("下");
			}
		}		
		
		//复杂攻击按钮--左
		else if(e.getSource() == complexAttackDirectionButton[2]){
			//判断是不是李白
			if(Function.isLiPo(this.operatingRole.roleImg.getDescription())) {
				li = (LiPo)this.operatingRole;
				
				Client.sendedOrder = this.operatingRole.rolePosition.toString()+"向左复杂攻击";
				Client.sendedOrderIsChanged = true;
				
				li.complexAttack("左");
			}
		}
		
		//复杂攻击按钮--右
		else if(e.getSource() == complexAttackDirectionButton[3]){
			//判断是不是李白
			if(Function.isLiPo(this.operatingRole.roleImg.getDescription())) {
				li = (LiPo)this.operatingRole;
				
				Client.sendedOrder = this.operatingRole.rolePosition.toString()+"向右复杂攻击";
				Client.sendedOrderIsChanged = true;
				
				li.complexAttack("右");
			}
		}
	}
	
	/**
	 * 监听鼠标
	 * @param e 鼠标对象
	 */
	private void manageMouse(MouseEvent e) {
		Point anotherPoint;
		String description;
		
		anotherPoint = new Point(e.getY()/30-1,e.getX()/30);
		description = this.battle.map.get(anotherPoint);
		
		//点击空格才有效
		if(description != null) {
			if(description.equals(PictureName.SPACE)) {
				
				Client.sendedOrder = this.operatingRole.rolePosition.toString()+"去"+anotherPoint.toString();
				Client.sendedOrderIsChanged = true;
				
				this.operatingRole.goTo(anotherPoint);
			}
		}
		
		else {
			
		}
	}
	
	/**
	 * 获取指令中的方向
	 * @param order 指令
	 * @return 方向
	 */
	private String getDirection(String order) {
		if(order.indexOf("上") != -1) {
			return "上";
		}
		
		else if(order.indexOf("下") != -1) {
			return "下";
		}
		
		else if(order.indexOf("左") != -1) {
			return "左";
		}

		else if(order.indexOf("右") != -1) {
			return "右";
		}
		
		return null;
	}
	
	/**
	 * 从指令尾部获取点
	 * @param order 指令
	 * @return Point 获取的点
	 */
	private Point getPointFromTail(String order) {
		int i;
		char temp;
		String orderPointStr;
		
		orderPointStr = "";
		for(i=order.length()-1 ; i>=0 ; i--) {
			temp = order.charAt(i);
			
			if((temp>='0' && temp<='9') || (temp=='_')) {
				orderPointStr += temp;
			}
			
			else {
				break;
			}
		}
		
		return new Point(new StringBuffer(orderPointStr).reverse().toString());
	}
	
	/**
	 * 从指令中获取角色名称
	 * @param order 指令
	 * @return String 角色名称
	 */
	private String getRoleImgName(String order) {
		if(order.indexOf(RoleName.ROLE_A) != -1) {
			return PictureName.ROLE_A;
		}
		
		else if(order.indexOf(RoleName.ROLE_a) != -1) {
			return PictureName.ROLE_a;
		}
		
		else if(order.indexOf(RoleName.ROLE_N) != -1) {
			return PictureName.ROLE_N;
		}
		
		else if(order.indexOf(RoleName.ROLE_n) != -1) {
			return PictureName.ROLE_n;
		}
		
		return null;
	}
	
	/**
	 * 获取指令中的角色
	 * @param order 指令
	 * @return Role 获取的角色
	 */
	private Role getRole(String order) {
		int i;
		char temp;
		String orderPointStr;
		
		orderPointStr = "";
		for(i=0 ; i<order.length() ; i++) {
			temp = order.charAt(i);
			
			if((temp>='0' && temp<='9') || (temp=='_')) {
				orderPointStr += temp;
			}
			
			else {
				break;
			}
		}
		
		return Function.searchRole(new Point(orderPointStr), this.battle.firstRole, this.battle.secondRole);
	}
	
	/**
	 * 构造一个面板
	 * @param choosedMap 面板上的地图类型
	 * @param choosedRoleDescription 面板上玩家的角色描述
	 */
	BattlePanel(String choosedMap,String choosedRoleDescription) {
		//第一步：关联所有静态数据成员--面板
		this.setStaticData();
		//第二步：构建战场
		this.createBattle(choosedMap);
		//第三步：构造角色(构造方法有进入地图方法的调用)
		this.createOperatingRole(choosedRoleDescription);
		//第四步：构建简单攻击按钮
		this.createSimpleAttackDirectionButton();
		//第五步：构建复杂攻击按钮
		this.createComplexAttackDirectionButton();
	}
	
	//监听实现：
	//监听当前操作的角色
	/**
	 * 实现ActionListener接口的方法
	 */
	public void actionPerformed(ActionEvent e) {
		//管理简单攻击
		this.manageSimpleAttack(e);
		//管理复杂攻击
		if(Function.isLiPo(this.operatingRole.roleImg.getDescription())) {
			this.manageComplexAttack(e);
		}
	}
	
	//监听键盘上下左右
	/**
	 * 实现KeyListener接口的方法
	 */
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			//必须先产生指令再走
			Client.sendedOrder = this.operatingRole.rolePosition.toString()+"向上走";
			Client.sendedOrderIsChanged = true;
			
			this.operatingRole.goForward("上");
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			Client.sendedOrder = this.operatingRole.rolePosition.toString()+"向下走";
			Client.sendedOrderIsChanged = true;
			
			this.operatingRole.goForward("下");
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			Client.sendedOrder = this.operatingRole.rolePosition.toString()+"向左走";
			Client.sendedOrderIsChanged = true;
			
			this.operatingRole.goForward("左");
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			Client.sendedOrder = this.operatingRole.rolePosition.toString()+"向右走";
			Client.sendedOrderIsChanged = true;
			
			this.operatingRole.goForward("右");
		}
		
		else {
			
		}
	}
	/**
	 * 实现KeyListener接口的方法
	 */
	public void keyReleased(KeyEvent e) {}
	/**
	 * 实现KeyListener接口的方法
	 */
	public void keyTyped(KeyEvent e) {}
	
	/**
	 * 判断死亡情况，判断是否出现成功或胜利
	 * @param description 死亡的角色描述
	 */
	public void manageDeath(String description) {
		Runnable run;
		Thread task;
		
		run = new Runnable() {
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
			}
		};
		
		task = new Thread(run);
		
		//死亡的是朋友
		if(Function.isFriend(this.operatingRole.roleImg.getDescription(), description)) {
			if(Function.isFirstRole(description) && this.battle.firstRole.size() == 0) {
				task.start();
				
				this.beDefeated();
			}
			
			else if(Function.isSecondRole(description) && this.battle.secondRole.size() == 0) {
				task.start();
				
				this.beDefeated();
			}
		}
		
		else {
			if(Function.isFirstRole(description) && this.battle.firstRole.size() == 0) {
				task.start();
				
				this.win();
			}
			
			else if(Function.isSecondRole(description) && this.battle.secondRole.size() == 0) {
				task.start();
				
				this.win();
			}
		}
	}

	public void understandOtherRoleOrder(String order) {
		if(order.indexOf("增加") != -1) {
			String roleImgName;
			
			roleImgName = this.getRoleImgName(order);
			
			if(Function.isLiPo(roleImgName)) {
				new LiPo(roleImgName,this.getPointFromTail(order));
			}
			
			else {
				new Role(roleImgName,this.getPointFromTail(order));
			}
		}
		
		else {
			Role orderRole = this.getRole(order);
			
			//该指令为简单攻击指令
			if(order.indexOf("简单攻击") != -1) {
				orderRole.simpleAttack(this.getDirection(order));
			}
			
			else if(order.indexOf("复杂攻击") != -1) {
				((LiPo)orderRole).complexAttack(this.getDirection(order));
			}
			
			else if(order.indexOf("走") != -1) {
				orderRole.goForward(this.getDirection(order));
			}
			
			else if(order.indexOf("去") != -1) {
				orderRole.goTo(this.getPointFromTail(order));
			}
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO 自动生成的方法存根
		
		this.manageMouse(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}

}

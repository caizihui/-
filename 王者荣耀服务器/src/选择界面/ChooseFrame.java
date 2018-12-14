package 选择界面;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButtonMenuItem;

import 战斗界面.BattleFrame;
import 战斗界面.BattlePanel;
import 辅助.Function;
import 辅助.MyImageIcon;
import 辅助.MyLabel;
import 辅助.PictureName;
import 辅助.Size;

/**
 * 选择窗体类
 * @author 蔡子辉
 *
 */
public class ChooseFrame extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7873849994380834947L;

	/**
	 * 英雄图片
	 */
	MyLabel rolePictureLabel[];
	/**
	 * 提示语标签
	 */
	JLabel roleInformation;
	 /** 玩家操控方角色选择按钮
	 */
	LinkedList<JRadioButtonMenuItem> firstRoleButton;		//为了访问的方便
	/**
	 * 玩家操控方角色选择按钮组，实现单选
	 */
	ButtonGroup firstRoleButtonGroup;						//为了实现单选
	
	/**
	 * 地图图片
	 */
	MyLabel mapPictureLabel[];
	/**
	 * 地图信息
	 */
	JLabel mapInformation;
	/**
	 * 地图选择按钮
	 */
	LinkedList<JRadioButtonMenuItem> mapButton;
	ButtonGroup mapButtonGroup;
	
	/**
	 * 确定按钮
	 */
	JButton beginToPlayButton;
	/**
	 * 取消按钮
	 */
	JButton cancelButton;
	
	/**
	 * 被选定的角色的名称
	 */
	String choosedRole;
	/**
	 * 被选定的地图的名称
	 */
	String choosedMap;
	
	
	/**
	 * 构造可选择的角色图片
	 */
	private void createRolePicture() {
		int i;
		
		this.rolePictureLabel = new MyLabel[4];
		this.rolePictureLabel[0] = new MyLabel(new MyImageIcon(PictureName.ROLE_A_CHOOSE,Size.CHOSE_ROLE_WIDTH,Size.CHOSE_ROLE_HEIGHT));
		this.rolePictureLabel[1] = new MyLabel(new MyImageIcon(PictureName.ROLE_a_CHOOSE,Size.CHOSE_ROLE_WIDTH,Size.CHOSE_ROLE_HEIGHT));
		this.rolePictureLabel[2] = new MyLabel(new MyImageIcon(PictureName.ROLE_N_CHOOSE,Size.CHOSE_ROLE_WIDTH,Size.CHOSE_ROLE_HEIGHT));
		this.rolePictureLabel[3] = new MyLabel(new MyImageIcon(PictureName.ROLE_n_CHOOSE,Size.CHOSE_ROLE_WIDTH,Size.CHOSE_ROLE_HEIGHT));
		
		for(i=0 ; i<this.rolePictureLabel.length ; i++) { 
			this.add(this.rolePictureLabel[i]);
			this.rolePictureLabel[i].setBounds(Function.realWidthOf(100+i*200),Function.realHeightOf(0),
											   Function.realWidthOf(200),Function.realHeightOf(300));
		}
	}
	/**
	 * 构造角色单选框
	 */
	private void createFirstRoleButton() {
		//字体
		Font font = new Font("",Font.BOLD,Function.realWidthOf(20));
		JRadioButtonMenuItem tempButton;
		
		firstRoleButton = new LinkedList<JRadioButtonMenuItem>();
		firstRoleButtonGroup = new ButtonGroup();
		
		tempButton = new JRadioButtonMenuItem("A");
		tempButton.setFont(font);
		tempButton.addActionListener(this);
		firstRoleButton.add(tempButton);
		firstRoleButtonGroup.add(tempButton);
		this.add(tempButton);
		tempButton.setBounds(Function.realWidthOf(180),Function.realHeightOf(280),
					  		 Function.realWidthOf(100),Function.realHeightOf(50));
		
		
		tempButton = new JRadioButtonMenuItem("a");
		tempButton.setFont(font);
		tempButton.addActionListener(this);
		firstRoleButton.add(tempButton);
		firstRoleButtonGroup.add(tempButton);
		this.add(tempButton);
		tempButton.setBounds(Function.realWidthOf(380),Function.realHeightOf(280),
							 Function.realWidthOf(100),Function.realHeightOf(50));
		
		
		tempButton = new JRadioButtonMenuItem("N");
		tempButton.setFont(font);
		tempButton.addActionListener(this);
		firstRoleButton.add(tempButton);
		firstRoleButtonGroup.add(tempButton);
		this.add(tempButton);
		tempButton.setBounds(Function.realWidthOf(580),Function.realHeightOf(280),
		  		 			 Function.realWidthOf(100),Function.realHeightOf(50));
		
		tempButton = new JRadioButtonMenuItem("n");
		tempButton.setFont(font);
		tempButton.addActionListener(this);
		firstRoleButton.add(tempButton);
		firstRoleButtonGroup.add(tempButton);
		this.add(tempButton);
		tempButton.setBounds(Function.realWidthOf(780),Function.realHeightOf(280),
							 Function.realWidthOf(100),Function.realHeightOf(50));
	}
	/**
	 * 更改选择的角色，并输出角色相关信息
	 * @param aim 选定的角色
	 */
	private void selectRole(JRadioButtonMenuItem aim) {
		String information;
		
		//选定角色
		aim.setSelected(true);
		this.choosedRole = aim.getText();
		
		//更改提示信息
		//李白信息
		if(Function.isLiPo(aim.getText())) {
			information = "<html>"+
								"<p>名称："+this.choosedRole+"</p>";
			
			
			if(Function.isFirstRole(this.choosedRole)) {
				information += "<p>队列：一队"+"</p>";
			}
			
			else {
				information += "<p>队列：二队"+"</p>";
			}
			
			information +=		"<p>类型：LiPo</p>"+
								"<p>生命值：200</p>"+
								"<p>魔法值：50</p>"+
								"<p>经验值：5</p>"+
								"<p>技能：简单攻击、复杂攻击</p>"+
						  "</html>";
		}
		//普通角色
		else {
			information = "<html>"+
								"<p>名称："+this.choosedRole+"</p>";


			if(Function.isFirstRole(this.choosedRole)) {
				information += "<p>队列：一队"+"</p>";
			}

			else {
				information += "<p>队列：二队"+"</p>";
			}

			information +=		"<p>类型：LiPo</p>"+
								"<p>生命值：100</p>"+
								"<p>魔法值：30</p>"+
								"<p>经验值：0</p>"+
								"<p>技能：简单攻击</p>"+
								"</html>";
		}
		
		roleInformation.setText(information);
	}
	
	/**
	 * 构造可选择的地图图片
	 */
	private void createMapPicture() {
		int i;
		
		this.mapPictureLabel = new MyLabel[2];
		
		this.mapPictureLabel[0] = new MyLabel(new MyImageIcon(PictureName.MAP_NO_BARRIERS,Size.CHOSE_MAP_WIDTH,Size.CHOSE_MAP_HEIGHT));
		this.mapPictureLabel[1] = new MyLabel(new MyImageIcon(PictureName.MAP_HAVE_BARRIERS,Size.CHOSE_MAP_WIDTH,Size.CHOSE_MAP_HEIGHT));
		
		for(i=0 ; i<this.mapPictureLabel.length ; i++) {
			this.add(this.mapPictureLabel[i]);
			this.mapPictureLabel[i].setBounds(Function.realWidthOf(80+i*430),Function.realHeightOf(550),
					   						  Function.realWidthOf(400),Function.realHeightOf(160));
		}
	}
	/**
	 * 构造地图单选框
	 */
	private void createMapButton() {
		//字体
		Font font = new Font("",Font.BOLD,20);
		JRadioButtonMenuItem tempButton;
		
		this.mapButton = new LinkedList<JRadioButtonMenuItem>();
		this.mapButtonGroup = new ButtonGroup();
		
		tempButton = new JRadioButtonMenuItem("简单地图");
		tempButton.setFont(font);
		tempButton.addActionListener(this);
		this.mapButton.add(tempButton);
		this.mapButtonGroup.add(tempButton);
		this.add(tempButton);
		tempButton.setBounds(Function.realWidthOf(220),Function.realHeightOf(710),
		  		 			 Function.realWidthOf(150),Function.realHeightOf(50));
		
		tempButton = new JRadioButtonMenuItem("复杂地图");
		tempButton.setFont(font);
		tempButton.addActionListener(this);
		this.mapButton.add(tempButton);
		this.mapButtonGroup.add(tempButton);
		this.add(tempButton);
		tempButton.setBounds(Function.realWidthOf(670),Function.realHeightOf(710),
		 			 		 Function.realWidthOf(150),Function.realHeightOf(50));
	}
	/**
	 * 更改选择的地图，并输出地图相关信息
	 * @param aim 选定的地图
	 */
	private void selectMap(JRadioButtonMenuItem aim) {
		String information;
		
		//选定地图
		aim.setSelected(true);
		this.choosedMap = aim.getText();
		
		//更改提示信息
		//简单地图信息
		if(aim.getText().equals("简单地图")) {
			information = "<html>"+
								"<p>地图介绍：</p>"+
								"<p>简单地图没有障碍物，只有最外层的墙。这有利于您直接攻击对方哦！</p>"+
						  "</html>";
		}
		//复杂地图信息
		else {
			information = "<html>"+
								"<p>地图介绍：</p>"+
								"<p>复杂地图具有障碍物。这有利于您躲避对方的攻击哦！</p>"+
							"</html>";
		}
		
		this.mapInformation.setText(information);
	}
	
	/**
	 * 构造“开始游戏”与“取消”按钮
	 */
	private void createElseButton() {
		Font font = new Font("",Font.BOLD,Function.realWidthOf(25));
		
		this.beginToPlayButton = new JButton("开始游戏");
		this.beginToPlayButton.addActionListener(this);
		this.beginToPlayButton.setFocusable(false);
		this.add(this.beginToPlayButton);
		this.beginToPlayButton.setFont(font);
		this.beginToPlayButton.setBounds(Function.realWidthOf(350),Function.realHeightOf(780),
										 Function.realWidthOf(150),Function.realHeightOf(40));
		
		this.cancelButton = new JButton("取消");
		this.cancelButton.addActionListener(this);
		this.cancelButton.setFocusable(false);
		this.add(this.cancelButton);
		this.cancelButton.setFont(font);
		this.cancelButton.setBounds(Function.realWidthOf(530),Function.realHeightOf(780),
				 					Function.realWidthOf(100),Function.realHeightOf(40));
	}
	
	/**
	 * 初始化选定的角色
	 */
	private void initialize() {
		Font font = new Font("",Font.BOLD,Function.realWidthOf(20));
		
		this.roleInformation = new JLabel();
		this.roleInformation.setFont(font);
		this.roleInformation.setBounds(Function.realWidthOf(150),Function.realHeightOf(330),
									   Function.realWidthOf(300),Function.realHeightOf(200));
		this.add(this.roleInformation);
		this.selectRole(this.firstRoleButton.get(0));
		
		this.mapInformation = new JLabel();
		this.mapInformation.setFont(font);
		this.mapInformation.setBounds(Function.realWidthOf(580),Function.realHeightOf(330),
				   					  Function.realWidthOf(300),Function.realHeightOf(200));
		this.add(this.mapInformation);
		this.selectMap(this.mapButton.get(0));
	}
	
	/**
	 * 开始游戏
	 */
	private void playGame() {
		BattleFrame frame;
		
		//销毁现有窗体
		this.dispose();
		//新建游戏窗体
		frame = new BattleFrame(this.choosedMap,Function.translate(this.choosedRole));
		BattlePanel.frame = frame;
	}
	
	/**
	 * 构造选择窗体
	 */
	public ChooseFrame() {
		//1、设置窗体的一些参数
		this.setLayout(null);
		this.setTitle("英雄地图选择");
		this.setVisible(true);
		this.setSize(Function.realWidthOf(1020), Function.realHeightOf(900));
		this.setLocation(Function.realWidthOf(100), Function.realHeightOf(20));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//2、加载英雄图片
		this.createRolePicture();
		//3、加载英雄按钮
		this.createFirstRoleButton();
		//4、加载地图图片
		this.createMapPicture();
		//5、加载地图按钮
		this.createMapButton();
		//6、加载其他按钮
		this.createElseButton();
		//7、初始化选定英雄
		this.initialize();
	}
	
	/**
	 * 监听按钮等组件
	 */
	public void actionPerformed(ActionEvent e) {
		int i;
		
		//选择角色
		for(i=0 ; i<this.firstRoleButton.size() ; i++) {
			if(this.firstRoleButton.get(i) == e.getSource()) {
				this.selectRole(this.firstRoleButton.get(i));
				
				break;
			}
		}
		
		//选择地图
		for(i=0 ; i<this.mapButton.size() ; i++) {
			if(this.mapButton.get(i) == e.getSource()) {
				this.selectMap(this.mapButton.get(i));
				
				break;
			}
		}
		
		//玩
		if(e.getSource() == this.beginToPlayButton) {
			this.playGame();
		}
		
		
		//不玩
		if(e.getSource() == this.cancelButton) {
			this.dispose();
		}
	}

}

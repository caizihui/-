package ѡ�����;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButtonMenuItem;

import ս������.BattleFrame;
import ս������.BattlePanel;
import ����.Function;
import ����.MyImageIcon;
import ����.MyLabel;
import ����.PictureName;
import ����.Size;

/**
 * ѡ������
 * @author ���ӻ�
 *
 */
public class ChooseFrame extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7873849994380834947L;

	/**
	 * Ӣ��ͼƬ
	 */
	MyLabel rolePictureLabel[];
	/**
	 * ��ʾ���ǩ
	 */
	JLabel roleInformation;
	 /** ��Ҳٿط���ɫѡ��ť
	 */
	LinkedList<JRadioButtonMenuItem> firstRoleButton;		//Ϊ�˷��ʵķ���
	/**
	 * ��Ҳٿط���ɫѡ��ť�飬ʵ�ֵ�ѡ
	 */
	ButtonGroup firstRoleButtonGroup;						//Ϊ��ʵ�ֵ�ѡ
	
	/**
	 * ��ͼͼƬ
	 */
	MyLabel mapPictureLabel[];
	/**
	 * ��ͼ��Ϣ
	 */
	JLabel mapInformation;
	/**
	 * ��ͼѡ��ť
	 */
	LinkedList<JRadioButtonMenuItem> mapButton;
	ButtonGroup mapButtonGroup;
	
	/**
	 * ȷ����ť
	 */
	JButton beginToPlayButton;
	/**
	 * ȡ����ť
	 */
	JButton cancelButton;
	
	/**
	 * ��ѡ���Ľ�ɫ������
	 */
	String choosedRole;
	/**
	 * ��ѡ���ĵ�ͼ������
	 */
	String choosedMap;
	
	
	/**
	 * �����ѡ��Ľ�ɫͼƬ
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
	 * �����ɫ��ѡ��
	 */
	private void createFirstRoleButton() {
		//����
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
	 * ����ѡ��Ľ�ɫ���������ɫ�����Ϣ
	 * @param aim ѡ���Ľ�ɫ
	 */
	private void selectRole(JRadioButtonMenuItem aim) {
		String information;
		
		//ѡ����ɫ
		aim.setSelected(true);
		this.choosedRole = aim.getText();
		
		//������ʾ��Ϣ
		//�����Ϣ
		if(Function.isLiPo(aim.getText())) {
			information = "<html>"+
								"<p>���ƣ�"+this.choosedRole+"</p>";
			
			
			if(Function.isFirstRole(this.choosedRole)) {
				information += "<p>���У�һ��"+"</p>";
			}
			
			else {
				information += "<p>���У�����"+"</p>";
			}
			
			information +=		"<p>���ͣ�LiPo</p>"+
								"<p>����ֵ��200</p>"+
								"<p>ħ��ֵ��50</p>"+
								"<p>����ֵ��5</p>"+
								"<p>���ܣ��򵥹��������ӹ���</p>"+
						  "</html>";
		}
		//��ͨ��ɫ
		else {
			information = "<html>"+
								"<p>���ƣ�"+this.choosedRole+"</p>";


			if(Function.isFirstRole(this.choosedRole)) {
				information += "<p>���У�һ��"+"</p>";
			}

			else {
				information += "<p>���У�����"+"</p>";
			}

			information +=		"<p>���ͣ�LiPo</p>"+
								"<p>����ֵ��100</p>"+
								"<p>ħ��ֵ��30</p>"+
								"<p>����ֵ��0</p>"+
								"<p>���ܣ��򵥹���</p>"+
								"</html>";
		}
		
		roleInformation.setText(information);
	}
	
	/**
	 * �����ѡ��ĵ�ͼͼƬ
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
	 * �����ͼ��ѡ��
	 */
	private void createMapButton() {
		//����
		Font font = new Font("",Font.BOLD,20);
		JRadioButtonMenuItem tempButton;
		
		this.mapButton = new LinkedList<JRadioButtonMenuItem>();
		this.mapButtonGroup = new ButtonGroup();
		
		tempButton = new JRadioButtonMenuItem("�򵥵�ͼ");
		tempButton.setFont(font);
		tempButton.addActionListener(this);
		this.mapButton.add(tempButton);
		this.mapButtonGroup.add(tempButton);
		this.add(tempButton);
		tempButton.setBounds(Function.realWidthOf(220),Function.realHeightOf(710),
		  		 			 Function.realWidthOf(150),Function.realHeightOf(50));
		
		tempButton = new JRadioButtonMenuItem("���ӵ�ͼ");
		tempButton.setFont(font);
		tempButton.addActionListener(this);
		this.mapButton.add(tempButton);
		this.mapButtonGroup.add(tempButton);
		this.add(tempButton);
		tempButton.setBounds(Function.realWidthOf(670),Function.realHeightOf(710),
		 			 		 Function.realWidthOf(150),Function.realHeightOf(50));
	}
	/**
	 * ����ѡ��ĵ�ͼ���������ͼ�����Ϣ
	 * @param aim ѡ���ĵ�ͼ
	 */
	private void selectMap(JRadioButtonMenuItem aim) {
		String information;
		
		//ѡ����ͼ
		aim.setSelected(true);
		this.choosedMap = aim.getText();
		
		//������ʾ��Ϣ
		//�򵥵�ͼ��Ϣ
		if(aim.getText().equals("�򵥵�ͼ")) {
			information = "<html>"+
								"<p>��ͼ���ܣ�</p>"+
								"<p>�򵥵�ͼû���ϰ��ֻ��������ǽ������������ֱ�ӹ����Է�Ŷ��</p>"+
						  "</html>";
		}
		//���ӵ�ͼ��Ϣ
		else {
			information = "<html>"+
								"<p>��ͼ���ܣ�</p>"+
								"<p>���ӵ�ͼ�����ϰ��������������ܶԷ��Ĺ���Ŷ��</p>"+
							"</html>";
		}
		
		this.mapInformation.setText(information);
	}
	
	/**
	 * ���조��ʼ��Ϸ���롰ȡ������ť
	 */
	private void createElseButton() {
		Font font = new Font("",Font.BOLD,Function.realWidthOf(25));
		
		this.beginToPlayButton = new JButton("��ʼ��Ϸ");
		this.beginToPlayButton.addActionListener(this);
		this.beginToPlayButton.setFocusable(false);
		this.add(this.beginToPlayButton);
		this.beginToPlayButton.setFont(font);
		this.beginToPlayButton.setBounds(Function.realWidthOf(350),Function.realHeightOf(780),
										 Function.realWidthOf(150),Function.realHeightOf(40));
		
		this.cancelButton = new JButton("ȡ��");
		this.cancelButton.addActionListener(this);
		this.cancelButton.setFocusable(false);
		this.add(this.cancelButton);
		this.cancelButton.setFont(font);
		this.cancelButton.setBounds(Function.realWidthOf(530),Function.realHeightOf(780),
				 					Function.realWidthOf(100),Function.realHeightOf(40));
	}
	
	/**
	 * ��ʼ��ѡ���Ľ�ɫ
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
	 * ��ʼ��Ϸ
	 */
	private void playGame() {
		BattleFrame frame;
		
		//�������д���
		this.dispose();
		//�½���Ϸ����
		frame = new BattleFrame(this.choosedMap,Function.translate(this.choosedRole));
		BattlePanel.frame = frame;
	}
	
	/**
	 * ����ѡ����
	 */
	public ChooseFrame() {
		//1�����ô����һЩ����
		this.setLayout(null);
		this.setTitle("Ӣ�۵�ͼѡ��");
		this.setVisible(true);
		this.setSize(Function.realWidthOf(1020), Function.realHeightOf(900));
		this.setLocation(Function.realWidthOf(100), Function.realHeightOf(20));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//2������Ӣ��ͼƬ
		this.createRolePicture();
		//3������Ӣ�۰�ť
		this.createFirstRoleButton();
		//4�����ص�ͼͼƬ
		this.createMapPicture();
		//5�����ص�ͼ��ť
		this.createMapButton();
		//6������������ť
		this.createElseButton();
		//7����ʼ��ѡ��Ӣ��
		this.initialize();
	}
	
	/**
	 * ������ť�����
	 */
	public void actionPerformed(ActionEvent e) {
		int i;
		
		//ѡ���ɫ
		for(i=0 ; i<this.firstRoleButton.size() ; i++) {
			if(this.firstRoleButton.get(i) == e.getSource()) {
				this.selectRole(this.firstRoleButton.get(i));
				
				break;
			}
		}
		
		//ѡ���ͼ
		for(i=0 ; i<this.mapButton.size() ; i++) {
			if(this.mapButton.get(i) == e.getSource()) {
				this.selectMap(this.mapButton.get(i));
				
				break;
			}
		}
		
		//��
		if(e.getSource() == this.beginToPlayButton) {
			this.playGame();
		}
		
		
		//����
		if(e.getSource() == this.cancelButton) {
			this.dispose();
		}
	}

}

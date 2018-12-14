package ս������;

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
import ����.ComplexShell;
import ����.Function;
import ����.PictureName;
import ����.Point;
import ����.RoleName;
import ����.SimpleShell;
import �ϰ������ͼ.Map;
import ս��.Battle;
import ������.Server;
import ��ɫ.LiPo;
import ��ɫ.Role;

/**
 * ս�������
 * @author ���ӻ�
 *
 */
public class BattlePanel extends JPanel implements KeyListener,ActionListener,MouseListener {
	/**
	 * ���ȱʡ���а汾
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * �������
	 */
	public static BattleFrame frame = null;
	
	
	//ս��
	/**
	 * ս��
	 */
	public Battle battle;
	/**
	 * ��ʾ���ǩ
	 */
	JLabel firstRoleButtonTipLabel;
	
	//�򵥹���
	/**
	 * �򵥹�����ť����
	 */
	Container simpleAttackContainer;
	/**
	 * �򵥹�����ǩ��ʾ��
	 */
	JLabel simpleAttackTipLabel;
	/**
	 * �򵥹�������ť
	 */
	JButton simpleAttackDirectionButton[];
	
	//���ӹ���
	/**
	 * ���ӹ�����ť����
	 */
	Container complexAttackContainer;
	/**
	 * ���ӹ�����ǩ��ʾ��
	 */
	JLabel complexAttackTipLabel;
	/**
	 * ���ӹ�������ť
	 */
	JButton complexAttackDirectionButton[]; 
	
	//��������
	/**
	 * ��ǰ������ڲ����Ľ�ɫ
	 */
	private Role operatingRole;	//��ǰ�ڲ�����Ӣ��
	
	//˽�з�������
	/**
	 * ��������������
	 */
	private void setStaticData() {
		Point.panel = this;
		Map.panel = this;
		Battle.panel = this;
		SimpleShell.panel = this;
		ComplexShell.panel = this;
	}
	
	/**
	 * ����ս��
	 * @param choosedMap ��ͼ����
	 */
	private void createBattle(String choosedMap) {
		battle = new Battle(choosedMap);
		Role.battle = this.battle;
		LiPo.battle = this.battle;
	}
	
	/**
	 * �������ڲ����Ķ���
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
	 * ����򵥹�����ť
	 */
	private void createSimpleAttackDirectionButton() {
		//��ʾ��ǩ
		simpleAttackContainer = new Container();
		simpleAttackTipLabel = new JLabel("�򵥹�������");
		simpleAttackDirectionButton = new JButton[4];
		//��
		simpleAttackDirectionButton[0] = new JButton("��");
		simpleAttackDirectionButton[0].addActionListener(this);
		simpleAttackDirectionButton[0].setFocusable(false);
		//��
		simpleAttackDirectionButton[1] = new JButton("��");
		simpleAttackDirectionButton[1].addActionListener(this);
		simpleAttackDirectionButton[1].setFocusable(false);
		//��
		simpleAttackDirectionButton[2] = new JButton("��");
		simpleAttackDirectionButton[2].addActionListener(this);
		simpleAttackDirectionButton[2].setFocusable(false);
		//��
		simpleAttackDirectionButton[3] = new JButton("��");
		simpleAttackDirectionButton[3].addActionListener(this);
		simpleAttackDirectionButton[3].setFocusable(false);
		//װ������
		simpleAttackContainer.add(simpleAttackTipLabel);
		simpleAttackContainer.add(simpleAttackDirectionButton[0]);
		simpleAttackContainer.add(simpleAttackDirectionButton[1]);
		simpleAttackContainer.add(simpleAttackDirectionButton[2]);
		simpleAttackContainer.add(simpleAttackDirectionButton[3]);
		
		//�ӵ���壬���趨λ��
		this.add(simpleAttackContainer);
		simpleAttackContainer.setLayout(new FlowLayout());
		simpleAttackContainer.setBounds(Function.realWidthOf(620),Function.realHeightOf(770),
										Function.realWidthOf(400),Function.realHeightOf(50));
	}
	
	/**
	 * ���������ӹ�����ť
	 */
	private void createComplexAttackDirectionButton() {
		if(Function.isLiPo(this.operatingRole.roleImg.getDescription())) {
			//��ʾ��ǩ
			complexAttackContainer = new Container();
			complexAttackTipLabel = new JLabel("���ӹ�������");
			complexAttackDirectionButton = new JButton[4];
			//��
			complexAttackDirectionButton[0] = new JButton("��");
			complexAttackDirectionButton[0].addActionListener(this);
			complexAttackDirectionButton[0].setFocusable(false);
			//��
			complexAttackDirectionButton[1] = new JButton("��");
			complexAttackDirectionButton[1].addActionListener(this);
			complexAttackDirectionButton[1].setFocusable(false);
			//��
			complexAttackDirectionButton[2] = new JButton("��");
			complexAttackDirectionButton[2].addActionListener(this);
			complexAttackDirectionButton[2].setFocusable(false);
			//��
			complexAttackDirectionButton[3] = new JButton("��");
			complexAttackDirectionButton[3].addActionListener(this);
			complexAttackDirectionButton[3].setFocusable(false);
			//װ������
			complexAttackContainer.add(complexAttackTipLabel);
			complexAttackContainer.add(complexAttackDirectionButton[0]);
			complexAttackContainer.add(complexAttackDirectionButton[1]);
			complexAttackContainer.add(complexAttackDirectionButton[2]);
			complexAttackContainer.add(complexAttackDirectionButton[3]);
			
			//�ӵ���壬���趨λ��
			this.add(complexAttackContainer);
			complexAttackContainer.setLayout(new FlowLayout());
			complexAttackContainer.setBounds(Function.realWidthOf(620),Function.realHeightOf(820),
											 Function.realWidthOf(400),Function.realHeightOf(50));
		}
	}
	
	/**
	 * ��һ�ʤ
	 */
	private void win() {
		//���ٴ���
		frame.dispose();
		
		//����ʤ����ʾ��
		Font font = new Font("",Font.BOLD,Function.realWidthOf(40));
		JFrame frame = new JFrame("ʤ��");
		JLabel label = new JLabel("�ۣ�̫���ˣ���ɹ��ˣ�");
		label.setFont(font);
		frame.add(label);
		frame.setSize(Function.realWidthOf(480),Function.realHeightOf(100));
		frame.setLocation(Function.realWidthOf(650),Function.realHeightOf(400));
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * ���ʧ��
	 */
	private void beDefeated() {
		//���ٴ���
		frame.dispose();
		
		//����ʧ����ʾ��
		Font font = new Font("",Font.BOLD,Function.realWidthOf(40));
		JFrame frame = new JFrame("ʧ��");
		JLabel label = new JLabel("���ź�����ʧ���ˣ�");
		label.setFont(font);
		frame.add(label);
		frame.setSize(Function.realWidthOf(400),Function.realHeightOf(100));
		frame.setLocation(Function.realWidthOf(700),Function.realHeightOf(400));
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * �趨�򵥹�����ť��Ӧ���¼�
	 * @param e �������Ķ���
	 */
	private void manageSimpleAttack(ActionEvent e) {
		//��
		if(e.getSource() == simpleAttackDirectionButton[0]) {
			Server.sendedOrder = this.operatingRole.rolePosition.toString()+"���ϼ򵥹���";
			Server.sendedOrderIsChanged = true;
			
			this.operatingRole.simpleAttack("��");
		}
		
		//��
		else if(e.getSource() == simpleAttackDirectionButton[1]) {
			Server.sendedOrder = this.operatingRole.rolePosition.toString()+"���¼򵥹���";
			Server.sendedOrderIsChanged = true;
			
			this.operatingRole.simpleAttack("��");
		}
		
		//��
		else if(e.getSource() == simpleAttackDirectionButton[2]) {
			Server.sendedOrder = this.operatingRole.rolePosition.toString()+"����򵥹���";
			Server.sendedOrderIsChanged = true;
			
			this.operatingRole.simpleAttack("��");
		}	
		
		//��
		else if(e.getSource() == simpleAttackDirectionButton[3]) {
			Server.sendedOrder = this.operatingRole.rolePosition.toString()+"���Ҽ򵥹���";
			Server.sendedOrderIsChanged = true;
			
			this.operatingRole.simpleAttack("��");
		}	
	}
	
	/**
	 * �趨���ӹ�����ť��Ӧ���¼�
	 * @param e �������Ķ���
	 */
	private void manageComplexAttack(ActionEvent e) {
		LiPo li;
		
		//���ӹ�����ť--��
		if(e.getSource() == complexAttackDirectionButton[0]){
			//�ж��ǲ������
			if(Function.isLiPo(this.operatingRole.roleImg.getDescription())) {
				li = (LiPo)this.operatingRole;
				
				Server.sendedOrder = this.operatingRole.rolePosition.toString()+"���ϸ��ӹ���";
				Server.sendedOrderIsChanged = true;
				
				
				li.complexAttack("��");
			}
		}
		
		//���ӹ�����ť--��
		else if(e.getSource() == complexAttackDirectionButton[1]){
			//�ж��ǲ������
			if(Function.isLiPo(this.operatingRole.roleImg.getDescription())) {
				li = (LiPo)this.operatingRole;

				Server.sendedOrder = this.operatingRole.rolePosition.toString()+"���¸��ӹ���";
				Server.sendedOrderIsChanged = true;
				
				li.complexAttack("��");
			}
		}		
		
		//���ӹ�����ť--��
		else if(e.getSource() == complexAttackDirectionButton[2]){
			//�ж��ǲ������
			if(Function.isLiPo(this.operatingRole.roleImg.getDescription())) {
				li = (LiPo)this.operatingRole;
				
				Server.sendedOrder = this.operatingRole.rolePosition.toString()+"�����ӹ���";
				Server.sendedOrderIsChanged = true;
				
				li.complexAttack("��");
			}
		}
		
		//���ӹ�����ť--��
		else if(e.getSource() == complexAttackDirectionButton[3]){
			//�ж��ǲ������
			if(Function.isLiPo(this.operatingRole.roleImg.getDescription())) {
				li = (LiPo)this.operatingRole;
				
				Server.sendedOrder = this.operatingRole.rolePosition.toString()+"���Ҹ��ӹ���";
				Server.sendedOrderIsChanged = true;
				
				li.complexAttack("��");
			}
		}
	}
	
	/**
	 * �������
	 * @param e ������
	 */
	private void manageMouse(MouseEvent e) {
		Point anotherPoint;
		String description;
		
		anotherPoint = new Point(e.getY()/30-1,e.getX()/30);
		description = this.battle.map.get(anotherPoint);
		
		//����ո����Ч
		if(description != null) {
			if(description.equals(PictureName.SPACE)) {
				
				Server.sendedOrder = this.operatingRole.rolePosition.toString()+"ȥ"+anotherPoint.toString();
				Server.sendedOrderIsChanged = true;
				
				this.operatingRole.goTo(anotherPoint);
			}
		}
		
		else {
			
		}
	}
	
	/**
	 * ��ȡָ���еķ���
	 * @param order ָ��
	 * @return ����
	 */
	private String getDirection(String order) {
		if(order.indexOf("��") != -1) {
			return "��";
		}
		
		else if(order.indexOf("��") != -1) {
			return "��";
		}
		
		else if(order.indexOf("��") != -1) {
			return "��";
		}

		else if(order.indexOf("��") != -1) {
			return "��";
		}
		
		return null;
	}
	
	/**
	 * ��ָ��β����ȡ��
	 * @param order ָ��
	 * @return Point ��ȡ�ĵ�
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
	 * ��ָ���л�ȡ��ɫ����
	 * @param order ָ��
	 * @return String ��ɫ����
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
	 * ��ȡָ���еĽ�ɫ
	 * @param order ָ��
	 * @return Role ��ȡ�Ľ�ɫ
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
	 * ����һ�����
	 * @param choosedMap ����ϵĵ�ͼ����
	 * @param choosedRoleDescription �������ҵĽ�ɫ����
	 */
	BattlePanel(String choosedMap,String choosedRoleDescription) {
		//��һ�����������о�̬���ݳ�Ա--���
		this.setStaticData();
		//�ڶ���������ս��
		this.createBattle(choosedMap);
		//�������������ɫ(���췽���н����ͼ�����ĵ���)
		this.createOperatingRole(choosedRoleDescription);
		//���Ĳ��������򵥹�����ť
		this.createSimpleAttackDirectionButton();
		//���岽���������ӹ�����ť
		this.createComplexAttackDirectionButton();
	}
	
	//����ʵ�֣�
	//������ǰ�����Ľ�ɫ
	/**
	 * ʵ��ActionListener�ӿڵķ���
	 */
	public void actionPerformed(ActionEvent e) {
		//����򵥹���
		this.manageSimpleAttack(e);
		//�����ӹ���
		if(Function.isLiPo(this.operatingRole.roleImg.getDescription())) {
			this.manageComplexAttack(e);
		}
	}
	
	//����������������
	/**
	 * ʵ��KeyListener�ӿڵķ���
	 */
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			//�����Ȳ���ָ������
			Server.sendedOrder = this.operatingRole.rolePosition.toString()+"������";
			Server.sendedOrderIsChanged = true;
			
			this.operatingRole.goForward("��");
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			Server.sendedOrder = this.operatingRole.rolePosition.toString()+"������";
			Server.sendedOrderIsChanged = true;
			
			this.operatingRole.goForward("��");
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			Server.sendedOrder = this.operatingRole.rolePosition.toString()+"������";
			Server.sendedOrderIsChanged = true;
			
			this.operatingRole.goForward("��");
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			Server.sendedOrder = this.operatingRole.rolePosition.toString()+"������";
			Server.sendedOrderIsChanged = true;
			
			this.operatingRole.goForward("��");
		}
		
		else {
			
		}
	}
	/**
	 * ʵ��KeyListener�ӿڵķ���
	 */
	public void keyReleased(KeyEvent e) {}
	/**
	 * ʵ��KeyListener�ӿڵķ���
	 */
	public void keyTyped(KeyEvent e) {}
	
	/**
	 * �ж�����������ж��Ƿ���ֳɹ���ʤ��
	 * @param description �����Ľ�ɫ����
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
		
		//������������
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
		if(order.indexOf("����") != -1) {
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
			
			//��ָ��Ϊ�򵥹���ָ��
			if(order.indexOf("�򵥹���") != -1) {
				orderRole.simpleAttack(this.getDirection(order));
			}
			
			else if(order.indexOf("���ӹ���") != -1) {
				((LiPo)orderRole).complexAttack(this.getDirection(order));
			}
			
			else if(order.indexOf("��") != -1) {
				orderRole.goForward(this.getDirection(order));
			}
			
			else if(order.indexOf("ȥ") != -1) {
				orderRole.goTo(this.getPointFromTail(order));
			}
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO �Զ����ɵķ������
		
		this.manageMouse(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO �Զ����ɵķ������
		
	}

}

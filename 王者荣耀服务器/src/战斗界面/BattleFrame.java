package ս������;

import javax.swing.JFrame;

import ������.Server;
import ����.Function;

/**
 * ս��������
 * @author ���ӻ�
 *
 */
public class BattleFrame extends JFrame{
	/**
	 * ���ȱʡ���а汾��ʶ
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * ������е����
	 */
	public BattlePanel panel;
	
	public Server server;
	
	/**
	 * ���촰��
	 * @param choosedMap ��ͼ����
	 * @param choosedRoleDescription ��ɫ����
	 */
	public BattleFrame(String choosedMap,String choosedRoleDescription) {
		panel = new BattlePanel(choosedMap,choosedRoleDescription);
		this.setContentPane(panel);
		
		this.getContentPane().setLayout(null);
		
		this.addKeyListener(panel);
		this.addMouseListener(panel);
		
		this.setTitle("������ҫ�ع���");
		this.setVisible(true);
		
		this.setSize(Function.realWidthOf(1818), Function.realHeightOf(930));
		this.setLocation(Function.realWidthOf(40), Function.realHeightOf(20));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Server.battleFrame = this;
	}
}

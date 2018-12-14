package ����;

import java.util.LinkedList;

import ��ɫ.Role;

/**
 * ������
 * @author ���ӻ�
 *
 */
public class Function {
	//˽�з�������
	/**
	 * �������һ����ɫ����Ϊָ��
	 * @return String
	 */
	public static String getAction() {
		 int number = (int)(Math.random()*100);
		 
		 if(number <= 80) {
			 return "��";
		 }
		 
		 else if(number <= 90) {
			 return "����";
		 }
		 
		 else {
			 return "��";
		 }
	 }
	 
	/**
	 * �������һ������
	 * @return String
	 */
	public static String getDirection() {
		 int number = (int)(Math.random()*4);
			
			if(number == 0) {
				return "��";
			}
			
			else if(number == 1) {
				return "��";
			}
			
			else if(number == 2) {
				return "��";
			}
			
			else {
				return "��";
			}
	 }
	
	
	//���з�������
	/**
	 * �ж�һ�������Ƿ��ǽ�ɫ
	 * @param description ����
	 * @return boolean
	 */
	public static boolean isRole(String description) {
		 if(isFirstRole(description) || isSecondRole(description)) {
			 return true;
		 }
		 
		 return false;
	 }
	
	/**
	 * �ж�һ�������Ƿ���һ�ӽ�ɫ
	 * @param description ��ɫ����
	 * @return boolean
	 */
	public static boolean isFirstRole(String description) {
		if(description.equals(PictureName.ROLE_A) ||
		   description.equals(PictureName.ROLE_a) ||
		   description.equals(RoleName.ROLE_A) ||
		   description.equals(RoleName.ROLE_a) ) {
			 return true;
		 }
		
		 return false;
	 }
	
	/**
	 * �ж�һ�������Ƿ��Ƕ��ӽ�ɫ
	 * @param description ����
	 * @return boolean
	 */
	public static boolean isSecondRole(String description) {
		 if(description.equals(PictureName.ROLE_N) ||
			description.equals(PictureName.ROLE_n) ||
			description.equals(RoleName.ROLE_N) ||
			description.equals(RoleName.ROLE_n) ) {
			 
			 return true;
		 }
		 
		 return false;
	 }
	
	/**
	 * �ж�һ�������Ƿ������
	 * @param description ָ��������
	 * @return boolean
	 */
	public static boolean isLiPo(String description) {
		 if(description.equals(PictureName.ROLE_A) ||
			description.equals(PictureName.ROLE_N)) {
			 
			 return true;
		 }
		 
		 if(description.equals(PictureName.ROLE_A_CHOOSE) ||
			description.equals(PictureName.ROLE_N_CHOOSE)) {
					 
			 return true;
		}
		 
		 if(description.equals(RoleName.ROLE_A) ||
			description.equals(RoleName.ROLE_N)) {
					 
			return true;
		}
				 
		return false;
	 }
	
	/**
	 * ��ָ���������ҵ����������Ľ�ɫ
	 * @param tempPoint ָ����
	 * @param firstRole ����һ
	 * @param secondRole ���϶�
	 * @return Role ��õĽ�ɫ
	 */
	public static Role searchRole(Point tempPoint,LinkedList<Role>firstRole,LinkedList<Role>secondRole) {
		 int i;
		 
		 for(i=0 ; i<firstRole.size() ; i++) {
			 if(firstRole.get(i).rolePosition.isSameWith(tempPoint)) {
				 return firstRole.get(i);
			 }
		 }
		 
		 for(i=0 ; i<secondRole.size() ; i++) {
			 if(secondRole.get(i).rolePosition.isSameWith(tempPoint)) {
				 return secondRole.get(i);
			 }
		 }
		 
		 return null;
	 }
	 
	/**
	 * �ж�����������Ӧ�Ľ�ɫ�Ƿ��Ƕ���
	 * @param description1 ��ɫ����1
	 * @param description2 ��ɫ����2
	 * @return boolean
	 */
	public static boolean isFriend(String description1,String description2) {
		 int tag1,tag2;
		 
		 if(isFirstRole(description1)) {
			 tag1 = 1;
		 }
		 
		 else {
			 tag1 = -1;
		 }
		 
		 if(isFirstRole(description2)) {
			 tag2 = 1;
		 }
		 
		 else {
			 tag2 = -1;
		 }
		 
		 if(tag1*tag2 > 0) {
			 return true;
		 }
		 
		 else {
			 return false;
		 }
	 }
	 
	/**
	 * ��ָ����ɫ�������Ƴ�ָ����ɫ
	 * @param R ���Ƴ��Ľ�ɫ
	 * @param firstRole ��ɫ����һ
	 * @param secondRole ��ɫ���϶�
	 */
	public static void remove(Role R,LinkedList<Role>firstRole,LinkedList<Role>secondRole) {
		 if(firstRole.contains(R)) {
			 firstRole.remove(R);
		 }
		 
		 else if(secondRole.contains(R)) {
			 secondRole.remove(R);
		 }
	 }

	/**
	 * ����ɫ�����ͽ�ɫ���ƽ��л���
	 * @param oldString ��ȡ���ַ���
	 * @return String ���ַ���
	 */
	public static String translate(String oldString) {
		 switch(oldString) {
		 //��Ƭ��ת������
		 case PictureName.ROLE_A:
			 return RoleName.ROLE_A;
		 case PictureName.ROLE_a:
			 return RoleName.ROLE_a;
			 
		 case PictureName.ROLE_N:
			 return RoleName.ROLE_N;
		 case PictureName.ROLE_n:
			 return RoleName.ROLE_n;
			 
		//����ת��Ƭ����
		 case RoleName.ROLE_A:
			 return PictureName.ROLE_A;
		 case RoleName.ROLE_a:
			 return PictureName.ROLE_a;
			 
		 case RoleName.ROLE_N:
			 return PictureName.ROLE_N;
		 case RoleName.ROLE_n:
			 return PictureName.ROLE_n;
		 }
		 
		 return null;
	 }

	/**
	 * ��ȡ��Ե�ǰ��Ļ�Ŀ��
	 * @param oldSize ���1920��˵�Ŀ�
	 * @return ��Ե�ǰ��Ļ��Ŀ�
	 */
	public static int realWidthOf(int oldSize) {
		return (int)(oldSize*Size.WIDTH_SCALING);
	}
	
	public static int realHeightOf(int oldSize) {
		return (int)(oldSize*Size.HEIGHT_SCALING);
	}
	
}

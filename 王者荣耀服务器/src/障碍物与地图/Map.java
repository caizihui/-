package �ϰ������ͼ;

import ս������.BattlePanel;
import ����.PictureName;
import ����.Point;
import ����.Size;
import ����.Function;
import ����.MyImageIcon;
import ����.MyLabel;

/**
 * ��ͼ��
 * @author ���ӻ�
 *
 */
public class Map {
	/**
	 * ��ͼ���������
	 */
	public static BattlePanel panel = null;
	/**
	 * ��ǩ,�ں�ͼƬ
	 */
	public MyLabel mapCellLabel[][];
	
	/**
	 * Ϊ��ͼ���ӵ����ϰ���
	 * @param barrier �ϰ���
	 */
	private void addBarrier(Barrier barrier) {
		int i,j;
		int beginX,beginY;
		
		beginX = barrier.position.getX();
		beginY = barrier.position.getY();
		
		for(i=0 ; i<barrier.height && beginX+i<mapCellLabel.length ; i++) {
			for(j=0 ; j<barrier.width && beginY+j<mapCellLabel[i].length ; j++) {
				//ת��size���½�����MyImageIcon�Ĺ��캯��
				mapCellLabel[beginX+i][beginY+j].setIcon(new MyImageIcon(PictureName.WALL,Size.MAP_CELL_WIDTH,Size.MAP_CELL_HEIGHT));
			}
		}
	}
	
	/**
	 * �����ͼ
	 * @param width ��ͼ��
	 * @param height ��ͼ��
	 * @param barrier ��ͼ�����е��ϰ���
	 */
	public Map(int width,int height,Barrier barrier[]) {
		int i,j;
		
		mapCellLabel = new MyLabel[height][width];
		
		for(i=0 ; i<mapCellLabel.length ; i++) {
			//��һ�������һ�����⣬ȫ��ǽ
			if(i==0 || i==mapCellLabel.length-1) {
				for(j=0 ; j<mapCellLabel[i].length ; j++) {
					mapCellLabel[i][j] = new MyLabel(new MyImageIcon(PictureName.WALL,Size.MAP_CELL_WIDTH,Size.MAP_CELL_HEIGHT));
					
					panel.add(mapCellLabel[i][j]);
					mapCellLabel[i][j].setLocation(j*Size.MAP_CELL_WIDTH, i*Size.MAP_CELL_HEIGHT);
				}
			}
			
			else {
				for(j=0 ; j<mapCellLabel[i].length ; j++) {
					if(j==0 || j==mapCellLabel[i].length-1) {
						mapCellLabel[i][j] = new MyLabel(new MyImageIcon(PictureName.WALL,Size.MAP_CELL_WIDTH,Size.MAP_CELL_HEIGHT));
					}
					
					else {
						mapCellLabel[i][j] = new MyLabel(new MyImageIcon(PictureName.SPACE,Size.MAP_CELL_WIDTH,Size.MAP_CELL_HEIGHT));
					}
					
					panel.add(mapCellLabel[i][j]);
					mapCellLabel[i][j].setLocation(j*Size.MAP_CELL_WIDTH, i*Size.MAP_CELL_HEIGHT);
				}
			}
		}
		
		//�����ϰ���
		for(i=0 ; i<barrier.length ; i++) {
			this.addBarrier(barrier[i]);
		}
	}
	
	/**
	 * �ж�һ�����Ƿ��ڵ�ͼ��
	 * @param position ���λ��
	 * @return boolean
	 */
	public boolean contains(Point position) {
		if(position.getX() >= 0 && position.getX() < mapCellLabel.length 
		&& position.getY() >= 0 && position.getY() < mapCellLabel[0].length) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * ��ȡָ�����ͼƬ����
	 * @param position ָ����
	 * @return String �õ��ͼƬ����
	 */
	public String get(Point position) {
		if(contains(position)) {
			return mapCellLabel[position.getX()][position.getY()].img.getDescription();
		}
		
		return null;
	}
	
	/**
	 * ���ĵ�ͼ��ָ�����ͼƬ��ֻ�ܸ��Ŀհ׸�
	 * @param position ָ����
	 * @param description ͼƬ����
	 * @return boolean �����Ƿ�ɹ�����Ϣ
	 */
	public boolean replace(Point position,String description) {
		String tempDescription;
		
		if(contains(position)) {
			tempDescription = get(position);
			
			//����ǽ��Ӣ��
			if(tempDescription.equals(PictureName.WALL)==false && Function.isRole(tempDescription)==false) {
				
				mapCellLabel[position.getX()][position.getY()].setIcon(new MyImageIcon(description,Size.MAP_CELL_WIDTH,Size.MAP_CELL_HEIGHT));
				
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * ���ĵ�ͼ��ָ�����ͼƬ������ǽ�������Ķ��ܸ���
	 * @param position ָ����
	 * @param description ͼƬ����
	 * @return boolean �����Ƿ�ɹ�����Ϣ
	 */
	public boolean sharpReplace(Point position,String description) {
		String tempDescription;
		
		if(contains(position)) {
			tempDescription = get(position);
			
			//����ǽ
			if(tempDescription.equals(PictureName.WALL)==false) {
				mapCellLabel[position.getX()][position.getY()].setIcon(new MyImageIcon(description,Size.MAP_CELL_WIDTH,Size.MAP_CELL_HEIGHT));
				
				return true;
			}
		}
		
		return false;
	}

	/**
	 * ��ȡ��ͼ�ϵ�һ���ո��
	 * @return Point �ո��
	 */
	public Point getASpacePoint() {
		Point result;
		
		while(true) {
			result = new Point((int)(Math.random()*this.mapCellLabel.length),(int)(Math.random()*this.mapCellLabel[0].length));
			
			if(this.get(result).equals(PictureName.SPACE)) {
				return result;
			}
		}
	}
}

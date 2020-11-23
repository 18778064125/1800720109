import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;

public class AI extends MIDlet
{
	Display display;
	MainCanvas mc;
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas
{

	/*
	����������
	�﷨���������� �������ƣ���ʶ����;
	*/
	int x,y;
	int flag;
	Image heroImg[][]=new Image[4][3];
	//4������ÿ������3��ͼƬ��0��ʾleft��1��ʾright,��2��ʾup,3��ʾdown


	//Image heroLeftImg[]=new Image[3];
	//Image heroRightImg[]=new Image[3];
	//Image heroUpImg[]=new Image[3];
	//Image heroDownImg[]=new Image[3];
	Image currentImg;
	public MainCanvas(){
		try
		{
			/*
			��������ֵ
			�﷨����������=value;
			*/
			for(int i=0;i<heroImg.length;i++){
				for(int j=0;j<heroImg[i].length;j++){
					heroImg[i][j]=Image.createImage("/sayo"+i+j+".png");
				}}
				
			currentImg=heroImg[3][1];
			x=120;
			y=100;
			flag=1;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);//120��X���ꡢ100��Y����
	}
	public void changepicanddirect(int direction){
	if(flag==1){
		    currentImg=heroImg[direction][0];
	        flag++;
		}
		else if(flag==2){
			currentImg=heroImg[direction][2];
			flag=1;
		}
		repaint();
	}
    public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		/*
		action��ֵ��UP��DOWN��LEFT��RIGHT
		*/
		if(action==LEFT){
			changepicanddirect(0);
			x=x-3;
		}
		if(action==UP){
			changepicanddirect(2);
			y=y-3;
			repaint();
		}
		if(action==RIGHT){
			changepicanddirect(1);
			x=x+3;
			repaint();
		}
		if(action==DOWN){
			changepicanddirect(3);
			y=y+6;
			repaint();
		}
		}
}
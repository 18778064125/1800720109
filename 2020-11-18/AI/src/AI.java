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
	int leftflag;
	Image downImg,leftImg,rightImg,upImg,Img5,Img6,currentImg;
	public MainCanvas(){
		try
		{
			/*
			��������ֵ
			�﷨����������=value;
			*/
			downImg=Image.createImage("/sayo10.png");
			leftImg=Image.createImage("/sayo12.png");
			rightImg=Image.createImage("/sayo16.png");
			upImg=Image.createImage("/sayo14.png");
           Img5=Image.createImage("/sayo02.png");
           Img6=Image.createImage("/sayo22.png");
			currentImg=downImg;
			x=120;
			y=100;
			leftflag=1;
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
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		/*
		action��ֵ��UP��DOWN��LEFT��RIGHT
		*/
		if(action==LEFT){
			/*
			ʵ��ת�����
			*/
			/*
			���������¸�ֵ����
			*/
			if(leftflag==1){
				currentImg=Img5;
			    leftflag++;
		}
			else if(leftflag==2){
			currentImg=Img6;
			leftflag=1;
			}
			System.out.println("����ת");
			x=x-1;
            repaint();
		if(action==RIGHT){
			currentImg=rightImg;
		}
		if(action==UP){
			currentImg=upImg;
		}
		if(action==DOWN){
			currentImg=downImg;
		}
		
	}
}
}

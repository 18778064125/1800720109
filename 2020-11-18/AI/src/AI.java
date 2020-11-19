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
	变量的声明
	语法：数据类型 变量名称（标识符）;
	*/
	int x,y;
	int leftflag;
	Image downImg,leftImg,rightImg,upImg,Img5,Img6,currentImg;
	public MainCanvas(){
		try
		{
			/*
			给变量赋值
			语法：变量名称=value;
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
		g.drawImage(currentImg,x,y,0);//120：X坐标、100：Y坐标
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		/*
		action的值：UP、DOWN、LEFT、RIGHT
		*/
		if(action==LEFT){
			/*
			实现转向代码
			*/
			/*
			给变量重新赋值即可
			*/
			if(leftflag==1){
				currentImg=Img5;
			    leftflag++;
		}
			else if(leftflag==2){
			currentImg=Img6;
			leftflag=1;
			}
			System.out.println("向左转");
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

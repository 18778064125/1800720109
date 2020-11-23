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
	int flag;
	Image heroImg[][]=new Image[4][3];
	//4个方向，每个方向3张图片，0表示left，1表示right,，2表示up,3表示down


	//Image heroLeftImg[]=new Image[3];
	//Image heroRightImg[]=new Image[3];
	//Image heroUpImg[]=new Image[3];
	//Image heroDownImg[]=new Image[3];
	Image currentImg;
	public MainCanvas(){
		try
		{
			/*
			给变量赋值
			语法：变量名称=value;
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
		g.drawImage(currentImg,x,y,0);//120：X坐标、100：Y坐标
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
		action的值：UP、DOWN、LEFT、RIGHT
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
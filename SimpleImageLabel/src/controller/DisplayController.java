package controller;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import model.DisplayModel;
import view.DisplayView;

public class DisplayController implements MouseListener, MouseMotionListener, KeyListener{

	private DisplayModel model;
	private DisplayView view;
	private int x,y,w,h;
	private int mode;
	public static int RECT_MODE = 1;
	public static int POLYGON_MODE = 2;
	private boolean firstClick;
	public boolean finished;

	public DisplayController(DisplayModel model) {
		this.model=model;
		this.x=0;
		this.y=0;
		this.w=0;
		this.h=0;
		this.mode = DisplayController.RECT_MODE;
		this.firstClick=true;
		finished = false;
	}

	public int getMode() {
		return mode;
	}

	public void setMode(int mode) {
		this.mode = mode;
	}

	public void setView(DisplayView view)
	{
		this.view = view;
	}

	final public DisplayView getView()
	{
		return this.view;
	}

	public void setModel(DisplayModel model)
	{
		this.model = model;
	}

	public DisplayModel getModel()
	{
		return this.model;
	}

	public void mousePressed(MouseEvent e)
	{
		if(this.mode==DisplayController.RECT_MODE){
			this.x=0;
			this.y=0;
			this.w=0;
			this.h=0;
			this.x=e.getX();
			this.y=e.getY();
			this.model.selection = new Rectangle(this.x,this.y,this.w,this.h);
			this.view.parent.statsPanel.x.setText(this.x+"");
			this.view.parent.statsPanel.y.setText(this.y+"");
			this.view.parent.statsPanel.w.setText(this.w+"");
			this.view.parent.statsPanel.h.setText(this.h+"");
			if(Integer.parseInt(this.view.parent.statsPanel.width.getText())!=0 && Integer.parseInt(this.view.parent.statsPanel.height.getText())!=0){
				this.view.parent.statsPanel.xmin.setText((this.x/(float)Integer.parseInt(this.view.parent.statsPanel.width.getText()))+"");
				this.view.parent.statsPanel.ymin.setText((this.y/(float)Integer.parseInt(this.view.parent.statsPanel.height.getText()))+"");
				this.view.parent.statsPanel.xmax.setText(((this.x+this.w)/(float)Integer.parseInt(this.view.parent.statsPanel.width.getText()))+"");
				this.view.parent.statsPanel.ymax.setText(((this.y+this.h)/(float)Integer.parseInt(this.view.parent.statsPanel.height.getText()))+"");
			}
			this.view.repaint();
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if(this.mode==DisplayController.RECT_MODE){
			int xTemp = e.getX();
			int yTemp = e.getY();
			int xReal = 0;
			int yReal = 0;
			this.w = Math.abs(xTemp-x);
			this.h = Math.abs(yTemp-y);
			if(x<=xTemp && y<=yTemp){
				this.model.selection = new Rectangle(this.x,this.y,this.w,this.h);
				xReal = this.x;
				yReal = this.y;
			}else if(x>xTemp && y<=yTemp){
				this.model.selection = new Rectangle(this.x-this.w,this.y,this.w,this.h);
				xReal = this.x-this.w;
				yReal = this.y;
			}else if(x<=xTemp && y>yTemp){
				this.model.selection = new Rectangle(this.x,this.y-this.h,this.w,this.h);
				xReal = this.x;
				yReal = this.y-this.h;
			}else if(x>xTemp && y>yTemp){
				this.model.selection = new Rectangle(this.x-this.w,this.y-this.h,this.w,this.h);
				xReal = this.x-this.w;
				yReal = this.y-this.h;
			}
			this.view.parent.statsPanel.x.setText(xReal+"");
			this.view.parent.statsPanel.y.setText(yReal+"");
			this.view.parent.statsPanel.w.setText(this.w+"");
			this.view.parent.statsPanel.h.setText(this.h+"");
			if(Integer.parseInt(this.view.parent.statsPanel.width.getText())!=0 && Integer.parseInt(this.view.parent.statsPanel.height.getText())!=0){
				this.view.parent.statsPanel.xmin.setText((xReal/(float)Integer.parseInt(this.view.parent.statsPanel.width.getText()))+"");
				this.view.parent.statsPanel.ymin.setText((yReal/(float)Integer.parseInt(this.view.parent.statsPanel.height.getText()))+"");
				this.view.parent.statsPanel.xmax.setText(((xReal+this.w)/(float)Integer.parseInt(this.view.parent.statsPanel.width.getText()))+"");
				this.view.parent.statsPanel.ymax.setText(((yReal+this.h)/(float)Integer.parseInt(this.view.parent.statsPanel.height.getText()))+"");
			}
			this.view.repaint();
		}
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(this.mode==DisplayController.POLYGON_MODE){
			if (arg0.getButton() == MouseEvent.BUTTON1){
                //System.out.println("Left button clicked");
				if(firstClick){
					this.model.polygon.clear();
					firstClick = false;
					finished=false;
				}
				this.view.parent.statsPanel.x.setText(arg0.getX()+"");
				this.view.parent.statsPanel.y.setText(arg0.getY()+"");
				this.model.polygon.add(arg0.getPoint());
            } else if (arg0.getButton() == MouseEvent.BUTTON2){
               //System.out.println("Middle button clicked");
            	if(!this.model.polygon.isEmpty()){
            		this.model.polygon.remove(this.model.polygon.size()-1);
            	}
            } else if (arg0.getButton() == MouseEvent.BUTTON3) {
               //System.out.println("Right button clicked");
            	firstClick = true;
            	finished=true;
            } 
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}

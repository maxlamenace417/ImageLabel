package view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JScrollPane;

public class ImageScrollPane extends JScrollPane {
	private DisplayView panel;

	public ImageScrollPane(){
		super();
		this.setPreferredSize(new Dimension(500,500));
		this.setSize(new Dimension(500,500));
		this.getHorizontalScrollBar().setUnitIncrement(20);
		this.getVerticalScrollBar().setUnitIncrement(20); 
	}
	
	public void setPanel(DisplayView imgPanel){
		this.panel=imgPanel;
		this.setViewportView(imgPanel);
	}
	
	public DisplayView getPanel(){
		return panel;
	}
	
	public void paint(Graphics g)
	{
		super.updateUI();
		super.paint(g);
	}
}

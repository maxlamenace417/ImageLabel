package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import controller.DisplayController;
import model.DisplayModel;
import ui.MainFrame;

public class DisplayView extends JPanel {
	
	public MainFrame parent;
	protected DisplayModel model;
	private DisplayController controller;
	
	public DisplayView(DisplayModel model,MainFrame parent) {
		this.model = model;
		this.setPreferredSize(new Dimension(this.model.image.getWidth(),this.model.image.getHeight()));
		this.parent = parent;
		this.controller = defaultController(model);
		this.controller.setView(this);
		this.addMouseListener(this.controller);
		this.addMouseMotionListener(this.controller);
		this.addKeyListener(this.controller);
	}
	
	public void setModel(DisplayModel model)
	{
		this.model = model;
		this.controller.setModel(model);
	}
	
	public DisplayModel getModel()
	{
		return this.model;
	}
	
	
	final public DisplayController getController()
	{
		return this.controller;
	}
	
	public DisplayController defaultController(DisplayModel model)
	{
		return new DisplayController(model);
	}

	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2 = (Graphics2D)g;
		DisplayModel model = (DisplayModel)this.model;
		g2.drawImage(model.image, 0, 0, null);
		g2.setColor(Color.RED);
		g2.setStroke(new BasicStroke(3));
		g2.drawRect(model.selection.x, model.selection.y, model.selection.width, model.selection.height);
	}
}
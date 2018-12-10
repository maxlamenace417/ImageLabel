package view;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import controller.DisplayController;
import ui.MainFrame;

public class ChangeModeButton extends JButton implements ActionListener{
	
	public MainFrame parent;

	public ChangeModeButton(String title, MainFrame parent){
		super(title);
		this.parent=parent;
		this.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(parent.displayView.controller.getMode()==DisplayController.RECT_MODE){
			parent.displayView.controller.setMode(DisplayController.POLYGON_MODE);
			parent.displayModel.polygon.clear();
		}else if(parent.displayView.controller.getMode()==DisplayController.POLYGON_MODE){
			parent.displayView.controller.setMode(DisplayController.RECT_MODE);
			parent.displayModel.selection = new Rectangle(0,0,0,0);
		}
		parent.statsPanel.reset();
		this.parent.repaint();
		this.parent.displayView.repaint();
	}

}

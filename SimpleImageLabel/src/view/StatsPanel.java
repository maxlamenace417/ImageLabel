package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StatsPanel extends JPanel {

	public JLabel width;
	public JLabel height;
	public JLabel x;
	public JLabel y;
	public JLabel w;
	public JLabel h;
	public JLabel xmin;
	public JLabel ymin;
	public JLabel xmax;
	public JLabel ymax;
	
	public StatsPanel(){
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		//this.setPreferredSize(new Dimension(150,100));
		this.width = new JLabel("0");
		this.height = new JLabel("0");
		this.x = new JLabel("0");
		this.y = new JLabel("0");
		this.w = new JLabel("0");
		this.h = new JLabel("0");
		this.xmin = new JLabel("0");
		this.ymin = new JLabel("0");
		this.xmax = new JLabel("0");		
		this.ymax = new JLabel("0");
		JPanel widthPanel = new JPanel();
		widthPanel.add(new JLabel("width: "));
		widthPanel.add(this.width);
		this.add(widthPanel);
		JPanel heightPanel = new JPanel();
		heightPanel.add(new JLabel("height: "));
		heightPanel.add(this.height);
		this.add(heightPanel);
		JPanel xPanel = new JPanel();
		xPanel.add(new JLabel("x: "));
		xPanel.add(this.x);
		this.add(xPanel);
		JPanel yPanel = new JPanel();
		yPanel.add(new JLabel("y: "));
		yPanel.add(this.y);
		this.add(yPanel);
		JPanel wPanel = new JPanel();
		wPanel.add(new JLabel("w: "));
		wPanel.add(this.w);
		this.add(wPanel);
		JPanel hPanel = new JPanel();
		hPanel.add(new JLabel("h: "));
		hPanel.add(this.h);
		this.add(hPanel);
		JPanel xminPanel = new JPanel();
		xminPanel.add(new JLabel("xmin: "));
		xminPanel.add(this.xmin);
		this.add(xminPanel);
		JPanel yminPanel = new JPanel();
		yminPanel.add(new JLabel("ymin: "));
		yminPanel.add(this.ymin);
		this.add(yminPanel);
		JPanel xmaxPanel = new JPanel();
		xmaxPanel.add(new JLabel("xmax: "));
		xmaxPanel.add(this.xmax);
		this.add(xmaxPanel);
		JPanel ymaxPanel = new JPanel();
		ymaxPanel.add(new JLabel("ymax: "));
		ymaxPanel.add(this.ymax);
		this.add(ymaxPanel);
	}

	public void reset() {
		// TODO Auto-generated method stub
		this.x.setText("0");
		this.y.setText("0");
		this.w.setText("0");
		this.h.setText("0");
		this.xmin.setText("0");
		this.ymin.setText("0");
		this.xmax.setText("0");		
		this.ymax.setText("0");
		this.repaint();
	}
	
}

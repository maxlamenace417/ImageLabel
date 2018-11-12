package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import ui.MainFrame;
import utils.Utils;

public class LoadButtonView extends JButton implements ActionListener{

	public MainFrame parent;
	
	public LoadButtonView(String title, MainFrame parent){
		super(title);
		this.parent=parent;
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JFileChooser chooser = new JFileChooser(this.parent.lastOpenedFile);
		chooser.setDialogTitle("Load Picture");
	    FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG & JPG & GIF & TIF & BMP Images", "png", "jpg","jpeg", "gif","tif","bmp");
	    chooser.addChoosableFileFilter(filter);
	    FileNameExtensionFilter filterJPG = new FileNameExtensionFilter("JPG Images (.jpg, .jpeg)", "jpg","jpeg");
	    chooser.addChoosableFileFilter(filterJPG);
	    FileNameExtensionFilter filterGIF = new FileNameExtensionFilter("GIF Images (.gif)","gif");
	    chooser.addChoosableFileFilter(filterGIF);
	    FileNameExtensionFilter filterTIF = new FileNameExtensionFilter("TIF Images (.tif)","tif");
	    chooser.addChoosableFileFilter(filterTIF);
	    FileNameExtensionFilter filterBMP = new FileNameExtensionFilter("BMP Images (.bmp)","bmp");
	    chooser.addChoosableFileFilter(filterBMP);
	    FileNameExtensionFilter filterPNG = new FileNameExtensionFilter("PNG Images (.png)", "png");
	    chooser.addChoosableFileFilter(filterPNG);
	    chooser.setAcceptAllFileFilterUsed(false);
	    int returnVal = chooser.showOpenDialog(null);
	    String filePath = "";
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	    	filePath=chooser.getSelectedFile().getAbsolutePath();
	    	this.parent.img_path = filePath;
	    	this.parent.lastOpenedFile = filePath;
			BufferedImage img = Utils.loadImage(filePath);
			
			this.parent.pathPanel.filePath.setText(filePath.replace("\\", "/"));
			this.parent.pathPanel.fileName.setText(chooser.getSelectedFile().getName().split("\\.")[0]);
			this.parent.pathPanel.fileExtension.setText(getFileExtension(chooser.getSelectedFile()));
			this.parent.statsPanel.width.setText(img.getWidth()+"");
			this.parent.statsPanel.height.setText(img.getHeight()+"");
			
			this.parent.displayModel.image = img;
			this.parent.displayView.setPreferredSize(new Dimension(img.getWidth(),img.getHeight()));
			this.parent.repaint();
	    }		
	}
	
	private static String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
        return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }
}

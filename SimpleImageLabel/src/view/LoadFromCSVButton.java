package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.ModeleDynamiqueObject;
import model.TableLineModel;
import ui.MainFrame;
import utils.CSVUtils;
import utils.Utils;

public class LoadFromCSVButton extends JButton implements ActionListener{

	public MainFrame parent;
	
	public LoadFromCSVButton(String title, MainFrame parent){
		super(title);
		this.parent=parent;
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JFileChooser chooser = new JFileChooser(this.parent.lastOpenedFile);
		chooser.setDialogTitle("Load From CSV");
	    FileNameExtensionFilter filterCSV = new FileNameExtensionFilter("CSV (.csv)", "csv");
	    chooser.addChoosableFileFilter(filterCSV);
	    chooser.setAcceptAllFileFilterUsed(false);
	    int returnVal = chooser.showOpenDialog(null);
	    String filePath = "";
	    if(returnVal == JFileChooser.APPROVE_OPTION) {	    	
	    	filePath=chooser.getSelectedFile().getAbsolutePath();
	    	this.parent.lastOpenedFile = filePath;
	    	List<List<String>> CSVcontent =  CSVUtils.readCSV(filePath, ';');
	    	ModeleDynamiqueObject tableModel = new ModeleDynamiqueObject();
	    	for(int i=1;i<CSVcontent.size();i++){
	    		List<String> lineContent = CSVcontent.get(i);
	    		tableModel.addTableLineModel(new TableLineModel(lineContent.get(0), lineContent.get(1), lineContent.get(2), lineContent.get(3),
	    				lineContent.get(4),	lineContent.get(5), lineContent.get(6), lineContent.get(7), lineContent.get(8), lineContent.get(9),
	    				lineContent.get(10), lineContent.get(11), lineContent.get(12), lineContent.get(13), lineContent.get(14)));
	    	}
	    	this.parent.myTableModel = tableModel;
	    	this.parent.myJTable.setModel(tableModel);
			this.parent.repaint();
	    }	
		
	}
}

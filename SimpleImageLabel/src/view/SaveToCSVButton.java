package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import ui.MainFrame;
import utils.CSVUtils;

public class SaveToCSVButton extends JButton implements ActionListener{

	public MainFrame parent;

	public SaveToCSVButton(String title, MainFrame parent){
		super(title);
		this.parent=parent;
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JFileChooser chooser = new JFileChooser(this.parent.lastOpenedFile);
		chooser.setDialogTitle("Save To CSV");
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		//
		// disable the "All files" option.
		//
		FileNameExtensionFilter filterCSV = new FileNameExtensionFilter("CSV (.csv)", "csv");
		chooser.addChoosableFileFilter(filterCSV);
		chooser.setAcceptAllFileFilterUsed(false);
		//    
		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			String csvFile = chooser.getSelectedFile().toString();
			this.parent.lastOpenedFile = csvFile;
			FileWriter writer;
			try {
				writer = new FileWriter(csvFile);
				CSVUtils.writeLine(writer, Arrays.asList(parent.myTableModel.getEntetes()));

				for(int i=0;i<parent.myTableModel.getRowCount();i++){
					List<String> toWrite = new ArrayList<>();
					for(int j=0;j<parent.myTableModel.getColumnCount();j++){
						toWrite.add((String) parent.myTableModel.getValueAt(i, j));
					}
					CSVUtils.writeLine(writer, toWrite);
				}

				writer.flush();
				writer.close();	
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}




	}
}

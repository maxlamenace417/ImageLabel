package view;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PathPanel extends JPanel {
	public JTextField filePath;
	public JTextField customFilePath;
	public JTextField fileName;
	public JTextField fileExtension;
	public JTextField category;
	public JTextField id;
	
	public PathPanel(){
		this.filePath = new JTextField("");
		this.customFilePath = new JTextField("");
		this.customFilePath.setPreferredSize(new Dimension(150, 20));
		this.fileName = new JTextField("");
		this.fileExtension = new JTextField("");
		this.category = new JTextField("");
		this.category.setPreferredSize(new Dimension(80, 20));
		this.id = new JTextField("");
		this.id.setPreferredSize(new Dimension(40, 20));
		
		this.add(new JLabel("filePath: "));
		this.add(filePath);
		this.add(new JLabel("customFilePath: "));
		this.add(customFilePath);
		this.add(new JLabel("fileName: "));
		this.add(fileName);
		this.add(new JLabel("fileExtension: "));
		this.add(fileExtension);
		this.add(new JLabel("category: "));
		this.add(category);
		this.add(new JLabel("id: "));
		this.add(id);
	}
}

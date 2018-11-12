package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ModeleDynamiqueObject extends AbstractTableModel {
    private final List<TableLineModel> tableLineModels = new ArrayList<TableLineModel>();
 
    private final String[] entetes = {"FilePath","FileName","FileExtension","Category","Id","Width","Height","X",
    		"Y","W","H","xMin","yMin","xMax","yMax"};
 
    public ModeleDynamiqueObject() {
        super();
    }
 
    public String[] getEntetes(){
    	return entetes;
    }
    public int getRowCount() {
        return tableLineModels.size();
    }
 
    public int getColumnCount() {
        return entetes.length;
    }
 
    public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }
 
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return tableLineModels.get(rowIndex).getFilePath();
            case 1:
                return tableLineModels.get(rowIndex).getFileName();
            case 2:
                return tableLineModels.get(rowIndex).getFileExtension();
            case 3:
                return tableLineModels.get(rowIndex).getCategory();
            case 4:
                return tableLineModels.get(rowIndex).getId();
            case 5:
                return tableLineModels.get(rowIndex).getWidth();
            case 6:
                return tableLineModels.get(rowIndex).getHeight();
            case 7:
                return tableLineModels.get(rowIndex).getX();
            case 8:
                return tableLineModels.get(rowIndex).getY();
            case 9:
                return tableLineModels.get(rowIndex).getW();
            case 10:
                return tableLineModels.get(rowIndex).getH();
            case 11:
                return tableLineModels.get(rowIndex).getXmin();
            case 12:
                return tableLineModels.get(rowIndex).getYmin();
            case 13:
                return tableLineModels.get(rowIndex).getXmax();
            case 14:
                return tableLineModels.get(rowIndex).getYmax();
            default:
                return null; //Ne devrait jamais arriver
        }
    }
 
    public void addTableLineModel(TableLineModel tableLineModel) {
    	tableLineModels.add(tableLineModel);
 
        fireTableRowsInserted(tableLineModels.size() -1, tableLineModels.size() -1);
    }
 
    public void removeTableLineModel(int rowIndex) {
    	tableLineModels.remove(rowIndex);
 
        fireTableRowsDeleted(rowIndex, rowIndex);
    }
}
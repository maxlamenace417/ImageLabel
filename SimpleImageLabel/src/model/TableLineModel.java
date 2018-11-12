package model;

public class TableLineModel {
	private String filePath;
	private String fileName;
	private String fileExtension;
	private String category;
	private String id;
	private String width;
	private String height;
	private String x;
	private String y;
	private String w;
	private String h;
	private String xmin;
	private String ymin;
	private String xmax;
	private String ymax;
	
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileExtension() {
		return fileExtension;
	}
	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getX() {
		return x;
	}
	public void setX(String x) {
		this.x = x;
	}
	public String getY() {
		return y;
	}
	public void setY(String y) {
		this.y = y;
	}
	public String getW() {
		return w;
	}
	public void setW(String w) {
		this.w = w;
	}
	public String getH() {
		return h;
	}
	public void setH(String h) {
		this.h = h;
	}
	public String getXmin() {
		return xmin;
	}
	public void setXmin(String xmin) {
		this.xmin = xmin;
	}
	public String getYmin() {
		return ymin;
	}
	public void setYmin(String ymin) {
		this.ymin = ymin;
	}
	public String getXmax() {
		return xmax;
	}
	public void setXmax(String xmax) {
		this.xmax = xmax;
	}
	public String getYmax() {
		return ymax;
	}
	public void setYmax(String ymax) {
		this.ymax = ymax;
	}
	
	public TableLineModel(String filePath, String fileName, String fileExtension, String category, String id, String width, String height, String x,
			String y, String w, String h, String xmin, String ymin, String xmax, String ymax) {
		super();
		this.filePath = filePath;
		this.fileName = fileName;
		this.fileExtension = fileExtension;
		this.category = category;
		this.id = id;
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.xmin = xmin;
		this.ymin = ymin;
		this.xmax = xmax;
		this.ymax = ymax;
	}
}

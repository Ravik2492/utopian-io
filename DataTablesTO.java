package beans;

import java.util.List;

public class DataTablesTO<T> {
	
	private List<T> aaData;
	private String aoColumns;
	private int sEcho;
	private Integer iTotalRecords;
	private Integer iTotalDisplayRecords;
	
	public List<T> getAaData() {
		return aaData;
	}
	public void setAaData(List<T> aaData) {
		this.aaData = aaData;
	}
	public String getAoColumns() {
		return aoColumns;
	}
	public void setAoColumns(String aoColumns) {
		this.aoColumns = aoColumns;
	}
	public int getsEcho() {
		return sEcho;
	}
	public void setsEcho(int sEcho) {
		this.sEcho = sEcho;
	}
	public Integer getiTotalRecords() {
		return iTotalRecords;
	}
	public void setiTotalRecords(Integer iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}
	public Integer getiTotalDisplayRecords() {
		return iTotalDisplayRecords;
	}
	public void setiTotalDisplayRecords(Integer iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}

}

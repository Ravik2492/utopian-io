package beans;

public class Sudent {
	
	int sid, sage;
	public Sudent(int sid, int sage, String sname, String saddress, String semail) {
		super();
		this.sid = sid;
		this.sage = sage;
		this.sname = sname;
		this.saddress = saddress;
		this.semail = semail;
	}
	String sname, saddress, semail;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getSage() {
		return sage;
	}
	public void setSage(int sage) {
		this.sage = sage;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSaddress() {
		return saddress;
	}
	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
	public String getSemail() {
		return semail;
	}
	public void setSemail(String semail) {
		this.semail = semail;
	}
	

}

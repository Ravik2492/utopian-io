package beans;

public class UserSetting {

	private int uid;
	private boolean update,save,select,delete;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public boolean isUpdate() {
		return update;
	}
	public void setUpdate(boolean update) {
		this.update = update;
	}
	public boolean isSave() {
		return save;
	}
	public void setSave(boolean save) {
		this.save = save;
	}
	public boolean isSelect() {
		return select;
	}
	public void setSelect(boolean select) {
		this.select = select;
	}
	public boolean isDelete() {
		return delete;
	}
	public void setDelete(boolean delete) {
		this.delete = delete;
	}
	public UserSetting(int uid, boolean update, boolean save, boolean select, boolean delete) {
		super();
		this.uid = uid;
		this.update = update;
		this.save = save;
		this.select = select;
		this.delete = delete;
	}
	
}

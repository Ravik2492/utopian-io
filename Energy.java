package beans;

public class Energy {
	
	public Energy(String state, String nuclear, String renewables, String thermal, String hydro, String grandtotal) {
		super();
		this.state = state;
		this.nuclear = nuclear;
		this.renewables = renewables;
		this.thermal = thermal;
		this.hydro = hydro;
		this.grandtotal = grandtotal;
	}

	String state,nuclear,renewables,thermal,hydro,grandtotal;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getNuclear() {
		return nuclear;
	}

	public void setNuclear(String nuclear) {
		this.nuclear = nuclear;
	}

	public String getRenewables() {
		return renewables;
	}

	public void setRenewables(String renewables) {
		this.renewables = renewables;
	}

	public String getThermal() {
		return thermal;
	}

	public void setThermal(String thermal) {
		this.thermal = thermal;
	}

	public String getHydro() {
		return hydro;
	}

	public void setHydro(String hydro) {
		this.hydro = hydro;
	}

	public String getGrandtotal() {
		return grandtotal;
	}

	public void setGrandtotal(String grandtotal) {
		this.grandtotal = grandtotal;
	}

}

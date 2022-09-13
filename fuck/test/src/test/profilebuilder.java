package test;

public class profilebuilder {
	private profile Profile;
	public profilebuilder(profile Profile) {
		super();
		this.Profile = Profile;
	}
	public profilebuilder id(String id) {
		Profile.setID(id);
		return this;
	}
	
	public profilebuilder pass(String pass) {
		Profile.setPASS(pass);
		return this;
	}
	
	public profilebuilder phone(String phone) {
		Profile.setPHONE(phone);
		return this;
	}
	
	public profilebuilder address(String address) {
		Profile.setADDRESS(address);
		return this;
	}
	
	public profile Test02() {
		return Profile;
	}
	
}


package test;

public class profile {
	private String id;     // 아이디
	private String pass;    // 비밀번호
	private String phone;     // 전화번호
	private String address; // 주소
	
	
//	public test02(String id, String pass, String phone, String address){
//		super();
//		this.id = id;
//		this.pass = pass;
//		this.phone = phone;
//		this.address = address;
//	}
	// Alt+Shift+S -> getters/setters -> select All
	public String getID() {
		return id;
	}
	public void setID(String id) {
		this.id = id;
	}
	public String getPASS() {
		return pass;
	}
	public void setPASS(String pass) {
		this.pass = pass;
	}
	public String getPHONE() {
		return phone;
	}
	public void setPHONE(String phone) {
		this.phone = phone;
	}
	public String getADDRESS() {
		return address ;
	}
	public void setADDRESS(String address) {
		this.address = address;
	}
	
//	@Override
//	public String toString() {
//		return "Bookinfo [아이디="+id+", 비밀번호="+pass+
//	            ", 전화번호="+phone+", 배송주소"+address+"]";
//	}
}





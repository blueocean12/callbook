package dto;

public class CallBookUserDTO {
	private String name;
	private String phoneNumber;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhonenumber() {
		return phoneNumber;
	}
	
	public void setphoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public void printUserInfo() {
		System.out.println(name + "," + phoneNumber);
	}
	
}

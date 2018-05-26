package data.factory.service;

public class User {

	private String firstName;
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getBusinessName() {
		return businessName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	private String lastName;
	private String address;
	private String city;
	private String businessName;
	private String emailAddress;

	public User(String firstName, String lastName, String address, String city, String businessName,
			String emailAddress) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.businessName = businessName;
		this.emailAddress = emailAddress;
	}
	
	public String toString() {
		return "{\"firstName \":" + firstName + ",\"lastName\":\"" + lastName + "\",\"address\":\"" +address+"\",\"city\":\"" + city + "\",\"businessName\":\""
				+ businessName + ",\"emailAddress\":\"" + emailAddress +"\"}\"";
	}

}

package Contact;

public class Contact {

    private final String contactId;
    private final String firstName;
    private final String lastName;
    private final String phone;
    private final String address;

    public Contact(String contactId, String firstName, String lastName, String phone, String address) {

        if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException("Contact ID must not be null and cannot be longer than 10 characters");
        }
        this.contactId = contactId;

        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First name must not be null and cannot be longer than 10 characters");
        }
        this.firstName = firstName;

        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last name must not be null and cannot be longer than 10 characters");
        }
        this.lastName = lastName;

        if (phone == null || phone.length() != 10 || !phone.matches("\\d+")) {
            throw new IllegalArgumentException("Phone must not be null, must be exactly 10 digits, and contain only digits");
        }
        this.phone = phone;

        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address must not be null and cannot be longer than 30 characters");
        }
        this.address = address;
    }
    public String getContactId() {
        return contactId;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getPhone() {
        return phone;
    }
    public String getAddress() {
        return address;
    }
	public void setPhone(String newPhone) {
		
	}
	public void setAddress(String newAddress) {
		
	}
	public void setLastName(String newLastName) {
	
	}
	public void setFirstName(String newFirstName) {
		
	}
}


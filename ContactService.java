package Contact;


import java.util.HashMap;
import java.util.Map;

public class ContactService {

    private final Map<String, Contact> contacts;

    public ContactService() {
        this.contacts = new HashMap<>();
    }
    public void addContact(Contact contact) {

        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact ID must be unique");
        }
        contacts.put(contact.getContactId(), contact);
    }
    public void deleteContact(String contactId) {

        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact not found with ID: " + contactId);
        }
        contacts.remove(contactId);
    }
    public void updateContact(String contactId, String newFirstName, String newLastName, String newPhone, String newAddress) {

        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact not found with ID: " + contactId);
        }

        Contact existingContact = contacts.get(contactId);

        if (newFirstName != null) {
            if (newFirstName.length() > 10) {
                throw new IllegalArgumentException("First name cannot be longer than 10 characters");
            }
            existingContact.setFirstName(newFirstName);
        }
        if (newLastName != null) {
            if (newLastName.length() > 10) {
                throw new IllegalArgumentException("Last name cannot be longer than 10 characters");
            }
            existingContact.setLastName(newLastName);
        }
        if (newPhone != null) {
            if (newPhone.length() != 10 || !newPhone.matches("\\d+")) {
                throw new IllegalArgumentException("Phone must be exactly 10 digits and contain only digits");
            }
            existingContact.setPhone(newPhone);
        }
        if (newAddress != null) {
            if (newAddress.length() > 30) {
                throw new IllegalArgumentException("Address cannot be longer than 30 characters");
            }
            existingContact.setAddress(newAddress);
        }
    }
	public Object getContactById(String string) {
		return null;
	}
}
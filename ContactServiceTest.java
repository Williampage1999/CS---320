package Test;

import org.junit.Before;
import org.junit.Test;

import Contact.Contact;
import Contact.ContactService;

import static org.junit.Assert.*;

public class ContactServiceTest {

    private ContactService contactService;

    @Before
    public void setUp() {
        contactService = new ContactService();
    }
    @Test
    public void testAddContact() {
        Contact contact = new Contact("12345", "Cam", "Green", "1234567890", "123 Main St");

        contactService.addContact(contact);

        assertEquals(contact, contactService.getContactById("12345"));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddDuplicateContact() {
        Contact contact1 = new Contact("12345", "Cam", "Green", "1234567890", "123 Main St");
        Contact contact2 = new Contact("12345", "Cam", "Green", "9876543210", "456 Side St");

        contactService.addContact(contact1);
        contactService.addContact(contact2);
    }
    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("12345", "Cam", "Green", "1234567890", "123 Main St");

        contactService.addContact(contact);
        contactService.deleteContact("12345");

        assertNull(contactService.getContactById("12345"));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testDeleteNonexistentContact() {
        contactService.deleteContact("nonexistentId"); 
    }
    @Test
    public void testUpdateContact() {
        Contact contact = new Contact("12345", "Cam", "Green", "1234567890", "123 Main St");

        contactService.addContact(contact);

        contactService.updateContact("12345", "Jane", "Smith", "9876543210", "456 Side St");

        Contact updatedContact = (Contact) contactService.getContactById("12345");

        assertEquals("Janet", updatedContact.getFirstName());
        assertEquals("Joe", updatedContact.getLastName());
        assertEquals("9876543210", updatedContact.getPhone());
        assertEquals("456 Side St", updatedContact.getAddress());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testUpdateNonexistentContact() {
        contactService.updateContact("nonexistentId", "Jane", "Smith", "9876543210", "456 Side St");
    }
}
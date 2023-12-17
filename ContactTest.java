package Test;

import org.junit.Test;

import Contact.Contact;

import static org.junit.Assert.*;

public class ContactTest {

    @Test
    public void testValidContactCreation() {
        Contact contact = new Contact("12345", "Cam", "Green", "1234567890", "123 Main St");

        assertEquals("12345", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidContactId() {
        new Contact(null, "Cam", "Green", "1234567890", "123 Main St");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidFirstName() {
        new Contact("12345", null, "Green", "1234567890", "123 Main St");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidLastName() {
        new Contact("12345", "Cam", null, "1234567890", "123 Main St");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidPhone() {
        new Contact("12345", "Cam", "Green", "12345", "123 Main St");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidAddress() {
        new Contact("12345", "Cam", "Green", "1234567890", null);
    }
}



import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    private String name;
    private String phoneNumber;
    private String emailAddress;
    // Add any other relevant details as needed

    public Contact(String name, String phoneNumber, String emailAddress) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    // Getters and setters for other attributes can be added if needed

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phoneNumber + ", Email: " + emailAddress;
    }
}

class AddressBook {
    private ArrayList<Contact> contacts;

    public AddressBook() {
        contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void removeContact(Contact contact) {
        contacts.remove(contact);
    }

    public Contact searchContact(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null;
    }

    public void displayAllContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Address book is empty.");
        } else {
            System.out.println("===== All Contacts =====");
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }
}

public class Address {
    private AddressBook addressBook;
    private Scanner scanner;

    public Address() {
        addressBook = new AddressBook();
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("===== Address Book Menu =====");
        System.out.println("1. Add Contact");
        System.out.println("2. Remove Contact");
        System.out.println("3. Search Contact");
        System.out.println("4. Display All Contacts");
        System.out.println("5. Exit");
    }

    public void start() {
        int choice;
        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character left by nextInt()
            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    removeContact();
                    break;
                case 3:
                    searchContact();
                    break;
                case 4:
                    addressBook.displayAllContacts();
                    break;
                case 5:
                    System.out.println("Thank you for using the Address Book System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        } while (choice != 5);
    }

    private void addContact() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter email address: ");
        String emailAddress = scanner.nextLine();

        if (!name.isEmpty() && !phoneNumber.isEmpty() && !emailAddress.isEmpty()) {
            Contact newContact = new Contact(name, phoneNumber, emailAddress);
            addressBook.addContact(newContact);
            System.out.println("Contact added successfully.");
        } else {
            System.out.println("Please fill in all required fields (name, phone number, email address).");
        }
    }

    private void removeContact() {
        System.out.print("Enter the name of the contact you want to remove: ");
        String name = scanner.nextLine();
        Contact contact = addressBook.searchContact(name);
        if (contact != null) {
            addressBook.removeContact(contact);
            System.out.println("Contact removed successfully.");
        } else {
            System.out.println("Contact not found.");
        }
    }

    private void searchContact() {
        System.out.print("Enter the name of the contact you want to search for: ");
        String name = scanner.nextLine();
        Contact contact = addressBook.searchContact(name);
        if (contact != null) {
            System.out.println("Contact found:");
            System.out.println(contact);
        } else {
            System.out.println("Contact not found.");
        }
    }

    public static void main(String[] args) {
        Address addressBookSystem = new Address();
        addressBookSystem.start();
    }
}
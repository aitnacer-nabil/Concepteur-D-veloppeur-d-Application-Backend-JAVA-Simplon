package org.example;

import org.example.controller.ContactManagerAccessList;

import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ContactManagerAccessList contactManager = new ContactManagerAccessList();
        System.out.println("Welcome To Contact Manager ");
        manage:
        while (true) {
            System.out.println("OPTION : Print Contacts 1 / Add contact 2 / Delete Contact 3 / Search By FirstName 4 / Search By Phone 5");
            System.out.println("to Exit 6");
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    contactManager.printContactList();
                    break;
                case 2:
                    System.out.println("Write FirstName : ");
                    String firstName = sc.next();

                    System.out.println("Write LastName : ");
                    String lastName = sc.next();

                    System.out.println("Write Email : ");
                    String email = sc.next();
                    System.out.println("Write PhoneNumber : ");
                    String phoneNumber = sc.next();

                    System.out.println("Status : COLLEGE FRIEND NONE");
                    String status = sc.next();
                    RelationStatus relationStatus= RelationStatus.valueOf(status.toUpperCase());
                    Contact contact = new Contact(firstName, lastName, email, phoneNumber,relationStatus);
                    System.out.println(contact.toString());
                    contactManager.addContact(contact);
                    break;
                case  3:
                    System.out.print("Please Write id to delete : ");
                    int id = sc.nextInt();
                    contactManager.deleteContact(id);
                    break ;
                case 4:
                    System.out.print("Search By lastName :  ");
                    String name=sc.next();
                    Optional<Contact> contact1= contactManager.searchByLastName(name);
                    if(contact1.isPresent()){
                        System.out.println(contact1.get().toString());
                    }else {
                        System.out.println("Contact not Found");
                    }
                    break ;
                case 5 :
                    System.out.print("Search By phoneNumer :  ");
                    String phone=sc.next();
                    Optional<Contact> contactp= contactManager.searchByLastName(phone);
                    if(contactp.isPresent()){
                        System.out.println(contactp.toString());
                    }else {
                        System.out.println("Contact not Found");
                    }
                    break ;
                case 6:
                    break  manage;

            }
        }

    }

}
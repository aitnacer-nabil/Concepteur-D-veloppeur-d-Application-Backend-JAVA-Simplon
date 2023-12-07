package org.example.controller;

import org.example.Contact;
import org.example.service.IContactDao;

import java.util.ArrayList;
import java.util.Optional;

public class ContactManagerAccessList implements IContactDao {

    private ArrayList<Contact> contactList = new ArrayList<>();







    public Optional<Contact> searchByPhone(String phone){
        return  contactList
                .stream()
                .filter(c -> c.getPhoneNumber().equals(phone))
                .findFirst();

    }

    public ArrayList<Contact> getContactList() {

        return contactList;
    }

    public void setContactList(ArrayList<Contact> contactList) {
        this.contactList = contactList;
    }
    public void  printContactList(){
        if (contactList.isEmpty()){
            System.out.println("Contact Manger Empty");
            return;
        }
        for (int i = 0; i < contactList.size(); i++){
            System.out.println(contactList.get(i).toString());
        }
    }

    @Override
    public void add(Contact contact) {
        if(contactList.contains(contact)){
            System.out.println("User Already registered");
            return;
        }
        contactList.add(contact);
    }

    @Override
    public void delete(int contactID) {
        contactList.stream()
                .filter(c -> c.getId() == contactID)
                .findFirst()
                .ifPresent(contactList::remove);

    }

    @Override
    public void update(Contact contact) {

    }

    @Override
    public void contactExists(Contact contact) {

    }

    @Override
    public Optional<Contact> searchByFirstName(String firstName) {
        return  contactList
                .stream()
                .filter(c -> c.getLastName().equals(firstName))
                .findFirst();
    }
}

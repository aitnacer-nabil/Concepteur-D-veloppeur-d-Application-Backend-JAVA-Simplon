package org.example.service;

import org.example.Contact;

import java.util.Optional;

public interface IContactDao {
    void add(Contact contact);
    void delete(int contactID);
    void update(Contact contact);
    void contactExists(Contact contact);
    Optional<Contact> searchByFirstName(String firstName);
    Optional<Contact> searchByPhone(String phone);

}

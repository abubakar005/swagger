package com.spring.boot.swagger.service;

import com.spring.boot.swagger.dto.Contact;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ContactService {

    private ConcurrentHashMap<Integer, Contact> contacts = new ConcurrentHashMap<>();


    public Contact addContact(Contact contact) {
        contacts.put(contact.getId(), contact);
        return contact;
    }

    public Contact getContactById(int id) {
        return contacts.get(id);
    }

    public List<Contact> getAllContacts() {
        return new ArrayList<>(contacts.values());
    }

    public Contact deleteContactById(int id) {
        return contacts.remove(id);
    }
}

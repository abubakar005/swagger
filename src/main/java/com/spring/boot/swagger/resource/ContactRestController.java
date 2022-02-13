package com.spring.boot.swagger.resource;

import com.spring.boot.swagger.dto.Contact;
import com.spring.boot.swagger.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ContactRestController {

    @Autowired
    private ContactService contactService;

    @PostMapping("/add")
    public Contact addContact(@RequestBody Contact contact) {
        return contactService.addContact(contact);
    }

    @GetMapping("/{id}")
    public Contact getContactById(@PathVariable int id) {
        return contactService.getContactById(id);
    }

    @GetMapping("/all")
    public List<Contact> getAllContacts() {
        return contactService.getAllContacts();
    }

    @DeleteMapping("/{id}")
    public void deleteContactById(@PathVariable int id) {
        contactService.deleteContactById(id);
    }
}

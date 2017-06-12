package com.company.project.services;

import com.company.project.models.Contact;
import com.company.project.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Contact service implementation.
 */
@Service
public class ContactServiceImpl implements ContactService {

    private ContactRepository contactRepository;

    @Autowired
    public void setContactRepository(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public Iterable<Contact> listAllContacts() {
        return contactRepository.findAll();
    }

    @Override
    public Contact getContactById(Integer id) {
        return contactRepository.findOne(id);
    }

    @Override
    public Contact saveContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public void deleteContact(Integer id) {
        contactRepository.delete(id);
    }

}

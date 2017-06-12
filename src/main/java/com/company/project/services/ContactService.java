package com.company.project.services;

import com.company.project.models.Contact;

public interface ContactService {

    Iterable<Contact> listAllContacts();

    Contact getContactById(Integer id);

    Contact saveContact(Contact product);

    void deleteContact(Integer id);

}

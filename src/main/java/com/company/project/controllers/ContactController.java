package com.company.project.controllers;

import com.company.project.models.Contact;
import com.company.project.services.ContactService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Contact controller.
 */
@Controller
public class ContactController {

    private ContactService contactService;
    
    final static Logger logger = LoggerFactory.getLogger("MYAPP");

    @Autowired
    public void setContactService(ContactService contactService) {
        this.contactService = contactService;
    }

    /**
     * List all contacts.
     *
     * @param model
     * @return1111
     */
    @RequestMapping(value = "/contactos", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("contacts", contactService.listAllContacts());
        logger.info("Returning contact list.");
        return "contacts";
    }    
    
    /**
     * View a specific contact by its id.
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("contactos/{id}")
    public String showContact(@PathVariable Integer id, Model model) {
    	Contact contact = contactService.getContactById(id);
    	if(contact != null) {
    		logger.info("Showing contact id: "+contact.getId().toString());
    		model.addAttribute("contact", contact);
        	return "contactshow";
    	}else{
    		return "redirect:/contactos";
    	}   	
    }

    // Afficher le formulaire de modification du Contact
    @RequestMapping("contactos/{id}/editar")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("contact", contactService.getContactById(id));
        return "contactform";
    }

    /**
     * New contact.
     *
     * @param model
     * @return
     */
    @RequestMapping("contactos/nuevo")
    public String newContact(Model model) {
        model.addAttribute("contact", new Contact());
        return "contactform";
    }

    /**
     * Save contact to database.
     *
     * @param contact
     * @return
     */
    @RequestMapping(value = "contactos", method = RequestMethod.POST)
    public String saveContact(Contact contact) {
        contactService.saveContact(contact);
        return "redirect:/contactos/" + contact.getId();
    }

    /**
     * Delete contact by its id.
     *
     * @param id
     * @return
     */
    @RequestMapping("contactos/{id}/eliminar")
    public String delete(@PathVariable Integer id) {
        contactService.deleteContact(id);
        return "redirect:/contactos";
    }

}

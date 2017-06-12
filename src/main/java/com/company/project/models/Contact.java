package com.company.project.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Contact entity.
 */
@Entity
@Table(name = "dsb_contacto__c", schema = "salesforce")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    
    @Version
    @Column(name = "version__c", nullable = true)
    private Integer version;

    @Column(name = "firstname__c", nullable = false)    
    private String firstName;
    
    @Column(name = "Lastname__c", nullable = false)
    private String lastName;
    
    @Column(name = "email__c", nullable = false)
    private String email;
    
    @Column(name = "mobilephone__c", nullable = false)
    private String mobilePhone;
    
    @Column(name = "address__c", nullable = true)
    private String address;
    
    @Column(name = "subject__c", nullable = false)
    private String subject;
    
    @Column(name = "message__c", nullable = false)
    private String message;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }    
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}

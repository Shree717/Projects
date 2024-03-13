package com.Spring.service;

import com.Spring.model.Contact;
import org.springframework.stereotype.Service;

public interface ContactService{
    Contact saveContact(Contact contact);
}

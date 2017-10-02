package com.business.services;

import com.business.interfaces.MyStrings;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("!strings")
public class StringDefaultService implements MyStrings {

    @Override
    public String getText(String string) {
        return "No text";
    }

    @Override
    public void setLanguage(String lang) {

    }
}

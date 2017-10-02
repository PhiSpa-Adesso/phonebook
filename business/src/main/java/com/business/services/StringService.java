package com.business.services;

import com.business.interfaces.MyStrings;
import com.data.model.Strings;
import com.data.repository.StringDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;



@Service
@Profile("strings")
public class StringService implements MyStrings{

    @Autowired
    StringDAO stringDAO;

    private String language="EN";

    private Strings getEntity(String name){
      return stringDAO.getByName(name);
    }
    private String getEntityText(Strings entity){
      if (language.equals("DE")){return entity.getDe();}
      if (language.equals("EN")){return entity.getEn();}
      return "No language " + language +" detected.";
    }


    @Override
    public String getText(String string){
      Strings entity = getEntity(string);
      String result;
      try {
          result = getEntityText(entity);
      } catch (Exception e){
          result =  "String dose not exist!";
      }
      return result;
    }

    @Override
    public  void setLanguage(String lang){
        if (lang.equals("DE")){language = lang;}
        else if (lang.equals("EN")){language = lang;}
    }
}

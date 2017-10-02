package com.business.services;


import org.springframework.context.annotation.Profile;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;



@Service
public class AuthenticationService {



    public String getWebPagePrefix(){
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            boolean isAdmin = auth.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"));
            if (isAdmin) {
                return "admin_";
            }
        }catch (Exception e){
            System.out.println("ERROR: "+ e);
        }
        return "guest_";
    }


    }

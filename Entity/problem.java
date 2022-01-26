package com.hagere.ethiop.Entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.web.servlet.oauth2.login.OAuth2LoginSecurityMarker;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class problem {


    @Id
    private String id;
   private String organization;

    private String description;
    private Type type;
    public static enum Type {
       New,URGENT,SOLVED
    }




}

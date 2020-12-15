package com.example.helloworld;

import com.example.helloworld.entity.LibraryProperties;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//@SpringBootApplication
public class ReadConfigPropertiesApplication implements InitializingBean {

    private final LibraryProperties libraryProperties;

    public ReadConfigPropertiesApplication(LibraryProperties libraryProperties) {
        this.libraryProperties = libraryProperties;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(libraryProperties.getBooks());
        System.out.println(libraryProperties.getLocation());
    }


}

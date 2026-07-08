package com.springLearning.learn_spring_framework;

// both the annotations of @Configuration and @Bean require the respective import statements
import org.springframework.context.annotation.Bean; // used to indicate "that a method produces a bean to be managed by the Spring Container" - java hover-docs
import org.springframework.context.annotation.Configuration; // used to indicate "that a class declares one or more @Bean methods and may be processed by the Spring container to generate bean definitions and service requests for those beans at runtime" - java hover-docs

@Configuration // used to indicate a "@Configuration" class (Config-Class)
public class HelloWorldConfiguration {

    // define Spring Beans in here
    // the "things" managed by Spring Framework, known as "Spring Beans"
    // and can define the methods to create "Spring Beans" in Config-Class


    // the below would be the right step to creating a Spring-Bean, but it is NOT sufficient
//    // creating a method
//    public String name(){
//        return "Spring!";
//    }//

    // in addition to creating the method, we also have to add in an additional piece:
    @Bean
    public String name(){
        return "Bean with name of \"name\": Spring!";
    }//
    // thus this method "produces" a bean to be managed by the Spring Container





}// config-class

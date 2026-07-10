package com.springLearning.learn_spring_framework;

// both the annotations of @Configuration and @Bean require the respective import statements
import org.springframework.context.annotation.Bean; // used to indicate "that a method produces a bean to be managed by the Spring Container" - java hover-docs
import org.springframework.context.annotation.Configuration; // used to indicate "that a class declares one or more @Bean methods and may be processed by the Spring container to generate bean definitions and service requests for those beans at runtime" - java hover-docs



// seeing if Spring can manage the object of a custom class
record Person(String name, int age) { /* can define custom methods in these braces */ }; // defining 2 member vars (name and age)
// "record" is after JDK16 release

// typically, when creating a Java class, it would require creation a bunch of stuff like: public accessor methods, constructors, equals, hashcode and toString etc
// however, the "record" keyword  eliminates verbosity in creating Java Beans, such as eliminating the need to create getter/setters or other "requirements" of a class


// another custom class --> Address - firstLine & city
record Address(String firstLine, String city) { /* can define custom methods in these braces */ } ;



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

    // in addition to creating the met  hod, we also have to add in an additional piece:
    @Bean
    public String name(){
        return "Bean with name of \"name\": Spring!";
    }//
    // thus this method "produces" a bean to be managed by the Spring Container


    @Bean
    public Integer age(){
        return 21;
    }//


    // when using a record (in place of an actual class definition)
    // all the "verbosity" is automatically created --> for eg: in the above record def, a "Person" constructor is automatically created with the 2 args
    @Bean
    public Person person(){
        var person = new Person("Spring Bean - Obj Eg (Custom Class)", 301);
        // Note: becoz we use a "record", all the extra verbosity (such as getter, setter, constructor, toString, etc) are created automatically
        // thus, doing "person.age()", "person.name()" is viable. Additionally, the constructor is automatically run in the above line.

        return person;

        // so we created a Bean which has type "Person" (i.e. type belonging to the class "Person"), with the name of the Bean being "person" (could be diff)
        // within the method, we have to return an *object* instantiated from the class "Person", thus we create a new var called "person" (could be diff like the method name)
        // and so we instantiate the "person" var with name="Spring Bean - Custom Class, Obj Eg", and age=301
        // finally we return a "Person" obj (called "person")

        // Note: the name "person" in the method name is diff and unrelated from the name "person" in the obj instantiation --> the both of them could be named diff
    }


    // the custom class Address as a Spring Bean
    // to add a diff name to then bean, instead of the default name of the bean ("address" in this case) which is the name of the method,
    // we add/pass a str-val to the Bean-annotator ( @Bean(name="") )
    @Bean(name="addr")
    // Note: if the "@Bean" annotator is not included for a method def, upon doing "variable.getBean(<string val>)" to call the new method
    // the output will be errored: "Exception in thread "main" org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named <string val> available"
    // becoz we calling .getBean(...), expecting to find a bean, but we have no methods that have the @Bean annotator
    public Address address(){
        var address = new Address("Vancouver", "Lucerne");

        return address;

    }// address-bean



}// config-class

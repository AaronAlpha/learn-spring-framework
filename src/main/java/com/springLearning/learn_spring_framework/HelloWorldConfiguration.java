package com.springLearning.learn_spring_framework;

// both the annotations of @Configuration and @Bean require the respective import statements
import org.springframework.beans.factory.annotation.Qualifier; // required import to use the "@Qualifier" annotator
import org.springframework.context.annotation.Bean; // used to indicate "that a method produces a bean to be managed by the Spring Container" - java hover-docs
import org.springframework.context.annotation.Configuration; // used to indicate "that a class declares one or more @Bean methods and may be processed by the Spring container to generate bean definitions and service requests for those beans at runtime" - java hover-docs
import org.springframework.context.annotation.Primary; // required import when calling the "@Primary" annotator on a specific Bean (class-method)


// seeing if Spring can manage the object of a custom class
// record Person(String name, int age) { /* can define custom methods in these braces */ }; // defining 2 member vars (name and age)
// "record" is after JDK16 release

// typically, when creating a Java class, it would require creation a bunch of stuff like: public accessor methods, constructors, equals, hashcode and toString etc
// however, the "record" keyword  eliminates verbosity in creating Java Beans, such as eliminating the need to create getter/setters or other "requirements" of a class


record Person(String name, int age, Address address) { /* can define custom methods in these braces */ }; // defining 2 member vars (name and age)
// making a new 'version' of Person (with an "Address" param in the constructor call


// another custom class --> Address - firstLine & city
record Address(String firstLine, String city) { /* can define custom methods in these braces */ } ;



@Configuration // used to indicate a "@Configuration" class (Config-Class)
public class  HelloWorldConfiguration {

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
    }// name
    // thus this method "produces" a bean to be managed by the Spring Container


    @Bean
    public Integer age(){
        return 21;
    }// age


    // when using a record (in place of an actual class definition)
    // all the "verbosity" is automatically created --> for eg: in the above record def, a "Person" constructor is automatically created with the 2 args
    @Bean
    public Person person(){
        var person = new Person("Spring Bean - Obj Eg (Custom Class)", 301, new Address("hardcoded Addr val", "Note: would need to create a new obj, becoz the param is of an OBJECT of type Address, so would need to create a new \"Address\" obj") );
        // Note: becoz we use a "record", all the extra verbosity (such as getter, setter, constructor, toString, etc) are created automatically
        // thus, doing "person.age()", "person.name()" is viable. Additionally, the constructor is automatically run in the above line.

        return person;

        // so we created a Bean which has type "Person" (i.e. type belonging to the class "Person"), with the name of the Bean being "person" (could be diff)
        // within the method, we have to return an *object* instantiated from the class "Person", thus we create a new var called "person" (could be diff like the method name)
        // and so we instantiate the "person" var with name="Spring Bean - Custom Class, Obj Eg", and age=301
        // finally we return a "Person" obj (called "person")

        // Note: the name "person" in the method name is diff and unrelated from the name "person" in the obj instantiation --> the both of them could be named diff
    }// person


    // the custom class Address as a Spring Bean
    // to add a diff name to then bean, instead of the default name of the bean ("address" in this case) which is the name of the method,
    // we add/pass a str-val to the Bean-annotator ( @Bean(name="") )
    @Bean(name="addr")
    // Note: if the "@Bean" annotator is not included for a method def, upon doing "variable.getBean(<string val>)" to call the new method
    // the output will be errored: "Exception in thread "main" org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named <string val> available"
    // becoz we calling .getBean(...), expecting to find a bean, but we have no methods that have the @Bean annotator
    @Primary // to solve the issue of retrieving info by class-type, but there exists multiple candidates of the same class-type
    public Address address(){
        var address = new Address("Vancouver", "Lucerne");

        return address;

    }// address-bean




    // creating a new "Person" - bean "person2" - using "method calls"
    @Bean
    public Person person2_MethodCall() {
        // using existing Beans (managed by Spring) - Bean "name" and "age"

        // using existing Bean-methods thru "method calls" - therefore, just "name()" and "age()" and "address()"
        var person = new Person(this.name(), this.age(), this.address());


        return person;
    }// person2_MethodCall





    @Bean(name="addr2")
    // Note: if the "@Bean" annotator is not included for a method def, upon doing "variable.getBean(<string val>)" to call the new method
    // the output will be errored: "Exception in thread "main" org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named <string val> available"
    // becoz we calling .getBean(...), expecting to find a bean, but we have no methods that have the @Bean annotator
    @Qualifier("addr2_Qual") // used to specify other Beans of similar type (when being retrieved)
    public Address address2(){
        var address = new Address("Vancouver", "Berne");

        return address;

    }// address-bean


    // creating a new "Person" - bean "person3" - by "passing params"
    @Bean
    public Person person3_Params(String name, int age, Address addr2) { // passing params, like "name", "address"
        // Note!, we don't pass in "address" (which would be the name of the class-method, as seen above), but we instead pass-in the name of the bean,
        // which we altered for the "address" class-method to be "addr"

        // thus, in this case (unlike the person2), we create passable params (name, age and addr) which refer to existing Beans in this .java file,
        // ensuring that the created params refer to the **name of the BEAN** not **name of the CLASS-METHOD**; if no Bean-name (param) is
        // specified for a class-method, then the name of the method is the name of the Bean

        var person = new Person(name, age, addr2);


        return person;
    }// person3_Params





    @Bean
    @Primary
    public Person person4_Params(String name, int age, Address address) { // passing params, like "name", "address"
        // Note!, we don't pass in "address" (which would be the name of the class-method, as seen above), but we instead pass-in the name of the bean,
        // which we altered for the "address" class-method to be "addr"

        // thus, in this case (unlike the person2), we create passable params (name, age and addr) which refer to existing Beans in this .java file,
        // ensuring that the created params refer to the **name of the BEAN** not **name of the CLASS-METHOD**; if no Bean-name (param) is
        // specified for a class-method, then the name of the method is the name of the Bean

        var person = new Person(name, age, address);


        return person;
    }// person3_Params





}// config-class

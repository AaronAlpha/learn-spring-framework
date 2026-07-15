package com.springLearning.learn_spring_framework.helloworld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02_HelloWorldSpring {

    public static void main(String[] args){
        // Step 1: Launch a new Spring Application (also: "Spring Context")
        // DONE BY USING A CLASS:

       // the entire point of this is to "close" the context
       // this is known as "try with resources" (an alternative to try-final)
       // so if there is an error within the code, "context.close" is called
       try( var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class) )  // creating a new Spring Context)
       {
           // we use the config-class from below to create this line (that creates a Spring Context)


           // Step 2: Configure the "things" (beans) we want the Spring Framework to manage -
           // one way to configure Spring to manage our things, is to create a "@Configuration" class
           // and have everything defined, like the "name" "thing"
           // AND, can use the configuration class to launch a "Spring Context"
           // DONE BY CREATING "HELLOWORLDCONFIGURATION" CLASS WITH THE @CONFIGURATION ANNOTATOR
           // inside the above config-class, we created a @Bean with the name of the method as "name"

           // thus we are launching a new Spring Context thru the Annotation...Context line, to launch the passed in Config-Class (Hello...Config... .class)


           // Step 3: Retrieving the Beans we managed by Spring, using: "context.getBean(<name of method producing Bean - type of arg passed in is a String>)"
           // to see out Spring Bean, we have to call "context" and access the respective property of the config-class
           var variable = context.getBean("name"); // this is a way to get any of the created Beans in the config-class
           // and pass in a String which is the name of the method/bean we created - in this case, the name of the method is "name"

           System.out.println(variable); // printing out the above line

           System.out.println(context.getBean("age"));
           System.out.println(context.getBean("person")); // Note: a toString met hod is automatically implemented when the printed out

           // System.out.println( context.getBean("address") );
           System.out.println(context.getBean("addr")); // retrieving info about the Bean val by passing the *name of the Bean* in .getBean(...)

           System.out.println("\n");

           // this is another way of attaining a Bean val -- by calling the class of a Bean-method ( eg  : public <Class> method_name() {}; )
//        System.out.println( context.getBean(Address.class) ); // retrieving info about the Bean val by passing the *type of the Bean* in .getBean(...)
           System.out.println("\n");
           System.out.println(context.getBean("person2_MethodCall")); // Note: a toString method is automatically implemented when the printed out

           System.out.println(context.getBean("person3_Params"));


           // to print out all the Beans in our Config-Class file (Q3)
           // String[] list = context.getBeanDefinitionNames(); // gets the Names of all defined Beans ; Note: its of type "String[]"
//
//        for (int i = 0; i < list.length; i++){
//            System.out.println(list[i]);
//        }


           // using System.out.println
           // Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println); // gets the Names of all defined Beans ; Note: its of type "String[]")
           // the above statement is a functional way of printing out the contents of the return of the context.getBeanDefinitionNames() (which is type String[])
        /* it is equivalent to the following piece of code

        for (int i = 0; i < list.length; i++){
            System.out.println(list[i]);
        }

         */
           //


           // Q4: figuring out what happens when there are multiple Beans of the same type when retrieving Bean def by type
           // how to give preference?
           System.out.println(context.getBean(Address.class)); // retrieving info about the Bean val by passing the *type of the Bean* in .getBean(...)

           // whether auto-wiring of pre-existing Beans via param-passing, OR, fetching by Class with .getBean(<ClassName>.class) from a Spring Context;
           // if there exists no dependency (param passed) of an existing Bean name, OR, are multiple matching Beans (candidates) of the same class-type,
           // Spring throws an exception

           // to solve this, we could make one of the candidates "Primary" (refer HelloWorldConfiguration.java file, and refer to the Bean of "addr" name)
           // to demonstrate which is most imp

           // the above line of retrieval by class-type prints: "Address[firstLine=Vancouver, city=Lucerne]" (the selected Bean to be @Primary)

           System.out.println(context.getBean(Person.class));


           // printing out the person5_Qual eg, that has passed in "@Qualifier("addr2_Qual") Address address" as the auto-wiring
           System.out.println(context.getBean("person5_Qual"));

       }







    }// main


}// class

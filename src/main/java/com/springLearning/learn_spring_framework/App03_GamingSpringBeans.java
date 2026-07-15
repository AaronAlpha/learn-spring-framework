package com.springLearning.learn_spring_framework;

import com.springLearning.learn_spring_framework.game.GameRunner; // need this to call on the GameRunner class from within the spring framework, to call from the Bean (Config) class
import com.springLearning.learn_spring_framework.game.GamingConsole; // Note! need to import Config-class to be used in this "running" class (spring context)
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App03_GamingSpringBeans {


    public static void main(String[] args) {

        // this is the imp step to connect the Config-class to the Spring Context! (unrelated to the name of the var)
        try(
        var springContext = new AnnotationConfigApplicationContext(GameConfiguration.class); // launching the Spring Context by creating an obj of type "AnnotationConfigApplicationContext"
        ) {
            springContext.getBean(GamingConsole.class).up(); // prints "Move up"
            // from our springContext, we call a Bean of type "GamingConsole"
            // but also want to run the "GameRunner" class --> refer GameConfigurationClass

            springContext.getBean(GameRunner.class).run(); // calling the run method, which was defined within the GameRunner class, from the Config class (where all the Spring Beans exist) 

        }


    }

}

package com.springLearning.learn_spring_framework.game;

public class GameRunner {


    // following code is restrictive due to "Tightly Coupled" code (definitions and arg-passing that explicitly "type" to the MarioGame class.
/*
    private MarioGame game; // creating a class var

    public GameRunner(MarioGame gamePassed) {
        this.game = gamePassed; // instantiation of the class var, with the passed "marioGame" of type "MarioGame"

    }// constructor
*/

    // this code, like the above implementation for the MarioGame class is still "Tightly Coupled" to the SuperContraGame class
//    private SuperContraGame game;

    // we have used "GamingConsole" as out passed in class, becoz it is an umbrella for all classes that implement the GamingConsole class
    private GamingConsole game;


    public GameRunner(GamingConsole gamePassed){
        this.game = gamePassed;

    }// new constructor - tailored to the SuperContraGame class


    public void run(){
        System.out.println("Running game: " + this.game); // not good practice to use "System.out.println", rather use
        // some form of logging framework

        // from the o'reilly website learning of Java and the Spring-SpringBoot Framework
        // this was "Tightly Coupled" Java Code
        // running the actions of the this.game

        // these methods still work, becoz they have already been defined as part of the GamingConsole interface .java class
        this.game.up();
        this.game.down();
        this.game.left();
        this.game.right();


    }// creating a class method (getter)

}// class
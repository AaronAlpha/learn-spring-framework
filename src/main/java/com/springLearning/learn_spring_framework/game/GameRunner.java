package com.springLearning.learn_spring_framework.game;

public class GameRunner {

    MarioGame game; // creating a class var

    public GameRunner(MarioGame marioGame) {
        this.game = marioGame; // instantiation of the class var, with the passed "marioGame" of type "MarioGame"

    }// constructor

    public void run(){
        System.out.println("Running game: " + this.game); // not good practice to use "System.out.println", rather use
        // some form of logging framework

    }// creating a class method (getter)

}// class
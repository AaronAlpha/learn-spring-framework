package com.springLearning.learn_spring_framework.game;

public class MarioGame implements GamingConsole{

    public MarioGame(){

    }// constructor

//    Iteration 1: "Tightly Coupled" Java Code

//    actions of this game
    public void up(){
        System.out.println("Jump");
    }

    public void down(){
        System.out.println("Go into a hole");
    }

    public void left(){
        System.out.println("Go left");
    }

    public void right(){
        System.out.println("Accelerate");
    }

}// class



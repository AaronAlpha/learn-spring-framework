package com.springLearning.learn_spring_framework;


import com.springLearning.learn_spring_framework.game.GameRunner;
import com.springLearning.learn_spring_framework.game.MarioGame; // Package imported after creating the "MarioGame" class with the package seen at top of file with ".game" suffix

// is a basic class
// want to create a gameRunner class instance and launch mario-game
public class AppGamingBasicJava {

    public static void main(String[] args){

        var marioGame = new MarioGame();
        var gameRunner = new GameRunner(marioGame); // new instance of a "GameRunner" class
        // want to pass "marioGame" as a constructor arg

        gameRunner.run(); // want to run the game


    }// main


}// class

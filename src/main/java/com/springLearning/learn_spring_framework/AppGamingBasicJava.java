package com.springLearning.learn_spring_framework;


import com.springLearning.learn_spring_framework.game.GameRunner;
import com.springLearning.learn_spring_framework.game.PacmanGame;
// HAVE to create the respective class (if not already created), then IMPORT the related class thru the above line(s)

// is a basic class
// want to create a gameRunner class instance and launch mario-game
public class AppGamingBasicJava {

    public static void main(String[] args){

//        var marioGame = new MarioGame(); // this definition (Loose Coupled)
        // instead of: "MarioGame marioGame = new MarioGame();" (Tight Coupled)

//        var gameRunner = new GameRunner(marioGame); // new instance of a "GameRunner" class
        // want to pass "marioGame" as a constructor arg

        // same for GameRunner: above definition (Loose Coupled)
        // instead of: "MarioGame marioGame = new MarioGame();" (Tight Coupled)


//
//        var superContraGame = new SuperContraGame();
//
//        var gameRunner = new GameRunner(superContraGame); // new instance of a "GameRunner" class
//        // (before) there is an error, because in the GameRunner class, it (GameRunner class) is Tightly Coupled to the MarioGame class


        // var game = new MarioGame();
        // var game = new SuperContraGame();

        var game = new PacmanGame();

        var gameRunner = new GameRunner(game); // new instance of a "GameRunner" class
        // (before) there is an error, because in the GameRunner class, it (GameRunner class) is Tightly Coupled to the MarioGame class



        gameRunner.run(); // want to run the game


    }// main


}// class

package com.springLearning.learn_spring_framework;


import com.springLearning.learn_spring_framework.game.GameRunner;
import com.springLearning.learn_spring_framework.game.PacmanGame;
// HAVE to create the respective class (if not already created), then IMPORT the related class thru the above line(s)

// is a basic class
// want to create a gameRunner class instance and launch mario-game
public class AppGamingBasicJava_Old {

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

        var game = new PacmanGame(); // 1. --> creating an object (obj creation_

        var gameRunner = new GameRunner(game); // 2. -->  obj creation & wiring of dependencies
        // for GameRunner to run, it requires a "game" to run (Mario/SuperContra/Pacman)
        // thus, a "Game is a dependency of GameRunner" - a specific game, like Mario/SuperContra/Pacman, or more generally,
        // the GamingConsole, is a dependency

        // and so the "game" obj of a specific GameClass is created; then injected (or wired) into the GameRunner class

        // in enterprise code environments, there may be 1000 classes, 1000 objs, and thus many "wiring of dependencies"
        // tedious create, manage these objs and wiring of dependencies manually
        // thus, can use the Spring Framework to manage these





        gameRunner.run(); // want to run the game


    }// main


}// class

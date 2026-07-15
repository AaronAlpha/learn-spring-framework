package com.springLearning.learn_spring_framework;



import org.springframework.context.annotation.Bean; // corresponding import statement for the Spring Bean
import org.springframework.context.annotation.Configuration; // imports the required import line to use @Config


// importing the required Game Classes (Marios, SuperContra, Pacman) from the game package
import com.springLearning.learn_spring_framework.game.PacmanGame;
import com.springLearning.learn_spring_framework.game.GamingConsole;
import com.springLearning.learn_spring_framework.game.GameRunner;

// making it a Config-Class - Remember!!!
@Configuration
public class GameConfiguration {


    // define Spring Beans below

    @Bean
    public GamingConsole game(){ // Note: the name of the class-method (game) is unrelated to the name of the var "game" used to return an obj of type GamingConsole
        var game = new PacmanGame(); // PacmanGame is a class that implements GamingConsoles (which is an interface)
        return game;
    }

    @Bean
    public GameRunner gameRunner(GamingConsole game){ // can pass as params (HAS to be the name of the Spring Bean, NOT class-method name - Bean(name="") )
        // , as a way of auto-wiring, to call on existing Beans, OR
        var gameRunner = new GameRunner(  game    /*game()*/ ); // pass the name of the class-method into the newly-created Bean (the commented line of code)

        return gameRunner;

    }




//    @Bean
//    public GamingConsole supercontraGame() {
//
//    }
//
//   @Bean
//   public GamingConsole pacmanGame(){
//
//
//   }


}

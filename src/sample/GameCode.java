package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class GameCode extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        System.out.println(new BackEnd().temp);
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        Button start = new Button("Press to Start");

        EventHandler<ActionEvent> gameStart = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                newGame(primaryStage);
            }
        };

        start.setOnAction(gameStart);
        Pane main = new Pane();
        main.getChildren().add(start);
        Scene primary = new Scene(main,500,200);
        primaryStage.setScene(primary);
        primaryStage.show();
    }

    public void newGame(Stage primaryStage)
    {
        Button game = new Button("Press");
        Label score = new Label("Your Score: 0");
        int currentScore = 0;
        EventHandler<ActionEvent> addScore = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                score.setText("Your Score: " + currentScore);
            }
        };
        game.setOnAction(addScore);
        Pane main = new Pane();
        main.getChildren().add(game);
        Scene primary = new Scene(main,500,200);
        primaryStage.setScene(primary);
        primaryStage.show();
        long time = System.nanoTime();
        new AnimationTimer()
        {
            @Override
            public void handle(long now) {
                if((now-time) >= 10000000000l)
                {
                   gameOver(primaryStage,currentScore);
                }
            }
        }.start();
    }

    public void gameOver(Stage primaryStage,int score)
    {
        String scoreString = "";
        Label Highscore = new Label(scoreString);
        Pane main = new Pane();
        main.getChildren().add(Highscore);
        Scene primary = new Scene(main,500,200);
        primaryStage.setScene(primary);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

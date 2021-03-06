package com.ivik.simpleroller;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

/**
 * Created by Tomorrowman on 6-4-2016.
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    public void start (Stage stage){

        stage.setTitle("Simple Dice Roller");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Scene scene = new Scene(grid);
        stage.setScene(scene);

        //text stuff
        Label rollLabel = new Label("Enter roll (ex. 1d20+1): ");
        grid.add(rollLabel, 0, 0);
        final TextField rollField = new TextField();
        grid.add(rollField, 1, 0);
        final TextArea results = new TextArea();
        grid.add(results, 0, 1, 3, 1);

        //buttons
        Button btn = new Button("Roll!");
        grid.add(btn, 2, 0);
        Button btn2 = new Button("Clear Field");
        grid.add(btn2, 0, 3);

        //ensures that the textfield resizes with the window
        grid.setHgrow(btn, Priority.ALWAYS);
        grid.setVgrow(results, Priority.ALWAYS);

        //stuff the buttons do
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent){

                String input = rollField.getText();
                Calculate calc1 = new Calculate();
                StringBuilder output = calc1.calculate(input);
                String previousOutput = results.getText();
                results.setText(previousOutput + String.valueOf(output));

            }

            });
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                results.clear();
            }

            });
        stage.show();
        }


}

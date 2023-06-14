package com.breadsb.simpleapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class EEICalculator extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(EEICalculator.class.getResource("eeicalculator-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 340);
        stage.setTitle("Kalkulator obliczania współczynnika EEI");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
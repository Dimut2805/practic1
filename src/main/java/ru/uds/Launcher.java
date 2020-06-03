package ru.uds;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Launcher extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    /**
     * Запуск приложения
     *
     * @param window главное окно
     */
    @Override
    public void start(Stage window) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Main.fxml"));
        Scene scene = new Scene(root);
        window.setTitle("Настольный преподаватель");
        window.setScene(scene);
        window.show();
    }
}

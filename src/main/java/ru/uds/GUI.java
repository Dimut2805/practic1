package ru.uds;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ru.uds.controllers.AddStudentController;

import java.io.IOException;

public class GUI {
    public static void exitGUI(VBox vbox) {
        Parent root = null;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(GUI.class.getResource("/AddStudent.fxml"));
            root = fxmlLoader.load();
            AddStudentController addStudentController = fxmlLoader.getController();
            addStudentController.setVbox(vbox);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scene scene = new Scene(root);
        Stage window = new Stage();
        window.setTitle("Добавить");
        window.setOnCloseRequest(event -> window.close());
        window.setScene(scene);
        window.show();
    }
}

package fi.tuni.tiko.app;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * In this class the stage for loading a file is created and shown
 */
public class LoadBox {
    /**
     * In this method the stage for loading a file is created
     */
    public static void display(){
        //Create the stage
        final Stage window = new Stage();
        //Declare modality
        window.initModality(Modality.APPLICATION_MODAL);
        //Set the title to "Save"
        window.setTitle("Load");
        //Set size
        window.setMaxWidth(300);
        window.setMinHeight(200);
        //Create a label text
        Label label= new Label();
        label.setText("Choose the file you want to load.");
        //Make the text automatically break lines to fit the space
        label.setWrapText(true);
        //Add some padding
        label.setPadding(new Insets(20));
        //Create a ChoiceBox for saved files
        ChoiceBox<String> loadings = new ChoiceBox<>();
        //Create the "Return" button to exit the stage and return to the main view without saving
        Button closeButton = new Button("Return");
        closeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                window.close();
            }
        });
        //Create the layout as a VBox
        VBox layout = new VBox();
        //Center the elements in the layout
        layout.setAlignment(Pos.CENTER);
        //Set the elements 3 pixels apart
        layout.setSpacing(3);
        //Add the elements to the layout
        layout.getChildren().addAll(label, loadings, closeButton);
        //Create the scene with the layout
        Scene scene = new Scene(layout);
        //Add the scene to the stage and make it visible
        window.setScene(scene);
        window.showAndWait();
    }
}


package fi.tuni.tiko.app;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * This class creates the stage for showing the saving options.
 * It has modality so it must be closed from the "Return" button.
 */
public class SaveBox {
    /**
     * In this method the stage for saving operations is created
     */
    public static void display(){
        //Create the stage
        final Stage window = new Stage();
        //Declare modality
        window.initModality(Modality.APPLICATION_MODAL);
        //Set the title to "Save"
        window.setTitle("Save");
        //Set size
        window.setMaxWidth(300);
        window.setMinHeight(200);
        //Create a label text
        Label label= new Label();
        label.setText("Write a name for the saving.");
        //Make the text automatically break lines to fit the space
        label.setWrapText(true);
        //Add some padding
        label.setPadding(new Insets(20));
        //Create a text field for the name of the file about to be saved (functionality added later)
        TextField saveField = new TextField();
        //Create the "Return" button to exit the stage and return to the main view without saving
        Button closeButton = new Button("Return");
        closeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                window.close();
            }
        });
        //Create the "Save" button (functionality added later)
        Button saveButton = new Button("Save");
        //Create the layout as a VBox
        VBox layout = new VBox();
        //Center the elements in the layout
        layout.setAlignment(Pos.CENTER);
        //Add the elements to the layout
        layout.getChildren().addAll(label, saveField, closeButton, saveButton);
        //Create the scene with the layout
        Scene scene = new Scene(layout);
        //Add the scene to the stage and make it visible
        window.setScene(scene);
        window.showAndWait();
    }
}


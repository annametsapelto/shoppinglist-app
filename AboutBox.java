package fi.tuni.tiko.app;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * This class creates a small window with given title and label.
 * It has modality which means that it has to be closed with the "Return" button.
 */
public class AboutBox {
    /**
     * This method creates the stage, scene and it's contents.
     * @param title
     * @param message
     */
    public static void display(String title, String message){
        //Create the stage with the parameter title and a fixed size
        final Stage window = new Stage();
        //Here modality is declared
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMaxWidth(300);
        window.setMinHeight(200);
        //Create the label with parameter message as text
        Label label = new Label();
        label.setText(message);
        //Make the text automatically add line breaks to fit the space
        label.setWrapText(true);
        //Add some padding
        label.setPadding(new Insets(20));
        //Create the "Return" button and the functionality to exit the stage on clicking
        Button closeButton = new Button("Return");
        closeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                window.close();
            }
        });
        //Create the layout as VBox
        VBox layout = new VBox();
        //Set the items in the layout to the center
        layout.setAlignment(Pos.CENTER);
        //Add the label and the button to the layout
        layout.getChildren().addAll(label, closeButton);
        //Create the scene and add the layout, add the scene to the window and make the window visible
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();


    }
}

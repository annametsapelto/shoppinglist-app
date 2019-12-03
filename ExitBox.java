package fi.tuni.tiko.app;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * In this class the stage before exiting is created and diplayed
 */
public class ExitBox {
    //Create the boolean closing which can be returned in the method display()
    static boolean closing;

    /**
     * In this method the stage for the exit stage is created
     * and the information if the user wants to close the app is given back
     * @return boolean closing
     */
    public static boolean display(){
        //Create the stage
        final Stage window = new Stage();
        //Declare modality
        window.initModality(Modality.APPLICATION_MODAL);
        //Set the title
        window.setTitle("Exit");
        //Set the size
        window.setMaxWidth(300);
        window.setMinHeight(200);
        //Create the label and the text
        Label label= new Label();
        label.setText("Do you really want to exit?");
        //Make the text break lines to fit the space
        label.setWrapText(true);
        //Add padding
        label.setPadding(new Insets(20));
        //Create the button "Exit" with the functionality to exit the app on click.
        //If it is clicked the boolean closing is true and the method will give the information
        // to the main app and close it as well.
        Button exitButton = new Button("Exit");
        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                closing = true;
                window.close();
            }
        });
        //Create the "Return" button with the functionality to close the stage and return to the main view
        Button closeButton = new Button("Return");
        closeButton.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent e) {
            closing = false;
            window.close();
        }
    });
        //Create the "Save" button with the functionality to go to the SaveBox stage for saving the file on click
        Button saveButton = new Button("Save");
        saveButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                window.close();
                SaveBox.display();
            }
        });
        //Make the buttons the same size
        closeButton.setMinSize(50,20);
        exitButton.setMinSize(50,20);
        saveButton.setMinSize(50,20);
        //Create the layout as VBox
        VBox layout = new VBox();
        //Center the elements inside the VBox
        layout.setAlignment(Pos.CENTER);
        //Create a HBox for the buttons
        HBox buttons = new HBox();
        //Set the buttons 3 pixels apart
        buttons.setSpacing(3);
        //Add the buttons to the HBox and center them
        buttons.getChildren().addAll(closeButton, saveButton, exitButton);
        buttons.setAlignment(Pos.CENTER);
        //Add the label and the HBox to the layout
        layout.getChildren().addAll(label, buttons);
        //Create the scene with the layout
        Scene scene = new Scene(layout);
        //Add the scene to the stage and make it visible
        window.setScene(scene);
        window.showAndWait();
        //Return the boolean to the main app so that it will close itself if it is true
        return closing;
}
}

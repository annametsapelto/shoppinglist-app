package fi.tuni.tiko.app;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

/**
 * This app has the graphic user interface for a shopping list
 *
 */
public class App extends Application {
    //Here a number of variables are initiated
    BorderPane pane;
    Scene scene;
    VBox top;
    Label shoppingList;
    Text pieces;
    Text item;
    Group categories;
    Stage window;
    /** In this method the interface's basic components are created and set visible
     */
    @Override
    public void start (Stage stage) {
        window = stage;
        //Define the title and style for the stage
        window.setTitle("Shopping list");
        window.initStyle(StageStyle.DECORATED);
        //Create the functionality that on close request the app will show the ExitBox to verify leaving
        window.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent e) {
                e.consume();
                boolean closing = ExitBox.display();
                if (closing) {
                    window.close();
                }
            }
        });
        //Create a border pane as the layout
        pane = new BorderPane();
        //Create a VBox for the top part of the BorderPane
        top = new VBox();
        //Add a menubar to the VBox with a method
        top.getChildren().add(createMenuBar());
        //Create the text for the label shoppingList
        shoppingList = new Label("Shopping List");
        top.getChildren().add(shoppingList);
        top.setAlignment(Pos.CENTER);
        //Create  two texts and put them into a group
        pieces = new Text("Pieces");
        item = new Text("Item");
        categories = new Group(pieces, item);
        item.setTranslateX(pieces.getTranslateX()+150);
        //Add the group of texts to the VBox
        top.getChildren().add(categories);
        //Add the VBox to the BorderPane's top
        pane.setTop(top);
        //Add a TextArea to the center of the BorderPane
        pane.setCenter(new TextArea());
        //Create the scene with size 400x400
        scene = new Scene(pane, 400, 400);
        //Make the scene to use the default stylesheet "flourished.css"
        scene.getStylesheets().add("flourished.css");
        //Add the scene to the stage and make them visible
        window.setScene(scene);
        window.show();
    }

    /**
     * This method creates the MenuBar and it's contents
     * @return MenuBar
     */
    private MenuBar createMenuBar() {
        //Create the menubar
        MenuBar menuBar = new MenuBar();
        //Create the three main menus
        Menu file = new Menu("File");
        Menu edit = new Menu("Edit");
        Menu about = new Menu("About");
        //Create the file menu item "Save" with the functionality that on click the user gets another scene with options
        MenuItem save = new MenuItem("Save");
        save.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                SaveBox.display();
            }
        });
        //Create the file menu item "Load" (for now no functionality)
        MenuItem load = new MenuItem("Load");
        load.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                LoadBox.display();
            }
        });
        //Create the file menu item exit with the functionality that on click the user gets another scene with options.
        MenuItem exit = new MenuItem("Exit");
        exit.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                boolean closing = ExitBox.display();
                if (closing) {
                    window.close();
                }
            }
        });
        //Create the toggle group for different styles
        ToggleGroup styleOptions = new ToggleGroup();
        //Create Radio Menu Item "Flourished" with the functionality that on click
        // the stylesheet is changed.

        RadioMenuItem flourished = new RadioMenuItem("Flourished");
        flourished.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                scene.getStylesheets().add("flourished.css");
            }
        });
        //Create Radio Menu Item "Technical" with the functionality that on click
        // the stylesheet is changed.
        RadioMenuItem technical = new RadioMenuItem("Technical");
        technical.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                scene.getStylesheets().add("technical.css");
            }
        });
        //Add the style items to the toggle group
        styleOptions.getToggles().addAll(flourished, technical);

        //Create the menu item "About the App" and create the functionality
        // to move to another scene by clicking the menu item.
        MenuItem aboutTheApp = new MenuItem("About This Shopping List");
        aboutTheApp.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                AboutBox.display("About Shopping List",
                        "This shopping list has been made for TAMK course about object oriented programming. " +
                                "It has a graphic user interface and functionality to save and load the shopping list. " +
                                "Written by Anna Metsäpelto");}
        });
        //Create the menu item "Help" and create the functionality
        // to move to another scene by clicking the menu item.
        MenuItem help = new MenuItem("Help");
        help.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                AboutBox.display("Help", "Save and load your shopping list in menu 'File'. " +
                        "Restarting the application usually helps if you experience further problems.");}
            });
        //Add the file menu items to the menu file
        file.getItems().addAll(save, load, exit);
        //Add the toggle group menu items to the menu edit
        edit.getItems().addAll(flourished, technical);

        //Add the items to menu About
        about.getItems().addAll(aboutTheApp, help);

        //Add the menus to the menu bar
        menuBar.getMenus().addAll(file, edit, about);
        //The menu bar is returned
        return menuBar;
    }

    public static void main( String[] args ) {
        System.out.println("Author: Anna Metsapelto");
        launch(args);
    }
}


package closetGUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import  javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import closetGUI.ClothingItem;

public class ClosetGUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label welcomeLabel = new Label("Welcome to Closet Organizer!");
        Label introLabel = new Label("Organize and Manage your Clothes");

        //adding buttons as the option list top choose from
        Button addButton = new Button("Add new Clothing");
        Button viewButton = new Button("Check your Clothing");

        //styling and creating the display window

        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));

        //making sure all the labels and buttons are displayed on the window
        root.getChildren().addAll(welcomeLabel, introLabel, addButton, viewButton);

        //display window size
        Scene scene = new Scene(root, 400, 250);

        //title of the window
        primaryStage.setTitle("Closet Organizer");
        primaryStage.setScene(scene);
        primaryStage.show();




        //setting an action to be done after clicking the button
        addButton.setOnAction(e -> {
            ClothingForm form = new ClothingForm();
            form.showForm();
        });

        viewButton.setOnAction(e ->
                ClosetViewer.showCloset(primaryStage, ClothingForm.getClothingList())
        );
    }

    public static void main(String[] args) {
        launch(args);
    }

}




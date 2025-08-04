package closetGUI;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ClothingForm {
    //shared list for storing added clothes
    private static ArrayList<ClothingItem> clothingList = new ArrayList<>();
    public void showForm(){
        Stage formStage = new Stage();

        Label nameLabel = new Label("Name of your clothing: ");
        TextField nameField = new TextField();

        Label typeLabel = new Label("Clothing Type(Top/Jean/Denim/Pant etc): ");
        TextField typeField = new TextField();

        Label favLabel = new Label("Is this your favourite? (true/false) ");
        TextField favField = new TextField();

        Button submitBtn = new Button("Add Clothing");
        submitBtn.setOnAction(e -> {
           String name = nameField.getText().trim();
           String type = typeField.getText().trim();
           String favText = favField.getText().trim().toLowerCase();

           if (!type.isEmpty() && !name.isEmpty() && (favText.equals("true") || favText.equals("false"))) {
                boolean isFav = Boolean.parseBoolean(favText);
                ClothingItem newItem = new ClothingItem(name, type, isFav);
                clothingList.add(newItem);
                formStage.close();
           }else {
               Alert alert = new Alert(Alert.AlertType.WARNING);
               alert.setTitle("Error");
               alert.setHeaderText("Invalid Input");
               alert.setContentText("Please fill out all the fields Correctly!");
               alert.showAndWait();
           }
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(nameLabel,nameField,typeLabel,typeField,favLabel,favField,submitBtn);

        Scene scene = new Scene(layout,300,250);
        formStage.setTitle("Add New Clothing");
        formStage.setScene(scene);
        formStage.show();
    }

    //This method gives access to the clothing list
    public static ArrayList<ClothingItem> getClothingList() {
        return clothingList;
    }

}

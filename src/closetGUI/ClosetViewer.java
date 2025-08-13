package closetGUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;


public class ClosetViewer {
    public static void showCloset(Stage owner, ArrayList<ClothingItem> clothingItems){
        Stage stage = new Stage();
        stage.setTitle("Your Closet");

        //show clothes by its type
        ObservableList<String> clothingTypes = FXCollections.observableArrayList(
          ClothingForm.getClothingList().stream().map(
                  ClothingItem->capitalizeAndPluralize(ClothingItem.getType())
          ).distinct().toList()
        );

        clothingTypes.addFirst("All"); //add all as default option

        //dropdown to select the type
        ComboBox<String> typeDropdown = new ComboBox<>(clothingTypes);
        typeDropdown.setValue("All");

        //listview to display results
        ListView<String> listView = new ListView<>();
        updateListView(ClothingForm.getClothingList(), listView, typeDropdown.getValue());

        // dropdown filter logic
        typeDropdown.setOnAction(e -> {
            String selectedType = typeDropdown.getValue();
            updateListView(ClothingForm.getClothingList(), listView, selectedType);
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(new Label("Filter by your clothing type "), typeDropdown, listView);

        Scene scene = new Scene(layout, 400, 300);
        stage.setScene(scene);
        stage.initOwner(owner);
        stage.show();
    }

    //helper method to update the listview
    private  static void updateListView(ArrayList<ClothingItem> clothingList, ListView<String> listView, String typeFilter){
        listView.getItems().clear();

        for(ClothingItem item : clothingList){
            if (typeFilter.equals("All") || capitalizeAndPluralize(item.getType()).equalsIgnoreCase(typeFilter)) {
                listView.getItems().add(item.toString());
            }
        }
    }

    //adjusting the dropdown label's name
    private static String capitalizeAndPluralize(String input) {
        if (input == null || input.isEmpty()) return input;
        input = input.toLowerCase().trim();
        String capitalized = input.substring(0, 1).toUpperCase() + input.substring(1);
        // Very simple pluralization rule
        if (!capitalized.endsWith("s")) {
            capitalized += "s";
        }
        return capitalized;
    }

}

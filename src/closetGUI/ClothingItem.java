package closetGUI;

public class ClothingItem {

    String name;
    String type;
    boolean isFav;

    public ClothingItem(String name, String type, boolean isFav) {
        this.name = name;
        this.type = type;
        this.isFav = isFav;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public boolean isFav() {
        return isFav;
    }
    public void setFav(boolean fav) {
        isFav = fav;
    }

    @Override
    public String toString() {
        return name + ", Favourite? " + (isFav ? "Yes" : "No");
    }

}

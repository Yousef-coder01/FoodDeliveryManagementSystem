
package fooddeliverymanagementsystem;
import java.util.ArrayList;


public class Restaurant {
    private int restaurantid;
    private String name;
    private String address;
    private ArrayList<String> menuItems = new ArrayList<>();

    public Restaurant(int restaurantid, String name, String address) {
        this.restaurantid = restaurantid;
        this.name = name;
        this.address = address;
    }

    public void setRestaurantid(int restaurantid) {
        this.restaurantid = restaurantid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMenuItems(ArrayList<String> menuItems) {
        this.menuItems = menuItems;
    }

    public int getRestaurantid() {
        return restaurantid;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public ArrayList<String> getMenuItems() {
        return menuItems;
    }
    
    public void  addMenuItems(String item){
        menuItems.add(item);
    } 
    
    
}


package fooddeliverymanagementsystem;
import java.util.ArrayList;


public class Order {
   private int orderId;
   private Customer customer;
   private Restaurant restaurant;
   private ArrayList <String> foodItems= new ArrayList<>();
   private double deliveryCost;
   private Deliverable deliverer;

    public Order(int orderId, Customer customer, Restaurant restaurant) {
        this.orderId = orderId;
        this.customer = customer;
        this.restaurant = restaurant;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public int getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setFoodItems(ArrayList<String> foodItems) {
        this.foodItems = foodItems;
    }

    public void setDeliveryCost(double deliveryCost) {
        if(customer instanceof GoldenMember){
            double discountRate = ((GoldenMember)customer).getDiscountRate();
            this.deliveryCost = deliveryCost*(1-discountRate);
        }else{
        this.deliveryCost = deliveryCost;
        }
    }

    public void setDeliverer(Deliverable deliverer) {
        this.deliverer = deliverer;
    }

    public ArrayList<String> getFoodItems() {
        return foodItems;
    }

    public double getDeliveryCost() {
        return deliveryCost;
    }

    public Deliverable getDeliverer() {
        return deliverer;
    }
   
    public void addFoodItem(String item){
    foodItems.add(item);
    }
    
    
   
}

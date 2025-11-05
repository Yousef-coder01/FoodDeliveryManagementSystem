
package fooddeliverymanagementsystem;
import java.util.ArrayList;

public class FoodDeliveryManagementSystem {
   private int nextOrder=0;
   private ArrayList<Person>persons = new ArrayList<>();
   private ArrayList<Deliverable>deliverers = new ArrayList<>();
   private ArrayList<Restaurant>restaurants = new ArrayList<>();
   private ArrayList<Order>orders = new ArrayList<>();
  
//Customer Mangement
   
       // Adds a regular customer to the system
       // return Confirmation message
       public String addRegularCustomer(int id, String name, String phoneNumber){
       RegularCustomer regcustomer = new RegularCustomer(id,name,phoneNumber);
       persons.add(regcustomer);
       return "Regular Customer "+name+" added successfully.";  
       }
     
       // Adds a premium (Golden) customer who gets delivery discounts
       //  return Confirmation message
       public String addGoldenCustomer(int id, String name, String phoneNumber, double monthlyFee, double discountRate){
           GoldenMember goldmem = new GoldenMember(monthlyFee,discountRate,id,name,phoneNumber); 
           persons.add(goldmem);
           return"Golden Customer "+name+" added successfully.";
       }
       
//Delivery Personnel Management
       
       // Registers a new human driver
       // return Confirmation message
       public String addDriver(int id, String name, String phoneNumber, int driverId, String vehicleType){
           Driver driver = new Driver(driverId,vehicleType,id,name,phoneNumber);
           persons.add(driver);
           deliverers.add(driver);
           return"Driver "+name+" added successfully.";
       }
       
       // Registers a new delivery drone
       // return Confirmation message
       public String addDrone(int droneId, double maxPayload, int batteryLevel){
           Drone drone = new Drone(droneId, maxPayload, batteryLevel);
           deliverers.add(drone);
           return"Drone "+droneId+" added successfully.";
       }
       
// Restaurant and Menu Management
       // Adds a new restaurant to the system
       // return Confirmation message
       public String addRestaurant(int restaurantId, String name, String address){
          Restaurant restaurant = new Restaurant(restaurantId, name, address);
          restaurants.add(restaurant);
          return"Restaurant "+restaurant.getName()+" added successfully.";
       }
       
       // Adds menu items to a restaurant's offerings
       // return Confirmation message per item added
       public String addMenuItem(int restaurantId, String menuItem){
           //Find Restaurant
           for(Restaurant restaurant:restaurants){
  
               if(restaurantId == restaurant.getRestaurantid()){
                   String[]menuItems = menuItem.split("#");
                   for(String items:menuItems){
                   restaurant.addMenuItems(items); 
                   return "Menu item '"+items+"' added to restaurant "+restaurant.getName();
                   }
                   }
}
               return"Restaurant is not found";
                    }
                 
 //Order Management
       
       // Creates a new food delivery order
       // return Order confirmation message
       public String createOrder(Customer customer, int restaurantId, String[]items, double deliveryCost){
               Restaurant restaurant = null;
           // Find the restaurant    
           for(Restaurant r:restaurants){
               if(restaurantId == r.getRestaurantid()){
                   restaurant = r;
                   break;
               }
                 }

           // Create and store the order
           Order order = new Order(++nextOrder,customer,restaurant);
  
           for(String item:items){
               order.addFoodItem(item);
           }
           // Applies discount if Golden Member
           order.setDeliveryCost(deliveryCost);
           orders.add(order);
      
           
           return "Order "+nextOrder+" created successfully for "+customer.getName() ;   
       }
       
       // Assigns a deliverer (driver/drone) to an order
       // return Assignment confirmation message
       public String assignDeliverer(int orderId, Deliverable deliverer){ 
           Order order = null;
           int delivererid;
           for(Order o:orders){
               if(orderId == o.getOrderId()){
               order = o;
               break;
               }   
           }
          
              
           if(order == null){
               return "order ID"+orderId+" not found";}
           
            if(deliverer == null){
                return "deliverer is not found";
            }
            
            order.setDeliverer(deliverer);
            
            //checks if the deliverer is driver or a drone
            if(deliverer instanceof Driver){
              String delivererName = (((Driver) deliverer).getName());
           return "Driver "+delivererName+" assigned to Order "+orderId; }
            
           else if(deliverer instanceof Drone){
           int delivererId = ((Drone) deliverer).getDroneId();
           return "Drone "+delivererId+" assigned to Order "+orderId; }
            
           return null;
       
       }  
       
//Reporting 
    //Generates a report of all orders handled by a specific deliverer
    //return Formatted order details or error message   
    public String printOrdersByDeliverer (Deliverable deliverer){
        
           if(deliverer == null){
           return "deliverer not found";}
            
        int delivererId = 0;
        StringBuilder OBD = new StringBuilder();
        String delivererType;
        boolean ordersfound = false;
        
        if(deliverer instanceof Driver){
            delivererId = ((Driver) deliverer).getDriverId();
            delivererType = "Driver";
            String deliverername =((Driver)deliverer).getName();
            OBD.append("-----Orders delivered by ").append(delivererType).append(" ").append(deliverername).append(" (ID: ").append(delivererId).append(")--------\n");}
         
        else if(deliverer instanceof Drone){
            delivererId = ((Drone) deliverer).getDroneId();
            delivererType = "Drone";
             OBD.append("-----Orders delivered by ").append(delivererType).append(" (ID: ").append(delivererId).append(")--------\n");
         }
            // Append all matching orders
            for(Order order:orders){
                if(deliverer == order.getDeliverer()){
                ordersfound = true;
                OBD.append("===============================================================\n");
                OBD.append("Order ID   Customer        Restaurant           Delivery Cost\n");
                OBD.append(String.format("%-10d %-15s %-20s %-5.2f\n",order.getOrderId(),order.getCustomer().getName(),order.getRestaurant().getName(),order.getDeliveryCost()));
                OBD.append("-----------------------------Items---------------------------");
                int itemNumber =1;
                for(String item:order.getFoodItems()){
                    OBD.append("\n").append(itemNumber++).append("-").append(item);}
                
                    OBD.append("\n==============================End==============================\n");
             }
            }
        
        
        if(ordersfound)
            return OBD.toString();
        else
            return"orders not found";
    }
   
    /* Calculates the total earnings for a specific deliverer (Driver or Drone)
    by summing up the delivery costs of all orders they've handled.
    return A formatted message containing:
          - Deliverer type (Driver/Drone)
          - Deliverer ID
          - Total earnings (formatted to 2 decimal places)
          Returns earnings even if $0.00 (shows they have no deliveries)
    */
    public String getTotalCostByDeliverer(int delivererId){
        double total  = 0;
        String delivererType = "";
          Deliverable d = getDelivererById(delivererId);
        for(Order order:orders){
       if(d == order.getDeliverer()){
        if(d instanceof Driver){
            delivererType = "Driver";
            total+=order.getDeliveryCost();}
            
        else if(d instanceof Drone){
            delivererType = "Drone";
        total+=order.getDeliveryCost();}
        }
        }
        total = Double.parseDouble(String.format("%.2f",total));
        String Message ="The "+delivererType+" with ID "+delivererId+" has earned $"+total+" for deliveries.";   
        return Message ;
}
    /*
    Generates a formatted report of all orders placed by a specific customer
    - return Formatted string containing all order details, or error message if:
    - Customer not found
    - No orders exist for this customer
    */
    public String printOrdersByCustomer(int customerId){
        int ordercount = 0;
        Customer customer = getCustomerById(customerId);
        if(customer == null){
            return"Customer not found";}
        
        
        StringBuilder OBC = new StringBuilder();
        String customerType = (customer instanceof GoldenMember)?"Golden":"Regular";
              OBC.append("------------- Orders for Customer: ").append(customer.getName()).append(" (ID: ").append(customerId).append(")").append("------------\n");
        for(Order order:orders){
        if(order.getCustomer().getId()== customerId){
            ordercount++;
            
            OBC.append("-------------------------------------------------------------");
            OBC.append("\nOrder ID      : ").append(order.getOrderId()).append("\nCustomer Type : ").append(customerType).append("\nRestaurant    : ").append(order.getRestaurant().getName());
          
    if(customer instanceof GoldenMember){
    OBC.append("\nDiscount Rate : ").append(((GoldenMember)customer).getDiscountRate());
    }else{OBC.append("\nDiscount Rate : ").append(0.0);
}
    
    OBC.append("\nDelivery Cost : ").append(String.format("%.2f",order.getDeliveryCost()));
    OBC.append("\nItems:");
    int itemscount = 1;
    for(String item:order.getFoodItems()){
        OBC.append("\n   ").append(itemscount++).append(". ").append(item);}
    Deliverable d = order.getDeliverer();
     
    
    //checks for the type of deliverer if itd driver or drone to print
    if(d instanceof Driver){
    String delivererType = "Driver";
    int ID = ((Driver)d).getDriverId();
    String driverName = ((Driver)d).getName();
    OBC.append("\nDelivered by  : ").append(delivererType).append(" ").append(driverName).append(" (ID: ").append(ID).append(")");
    }
    else if(d instanceof Drone){
    String delivererType = "Drone";
    int ID = ((Drone)d).getDroneId();
    OBC.append("\nDelivered by  :").append(delivererType).append(" (ID: ").append(ID).append(")");}
    OBC.append("\n-------------------------------------------------------------\n");
   
    }
        }
        if (ordercount ==0){
        return "no orders found";}
        
        return OBC.toString();
        
    }
    //Helper Methods
    
    // Helper method to find a customer by their ID
    // return Customer object if found, null otherwise
    public Customer getCustomerById(int customerID){
        for(Person p: persons){
            if(p instanceof Customer && p.getId() == customerID){
                return(Customer)p;}
    }
        return null;
    }
    // Helper method to find a deliverer (Driver or Drone) by ID
    // return Deliverable object if found, null otherwise
    public Deliverable getDelivererById(int delivererId){
        
        for(Deliverable d:deliverers){
        if(d instanceof Driver && ((Driver)d).getDriverId() == delivererId){
            return ((Driver)d);
        }else if(d instanceof Drone && ((Drone)d).getDroneId()== delivererId){
            return((Drone)d);
            
        }
        }
       return null;     
    }
}
    
 




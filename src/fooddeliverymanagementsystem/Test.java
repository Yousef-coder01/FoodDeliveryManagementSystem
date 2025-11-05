
package fooddeliverymanagementsystem;

import java.io.*;
import java.util.Scanner;

public class Test {

   
    public static void main(String[] args)throws FileNotFoundException{
       FoodDeliveryManagementSystem fdm = new FoodDeliveryManagementSystem();
    File file = new File("input.txt");
    Scanner in = new Scanner(file);
    PrintWriter output = new PrintWriter("output.txt");
    
       while(in.hasNext()){
           String line = in.nextLine().trim();
           String[]tokens = line.split(",");
           String command = tokens[0];
           Deliverable deliverer;
           Customer customer;
    switch(command){
        case "addRegularCustomer":
             output.println(fdm.addRegularCustomer(Integer.parseInt(tokens[1]),tokens[2],tokens[3]));
             break;
             
        case "addGoldenCustomer":
            output.println(fdm.addGoldenCustomer(Integer.parseInt(tokens[1]),tokens[2],tokens[3],Double.parseDouble(tokens[4]),Double.parseDouble(tokens[5])));
            break;
            
        case "addDriver":
            output.println(fdm.addDriver(Integer.parseInt(tokens[1]),tokens[2],tokens[3],Integer.parseInt(tokens[4]),tokens[5]));
            break;
        case "addDrone":
            output.println(fdm.addDrone(Integer.parseInt(tokens[1]),Double.parseDouble(tokens[2]),Integer.parseInt(tokens[3])));
            break;
            
        case "addRestaurant":
            int restaurantid = Integer.parseInt(tokens[1]);
            output.println(fdm.addRestaurant(restaurantid,tokens[2],tokens[3]));
            break;
            
        case "addMenuItem":
            String [] items = tokens[2].split("#");
            for(String item: items){
            int Restaurantid = Integer.parseInt(tokens[1]);
            output.println(fdm.addMenuItem(Restaurantid,item));
            }
            break;
            
        case "createOrder":
            String[]token = tokens[3].split("#"); 
            int customerid = Integer.parseInt(tokens[1]);
            customer = fdm.getCustomerById(customerid);
            int restaurantId = Integer.parseInt(tokens[2]);
            double deliverycost = Double.parseDouble(tokens[4]);
            output.println(fdm.createOrder(customer,restaurantId,token,deliverycost));
            break;
            
        case "assignDeliverer":
            deliverer = fdm.getDelivererById(Integer.parseInt(tokens[2]));
            output.println(fdm.assignDeliverer(Integer.parseInt(tokens[1]),deliverer));    
            break;
            
        case "printOrdersByDeliverer":
            deliverer = fdm.getDelivererById(Integer.parseInt(tokens[1]));
            output.println(fdm.printOrdersByDeliverer(deliverer));    
            break;
            
        case "getTotalCostByDelivererId":
            output.println(fdm.getTotalCostByDeliverer(Integer.parseInt(tokens[1])));
            break;
        
        case "printOrdersByCustomer":
            output.println(fdm.printOrdersByCustomer(Integer.parseInt(tokens[1])));
            break;
            }
                       
    }
            output.close();
            in.close();
                   
    
    
       
    }
    
    }
    


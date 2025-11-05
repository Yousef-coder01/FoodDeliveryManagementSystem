
package fooddeliverymanagementsystem;

public class Driver extends Person implements Deliverable {

    private int driverId;
    private String vehicleType;

    public Driver(int driverId, String vehicleType, int id, String name, String phoneNumber) {
        super(id, name, phoneNumber);
        this.driverId = driverId;
        this.vehicleType = vehicleType;
    }

    public int getDriverId() {
        return driverId;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
    
    public double calculateEarnings(double base,double distance){
        return 0;
    }
    
    
     
    
}

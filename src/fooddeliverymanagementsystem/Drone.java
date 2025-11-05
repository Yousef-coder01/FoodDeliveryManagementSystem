
package fooddeliverymanagementsystem;


public class Drone implements Deliverable {
    private int DroneId;
    private double maxPayload;
    private int batteryLevel;

    public Drone(int droneId, double maxPayload, int batteryLevel) {
        this.DroneId = droneId;
        this.maxPayload = maxPayload;
        this.batteryLevel = batteryLevel;
    }

    public int getDroneId() {
        return DroneId;
    }

    public double getMaxPayload() {
        return maxPayload;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void setDroneId(int DroneId) {
        this.DroneId = DroneId;
    }

    public void setMaxPayload(double maxPayload) {
        this.maxPayload = maxPayload;
    }

    public void setBatteryLevel(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }
    
    
    
            
    
}

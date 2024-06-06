import java.util.*;

class ParkingDetails {
    private Vehicle vehicle;
    private Parking parking;
    private Date entryTime;
    private Date exitTime;

    public ParkingDetails(Vehicle vehicle, Parking parking, Date entryTime, Date exitTime) {
        this.vehicle = vehicle;
        this.parking = parking;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Parking getParking() {
        return parking;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public Date getExitTime() {
        return exitTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }
}
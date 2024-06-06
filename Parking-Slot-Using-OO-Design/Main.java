import java.util.*;
import java.math.BigDecimal;
public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Create vehicle
        Vehicle bike = new Bike("B123");
        Vehicle sedan = new Sedan("S456");

        // Create parking slots
        ParkingSlot slot1 = new ParkingSlot("1", "001", ParkingStatus.EMPTY, SlotSize.SMALL);
        ParkingSlot slot2 = new ParkingSlot("2", "002", ParkingStatus.EMPTY, SlotSize.MEDIUM);

        // Create floor with slots
        List<ParkingSlot> slots = Arrays.asList(slot1, slot2);
        Floor floor = new Floor("F1", 1, "First Floor", slots);

        // Create parking with floors
        List<Floor> floors = Arrays.asList(floor);
        Parking parking = new Parking("P1", floors, "Main Parking", "123 Main St");

        // Create fare controller
        FareController fareController = new FareController();

        // Vehicle entry
        fareController.onVehicleEntry(bike, parking);
        fareController.onVehicleEntry(sedan, parking);

        // Park vehicles
        slot1.parkVehicle(bike);
        slot2.parkVehicle(sedan);

        // Simulate some parking time
        Thread.sleep(5000); // Simulate parking time (5 seconds for example)

        // Vehicle exit
        fareController.onVehicleExit(bike);
        fareController.onVehicleExit(sedan);

        // Calculate fare
        BigDecimal bikeFare = fareController.getFare(bike);
        BigDecimal sedanFare = fareController.getFare(sedan);

        // Print fare
        System.out.println("Bike Fare: " + bikeFare);
        System.out.println("Sedan Fare: " + sedanFare);
    }
}
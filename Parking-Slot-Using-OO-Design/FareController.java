import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class FareController {
    private Map<Vehicle, ParkingDetails> vehicleParkingDetailsMap = new HashMap<>();

    public void onVehicleEntry(Vehicle vehicle, Parking parking) {
        vehicleParkingDetailsMap.put(vehicle, new ParkingDetails(vehicle, parking, new Date(), null));
    }

    public void onVehicleExit(Vehicle vehicle) {
        ParkingDetails parkingDetails = vehicleParkingDetailsMap.get(vehicle);
        parkingDetails.setExitTime(new Date());
    }

    public BigDecimal getFare(Vehicle vehicle) {
        ParkingDetails parkingDetails = vehicleParkingDetailsMap.get(vehicle);
        if (parkingDetails == null || parkingDetails.getExitTime() == null) {
            throw new IllegalArgumentException("Vehicle has not exited or does not exist in records.");
        }
        return getFare(parkingDetails.getParking(), parkingDetails.getEntryTime(), parkingDetails.getExitTime(), vehicle);
    }

    private BigDecimal getFare(Parking parking, Date entryTime, Date exitTime, Vehicle vehicle) {
        long durationInMillis = exitTime.getTime() - entryTime.getTime();
        long durationInHours = TimeUnit.MILLISECONDS.toHours(durationInMillis) + 1;

        BigDecimal ratePerHour;
        switch (vehicle.getType()) {
            case BIKE:
                ratePerHour = new BigDecimal("5.00");
                break;
            case COMPACT:
                ratePerHour = new BigDecimal("10.00");
                break;
            case SEDAN:
                ratePerHour = new BigDecimal("15.00");
                break;
            case TRUCK:
                ratePerHour = new BigDecimal("20.00");
                break;
            default:
                throw new IllegalArgumentException("Unknown vehicle type");
        }

        return ratePerHour.multiply(new BigDecimal(durationInHours));
    }
}

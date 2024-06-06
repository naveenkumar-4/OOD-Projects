public class HatchBackCar implements Vehicle{
    private String carNumber;

    public HatchBackCar(String carNumber){
        this.carNumber = carNumber;
    }

    @Override
    public String toString(){
        return "Car Number = " + carNumber;
    }

    @Override
    public VehicleType getType(){
        return VehicleType.COMPACT;
    }
}

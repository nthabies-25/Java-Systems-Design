package system.rental.car.model;

public class Vehicle {
    private String model;
    private double dailyRate;
    private boolean available;

    public Vehicle (String model, double dailyRate){
        this.model = model;
        this.dailyRate = dailyRate;
        this.available = true;
    }

    public String model() {
        return model;
    }

    public double dailyRate(){
        return dailyRate;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean availability) {
        this.available = availability;
    }

    public void updateDailyRate(double dailyRateUpdated) {
        if ( dailyRate < 0) {
            throw new IllegalArgumentException("The daily rate can not be negative");
        }
        this.dailyRate = dailyRateUpdated;
    }

    @Override
    public String toString() {
        return model() + " " + dailyRate() + " " + isAvailable();
    }

}
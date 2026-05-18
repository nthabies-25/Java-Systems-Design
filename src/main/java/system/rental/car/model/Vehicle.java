package system.rental.car.model;

public class Vehicle {

    private String model;
    private double dailyRate;
    private boolean  available;

    public Vehicle(String model, double dailyRate) {
        if (dailyRate <= 0){
            throw new IllegalArgumentException("Rate cannot be negative");
        }
        this.model = model;
        this.dailyRate = dailyRate;
        this.available = true;
    }

    public String model()       { return model;}
    public double dailyRate()   {return dailyRate;}
    public boolean isAvailable()    {return available;}
    public void setAvailable(boolean available){
        this.available = available;
    }

    public void updateDailyRate(double rate){
        if (dailyRate <= 0){
            throw new IllegalArgumentException("Rate cannot be negative");
        }
        this.dailyRate = rate;
    }

    public String toString(){
        return model() + " " + dailyRate() + "/" + "day";

        }

    }



package system.rental.car.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import system.rental.car.model.Booking;
import system.rental.car.model.Customer;
import system.rental.car.model.Vehicle;


public abstract class RentalBranch {
    private String branchName;
    private Map<String, Vehicle> vehicles;
    private List<Booking> bookings;
    private int bookingCounter;


    public RentalBranch(String branchName) {
        this.branchName = branchName;
        this.vehicles = new HashMap<>();
        this.bookings = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle){
        if (vehicle != null && vehicle.model() != null){
            this.vehicles.put(vehicle.model(), vehicle);
        }
    }
    
    public Vehicle vehicle(String model){
        if (vehicles.keySet().contains(model)){
            return vehicles.get(model);

        }else {
            return null;
        }
    }

    public Map<String, Vehicle> getAllVehicle(){
        return new HashMap<>(vehicles);
    }

    public Vehicle createBooking(Customer customer, String model, int days){
        Vehicle vehicle = vehicles.get(model);
        if (vehicle.isAvailable()){
            Booking booking = new Booking(customer, vehicle, days);
            bookings.add(booking);
            bookingCounter ++;

        } 
        
        throw new IllegalArgumentException("The vehicle is unavailable");
    }

    
          
} 
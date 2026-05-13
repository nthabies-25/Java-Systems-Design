package system.rental.car.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import system.rental.car.model.Booking;
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
} 
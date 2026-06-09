package system.rental.car.service;

import java.util.*;

import system.rental.car.model.*;

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
        vehicles.put(vehicle.model(), vehicle);
    }

    public Vehicle getVehicle(String model) {
        return vehicles.get(model);
    }

    public Map<String, Vehicle> getAllVehicles(){
        return Map.copyOf(vehicles);
    }

    public void createBooking(Customer customer, String model, int days) {
        Vehicle vehicle = vehicles.get(model);

        if (vehicle == null || !vehicle.isAvailable()){
            throw new IllegalArgumentException("Vehicle is not available/doesn't exist.");
        }
        Booking booking = new Booking(++bookingCounter, customer, vehicle, days);
        bookings.add(booking);
        vehicle.setAvailable(false);

    }

    public void processNextBooking(Booking booking){
        for (Booking booking : bookings){
            if (status == PENDING){
                Booking.BookingStatus.APPROVED;
            }

        }
    }

    public List<Booking> boookings(){
        return List.copyOf(bookings);
    }

    public String branchName() {
        return branchName;
    }

    protected abstract void processRental(Booking booking);

}
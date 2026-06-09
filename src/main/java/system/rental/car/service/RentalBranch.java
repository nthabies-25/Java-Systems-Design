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

    public Booking processNextBooking(){
        for (Booking booking : bookings){
            if (booking.status() == Booking.BookingStatus.PENDING){
                booking.setStatus(Booking.BookingStatus.IN_PROGRESS);
                booking.setStatus(Booking.BookingStatus.APPROVED);

                processRental(booking);
                booking.vehicle().setAvailable(false);

            }
            return booking;

        }
        return null;
    }

    public Booking processNextBookingss(Booking booky){
        if (bookings.contains(booky)){
            processRental(booky);
            booky.vehicle().setAvailable(false);

        }
        return booky;
    }

    public List<Booking> boookings(){
        return List.copyOf(bookings);
    }

    public String branchName() {
        return branchName;
    }

    protected abstract void processRental(Booking booking);

}
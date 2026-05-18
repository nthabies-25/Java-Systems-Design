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

    public void createBooking(Customer customer, String model, int days){
        Vehicle vehicle = vehicles.get(model);
        if (vehicle.isAvailable()){
            Booking booking = new Booking(customer, vehicle, days);
            bookings.add(booking);
            bookingCounter ++;

        } 
        
        throw new IllegalArgumentException("The vehicle is unavailable");
    }

    public void processRental(Booking booking){
    }

    public Booking processNextBooking(Customer customer, String model){
        for (Booking booking : bookings){
            if (booking.status() == Booking.BookingStatus.PENDING){
                booking.updateStatus(Booking.BookingStatus.IN_PROGRESS);

                processRental(booking);
                booking.updateStatus(Booking.BookingStatus.APPROVED);



                Vehicle vehicle = vehicles.get(model);
                if (vehicle.isAvailable()){
                    vehicle.setAvailable(false);
                }
                return booking;
            }
        }
        return null;
    }

    public List<Booking> bookings(){
        return new ArrayList<>(this.bookings);
    }

    public String branchName(){
        return branchName;
    }

    public double totalRevenue(){
        double total = 0;
        for (Booking b1 : bookings){
            Booking booking = null;
            if (booking.status() == Booking.BookingStatus.APPROVED){
                total+= (booking.vehicle().dailyRate()) * booking.day();


            }

        }
        return total;
    }
} 
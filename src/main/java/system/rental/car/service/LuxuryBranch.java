package system.rental.car.service;

import system.rental.car.model.Booking;
import system.rental.car.model.Vehicle;


public class LuxuryBranch extends RentalBranch {

    public LuxuryBranch(String branchName ) {
        super(branchName);
    }


    public void processRental(Booking booking) {
        Vehicle vehicle = booking.vehicle();
        if (vehicle.isAvailable()) {
            vehicle.setAvailable(false);
            System.out.println(branchName() + " preparing premium vehicle "
                    + booking.vehicle() + " for VIP customer " + booking.customer());
        }

    }
}
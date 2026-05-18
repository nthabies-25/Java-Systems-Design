package system.rental.car.service;

import system.rental.car.model.Booking;
import system.rental.car.model.Customer;
import system.rental.car.model.Vehicle;

public class EconomyBranch extends RentalBranch {

    public EconomyBranch(String branchName) {
        super(branchName);
    }


    @Override
    public void processRental(Booking booking) {
        Vehicle vehicle = booking.vehicle();
        if (vehicle.isAvailable()) {
            vehicle.setAvailable(false);

            System.out.println(branchName() + " processing economy rental for "
                    + booking.customer() + " with vehicle" + booking.vehicle());
        }
    }
}
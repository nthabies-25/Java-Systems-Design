package system.rental.car.model;

public class Booking {

    public enum BookingStatus {
        PENDING,
        IN_PROGRESS,
        APPROVED
    }
    private int bookingId;
    private Customer customer;
    private Vehicle vehicle;
    private int days;
    private BookingStatus status;

    public Booking(int bookingId, Customer customer, Vehicle vehicle, int days) {
        this.status = BookingStatus.PENDING;
        if (days < 0){
            throw new IllegalArgumentException();
        }
        this.days =days;
        this.bookingId = bookingId;
        this.customer = customer;
        this.vehicle = vehicle;
    }

    public int bookingId() { return bookingId;}
    public Customer customer() { return customer;}
    public Vehicle vehicle() { return vehicle;}
    public int days() { return days;}
    public BookingStatus status() { return status;}

    public int totalCost() {
        int dailyRate = 0;
        return dailyRate * days;
    }

    public void updateStatus(BookingStatus statusUpdated){
        this.status = statusUpdated;
    }

    @Override
    public String toString(){
        return bookingId() + " " + customer() + " "
                + vehicle() + " " + days() + " " + status();
    }

}
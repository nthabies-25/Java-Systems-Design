package system.rental.car.model;

public class Booking {

    public enum BookingStatus{
        PENDING,
        IN_PROGRESS,
        CANCELLED,
        APPROVED
    }


    private int bookingId;
    private Customer customer;
    private Vehicle vehicle;
    private int days;
    private String model;
    private BookingStatus status;

    public Booking(int bookingId, Customer customer, Vehicle vehicle, int days){

        this.status = status.PENDING;
        this.bookingId = bookingId;
        this.customer = customer;
        this.vehicle = vehicle;
        this.days = days;
    }

    public Booking(Customer customer, Vehicle vehicle, int days){
        this.customer = customer;
        this.vehicle = vehicle;
        this.days = days;
    }

    public int bookingId()  {return bookingId;}
    public Customer customer()  {return customer;}
    public Vehicle vehicle()    {return vehicle;}
    public int day()    {return days;}
    public BookingStatus status()   {return status;}

    public double totalCost() {
        double v = vehicle.dailyRate() * days;
        return v;
    }

    public void updateStatus(BookingStatus updatedStatus) {
        this.status = updatedStatus;

    }

    @Override
    public String toString(){
        return bookingId() + " " 
        + customer() + " " 
        + vehicle() + " "
        + day() + " "
        + status();
    }
}
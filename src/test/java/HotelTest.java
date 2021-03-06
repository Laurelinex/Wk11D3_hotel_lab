import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HotelTest {

    private Hotel hotel;

    private Bedroom bedroom1;
    private Bedroom bedroom2;

    private ConferenceRoom conferenceRoom1;
    private ConferenceRoom conferenceRoom2;

    private Guest guest1;
    private Guest guest2;

    private Booking booking1;

    @Before
    public void setUp() throws Exception {
        hotel = new Hotel("CodeClan Towers");
        bedroom1 = new Bedroom(1, 1, "Single", 10.50);
        bedroom2 = new Bedroom(2, 2, "Double", 20.50 );
        conferenceRoom1 = new ConferenceRoom("The Big Apple Room", 10);
        conferenceRoom2 = new ConferenceRoom("The Michelangelo Room", 5);
        guest1 = new Guest("Larry");
        guest2 = new Guest("Steve");
        booking1 = new Booking(bedroom2, 10);
    }

    @Test
    public void hasName() {
        assertEquals("CodeClan Towers", hotel.getName());
    }

    @Test
    public void canCheckInGuest() {
        hotel.addBedroom(bedroom1);
        hotel.checkInGuest(guest1, bedroom1);
        assertEquals(1, hotel.guestCount());
    }

    @Test
    public void canCheckOutGuest() {
        hotel.addBedroom(bedroom1);
        hotel.checkInGuest(guest1, bedroom1);
        hotel.checkOutGuest(guest1, bedroom1);
        assertEquals(0, hotel.guestCount());
    }

    @Test
    public void canBookRoom() {
        hotel.addBedroom(bedroom1);
        hotel.bookRoom(bedroom1, 2);
        assertEquals (1, hotel.bookingCount());

    }

    @Test
    public void canGetBill() {
        assertEquals(205.00, hotel.getBill(booking1), 0.01) ;
    }

}

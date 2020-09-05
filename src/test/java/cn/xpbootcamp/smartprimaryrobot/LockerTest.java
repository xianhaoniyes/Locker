package cn.xpbootcamp.smartprimaryrobot;
import org.junit.Assert;
import org.junit.Test;


public class LockerTest {

    @Test
    public void should_return_ticket_when_locker_save_bag_given_locker_has_available_capacity(){
        Locker locker = new Locker(10);
        Ticket ticket = locker.save(new Bag());
        Assert.assertNotNull(ticket);
    }

    @Test(expected = LockerIsFullException.class)
    public void should_throw_LockerIsFullException_when_locker_save_bag_given_locker_is_full(){
        Locker locker = new Locker(1);
        locker.save(new Bag());
        locker.save(new Bag());

    }
}

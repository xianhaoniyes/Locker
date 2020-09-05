package cn.xpbootcamp.smartlockerrobot;
import org.junit.Assert;
import org.junit.Test;


import java.util.Arrays;

public class SmartLockerRobotTest {

    @Test
    public void should_save_in_1st_locker_and_return_ticket_when_1st_has_the_largest_capacity(){

        Locker firstLocker = new Locker(5);
        Locker secondLocker = new Locker(2);
        SmartLockerRobot robot = new SmartLockerRobot(Arrays.asList(firstLocker,secondLocker));
        Bag  bag = new Bag();

        Ticket ticket = robot.save(bag);
        Assert.assertNotNull(ticket);
        Assert.assertSame(bag, firstLocker.pickupBy(ticket));
    }
}

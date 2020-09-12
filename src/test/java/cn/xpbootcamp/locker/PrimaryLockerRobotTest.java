package cn.xpbootcamp.locker;


import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class PrimaryLockerRobotTest {


    @Test
    public void should_save_in_1st_locker_and_return_ticket_when_1st_has_capacity(){

        Locker firstLocker = new Locker(3);
        Locker secondLocker = new Locker(3);
        PrimaryLockerRobot robot = new PrimaryLockerRobot(Arrays.asList(firstLocker,secondLocker));
        Bag  bag = new Bag();

        Ticket ticket = robot.save(bag);
        Assert.assertNotNull(ticket);
        Assert.assertSame(bag, firstLocker.pickupBy(ticket));
    }

    @Test
    public void should_save_in_2st_locker_and_return_ticket_when_1st_is_full_and_2st_had_capacity(){

        Locker firstLocker = new Locker(1);
        Locker secondLocker = new Locker(5);
        PrimaryLockerRobot robot = new PrimaryLockerRobot(Arrays.asList(firstLocker,secondLocker));

        robot.save(new Bag());
        Bag bag = new Bag();
        Ticket ticket = robot.save(bag);
        Assert.assertNotNull(ticket);
        Assert.assertSame(bag, secondLocker.pickupBy(ticket));
    }



    @Test(expected = LockerIsFullException.class)
    public void should_throw_LockerIsFullException_when_locker_save_bag_given_lockers_are_full(){
        Locker firstLocker = new Locker(1);
        Locker secondLocker = new Locker(1);
        PrimaryLockerRobot robot = new PrimaryLockerRobot(Arrays.asList(firstLocker,secondLocker));

        robot.save(new Bag());
        robot.save(new Bag());
        robot.save(new Bag());
    }

    @Test
    public void should_return_bag_given_valid_ticket(){

        PrimaryLockerRobot robot = new PrimaryLockerRobot(Arrays.asList(new Locker(2),new Locker(1)));
        Bag bag = new Bag();
        Ticket ticket = robot.save(bag);

        Bag returnedBag = robot.pickupBy(ticket);

        Assert.assertSame(bag,returnedBag);

    }


    @Test(expected = InvalidTicketException.class)
    public void should_return_InvalidTicketException_given_invalid_ticket(){

        PrimaryLockerRobot robot = new PrimaryLockerRobot(Arrays.asList(new Locker(2),new Locker(1)));

        Ticket ticket = new Ticket();

        robot.pickupBy(ticket);

    }

}
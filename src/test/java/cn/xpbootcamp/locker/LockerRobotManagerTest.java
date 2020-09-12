package cn.xpbootcamp.locker;
import org.junit.Assert;
import org.junit.Test;


import java.util.Arrays;

public class LockerRobotManagerTest {

    @Test
    public void should_save_to_1st_locker_and_return_ticket_when_manage_two_lockers_and_1st_has_capacity(){
        Locker firstLocker = new Locker(1);
        Locker secondLocker = new Locker(1);
        LockerRobotManager lockerRobotManager = new LockerRobotManager(Arrays.asList(firstLocker,secondLocker));

        Bag bag = new Bag();
        Ticket ticket = lockerRobotManager.save(bag);

        Assert.assertNotNull(ticket);
        Assert.assertSame(bag, firstLocker.pickupBy(ticket));
    }

    @Test
    public void should_save_to_2nd_locker_and_return_ticket_when_manage_two_lockers_and_1st_is_full_and_2nd_has_capacity(){
        Locker firstLocker = new Locker(1);
        Locker secondLocker = new Locker(1);
        LockerRobotManager lockerRobotManager = new LockerRobotManager(Arrays.asList(firstLocker,secondLocker));
        lockerRobotManager.save(new Bag());

        Bag bag = new Bag();
        Ticket ticket = lockerRobotManager.save(bag);

        Assert.assertNotNull(ticket);
        Assert.assertSame(bag, secondLocker.pickupBy(ticket));
    }

    @Test(expected = LockerIsFullException.class)
    public void should_raise_LockerIsFullException_t_when_manage_two_lockers_and_both_are_full(){
        Locker firstLocker = new Locker(1);
        Locker secondLocker = new Locker(1);
        LockerRobotManager lockerRobotManager = new LockerRobotManager(Arrays.asList(firstLocker,secondLocker));
        lockerRobotManager.save(new Bag());
        lockerRobotManager.save(new Bag());

        lockerRobotManager.save(new Bag());
    }



    @Test
    public void should_save_to_1st_robot_and_return_ticket_when_manage_two_robot_and_1st_has_capacity(){
        SmartLockerRobot firstRobot = new SmartLockerRobot(Arrays.asList(new Locker(1)));
        PrimaryLockerRobot secondRobot = new PrimaryLockerRobot(Arrays.asList(new Locker(1)));
        LockerRobotManager lockerRobotManager = new LockerRobotManager(Arrays.asList(firstRobot ,secondRobot));

        Bag bag = new Bag();
        Ticket ticket = lockerRobotManager.save(bag);

        Assert.assertNotNull(ticket);
        Assert.assertSame(bag, firstRobot.pickupBy(ticket));
    }



    @Test
    public void should_save_to_2nd_robot_and_return_ticket_when_manage_two_robot_and_1st_is_full_and_2nd_has_capacity(){
        SmartLockerRobot firstRobot = new SmartLockerRobot(Arrays.asList(new Locker(1)));
        PrimaryLockerRobot secondRobot = new PrimaryLockerRobot(Arrays.asList(new Locker(1)));
        LockerRobotManager lockerRobotManager = new LockerRobotManager(Arrays.asList(firstRobot ,secondRobot));
        lockerRobotManager.save(new Bag());

        Bag bag = new Bag();
        Ticket ticket = lockerRobotManager.save(bag);

        Assert.assertNotNull(ticket);
        Assert.assertSame(bag, secondRobot.pickupBy(ticket));
    }

    @Test(expected = LockerIsFullException.class)
    public void should_raise_LockerIsFullException_t_when_manage_two_robots_and_both_are_full(){
        SmartLockerRobot firstRobot = new SmartLockerRobot(Arrays.asList(new Locker(1)));
        PrimaryLockerRobot secondRobot = new PrimaryLockerRobot(Arrays.asList(new Locker(1)));
        LockerRobotManager lockerRobotManager = new LockerRobotManager(Arrays.asList(firstRobot,secondRobot));
        lockerRobotManager.save(new Bag());
        lockerRobotManager.save(new Bag());

        lockerRobotManager.save(new Bag());
    }

    @Test
    public void should_save_to_robot_and_return_ticket_when_manage_one_robot_and_one_locker_and_robot_has_capacity(){
        SmartLockerRobot robot = new SmartLockerRobot(Arrays.asList(new Locker(1)));
        Locker locker = new Locker(1);
        LockerRobotManager lockerRobotManager = new LockerRobotManager(Arrays.asList(robot ,locker));

        Bag bag = new Bag();
        Ticket ticket = lockerRobotManager.save(bag);

        Assert.assertNotNull(ticket);
        Assert.assertSame(bag, robot.pickupBy(ticket));
    }

    @Test
    public void should_save_to_locker_and_return_ticket_when_manage_one_robot_and_one_locker_and_robot_is_full_and_locker_has_capacity(){
        SmartLockerRobot robot = new SmartLockerRobot(Arrays.asList(new Locker(1)));
        Locker locker = new Locker(1);
        LockerRobotManager lockerRobotManager = new LockerRobotManager(Arrays.asList(robot ,locker));
        lockerRobotManager.save(new Bag());

        Bag bag = new Bag();
        Ticket ticket = lockerRobotManager.save(bag);

        Assert.assertNotNull(ticket);
        Assert.assertSame(bag, locker.pickupBy(ticket));
    }

    @Test(expected = LockerIsFullException.class)
    public void should_raise_LockerIsFullException_when_manage_one_robot_and_one_locker_and_both_are_full(){
        SmartLockerRobot robot = new SmartLockerRobot(Arrays.asList(new Locker(1)));
        Locker locker = new Locker(1);
        LockerRobotManager lockerRobotManager = new LockerRobotManager(Arrays.asList(robot ,locker));
        lockerRobotManager.save(new Bag());
        lockerRobotManager.save(new Bag());

        lockerRobotManager.save(new Bag());
    }

    @Test
    public void should_return_bag_when_manage_two_lockers_and_ticket_is_valid(){
        Locker firstLocker = new Locker(1);
        Locker secondLocker = new Locker(1);
        LockerRobotManager lockerRobotManager = new LockerRobotManager(Arrays.asList(firstLocker,secondLocker));

        Bag bag = new Bag();
        Ticket ticket = lockerRobotManager.save(bag);

        Assert.assertSame(bag, lockerRobotManager.pickupBy(ticket));

    }

    @Test(expected = InvalidTicketException.class)
    public void should_return_bag_when_manage_two_lockers_and_ticket_is_invalid(){
        Locker firstLocker = new Locker(1);
        Locker secondLocker = new Locker(1);
        LockerRobotManager lockerRobotManager = new LockerRobotManager(Arrays.asList(firstLocker,secondLocker));
        Ticket ticket = new Ticket();

        lockerRobotManager.pickupBy(ticket);

    }

    @Test
    public void should_return_bag_when_manage_two_robots_and_ticket_is_valid(){
        SmartLockerRobot firstRobot = new SmartLockerRobot(Arrays.asList(new Locker(1)));
        PrimaryLockerRobot secondRobot = new PrimaryLockerRobot(Arrays.asList(new Locker(1)));
        LockerRobotManager lockerRobotManager = new LockerRobotManager(Arrays.asList(firstRobot ,secondRobot));

        Bag bag = new Bag();
        Ticket ticket = lockerRobotManager.save(bag);

        Assert.assertSame(bag, lockerRobotManager.pickupBy(ticket));

    }

    @Test(expected = InvalidTicketException.class)
    public void should_return_bag_when_manage_two_robots_and_ticket_is_invalid(){
        SmartLockerRobot firstRobot = new SmartLockerRobot(Arrays.asList(new Locker(1)));
        PrimaryLockerRobot secondRobot = new PrimaryLockerRobot(Arrays.asList(new Locker(1)));
        LockerRobotManager lockerRobotManager = new LockerRobotManager(Arrays.asList(firstRobot ,secondRobot));
        Ticket ticket = new Ticket();

        lockerRobotManager.pickupBy(ticket);
    }

    @Test
    public void should_return_bag_when_manage_one_robots_and_one_locker_and_ticket_is_valid(){
        SmartLockerRobot robot = new SmartLockerRobot(Arrays.asList(new Locker(1)));
        Locker locker = new Locker(1);
        LockerRobotManager lockerRobotManager = new LockerRobotManager(Arrays.asList(robot ,locker));

        Bag bag = new Bag();
        Ticket ticket = lockerRobotManager.save(bag);

        Assert.assertNotNull(ticket);
        Assert.assertSame(bag, lockerRobotManager.pickupBy(ticket));

    }

    @Test(expected = InvalidTicketException.class)
    public void should_return_bag_when_manage_one_robots_and_one_locker_and_ticket_is_invalid(){
        SmartLockerRobot robot = new SmartLockerRobot(Arrays.asList(new Locker(1)));
        Locker locker = new Locker(1);
        LockerRobotManager lockerRobotManager = new LockerRobotManager(Arrays.asList(robot ,locker));

        Ticket ticket = new Ticket();

        lockerRobotManager.pickupBy(ticket);
    }




}

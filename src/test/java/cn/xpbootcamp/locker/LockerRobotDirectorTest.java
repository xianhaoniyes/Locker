package cn.xpbootcamp.locker;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class LockerRobotDirectorTest {

    @Test
    public void should_print_correct_information_with_condition_1(){
        Locker firstLocker = new Locker(1);
        Locker secondLocker = new Locker(1);
        LockerRobotManager lockerRobotManager = new LockerRobotManager(Arrays.asList(firstLocker,secondLocker));
        firstLocker.save(new Bag());
        LockerRobotDirector lockerRobotDirector = new LockerRobotDirector(Collections.singletonList(lockerRobotManager));

        String expectReport = "M 1 2\n L 0 1\n L 1 1\n";

        lockerRobotDirector.report();
        Assert.assertEquals(expectReport,lockerRobotDirector.report());

    }

    @Test
    public void should_print_correct_information_with_condition_2(){
        Locker robot1Locker1 = new Locker(1);
        Locker robot1Locker2 = new Locker(1);
        Locker robot2Locker1 = new Locker(1);
        Locker robot2Locker2 = new Locker(1);
        PrimaryLockerRobot robot1 = new PrimaryLockerRobot(Arrays.asList(robot1Locker1,robot1Locker2));
        PrimaryLockerRobot robot2 = new PrimaryLockerRobot(Arrays.asList(robot2Locker1,robot2Locker2));
        LockerRobotManager lockerRobotManager = new LockerRobotManager(Arrays.asList(robot1,robot2));
        LockerRobotDirector lockerRobotDirector = new LockerRobotDirector(Collections.singletonList(lockerRobotManager));
        robot1Locker1.save(new Bag());
        robot2Locker1.save(new Bag());

        String expectReport = "M 2 4\n R 1 2\n  L 0 1\n  L 1 1\n R 1 2\n  L 0 1\n  L 1 1\n";
        lockerRobotDirector.report();

        Assert.assertEquals(expectReport,lockerRobotDirector.report());

    }

    @Test
    public void should_print_correct_information_with_condition_3(){
        Locker robotLocker1 = new Locker(1);
        Locker robotLocker2= new Locker(1);
        Locker locker = new Locker(1);

        PrimaryLockerRobot robot1 = new PrimaryLockerRobot(Arrays.asList(robotLocker1,robotLocker2));
        LockerRobotManager lockerRobotManager = new LockerRobotManager(Arrays.asList(robot1,locker));
        LockerRobotDirector lockerRobotDirector = new LockerRobotDirector(Collections.singletonList(lockerRobotManager));
        robotLocker1.save(new Bag());

        String expectReport = "M 2 3\n R 1 2\n  L 0 1\n  L 1 1\n L 1 1\n";
        lockerRobotDirector.report();

        Assert.assertEquals(expectReport,lockerRobotDirector.report());

    }
}

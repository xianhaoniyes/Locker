package cn.xpbootcamp.smartlockerrobot;

import java.util.List;

public class SmartLockerRobot {

    private List<Locker> lockers;

    public SmartLockerRobot(List<Locker> lockers) {

        this.lockers = lockers;

    }

    public Ticket save(Bag bag) {
        return lockers.get(0).save(bag);
    }
}

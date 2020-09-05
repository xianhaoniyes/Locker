package cn.xpbootcamp.smartlockerrobot;

import java.util.List;

public class SmartLockerRobot {

    private List<Locker> lockers;

    public SmartLockerRobot(List<Locker> lockers) {

        this.lockers = lockers;

    }

    public Ticket save(Bag bag) {
        Locker locker_max = lockers.get(0);
        for (Locker locker: lockers) {
            if (locker.currentCapacity() > locker_max.currentCapacity()){
                locker_max = locker;
            }
        }
        return locker_max.save(bag);
    }

    public Bag pickupBy(Ticket ticket) {

        for(Locker locker:lockers){
            try {
                return  locker.pickupBy(ticket);
            }
            catch (Exception ex){
            }
        }
        throw new InvalidTicketException();
    }
}

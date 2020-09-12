package cn.xpbootcamp.locker;

import java.util.List;

public class SmartLockerRobot implements BagSaver{

    private final List<Locker> lockers;

    public SmartLockerRobot(List<Locker> lockers) {

        this.lockers = lockers;

    }

    public Ticket save(Bag bag) {
        Locker lockerMax = lockers.get(0);
        for (Locker locker: lockers) {
            if (locker.currentCapacity() > lockerMax.currentCapacity()){
                lockerMax = locker;
            }
        }
        return lockerMax.save(bag);
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

    public int currentCapacity(){
        return  lockers.stream().reduce(0,(current,element) -> current +element.currentCapacity(),Integer::sum);
    }

    public int totalCapacity(){
        return  lockers.stream().reduce(0,(current,element) -> current +element.totalCapacity(),Integer::sum);
    }

    public String report() {
        String str = "R ";
        str = str+ totalCapacity()+" "+currentCapacity()+"\n"+" ";
        for (Locker locker:lockers) {
            str = str + locker.report()+" ";
        }
        return str;
    }
}

package cn.xpbootcamp.locker;

import java.util.List;

public class PrimaryLockerRobot implements BagSaver{

    private final List<Locker> lockers;

    public PrimaryLockerRobot(List<Locker> lockers) {

        this.lockers = lockers;

    }

    public Ticket save(Bag bag) {
        for (Locker locker: lockers) {
            if (locker.currentCapacity() > 0){
                return locker.save(bag);
            }
        }
        throw new LockerIsFullException();
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

    public String report(String empty) {
        String str = "R ";
        str = empty+str+ currentCapacity()+" "+totalCapacity()+"\n";
        for (Locker locker:lockers) {
            str = str + locker.report(empty+" ");
        }
        return str;
    }
}

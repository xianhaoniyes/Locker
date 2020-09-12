package cn.xpbootcamp.locker;

import java.util.ArrayList;
import java.util.List;

public class LockerRobotManager implements BagSaver{

    final private List<BagSaver> savers;

    public LockerRobotManager(List<BagSaver> initSavers) {
        this.savers = new ArrayList<>();
        List<BagSaver> list2 = new ArrayList<>();
        for (BagSaver bagsaver: initSavers) {
            if (bagsaver instanceof PrimaryLockerRobot || bagsaver instanceof SmartLockerRobot)
                this.savers.add(bagsaver);
            else
                list2.add(bagsaver);
        }
        this.savers.addAll(list2);
    }


    public Ticket save(Bag bag) {
        for (BagSaver saver:savers) {
            if(saver.currentCapacity()>0)
                return saver.save(bag);
        }
        throw new LockerIsFullException();
    }

    public Bag pickupBy(Ticket ticket){
        for(BagSaver saver:savers){
            try {
                return  saver.pickupBy(ticket);
            }
            catch (Exception ex){
            }
        }
        throw new InvalidTicketException();
    }

    public String report() {
        String str = "M ";
        str = str + this.currentCapacity()+" "+this.totalCapacity()+"\n"+" ";
        for (BagSaver saver:savers) {
            str = str + saver.report()+" ";
        }
        return str;
    }

    public int currentCapacity(){
        return  savers.stream().reduce(0,(current,element) -> current +element.currentCapacity(),Integer::sum);
    }

    public int totalCapacity(){
        return  savers.stream().reduce(0,(current,element) -> current +element.totalCapacity(),Integer::sum);
    }
}

package cn.xpbootcamp.locker;

public interface BagSaver {

    Ticket save(Bag bag);

    Bag pickupBy(Ticket ticket);

    int currentCapacity();
}

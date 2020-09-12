package cn.xpbootcamp.locker;

import java.util.List;

public class LockerRobotDirector {

    final private List<LockerRobotManager> lockerRobotManagers;

    public LockerRobotDirector(List<LockerRobotManager> list) {
        this.lockerRobotManagers = list;
    }

    public String report() {
        String str = "";
        for (LockerRobotManager lockerRobotManager:lockerRobotManagers) {
            str = str + lockerRobotManager.report();
        }
        return str;
    }
}

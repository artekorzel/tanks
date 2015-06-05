package fbao;

import robocode.Robot;
import robocode.ScannedRobotEvent;

public class DTRobot extends Robot {

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("MOVE");
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onScannedRobot(ScannedRobotEvent event) {
        try {
            System.out.println("FIRE");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

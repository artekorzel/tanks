package fbao;

import jdk.nashorn.api.scripting.JSObject;
import robocode.Robot;

public enum Action {
    FIRE {
        @Override
        public void doJob(Robot robot, JSObject result) {
            robot.turnGunRight(robot.getRadarHeading() - robot.getGunHeading());
            robot.fire(Double.valueOf(result.getMember("power").toString()));
        }
    },
    MOVE {
        @Override
        public void doJob(Robot robot, JSObject result) {
            double x = robot.getX();
            double y = robot.getY();
            double targetX = Double.valueOf(result.getMember("x").toString());
            double targetY = Double.valueOf(result.getMember("y").toString());
            double distance = Math.sqrt(Math.pow(targetX - x, 2) + Math.pow(targetY - y, 2));
            if (distance <= 3) {
                return;
            }
            double alfa = Math.toDegrees(Math.atan((targetX - x) / ((targetY - y))));
            if (targetY < y) {
                alfa += 180.0;
            }
            robot.turnRight(alfa - robot.getHeading());
            robot.ahead(distance);
        }
    },
    TURN_RADAR {
        @Override
        public void doJob(Robot robot, JSObject result) {
            double degrees = Double.valueOf(result.getMember("degrees").toString());
            robot.turnRadarRight(degrees);
        }
    };

    public abstract void doJob(Robot robot, JSObject result);
}

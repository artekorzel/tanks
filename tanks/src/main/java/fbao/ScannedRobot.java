package fbao;

public class ScannedRobot {

    public final double distance;
    public final double bearing;
    public final double energy;
    public final double heading;
    public final double velocity;

    public ScannedRobot(double distance, double bearing, double energy, double heading, double velocity) {
        this.distance = distance;
        this.bearing = bearing;
        this.energy = energy;
        this.heading = heading;
        this.velocity = velocity;
    }

    public static class ScannedRobotBuilder {
        public double distance;
        public double bearing;
        public double energy;
        public double heading;
        public double velocity;

        private ScannedRobotBuilder() {
        }

        public static ScannedRobotBuilder aScannedRobot() {
            return new ScannedRobotBuilder();
        }

        public ScannedRobotBuilder withDistance(double distance) {
            this.distance = distance;
            return this;
        }

        public ScannedRobotBuilder withBearing(double bearing) {
            this.bearing = bearing;
            return this;
        }

        public ScannedRobotBuilder withEnergy(double energy) {
            this.energy = energy;
            return this;
        }

        public ScannedRobotBuilder withHeading(double heading) {
            this.heading = heading;
            return this;
        }

        public ScannedRobotBuilder withVelocity(double velocity) {
            this.velocity = velocity;
            return this;
        }

        public ScannedRobotBuilder but() {
            return aScannedRobot().withDistance(distance).withBearing(bearing).withEnergy(energy).withHeading(heading).withVelocity(velocity);
        }

        public ScannedRobot build() {
            return new ScannedRobot(distance, bearing, energy, heading, velocity);
        }
    }
}

package fbao;

public class Robot {

    public final double sizeX;
    public final double sizeY;
    public final double positionX;
    public final double positionY;
    public final double energy;
    public final double heading;
    public final double radarHeading;
    public final double velocity;

    public Robot(double sizeX, double sizeY, double positionX, double positionY,
                 double energy, double heading, double radarHeading, double velocity) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.positionX = positionX;
        this.positionY = positionY;
        this.energy = energy;
        this.heading = heading;
        this.radarHeading = radarHeading;
        this.velocity = velocity;
    }

    public static class RobotBuilder {
        public double sizeX;
        public double sizeY;
        public double positionX;
        public double positionY;
        public double energy;
        public double heading;
        public double radarHeading;
        public double velocity;

        private RobotBuilder() {
        }

        public static RobotBuilder aRobot() {
            return new RobotBuilder();
        }

        public RobotBuilder withSizeX(double sizeX) {
            this.sizeX = sizeX;
            return this;
        }

        public RobotBuilder withSizeY(double sizeY) {
            this.sizeY = sizeY;
            return this;
        }

        public RobotBuilder withPositionX(double positionX) {
            this.positionX = positionX;
            return this;
        }

        public RobotBuilder withPositionY(double positionY) {
            this.positionY = positionY;
            return this;
        }

        public RobotBuilder withEnergy(double energy) {
            this.energy = energy;
            return this;
        }

        public RobotBuilder withHeading(double heading) {
            this.heading = heading;
            return this;
        }

        public RobotBuilder withRadarHeading(double radarHeading) {
            this.radarHeading = radarHeading;
            return this;
        }

        public RobotBuilder withVelocity(double velocity) {
            this.velocity = velocity;
            return this;
        }

        public RobotBuilder but() {
            return aRobot()
                    .withSizeX(sizeX)
                    .withSizeY(sizeY)
                    .withPositionX(positionX)
                    .withPositionY(positionY)
                    .withEnergy(energy)
                    .withHeading(heading)
                    .withRadarHeading(radarHeading)
                    .withVelocity(velocity);
        }

        public Robot build() {
            return new Robot(sizeX, sizeY, positionX, positionY, energy, heading, radarHeading, velocity);
        }
    }
}

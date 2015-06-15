package fbao;

public class Board {

    public final int noOfOpponents;
    public final double sizeX;
    public final double sizeY;

    public Board(int noOfOpponents, double sizeX, double sizeY) {
        this.noOfOpponents = noOfOpponents;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    public static class BoardBuilder {
        public int noOfOpponents;
        public double sizeX;
        public double sizeY;

        private BoardBuilder() {
        }

        public static BoardBuilder aBoard() {
            return new BoardBuilder();
        }

        public BoardBuilder withNoOfOpponents(int noOfOpponents) {
            this.noOfOpponents = noOfOpponents;
            return this;
        }

        public BoardBuilder withSizeX(double sizeX) {
            this.sizeX = sizeX;
            return this;
        }

        public BoardBuilder withSizeY(double sizeY) {
            this.sizeY = sizeY;
            return this;
        }

        public BoardBuilder but() {
            return aBoard().withNoOfOpponents(noOfOpponents).withSizeX(sizeX).withSizeY(sizeY);
        }

        public Board build() {
            return new Board(noOfOpponents, sizeX, sizeY);
        }
    }
}

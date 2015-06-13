function onMyTurn(me, board) {
    if ((me.positionX == 0 || me.positionX == board.sizeX - 1)
        || (me.positionY == 0 || me.positionY == board.sizeY - 1)) {
        return {action: "MOVE", x: board.sizeX / 2, y: board.sizeY / 2};
    }

    var rand = new java.util.Random();
    if (rand.nextInt(25) == 0) {
        return {action: "MOVE", x: rand.nextDouble() * board.sizeX, y: rand.nextDouble() * board.sizeY};
    } else {
        return {action: "TURN_RADAR", degrees: rand.nextDouble() * 20 - 10};
    }
}

function onScannedRobot(me, opponent, board) {
    var power = board.sizeX / opponent.distance;
    if (power > 25) {
        power = 25;
    }

    if (opponent.energy <= 20 && me.energy > 50) {
        return {action: "FIRE", power: power};
    }

    if (opponent.bearing == 0) {
        var rand = new java.util.Random();
        return {action: "MOVE", x: rand.nextDouble() * board.sizeX, y: rand.nextDouble() * board.sizeY};
    }

    return {action: "FIRE", power: power};
}

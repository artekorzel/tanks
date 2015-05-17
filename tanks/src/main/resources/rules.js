function onMyTurn(me, board) {
    return {action: "MOVE", x: 0, y: 0};
}

function onScannedRobot(me, opponent) {
    return {action: "FIRE"};
}

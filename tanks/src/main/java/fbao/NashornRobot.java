package fbao;

import jdk.nashorn.api.scripting.JSObject;
import jdk.nashorn.api.scripting.NashornScriptEngine;
import robocode.ScannedRobotEvent;

import javax.script.ScriptEngineManager;
import java.io.FileReader;
import java.io.Reader;
import java.net.URI;
import java.nio.file.Paths;

public class NashornRobot extends robocode.Robot {

    private NashornScriptEngine nashorn;

    public NashornRobot() {
        try {
            ScriptEngineManager manager = new ScriptEngineManager();
            nashorn = (NashornScriptEngine) manager.getEngineByName("nashorn");
            nashorn.compile(getScript()).eval();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                Robot me = getMyRobot();
                Board board = getBoard();
                JSObject result = (JSObject) nashorn.invokeFunction("onMyTurn", me, board);
                Action action = Action.valueOf(result.getMember("action").toString());
                action.doJob(this, result, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onScannedRobot(ScannedRobotEvent event) {
        try {
            Robot me = getMyRobot();
            ScannedRobot opponent = getScannedRobot(event);
            Board board = getBoard();

            JSObject result = (JSObject) nashorn.invokeFunction("onScannedRobot", me, opponent, board);
            Action action = Action.valueOf(result.getMember("action").toString());
            action.doJob(this, result, opponent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Board getBoard() {
        return Board.BoardBuilder.aBoard()
                .withNoOfOpponents(getOthers())
                .withSizeX(getBattleFieldWidth())
                .withSizeY(getBattleFieldHeight())
                .build();
    }

    private Robot getMyRobot() {
        return Robot.RobotBuilder.aRobot()
                .withPositionX(getX())
                .withPositionY(getY())
                .withSizeX(getWidth())
                .withSizeY(getHeight())
                .withEnergy(getEnergy())
                .withHeading(getHeading())
                .withRadarHeading(getRadarHeading())
                .withVelocity(getVelocity())
                .build();
    }

    private ScannedRobot getScannedRobot(ScannedRobotEvent event) {
        return ScannedRobot.ScannedRobotBuilder.aScannedRobot()
                .withDistance(event.getDistance())
                .withBearing(event.getBearing())
                .withEnergy(event.getEnergy())
                .withHeading(event.getHeading())
                .withVelocity(event.getVelocity())
                .build();
    }

    private Reader getScript() throws Exception {
        URI uri = getClass().getClassLoader().getResource("fbao/rules.js").toURI();
        String filePath = Paths.get(uri).toFile().getAbsolutePath();
        return new FileReader(filePath);
    }
}

package fbao;

import jdk.nashorn.api.scripting.JSObject;
import jdk.nashorn.api.scripting.NashornScriptEngine;
import robocode.Robot;
import robocode.ScannedRobotEvent;

import javax.script.ScriptEngineManager;
import java.io.FileReader;
import java.io.Reader;
import java.net.URI;
import java.nio.file.Paths;

public class NashornRobot extends Robot {

    private final NashornScriptEngine nashorn;

    public NashornRobot() {
        ScriptEngineManager manager = new ScriptEngineManager();
        nashorn = (NashornScriptEngine) manager.getEngineByName("nashorn");
        try {
            nashorn.compile(getScript()).eval();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
//            while(true) {
            JSObject result = (JSObject) nashorn.invokeFunction("turn");
            System.out.println(result.getMember("action"));
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onScannedRobot(ScannedRobotEvent event) {
        try {
            JSObject result = (JSObject) nashorn.invokeFunction("onScannedRobot");
            System.out.println(result.getMember("action"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Reader getScript() throws Exception {
        URI uri = getClass().getClassLoader().getResource("rules.js").toURI();
        String filePath = Paths.get(uri).toFile().getAbsolutePath();
        return new FileReader(filePath);
    }
}

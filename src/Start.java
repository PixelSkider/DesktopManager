import client.Logger;
import main.Main;
import main.Config;

import javax.swing.*;

/**
 * @author Kalud
 * @website pixelskider.github.io/
 * @since 2024/11/22
 */
public class Start {
    public static Config config = new Config();
    private static final Boolean testBoolean = false;
    public static void main(String[] args) {
        Logger.info("Client Start");
        Logger.info("RunPath: " + Config.getPath());
        if (!config.init() || testBoolean){
            JOptionPane.showMessageDialog(null, "Config File Create Unsuccessfully", "Error",JOptionPane.ERROR_MESSAGE);
        }else {
            Main main = new Main();
        }
    }
}

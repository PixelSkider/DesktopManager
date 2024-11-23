package main;

import client.Logger;

import java.io.IOException;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

/**
 * @author Kalud
 * @website pixelskider.github.io/
 * @since 2024/11/22
 */
public class Regedit {

    public void changeIcon(boolean hide) {
        try {
            String hideIconsCommand = "reg add \"HKEY_CURRENT_USER\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies\\Explorer\" /v NoDesktop /t REG_DWORD /d "+ (hide ? "1" : "0") + " /f";
            Process process = Runtime.getRuntime().exec(hideIconsCommand);
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            Logger.error(e.getMessage());
        }
    }

    public void changeTaskBar(boolean hide) {
        try {
            String hideIconsCommand = "REG ADD \"HKEY_CURRENT_USER\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Explorer\\StuckRects3\" /v Settings /t REG_BINARY /d 30000000feffffff0" + (hide ? "3" : "2") +"000000030000009b00000064000000000000000c080000000f000070080000f000000001000000 /f";
            Process process = Runtime.getRuntime().exec(hideIconsCommand);
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            Logger.error(e.getMessage());
        }
    }

    public void refreshExplorer() {
        try {
            Process killExplorer = Runtime.getRuntime().exec("taskkill /F /IM explorer.exe");
            killExplorer.waitFor();
            Thread.sleep(2000);
            ProcessBuilder builder = new ProcessBuilder("explorer.exe");
            builder.start();
            Thread.sleep(2000);
        } catch (IOException | InterruptedException e) {
            Logger.error(e.getMessage());
        }
    }
}

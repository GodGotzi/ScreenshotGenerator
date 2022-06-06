package at.gotzi.screenshotgen;

import at.gotzi.screenshotgen.api.ConnectHttpsWeb;
import at.gotzi.screenshotgen.random.Randomizer;

import javax.swing.*;
import java.io.File;

public class ScreenshotGenerator {

    public static String path;

    public static void main(String[] args) {
        path = JOptionPane.showInputDialog(null, "Gib an wo die Images gespeichert werden sollen!");

        File file = new File(path);
        if (!file.exists())
            file.mkdirs();

        while (true) {
            Randomizer randomizer = new Randomizer();
            String screenshot = randomizer.randomize();
            new ConnectHttpsWeb(screenshot);
            try {
                Thread.sleep(100);
            } catch (InterruptedException ignored) {
            }
        }
    }

}

package at.gotzi.screenshotgen.api;

import at.gotzi.screenshotgen.ScreenshotGenerator;

import java.io.*;
import java.net.URL;

public class ImageConverter {

    private final URL url;
    private final String destination;
    private InputStream is;


    public ImageConverter(URL url, String random) {
        this.url = url;
        this.destination = ScreenshotGenerator.path  + random + ".png";
    }

    public void buildImage() throws IOException {
        this.is = url.openStream();
    }

    public void write() throws IOException {
        OutputStream os = new FileOutputStream(destination);
        byte[] b = new byte[20002];
        int length;

        while ((length = is.read(b)) != -1) {
            os.write(b, 0, length);
        }

        this.is.close();
        os.close();
    }
}

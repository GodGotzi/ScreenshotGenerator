package at.gotzi.screenshotgen.api;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;

public class ConnectHttpsWeb {

    private final String urlStr;
    private final String random;

    public ConnectHttpsWeb(String random) {
        this.urlStr = "https://prnt.sc/" + random;
        this.random = random;

        try {
            this.connect();
        } catch (IOException e) {
            System.out.println("Image Does not exit, going on....");
        }
    }

    private void connect() throws IOException {
        Document document = Jsoup
                .connect(this.urlStr)
                .userAgent("Mozilla/5.0")
                .timeout(10 * 1000)
                .get();
        Elements imageElements = document.select("img");

        if ((long) imageElements.size() != 1 && !imageElements.stream().toList().get(0).attr("abs:src").equalsIgnoreCase("https://st.prntscr.com/2021/10/22/2139/img/0_173a7b_211be8ff.png")) {
            System.out.println(imageElements.stream().toList().get(0).attr("abs:src"));
            ImageConverter imageConverter = new ImageConverter(new URL(imageElements.stream().toList().get(0).attr("abs:src")), this.random);
            imageConverter.buildImage();
            imageConverter.write();
        }
    }
}
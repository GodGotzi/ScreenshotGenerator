package at.gotzi.screenshotgen.random;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Randomizer {

    public Randomizer() {
    }

    private static final List<String> codes = new ArrayList<>();

    public String randomize() {
        String possibleCharacters = "abcdefghijklmnopqrstuvwxyz0123456789";
        String rnStr;
        do {
            Random random = new Random();
            int size = random.nextInt(3) + 5;
            rnStr = RandomString.random(size, 0, possibleCharacters.toCharArray().length - 1, false, false, possibleCharacters.toCharArray(), new SecureRandom());
        } while (codes.contains(rnStr));
        codes.add(rnStr);
        return rnStr;
    }
}
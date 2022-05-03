package lotto.util;

public class Splitter {

    public String[] split(String input) {
        return input.replace(" ", "").split("[, ]");
    }
}

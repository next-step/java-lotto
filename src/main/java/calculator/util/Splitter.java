package calculator.util;

import java.util.List;

public class Splitter {

    private Splitter() {
    }

    public static List<String> split(String value) {
        return List.of(value.split(" "));
    }
}

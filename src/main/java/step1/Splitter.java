package step1;

import java.util.Arrays;

public class Splitter {

    private final static String SEPARATE_PATTERN = "[,:]";

    public static Integer[] split(String formula) {
        return Arrays.stream(formula.split(SEPARATE_PATTERN))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
    }
}

package step1;

import java.util.Arrays;

public class Splitter {

    private final static String SEPARATE_PATTERN = "[,:]";

    public static Integer[] split(Formula formula) {
        return Arrays.stream(formula.get().split(SEPARATE_PATTERN))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
    }
}

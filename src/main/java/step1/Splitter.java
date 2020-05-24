package step1;

import java.util.Arrays;

public class Splitter {

    public static Integer[] split(String formula) {
        return Arrays.stream(formula.split("[,:]"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
    }
}

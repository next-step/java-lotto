package stringcalculator.domain;

import java.util.List;

public class Adder {

    public static final int INITIAL_RESULT = 0;

    public static int add(List<Integer> integers) {
        return integers.stream().reduce(INITIAL_RESULT, Integer::sum);
    }
}

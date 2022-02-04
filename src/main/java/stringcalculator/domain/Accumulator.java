package stringcalculator.domain;

import java.util.List;

public class Accumulator {

    public static int calculate(List<Integer> asList) {
        return asList.stream()
                .mapToInt(n -> n).sum();
    }
}

package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Number;

public class NumbersGenerator {

    private NumbersGenerator() {
    }

    public static List<Number> generateNumbers(String[] inputs) {
        return Arrays.stream(inputs)
            .map(Integer::parseInt)
            .map(Number::new)
            .collect(Collectors.toList());
    }

}

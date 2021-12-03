package step1.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * .
 */
public class Numbers {

    private final List<Number> numberList;

    public Numbers(String[] stringArr) {
        this.numberList =
                Arrays.stream(stringArr)
                        .map(Number::new)
                        .collect(Collectors.toList());
    }

    public int sum() {
        return numberList.stream()
                .mapToInt(Number::getNumber)
                .sum();
    }
}

package calculator;

import java.util.List;
import java.util.stream.Collectors;

public class Sequence {

    private final List<Integer> elements;

    public Sequence(List<String> strSequence) {
        elements = strSequence.stream()
                              .map(this::parseInt)
                              .collect(Collectors.toList());
    }

    private int parseInt(String strNumber) {
        int number = Integer.parseInt(strNumber);

        validatePositiveInteger(number);

        return number;
    }

    private void validatePositiveInteger(int number) {
        if (number < 0) {
            throw new RuntimeException("양의 정수만 사용할 수 있습니다.");
        }
    }

}

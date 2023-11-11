package me.namuhuchutong.lotto;

import java.util.Collections;
import java.util.List;

public class Numbers {

    private final List<Number> values;

    public static Numbers create(NumberGenerator numberGenerator) {
        return new Numbers(numberGenerator.createNumbers());
    }

    public Numbers(List<Number> values) {
        validateSixNumbers(values);
        validateDuplicatedNumbers(values);
        this.values = values;
    }

    private void validateSixNumbers(List<Number> values) {
        if (values.size() != 6) {
            throw new IllegalArgumentException("숫자는 6개여야 합니다.");
        }
    }

    private void validateDuplicatedNumbers(List<Number> values) {
        values.stream()
              .filter(number -> Collections.frequency(values, number) > 1)
              .findAny()
              .ifPresent(value -> {
                  throw new IllegalArgumentException("중복된 값이 존재합니다. - " + value);
              });
    }

    public int size() {
        return this.values.size();
    }
}

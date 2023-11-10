package me.namuhuchutong.lotto;

import java.util.List;

public class Numbers {

    private final List<Number> values;

    public static Numbers create(NumberGenerator numberGenerator) {
        return new Numbers(numberGenerator.createNumbers());
    }

    public Numbers(List<Number> values) {
        validateSixNumbers(values);
        this.values = values;
    }

    private void validateSixNumbers(List<Number> values) {
        if (values.size() != 6) {
            throw new IllegalArgumentException("숫자는 6개여야 합니다.");
        }
    }

    public int size() {
        return this.values.size();
    }
}

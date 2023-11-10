package me.namuhuchutong.lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Numbers {

    private final List<Number> values;

    public static Numbers create(NumberGenerator numberGenerator) {
        List<Number> collect = Stream.generate(numberGenerator::createNumber)
                                      .limit(6)
                                      .collect(Collectors.toUnmodifiableList());
        return new Numbers(collect);
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

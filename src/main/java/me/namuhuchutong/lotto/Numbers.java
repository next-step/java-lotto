package me.namuhuchutong.lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Numbers {

    private final List<Integer> values;

    public static Numbers create(NumberGenerator numberGenerator) {
        List<Integer> collect = Stream.generate(numberGenerator::createNumber)
                                      .limit(6)
                                      .collect(Collectors.toUnmodifiableList());
        return new Numbers(collect);
    }

    public Numbers(List<Integer> values) {
        validateSixNumbers(values);
        validateNumbersRange(values);
        this.values = values;
    }

    private void validateSixNumbers(List<Integer> values) {
        if (values.size() != 6) {
            throw new IllegalArgumentException("숫자는 6개여야 합니다.");
        }
    }

    private void validateNumbersRange(List<Integer> values) {
        if(isValuesNonMatch(values)) {
            throw new IllegalArgumentException("숫자는 1~45 사이만 가능합니다");
        }
    }

    private boolean isValuesNonMatch(List<Integer> values) {
        return values.stream().noneMatch(number -> number >= 1 && number <= 45);
    }

    public int size() {
        return this.values.size();
    }
}

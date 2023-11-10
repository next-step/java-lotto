package me.namuhuchutong.lotto;

import java.util.List;

public class Numbers {

    private final List<Integer> values;

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

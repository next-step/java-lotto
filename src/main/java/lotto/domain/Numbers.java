package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Numbers {
    private final List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        this.numbers = numbers;
        validateCount();
        Collections.sort(this.numbers);
    }

    private void validateCount() {
        if (numbers.size() != LottoRule.CHOICE_COUNT) {
            throw new IllegalArgumentException("입력된 숫자 개수가 올바르지 않습니다.");
        }
    }

    public Integer find(int index) {
        return numbers.get(index);
    }

    public boolean contains(Integer number) {
        return numbers.contains(number);
    }

    public List<Integer> getValues() {
        return numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Numbers numbers1 = (Numbers) o;
        return Objects.equals(numbers, numbers1.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}

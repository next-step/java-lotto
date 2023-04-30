package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Numbers {
    private final String REGEX = "\\d+";
    private final List<Integer> numbers;

    public Numbers(String inputString) {
        this(new ArrayList<>());
        String[] strNumbers = inputString.split(LottoRule.SPLIT_DELIMITER);
        for (String strNumber : strNumbers) {
            validateNumber(strNumber);
            numbers.add(Integer.valueOf(strNumber));
        }
        validateCount();
        Collections.sort(numbers);
    }

    public Numbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Numbers auto() {
        List<Integer> autoNumbers = new ArrayList<>(LottoRule.NUMBER_RANGE);
        Collections.shuffle(autoNumbers);
        autoNumbers = autoNumbers.subList(0, LottoRule.CHOICE_COUNT);
        Collections.sort(autoNumbers);
        return new Numbers(autoNumbers);
    }

    private void validateCount() {
        if (numbers.size() != LottoRule.CHOICE_COUNT) {
            throw new IllegalArgumentException("입력된 숫자 개수가 올바르지 않습니다.");
        }
    }

    private void validateNumber(String strNumber) {
        if (!strNumber.matches(REGEX)) {
            throw new IllegalArgumentException("숫자로만 구성되어 있지 않은 값이 있습니다.");
        }
        if (!LottoRule.NUMBER_RANGE.contains(Integer.valueOf(strNumber))) {
            throw new IllegalArgumentException("입력된 숫자 범위가 올바르지 않습니다.");
        }
    }

    public Integer find(int index) {
        return numbers.get(index);
    }

    @Override
    public String toString() {
        return numbers.toString();
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

    public boolean contains(Integer number) {
        return numbers.contains(number);
    }

    public int count() {
        return numbers.size();
    }
}

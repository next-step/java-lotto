package lotto.domain;

import java.util.Set;
import java.util.TreeSet;

public class Lotto {
    private final String LOTTO_LIMIT_NUMBER_TEXT = "로또 숫자는 1 ~ 45 사이입니다.";
    private final String LOTTO_LIMIT_NUMBER_COUNT_TEXT = "6개의 로또 숫자를 입력 하십시오.";
    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 45;
    private final int LIMIT_NUMBER_COUNT = 6;
    private final Set<Integer> numbers;

    public Lotto(Set<Integer> numbers) {
        this.numbers = sortNumbers(numbers);
        validateCheck(this.numbers);
    }

    private Set<Integer> sortNumbers(Set<Integer> numbers) {
        return new TreeSet<>(numbers);
    }

    private void validateCheck(Set<Integer> numbers) {
        if (numbers.size() != LIMIT_NUMBER_COUNT) {
            throw new IllegalArgumentException(LOTTO_LIMIT_NUMBER_COUNT_TEXT);
        }

        numbers.stream().filter(number -> number.intValue() >= MIN_NUMBER && number.intValue() <= MAX_NUMBER)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(LOTTO_LIMIT_NUMBER_TEXT));
    }

    public Set<Integer> getNumbers() {
        return this.numbers;
    }
}

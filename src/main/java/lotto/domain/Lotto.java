package lotto.domain;

import java.util.*;

public class Lotto {
    public static final int LOWER_BOUND = 1;
    public static final int UPPER_BOUND = 45;
    private static final int LOTTO_NUMBER_SIZE = 6;
    private final List<Integer> lotto;

    public Lotto(List<Integer> numbers) {
        this.validateNumbers(numbers);

        this.lotto = numbers;
    }

    public List<Integer> getLotto() {
        return lotto;
    }

    private void validateNumbers(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 번호의 길이는 여섯 자리입니다.");
        }

        boolean isInRange = numbers.stream().allMatch(number -> number >= LOWER_BOUND && number <= UPPER_BOUND);

        if (!isInRange) {
            throw new IllegalArgumentException("로또 번호의 범위는 1부터 45까지 입니다.");
        }
    }

}

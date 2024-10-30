package lotto.domain;

import java.util.Set;

public class Lotto {
    private static final int REQUIRED_NUMBERS = 6;
    private final Set<Integer> numbers;

    public Lotto(Set<Integer> numbers) {
        if (numbers.size() != REQUIRED_NUMBERS) {
            throw new IllegalArgumentException("로또 발행에 문제가 생겼습니다.");
        }

        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}

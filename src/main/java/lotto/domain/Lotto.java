package lotto.domain;

import java.util.List;

public class Lotto {
    public static final int MIN = 1;
    public static final int MAX = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        numbers.forEach(this::checkNumberRange);
        this.numbers = numbers;
    }

    private void checkNumberRange(int number) {
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException("로또 숫자는 " + MIN + "과 " + MAX + " 사이의 값이어야 합니다");
        }
    }

    public int matches(Lotto winNumbers) {
        return (int) numbers.stream()
                .filter(winNumbers.numbers::contains)
                .count();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}

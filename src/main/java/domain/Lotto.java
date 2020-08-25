package domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_NUMBER = 6;

    private final Set<Number> numbers;

    public Lotto(Set<Number> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto auto() {
        Set<Number> numbers = new TreeSet<>();
        while(numbers.size() != 6) {
            numbers.add(Number.generateNumber());
        }
        return new Lotto(numbers);
    }

    private void validate(Set<Number> numbers) {
        if (numbers.size() != LOTTO_NUMBER) {
            throw new IllegalArgumentException("당첨 번호는 6개의 다른 값 이여야 합니다.");
        }
    }

    public Set<Number> getContainNumbers(Lotto lottoWinningNumbers) {
        return lottoWinningNumbers.numbers.stream()
                .filter(this.numbers::contains)
                .collect(Collectors.toSet());
    }

    public boolean isContainBonus(Number bonusNumber) {
        return this.numbers.contains(bonusNumber);
    }

    @Override public String toString() {
        return numbers.toString();
    }
}

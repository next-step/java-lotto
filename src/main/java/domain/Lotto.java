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

    private void validate(Set<Number> numbers) {
        if (numbers.size() != LOTTO_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 6개의 다른 값 이여야 합니다.");
        }
    }

    public static Lotto auto() {
        Set<Number> numbers = new TreeSet<>();
        while(numbers.size() != 6) {
            numbers.add(Number.generateNumber());
        }
        return new Lotto(numbers);
    }

    @Override public String toString() {
        return numbers.toString();
    }

    public boolean isContainBonus(WinningLotto winningLotto) {
        return numbers.stream()
                .anyMatch(winningLotto::isMatchBonusNumber);
    }

    public Set<Number> getWinningNumbers(WinningLotto lotto) {
        return numbers.stream()
                .filter(lotto::isContainInWinningNumber)
                .collect(Collectors.toSet());
    }
}

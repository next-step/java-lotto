package lotto.domain;

import java.util.*;

public class LottoNumbers {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int SIZE = 6;

    private final Set<Integer> numbers;

    private LottoNumbers(Set<Integer> numbers) {
        this.numbers = numbers;
    }

    public static LottoNumbers of(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);

        validateSize(numberSet);
        validateRange(numberSet);

        return new LottoNumbers(numberSet);
    }

    public static LottoNumbers of(Integer ... numbers) {
        return of(Arrays.asList(numbers));
    }

    private static void validateSize(Set<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException("중복되는 숫자가 존재하거나 6개의 숫자로 이루어져있지 않습니다.");
        }
    }

    private static void validateRange(Set<Integer> numbers) {
        numbers.stream()
                .filter(n -> n < MIN_NUMBER || n > MAX_NUMBER)
                .findAny()
                .ifPresent(n -> {
                    throw new IllegalArgumentException("1 ~ 45 범위를 벗어나는 숫자를 포함하고 있습니다.");
                });
    }

    public Prize matchNumbers(LottoNumbers winningNumbers) {
        long matchCount = winningNumbers.numbers
                .stream()
                .filter(this::containsWinningNumber)
                .count();
        return Prize.valueOfMatchCount(matchCount);
    }

    private boolean containsWinningNumber(int number) {
        return this.numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}

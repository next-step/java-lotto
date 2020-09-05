package lotto;

import java.util.*;

public class LottoNumbers {

    public static final int MIN_RANGE = 1;
    public static final int MAX_RANGE = 45;
    public static final int SIZE = 6;

    private List<Integer> numbers;

    public LottoNumbers(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicated(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    public static LottoNumbers of(Integer ... numbers) {
        return new LottoNumbers(Arrays.asList(numbers));
    }

    private void validateSize(List<Integer> numbers) {
        checkSize(numbers, "6개의 숫자로 이루어져있지 않습니다.");
    }

    private void validateDuplicated(List<Integer> numbers) {
        checkSize(new HashSet<>(numbers), "숫자는 중복되지 않아야 합니다.");
    }

    private void checkSize(Collection<Integer> numbers, String errorMessage) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private void validateRange(List<Integer> numbers) {
        numbers.stream()
                .filter(n -> n < MIN_RANGE || n > MAX_RANGE)
                .findAny()
                .ifPresent(n -> {
                    throw new IllegalArgumentException("1 ~ 45 범위를 벗어나는 숫자를 포함하고 있습니다.");
                });
    }

    public long matchNumbers(LottoNumbers winningNumbers) {
        return winningNumbers.numbers
                .stream()
                .filter(this::containsWinningNumber)
                .count();
    }

    private boolean containsWinningNumber(int number) {
        return this.numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}

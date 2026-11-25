package lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int NUMBERS_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = List.copyOf(numbers);
    }

    private static void validateNumbers(List<Integer> numbers) {
        validateNumbersCount(numbers);
        validateNoDuplicates(numbers);
        for (Integer number : numbers) {
            validateNumberRange(number);
        }
    }

    private static void validateNoDuplicates(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new RuntimeException("중복된 수를 가질 수 없습니다.");
        }
    }

    private static void validateNumbersCount(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_SIZE) {
            throw new RuntimeException("6개의 숫자만 생성 가능합니다.");
        }
    }

    private static void validateNumberRange(Integer number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new RuntimeException("1~45 사이 숫자만 가능합니다.");
        }
    }

    public int matchCount(Lotto other) {
        return (int) numbers.stream()
                .filter(other.numbers::contains)
                .count();
    }
}

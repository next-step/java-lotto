package lotto.model;

import java.util.*;

public class LottoTicket {

    private static final int MAX = 45;
    private static final int MIN = 1;
    private static final int SIZE = 6;
    private static final String RANGE_ERROR_MSG = "번호는 1~45사이의 자연수입니다.";
    private static final String SIZE_ERROR_MSG = "6개의 번호가 필요합니다.";
    private static final String DUPLICATE_ERROR_MSG = "번호는 중복되면 안됩니다.";

    private final List<Integer> numbers;

    public LottoTicket(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateNumbers(List<Integer> numbers) {
        checkSize(numbers);
        checkDuplication(numbers);
        for (int num : numbers) {
            checkRange(num);
        }
    }

    private void checkSize(List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException(SIZE_ERROR_MSG);
        }
    }

    private void checkDuplication(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != SIZE) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MSG);
        }
    }

    private void checkRange(int num) {
        if (num > MAX || num < MIN) {
            throw new IllegalArgumentException(RANGE_ERROR_MSG);
        }
    }


    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public int compareTicket(LottoTicket ticket) {
        return Math.toIntExact(numbers.stream()
                .filter(ticket::contains)
                .count());
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int num : numbers) {
            result.append(num).append(", ");
        }
        result.setLength(result.length() - 2);
        result.append("]");
        return result.toString();
    }
}

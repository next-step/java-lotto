package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {
    public static final int PRICE = 1000;
    public static final int DIGIT = 6;

    private final List<Integer> numbers;

    public LottoTicket(List<Integer> numbers) {
        validate(numbers);

        this.numbers = new ArrayList<>(numbers);
        this.numbers.sort(Integer::compareTo);
    }

    private static void validate(List<Integer> numbers) {
        if (numbers.size() != DIGIT) {
            throw new IllegalArgumentException("로또는 " + DIGIT + "자리여야 합니다.");
        }
    }

    public long countMatches(List<Integer> winningNumbers) {
        return numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}

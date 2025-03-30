package lotto;

import java.util.List;

public class LottoTicket {
    public static final int PRICE = 1000;
    public static final int DIGIT = 6;

    private final LottoNumber numbers;

    public LottoTicket(List<Integer> numbers) {
        validate(numbers);

        this.numbers = new LottoNumber(numbers);
    }

    private static void validate(List<Integer> numbers) {
        if (numbers.size() != DIGIT) {
            throw new IllegalArgumentException("로또는 " + DIGIT + "자리여야 합니다.");
        }
    }

    public long countMatches(List<Integer> winningNumbers) {
        return numbers.countMatches(winningNumbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}

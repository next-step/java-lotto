package lotto;

import java.util.List;

public class LottoTicket {

    public static final int MAX_LOTTO_NUM = 45;
    private static final int LOTTO_NUM_COUNT = 6;
    private static final int MIN_LOTTO_NUM = 1;
    private final List<Integer> numbers;

    public LottoTicket(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateNumbers(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUM_COUNT) {
            throw new IllegalArgumentException("로또 티켓은 6개의 숫자로 이루어져 있어야 합니다.");
        }

        if (numbers.stream().anyMatch(number -> number < MIN_LOTTO_NUM || number > MAX_LOTTO_NUM)) {
            throw new IllegalArgumentException("로또 티켓은 1부터 45 사이의 숫자로 이루어져 있어야 합니다.");
        }

        if (numbers.stream().distinct().count() != LOTTO_NUM_COUNT) {
            throw new IllegalArgumentException("로또 티켓은 중복된 숫자를 포함할 수 없습니다.");
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}

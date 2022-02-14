package lotto.domain.lotto;

import java.util.Collections;
import java.util.List;
import lotto.domain.generator.LottoGenerator;

public class Ticket {

    private static final String NUMBERS_NOT_IN_RANGE = "[ERROR] 숫자의 범위가 올바르지 않습니다.";
    private static final String DUPLICATES_NOT_AVAILABLE = "중복이 존재할 수 없습니다.";

    private final List<Number> numbers;

    public Ticket(final List<Number> numbers) {
        validateNumbers(numbers);
        validateDuplicatedNumbers(numbers);

        this.numbers = numbers;
    }

    public int size() {
        return numbers.size();
    }

    public List<Number> get() {
        return Collections.unmodifiableList(numbers);
    }

    public int matches(final Ticket comparison) {
        return (int) comparison.numbers.stream()
            .filter(numbers::contains)
            .count();
    }

    public boolean hasBonus(final Number bonus) {
        return numbers.contains(bonus);
    }

    private void validateNumbers(final List<Number> numbers) {
        if (numbers.size() != LottoGenerator.LOTTO_NUMBERS) {
            throw new IllegalArgumentException(NUMBERS_NOT_IN_RANGE);
        }
    }

    private void validateDuplicatedNumbers(final List<Number> numbers) {
        if (distinctNumbersCount(numbers) != LottoGenerator.LOTTO_NUMBERS) {
            throw new IllegalArgumentException(DUPLICATES_NOT_AVAILABLE);
        }
    }

    private int distinctNumbersCount(final List<Number> numbers) {
        return (int) numbers.stream().map(Number::value).distinct().count();
    }
}

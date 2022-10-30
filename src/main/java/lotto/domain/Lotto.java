package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private static final String DELIMITER_COMMA = ", ";

    private final LottoNumbers numbers;

    public Lotto(LottoNumbers numbers) {
        this.numbers = numbers;
    }

    public Lotto(List<Integer> numbers) {
        this(new LottoNumbers(numbers));
    }

    public static Lotto createFrom(NumberGenerator numberGenerator) {
        return new Lotto(numberGenerator.generate());
    }

    public List<Integer> getNumbers() {
        return this.numbers.getNumbers();
    }

    public long countSameNumbers(WinningNumbers winningNumbers) {
        return winningNumbers.getNumbers()
            .stream()
            .filter(this.numbers::contains)
            .count();
    }

    @Override
    public String toString() {
        return getNumbers().stream()
            .map(String::valueOf)
            .collect(Collectors.joining(DELIMITER_COMMA));
    }
}

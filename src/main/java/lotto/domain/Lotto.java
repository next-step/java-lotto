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
        this(LottoNumbers.of(numbers));
    }

    public static Lotto createFrom(NumberGenerator numberGenerator) {
        return new Lotto(numberGenerator.generate());
    }

    public List<LottoNumber> getNumbers() {
        return this.numbers.getNumbers();
    }

    public long countSameNumbers(WinningNumbers winningNumbers) {
        return winningNumbers.getNumbers()
            .stream()
            .filter(this.numbers::contains)
            .count();
    }

    public boolean containsBonusNumber(LottoNumber bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    @Override
    public String toString() {
        return getNumbers().stream()
            .map(LottoNumber::toString)
            .collect(Collectors.joining(DELIMITER_COMMA));
    }
}

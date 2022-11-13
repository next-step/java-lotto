package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private static final String DELIMITER_COMMA = ", ";

    private final LottoNumbers numbers;
    private boolean isManual = false;

    public Lotto(LottoNumbers numbers) {
        this.numbers = numbers;
    }

    public Lotto(List<Integer> numbers) {
        this(LottoNumbers.of(numbers));
    }

    public Lotto(LottoNumbers numbers, boolean isManual) {
        this(numbers);
        this.isManual = isManual;
    }

    public static Lotto createFrom(NumberGenerator numberGenerator) {
        return new Lotto(numberGenerator.generate());
    }

    public static Lotto createManual(LottoNumbers numbers) {
        return new Lotto(numbers, true);
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

    public boolean isManual() {
        return isManual;
    }
}

package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private final LottoNumbers numbers;

    public Lotto(LottoNumbers numbers) {
        this.numbers = numbers;
    }

    public Lotto(List<Integer> numbers) {
        this(new LottoNumbers(numbers));
    }

    public List<Integer> getNumbers() {
        return numbers.getNumbers();
    }

    public static Lotto createFrom(NumberGenerator numberGenerator) {
        return new Lotto(numberGenerator.generate());
    }

    public long countSameNumbers(WinningNumbers winningNumbers) {
        return winningNumbers.getNumbers()
                .stream()
                .filter(this.numbers::contains)
                .count();
    }
}

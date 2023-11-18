package lotto.model;

import java.util.HashSet;
import java.util.Set;

public class Lotto {

    private final LottoNumbers numbers;

    public Lotto(LottoNumbers numbers) {
        this.numbers = numbers;
    }

    public Lotto(Set<Integer> numbers) {
        Set<PositiveNumber> positiveNumbers = new HashSet<>();
        for (int number : numbers) {
            positiveNumbers.add(new PositiveNumber(number));
        }
        this.numbers = new LottoNumbers(positiveNumbers);
    }

    public Set<PositiveNumber> numbers() {
        return this.numbers.lottoNumbers();
    }

    public boolean isMatch(WinnerNumbers winnerNumbers, int correctCount) {
        return numbers.matchCount(winnerNumbers) == correctCount;
    }

}

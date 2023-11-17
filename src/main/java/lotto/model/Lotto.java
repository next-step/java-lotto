package lotto.model;

import java.util.List;
import java.util.Set;

public class Lotto {

    private final LottoNumbers numbers;

    public Lotto(LottoNumbers numbers) {
        this.numbers = numbers;
    }

    public Lotto(Set<Integer> numbers) {
        this.numbers = new LottoNumbers(numbers);
    }

    public Set<Integer> numbers() {
        return this.numbers.lottoNumbers();
    }

    public int match(WinnerNumbers winnerNumbers, int correctCount) {
        int result = (int) numbers.lottoNumbers().stream()
                .filter(winnerNumbers::has)
                .count();
        if (result == correctCount) {
            return 1;
        }
        return 0;
    }

}

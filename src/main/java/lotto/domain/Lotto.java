package lotto.domain;

import java.util.List;
import java.util.function.Predicate;

public class Lotto {

    private final LottoNumber lottoNumber;
    private Match match;

    public Lotto(List<Integer> numbers) {
        lottoNumber = new LottoNumber(numbers);
    }

    public Lotto() {
        lottoNumber = new LottoNumber();
    }

    public List<Integer> getNumbers() {
        return lottoNumber.getNumbers();
    }

    public void matchCount(Lotto winningNumbers) {
        int count = (int) lottoNumber.getNumbers().stream()
                .filter(n -> winningNumbers.getNumbers().stream()
                        .anyMatch(Predicate.isEqual(n))).count();
        this.match = Match.valueOf(count);
    }

    public Match getMatch() {
        return match;
    }
}

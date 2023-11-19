package lotto.domain;

import java.util.List;
import java.util.function.Predicate;

public class Lotto {

    private final LottoNumber lottoNumber;
    private Rank rank;

    public Lotto(List<Integer> numbers) {
        lottoNumber = new LottoNumber(numbers);
    }

    public Lotto() {
        lottoNumber = new LottoNumber();
    }

    public List<Integer> getNumbers() {
        return lottoNumber.getNumbers();
    }

    public void matchCount(Lotto winningNumbers, int bonusNumber) {
        int count = (int) lottoNumber.getNumbers().stream()
                .filter(n -> winningNumbers.getNumbers().stream()
                        .anyMatch(Predicate.isEqual(n))).count();
        boolean bonusMatch = lottoNumber.getNumbers().stream()
                .anyMatch(Predicate.isEqual(bonusNumber));
        this.rank = Rank.valueOf(count, bonusMatch);
    }

    public Rank getRank() {
        return rank;
    }
}

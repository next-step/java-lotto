package lotto.entity;

import java.util.List;
import java.util.Set;

public class Lotto {
    private final LottoNumbers lottoNumbers;

    public Lotto(List<Integer> numbers) {
        this.lottoNumbers = new LottoNumbers(numbers);
    }

    public Set<Integer> getLottoNumbers() {
        return this.lottoNumbers.getNumbers();
    }

    public int matchCount(Set<Integer> winningNumbers) {
        return lottoNumbers.matchCount(winningNumbers);
    }

}

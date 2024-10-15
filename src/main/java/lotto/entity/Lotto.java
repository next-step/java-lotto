package lotto.entity;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final LottoNumbers lottoNumbers;

    public Lotto(List<Integer> numbers) {
        Collections.sort(numbers);
        this.lottoNumbers = new LottoNumbers(numbers);
    }

    public List<Integer> getLottoNumbers() {
        return this.lottoNumbers.getNumbers();
    }

    public int matchCount(List<Integer> winningNumbers) {
        return lottoNumbers.matchCount(winningNumbers);
    }

}

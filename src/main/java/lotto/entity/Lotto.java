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
        Collections.sort(winningNumbers);

        int count = 0;
        for (Integer winningNumber : winningNumbers) {
            count = this.lottoNumbers.collectResult(count, winningNumber);
        }
        return count;
    }

    @Override
    public String toString() {
        return this.lottoNumbers.toString();

    }
}

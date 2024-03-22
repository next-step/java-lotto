package lotto.domain;

import java.util.List;

public class LottoNumbers {

    private final List<Integer> lottoNumbers;

    public LottoNumbers(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public int countMatchingWith(List<Integer> winningNumbers) {
        return Math.toIntExact(this.lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count());
    }

    public List<Integer> getLottoNumbers() {
        return this.lottoNumbers;
    }

}

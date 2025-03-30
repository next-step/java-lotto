package lotto;

import java.util.List;

public class Lotto {

    private final List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public LottoMatch getLottoMatch(List<Integer> winningNumbers) {
        return LottoMatch.fromMatchCount((int) this.lottoNumbers.stream().filter(winningNumbers::contains).count());
    }

}

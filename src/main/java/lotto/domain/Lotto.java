package lotto.domain;

import java.util.List;

public class Lotto {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private LottoNumbers lottoNumbers;

    public Lotto() {
        this.lottoNumbers = new LottoNumbers(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER);
    }

    public List<Integer> getLottoNumbers() {
        return this.lottoNumbers.getLottoNumbers();
    }

    public int getMatchCount(List<Integer> lastWeekLottoNumbers) {
        return this.lottoNumbers.matchCount(lastWeekLottoNumbers);
    }
}

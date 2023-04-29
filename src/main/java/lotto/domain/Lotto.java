package lotto.domain;

import java.util.List;

public class Lotto {

    private LottoNumbers lottoNumbers;

    public Lotto(List<Integer> list) {
        this.lottoNumbers = new LottoNumbers(list);
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers.getLottoNumbers();
    }

    public int countMatch(List<Integer> winningNumbers) {
        int matchCount = 0;

        for (Integer number : lottoNumbers.getLottoNumbers()) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

}

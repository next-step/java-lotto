package lotto.domain;

import java.util.List;

public class LottoResultChecker {
    private final List<Integer> winningNumbers;

    public LottoResultChecker(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public Rank checkLottoResult(Lotto lotto) {
        int matchCount = 0;

        List<Integer> lottoNumbers = lotto.getNumbers();
        for (Integer lottoNumber : lottoNumbers) {
            if (winningNumbers.contains(lottoNumber)) {
                matchCount++;
            }
        }

        return Rank.getRankByMatchCount(matchCount);
    }
}

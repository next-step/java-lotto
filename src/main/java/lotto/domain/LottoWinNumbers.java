package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoWinNumbers {

    private List<Integer> winningLottoNumbers;

    public LottoWinNumbers(List<Integer> winningLottoNumbers) {
        this.winningLottoNumbers = new ArrayList<>(winningLottoNumbers);
    }

    public LottoRank matchCount(List<Integer> lottoNumbers, BonusBall bonusBall) {
        long matchCount = lottoNumbers.stream()
                .filter(winningLottoNumbers::contains)
                .count();

        return LottoRank.of(matchCount, bonusBall.containsBonusBall(lottoNumbers));
    }
}

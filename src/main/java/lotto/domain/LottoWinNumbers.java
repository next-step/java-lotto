package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoWinNumbers {

    private final List<LottoNumber> winningLottoNumbers;

    public LottoWinNumbers(List<LottoNumber> winningLottoNumbers) {
        this.winningLottoNumbers = new ArrayList<>(winningLottoNumbers);
    }

    public LottoRank matchCount(List<LottoNumber> lottoNumbers, BonusBall bonusBall) {
        long matchCount = lottoNumbers.stream()
                .filter(winningLottoNumbers::contains)
                .count();

        return LottoRank.of(matchCount, bonusBall.containsBonusBall(lottoNumbers));
    }

}

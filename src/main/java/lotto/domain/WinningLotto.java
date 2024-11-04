package lotto.domain;

import lotto.LottoRank;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {
    private final LottoNumbers winningLottoNumbers;
    private final LottoNumber bonusNumber;

    public WinningLotto(LottoNumbers lottoNumbers, LottoNumber lottoNumber) {
        this.winningLottoNumbers = lottoNumbers;
        this.bonusNumber = lottoNumber;
    }


    public LottoRank lottoRank(LottoNumbers lottoNumbers) {
        int matchingCount = winningLottoNumbers.getMatchingCount(lottoNumbers);
        boolean ismatchingBonus = lottoNumbers.bonusMatchingCount(bonusNumber);
        return LottoRank.rank(matchingCount, ismatchingBonus);
    }

}

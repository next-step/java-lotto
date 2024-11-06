package lotto.domain;

import lotto.LottoRank;

public class WinningLotto {
    private final LottoNumbers winningLottoNumbers;
    private final LottoNumber bonusNumber;

    public WinningLotto(LottoNumbers lottoNumbers, LottoNumber lottoNumber) {
        this.winningLottoNumbers = lottoNumbers;
        this.bonusNumber = lottoNumber;

    }

    public void checkBonusInWinningLotto(LottoNumbers lottoNumbers) {
        if (lottoNumbers.checkMatching(bonusNumber)) {
           throw new IllegalArgumentException("보너스볼은 당첨번호와 중복될 수 없습니다.");
        }
    }


    public LottoRank lottoRank(LottoNumbers lottoNumbers) {
        checkBonusInWinningLotto(lottoNumbers);
        int matchingCount = winningLottoNumbers.getMatchingCount(lottoNumbers);
        boolean ismatchingBonus = winningLottoNumbers.checkMatching(bonusNumber);
        return LottoRank.rank(matchingCount, ismatchingBonus);
    }

}

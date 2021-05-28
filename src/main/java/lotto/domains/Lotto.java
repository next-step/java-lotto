package lotto.domains;

import lotto.enums.MatchingInfo;

public class Lotto {

    private final LottoNumbers lottoNumbers;
    private MatchingInfo matchingInfo;

    public Lotto() {
        lottoNumbers = new LottoNumbers();
    }

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public void matching(LottoNumbers winningNumbers, int bonusNumber) {
        int matchingNumber = this.lottoNumbers.matchingNumberCount(winningNumbers);
        boolean hasBonusNumber = this.lottoNumbers.contains(bonusNumber);
        this.matchingInfo = MatchingInfo.matchingInfo(matchingNumber, hasBonusNumber);
    }

    public LottoNumbers lottoNumbers() {
        return lottoNumbers;
    }

    public MatchingInfo matchingInfo() {
        return this.matchingInfo;
    }
}

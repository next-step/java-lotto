package lotto.domains;

import lotto.enums.MatchingInfo;
import lotto.enums.PurchasingWay;

public class Lotto {

    private final LottoNumbers lottoNumbers;
    private final PurchasingWay purchasingWay;
    private MatchingInfo matchingInfo;

    public Lotto() {
        this.lottoNumbers = new LottoNumbers();
        this.purchasingWay = PurchasingWay.AUTOMATIC;

    }

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
        this.purchasingWay = PurchasingWay.MANUAL;
    }

    public Lotto(String stringLottoNumber) {
        this(new LottoNumbers(stringLottoNumber));
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

    public PurchasingWay purchasingWay() {
        return this.purchasingWay;
    }
}

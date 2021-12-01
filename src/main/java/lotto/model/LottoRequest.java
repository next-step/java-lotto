package lotto.model;

import lotto.LottoNumbers;

import java.util.Set;

public class LottoRequest {
    private final int purchasedAutoCount;
    private final Set<LottoNumbers> purchasedManualLottoNumbers;

    public LottoRequest(int purchasedAutoCount, Set<LottoNumbers> purchasedManualLottoNumbers) {
        this.purchasedAutoCount = purchasedAutoCount;
        this.purchasedManualLottoNumbers = purchasedManualLottoNumbers;
    }

    public int getPurchasedAutoCount() {
        return purchasedAutoCount;
    }

    public Set<LottoNumbers> getPurchasedManualLottoNumbers() {
        return purchasedManualLottoNumbers;
    }
}

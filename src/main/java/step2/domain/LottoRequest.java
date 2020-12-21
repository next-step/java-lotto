package step2.domain;

import step2.domain.lotto.LottoNumbers;

import java.util.List;

import static java.util.Collections.*;
import static step2.domain.lotto.Lotto.*;

public class LottoRequest {
    private final int purchaseMoney;
    private final int totalQuantityForAutomatedPick;
    private List<LottoNumbers> lottoNumbersByManualPick;

    public LottoRequest(int purchaseMoney, List<LottoNumbers> lottoNumbersByManualPick) {
        int totalPriceOfManualPick = lottoNumbersByManualPick.size() * LOTTO_PRICE;
        if (purchaseMoney < totalPriceOfManualPick) {
            throw new IllegalArgumentException("지불 금액을 초과하여 로또를 구매할 수 없습니다");
        }
        this.purchaseMoney = purchaseMoney;
        this.totalQuantityForAutomatedPick = (purchaseMoney - totalPriceOfManualPick) / LOTTO_PRICE;
        this.lottoNumbersByManualPick = unmodifiableList(lottoNumbersByManualPick);
    }

    public int getPurchaseMoney() {
        return purchaseMoney;
    }

    public int getTotalQuantityForAutomatedPick() {
        return totalQuantityForAutomatedPick;
    }

    public List<LottoNumbers> getLottoNumbersByManualPick() {
        return lottoNumbersByManualPick;
    }
}

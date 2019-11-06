package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoAmount;
import lotto.domain.PurchasedLotto;

import java.util.Collections;
import java.util.List;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-02 22:27
 */
public class LottoOrder {

    private final LottoAmount lottoAmount;
    private final PurchasedLotto purchasedLotto;

    public LottoOrder(int amount) {
        this.lottoAmount = new LottoAmount(amount);
        this.purchasedLotto = new PurchasedLotto(lottoAmount.getPurchasedLottoCount());
    }

    public List<Lotto> getLotto() {
        return Collections.unmodifiableList(purchasedLotto.getPurchasedLotto());
    }

    public int getLottoAmount() {
        return this.lottoAmount.getPurchasedLottoCount();
    }
}

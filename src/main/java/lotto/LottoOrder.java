package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoAmount;
import lotto.domain.LottoNumberStrategy;
import lotto.domain.PurchasedLotto;

import java.util.*;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-02 22:27
 */
public class LottoOrder {

    private static final LottoNumberStrategy LOTTO_NUMBER_STRATEGY = new LottoNumberStrategy();
    private final LottoAmount lottoAmount;
    private final PurchasedLotto purchasedLotto;

    public LottoOrder(int amount) {
        this.lottoAmount = new LottoAmount(amount);
        this.purchasedLotto = new PurchasedLotto(purchaseLotto());
    }

    public List<Lotto> getLotto() {
        return Collections.unmodifiableList(purchasedLotto.getPurchasedLotto());
    }

    public List<List<Integer>> getLottoNumbers() {
        return purchasedLotto.getLottoNumbers();
    }

    private List<Lotto> purchaseLotto() {
        List<Lotto> lotto = new ArrayList<>();
        for (int i = 0; i < lottoAmount.getPurchasedLottoCount(); i++) {
            lotto.add(new Lotto(LOTTO_NUMBER_STRATEGY.randomNumbers()));
        }
        return lotto;
    }
}

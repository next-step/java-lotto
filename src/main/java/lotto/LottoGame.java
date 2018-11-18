package lotto;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.math.BigDecimal;
import java.util.List;

public class LottoGame {

    private final static int DEFAULT_PRICE = 1000;
    private final static Lottos MANUAL_PURCHASE_LOTTOS_EMPTY = new Lottos();

    private final int amount;
    private final int price;
    private final Lottos lottos;

    public LottoGame(final int amount) {
        this(amount, DEFAULT_PRICE, MANUAL_PURCHASE_LOTTOS_EMPTY);
    }

    public LottoGame(final int amount, final Lottos manualPurchaseLottos) {
        this(amount, DEFAULT_PRICE, manualPurchaseLottos);
    }

    public LottoGame(final int amount, final int price, final Lottos manualPurchaseLottos) throws IllegalArgumentException {

        this.amount = amount;
        this.price = price;
        this.lottos = manualPurchaseLottos;

        if (this.price == 0) {
            throw new IllegalArgumentException();
        }

        createLottos();
    }

    public List<Lotto> getLottos() {
        return lottos.getLottos();
    }

    public int getCountPurchased() {
        return new BigDecimal(this.amount / this.price).intValue();
    }

    private void createLottos() {
        for (int i = 0; i < getCountPurchased(); i++) {
            this.lottos.add(new Lotto());
        }
    }

}

package lotto;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.math.BigDecimal;
import java.util.List;

public class LottoGame {

    private final static int DEFAULT_PRICE = 1000;

    private final int amount;
    private final int price;
    private final Lottos lottos = new Lottos();

    public LottoGame(final int amount) {
        this(amount, DEFAULT_PRICE);
    }

    public LottoGame(final int amount, final int price) throws IllegalArgumentException {

        this.amount = amount;
        this.price = price;

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

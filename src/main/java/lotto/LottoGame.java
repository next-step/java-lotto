package lotto;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.utils.GenerateLotto;

import java.math.BigDecimal;
import java.util.List;

public class LottoGame {

    private final static int DEFAULT_PRICE = 1000;

    private int amount;
    private int price;
    private final Lottos lottos = new Lottos();

    public LottoGame(final int amount, final GenerateLotto generateLotto) {

        this.amount = amount;
        this.price = DEFAULT_PRICE;

        initialize(generateLotto);
    }

    public LottoGame(final int amount, final int price, final GenerateLotto generateLotto) throws IllegalArgumentException {

        this.amount = amount;
        this.price = price;

        if (this.price == 0) {
            throw new IllegalArgumentException();
        }

        initialize(generateLotto);
    }

    public int getCountAvailableForPurchase() {
        return calculateCountAvailableForPurchase();
    }

    public List<Lotto> getLottos() {
        return lottos.getLottos();
    }

    private int calculateCountAvailableForPurchase() {
        return new BigDecimal(this.amount / this.price).intValue();
    }

    private void initialize(final GenerateLotto generateLotto) {
        addLottos(generateLotto);
        createLottos();
    }

    private void createLottos() {
        for (int i = 0; i < calculateCountAvailableForPurchase(); i++) {
            this.lottos.getLottos().forEach(Lotto::createLotto);
        }
    }

    private void addLottos(final GenerateLotto generateLotto) {
        for (int i = 0; i < calculateCountAvailableForPurchase(); i++) {
            this.lottos.add(new Lotto(generateLotto));
        }
    }

}

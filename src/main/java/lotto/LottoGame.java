package lotto;

import lotto.utils.IGenerateLotto;

import java.math.BigDecimal;
import java.util.List;

public class LottoGame {

    private final static int DEFAULT_PRICE = 1000;

    private int amount;
    private int price;
    private final Lottos lottos = new Lottos();

    public LottoGame(final int amount, final IGenerateLotto generateLotto) {

        this.amount = amount;
        this.price = DEFAULT_PRICE;

        for (int i = 0; i < calculateCountAvailableForPurchase(); i++) {
            this.lottos.add(new Lotto(generateLotto));
        }

        for (int i = 0; i < calculateCountAvailableForPurchase(); i++) {
            this.lottos.getLottos().forEach(Lotto::createLotto);
        }
    }

    @SuppressWarnings("unused")
    public LottoGame(final int amount, final int price, final IGenerateLotto generateLotto) throws IllegalArgumentException {

        this.amount = amount;
        this.price = price;

        if (this.price == 0) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < calculateCountAvailableForPurchase(); i++) {
            this.lottos.add(new Lotto(generateLotto));
        }

        for (int i = 0; i < calculateCountAvailableForPurchase(); i++) {
            this.lottos.getLottos().forEach(Lotto::createLotto);
        }
    }

    public int getCountAvailableForPurchase() {
        return calculateCountAvailableForPurchase();
    }

    public List<Lotto> getLottos() {
        return lottos.getLottos();
    }

    public void executeAnalysisLottoNumberMatch(final Lotto sourceLotto) {
        for (Lotto lotto : this.getLottos()) {
            lotto.calculatorMatchLottoNumber(sourceLotto.getLottoNumber());
        }
    }

    private int calculateCountAvailableForPurchase() {
        return new BigDecimal(this.amount / this.price).intValue();
    }

}

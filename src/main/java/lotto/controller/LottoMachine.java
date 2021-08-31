package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.exception.PriceException;
import java.util.List;

public class LottoMachine {
    private LottoGenerator lottoGenerator = new LottoGenerator();
    private int buyingCount;

    public LottoMachine(int purchasingPrice) {
        checkPrice(purchasingPrice);
        this.buyingCount = purchasingPrice / Lotto.PRICE;
    }

    public List<Lotto> publish() {
        return this.lottoGenerator.autoPublish(buyingCount);
    }

    public int getBuyingCount() {
        return buyingCount;
    }

    private int checkPrice(int value) {
        if (value < Lotto.PRICE) {
            throw new PriceException();
        }
        return value;
    }
}
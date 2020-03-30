package lotto.domain;

import lotto.exception.NoPurchasePriceException;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    public Lotteries buy(final Price price) {
        checkAvailablePriceBuyLotto(price);
        return new Lotteries(publishLottery(price));
    }

    private void checkAvailablePriceBuyLotto(final Price price) {
        if (!price.isAvailablePrice()) {
            throw new NoPurchasePriceException();
        }
    }

    private List<LottoNumbers> publishLottery(final Price price) {
        List<LottoNumbers> lotteries = new ArrayList<>();
        for (int i = 0; i < price.lotteryCount(); i++) {
            lotteries.add(LottoNumberGenerator.generate());
        }
        return lotteries;
    }
}

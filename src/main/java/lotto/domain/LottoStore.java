package lotto.domain;

import lotto.exception.NoPurchasePriceException;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    public static Lotteries buy(final Price price) {
        checkAvailablePriceBuyLotto(price);
        return new Lotteries(publishLottery(price));
    }

    private static void checkAvailablePriceBuyLotto(final Price price) {
        if (!price.isAvailablePrice()) {
            throw new NoPurchasePriceException();
        }
    }

    private static List<LottoNumbers> publishLottery(final Price price) {
        List<LottoNumbers> lotteries = new ArrayList<>();
        for (int i = 0; i < price.lotteryCount(); i++) {
            lotteries.add(LottoNumberGenerator.generate());
        }
        return lotteries;
    }
}

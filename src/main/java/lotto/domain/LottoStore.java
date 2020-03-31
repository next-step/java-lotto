package lotto.domain;

import lotto.exception.NoPurchasePriceException;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {

    private LottoStore() {}

    public static Lotteries sell(final Price price, final LottoPublisher lottoPublisher) {
        checkAvailablePriceBuyLotto(price);
        return publishLottery(price, checkAvailablePublisher(lottoPublisher));
    }

    private static void checkAvailablePriceBuyLotto(final Price price) {
        if (!price.isAvailablePrice()) {
            throw new NoPurchasePriceException();
        }
    }

    private static LottoPublisher checkAvailablePublisher(final LottoPublisher lottoPublisher) {
        if (lottoPublisher == null) {
            return new LottoPublisher();
        }
        return lottoPublisher;
    }

    private static Lotteries publishLottery(final Price price, final LottoPublisher lottoPublisher) {
        return lottoPublisher.publish(price.lotteryCount());
    }
}

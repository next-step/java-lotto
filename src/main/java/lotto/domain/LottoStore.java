package lotto.domain;

import lotto.exception.ManualSizeOverflowException;
import lotto.exception.NoPurchasePriceException;

import java.util.List;

public class LottoStore {

    private LottoStore() {}

    public static Lotteries sell(final Price price, final LottoPublisher lottoPublisher) {
        checkAvailablePriceBuyLotto(price);
        return publishLottery(price, lottoPublisher);
    }

    public static Lotteries sellManual(final Price price, final List<LottoNumbers> manualLottoNumbers) {
        checkAvailablePriceBuyLotto(price);
        checkLotteriesSize(price, manualLottoNumbers.size());
        return null;
    }

    private static void checkAvailablePriceBuyLotto(final Price price) {
        if (!price.isAvailablePrice()) {
            throw new NoPurchasePriceException();
        }
    }

    private static void checkLotteriesSize(final Price price, final int numberOfManual) {
        if (price.isOverSize(numberOfManual)) {
            throw new ManualSizeOverflowException(numberOfManual);
        }
    }

    private static Lotteries publishLottery(final Price price, final LottoPublisher lottoPublisher) {
        return lottoPublisher.publish();
    }
}

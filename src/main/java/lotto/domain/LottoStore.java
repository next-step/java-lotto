package lotto.domain;

import lotto.exception.ManualSizeOverflowException;
import lotto.exception.NoPurchasePriceException;

public class LottoStore {

    private LottoStore() {}

    public static Lotteries sell(final Price price, final Lotteries manuals) {
        int manualCount = manuals.count();
        int autoCount = price.lotteryCount() - manualCount;

        checkAvailablePriceBuyLotto(price);
        checkLotteriesSize(price, manualCount);

        return manuals.merge(LottoNumberGenerator.generateAutomatically(autoCount));
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
}

package lotto.domain;

import lotto.exception.ManualSizeOverflowException;
import lotto.exception.NoPurchasePriceException;

import java.util.List;

public class LottoStore {

    private LottoStore() {}

    // 수동 + 자동
    public static Lotteries sell(final Price price, final List<LottoNumbers> manualLottoNumbers) {
        checkAvailablePriceBuyLotto(price);
        checkLotteriesSize(price, manualLottoNumbers.size());

        int autoCount = price.lotteryCount() - manualLottoNumbers.size();
        Lotteries manuals = publishLottery(new LottoManualPublisher(manualLottoNumbers));
        Lotteries autos = publishLottery(new LottoAutoPublisher(autoCount));

        return manuals.merge(autos);
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

    private static Lotteries publishLottery(final LottoPublisher lottoPublisher) {
        return lottoPublisher.publish();
    }
}

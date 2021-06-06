package lotto;

import lotto.domain.LottoBuyer;
import lotto.domain.LottoStore;
import lotto.domain.Result;
import lotto.domain.entity.LottoList;
import lotto.domain.entity.Number;

import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;

public final class LottoController {
    private final LottoStore lottoStore;

    public LottoController(LottoStore lottoStore) {
        this.lottoStore = lottoStore;
    }

    public void start() {
        statistics(lottoStore, purchasing(lottoStore));
    }

    private LottoList purchasing(LottoStore lottoStore) {
        printBuyLotto();
        LottoBuyer lottoBuyer = new LottoBuyer(receivePurchaseAmount());
        printManualLottoSize();
        int manualLottoSize = receiveManualLottoSize();
        printManualLottoNumbers();
        LottoList lottoList = lottoStore.toSell(lottoBuyer.payMoney(), receiveManualLottoNumberOfPurchases(manualLottoSize));
        printPurchaseCompletion(manualLottoSize, lottoList.size() - manualLottoSize);
        printLottoList(lottoList);
        return lottoList;
    }

    private Number bonus() {
        printReceiveBonusNumber();
        return receiveBonusNumber();
    }

    private void statistics(LottoStore lottoStore, LottoList lottoList) {
        printReceiveWinningNumber();
        Result result = new Result(receiveWinningNumbers(), bonus());
        result.confirm(lottoList, lottoStore.price());
        printStatistics(result.profitRate(), result.rank());
    }
}

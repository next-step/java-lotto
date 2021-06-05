package lotto;

import lotto.domain.LottoBuyer;
import lotto.domain.LottoStore;
import lotto.domain.Result;
import lotto.domain.entity.LottoList;
import lotto.domain.entity.Number;

import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;

public final class LottoController {
    private LottoStore lottoStore;
    private LottoList lottoList;

    public void start() {
        purchasing();
        printReceiveWinningNumber();
        statistics();
    }
    private void purchasing() {
        printBuyLotto();
        LottoBuyer lottoBuyer = new LottoBuyer(receivePurchaseAmount());
        lottoStore = new LottoStore();
        printManualLottoSize();
        int manualLottoSize = receiveManualLottoSize();
        printManualLottoNumbers();
        lottoList = lottoStore.toSell(lottoBuyer.payMoney(), receiveManualLottoNumberOfPurchases(manualLottoSize));
        printPurchaseCompletion(manualLottoSize, lottoList.size() - manualLottoSize);
        printLottoList(lottoList);
    }

    private Number bonus() {
        printReceiveBonusNumber();
        return receiveBonusNumber();
    }

    private void statistics() {
        Result result = new Result(receiveWinningNumbers(), bonus());
        result.confirm(lottoList, lottoStore.price());
        printStatistics(result.profitRate(), result.rank());
    }

}

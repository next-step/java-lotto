package lotto;

import lotto.domain.LottoBuyer;
import lotto.domain.LottoStore;
import lotto.domain.Result;
import lotto.domain.entity.LottoList;
import lotto.view.InputView;
import lotto.view.OutputView;

public final class LottoController {

    public void start() {
        OutputView.printBuyLotto();
        LottoBuyer lottoBuyer = new LottoBuyer(InputView.receivePurchaseAmount());
        LottoStore lottoStore = new LottoStore();
        LottoList lottoList = lottoStore.toSell(lottoBuyer.payMoney());
        OutputView.printPurchaseCompletion(lottoList.size());
        OutputView.printLottoList(lottoList);
        OutputView.printReceiveWinningNumber();
        Result result = new Result(InputView.receiveWinningNumbers());
        result.confirm(lottoList, lottoStore.price());
        OutputView.printStatistics(result.profitRate(), result.rank());
    }
}

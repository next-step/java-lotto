package lotto.app;

import lotto.domain.Amount;
import lotto.domain.LottoPrizes;
import lotto.domain.LottoResult;
import lotto.domain.LottoStatistics;
import lotto.domain.LottoTickets;
import lotto.domain.LottoVendingMachine;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Lotto {
    public void start() {
        Amount purchaseAmount = InputView.inputPurchaseAmount();

        LottoVendingMachine lottoVendingMachine = new LottoVendingMachine();
        LottoTickets lottoTickets = lottoVendingMachine.vend(purchaseAmount);

        OutputView.printTickets(lottoTickets);

        LottoResult lottoResult = generateLottoResult();
        LottoPrizes lottoPrizes = lottoResult.check(lottoTickets);

        OutputView.printStatistics(LottoStatistics.from(lottoPrizes));
    }

    private LottoResult generateLottoResult() {
        return InputView.inputLottoResult();
    }
}

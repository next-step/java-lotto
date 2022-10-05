package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoNumberApplication {

    public static void main(String[] args) {

        final Purchase purchase = Purchase.from(InputView.purchasePrint());
        final long availableTickets = purchase.available();
        ResultView.availablePurchasePrint(availableTickets);

        LottoNumbers lottoNumbers = new LottoNumbers(AutoLottoNumbers.autoCreate(availableTickets));
        ResultView.autoLottoNumberPrint(lottoNumbers);
        final WinningLottoNumber winningLottoNumber = WinningLottoNumber.from(InputView.winnerNumberPrint(), InputView.bonusNumberPrint());

        final WinningResult winningResult = WinningResult.init();
        winningResult.collect(lottoNumbers.match(winningLottoNumber));
        ResultView.winningResultPrint(winningResult);
        ResultView.winningPrizeRatePrint(ProfitRate.of(winningResult.sum(), purchase));
    }
}

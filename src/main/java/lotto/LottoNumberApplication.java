package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoNumberApplication {

    public static void main(String[] args) {

        final Purchase purchase = Purchase.from(InputView.purchasePrint());
        ResultView.availablePurchasePrint(purchase.available());
        LottoNumbers lottoNumbers = new LottoNumbers(AutoLottoNumbers.autoCreate(purchase.available()));
        ResultView.autoLottoNumberPrint(lottoNumbers);
        final WinningResult winningResult = WinningResult.init();
        final WinningLottoNumber winningLottoNumber = WinningLottoNumber.from(InputView.winnerNumberPrint());
        winningResult.collect(lottoNumbers.match(winningLottoNumber));
        ResultView.winningResultPrint(winningResult);
        ResultView.winningPrizeRatePrint(ProfitRate.of(winningResult.sum(), purchase));
    }
}

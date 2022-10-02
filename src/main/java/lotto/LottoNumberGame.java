package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoNumberGame {

    public static void main(String[] args) {

        final Purchase purchase = Purchase.from(InputView.purchasePrint());
        ResultView.availablePurchasePrint(purchase.available());
        final List<LottoNumber> lottoNumbers = AutoLottoNumbers.autoCreate(purchase.available());
        ResultView.autoLottoNumberPrint(lottoNumbers);
        final WinningResult winningResult = WinningResult.init();
        winningResult.match(new WinningLottoNumber(InputView.winnerNumberPrint()), lottoNumbers);

        ResultView.winningResultPrint(winningResult);
        purchase.update(winningResult.sum());
        ResultView.winningPrizeRatePrint(purchase);
    }
}

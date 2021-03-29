package study.step4.controller;

import study.step4.domain.Amount;
import study.step4.domain.Lotto;
import study.step4.domain.LottoFactory;
import study.step4.domain.LottoNumber;
import study.step4.domain.LottoWin;
import study.step4.domain.Lottos;
import study.step4.view.InputView;
import study.step4.view.ResultView;

public class LottoController {
    public LottoController() {
    }

    public void play() {
        Amount amount = new Amount(InputView.inputPurchaseAmount(), InputView.inputManualCount());
        Lottos manualLottoList = InputView.inputManualNumber(amount);
        Lottos autoLottoList = LottoFactory.purchase(amount);

        ResultView.printPurchaseLottoCount(amount.totalCount());
        ResultView.printLottoNumbers(autoLottoList.getLottos());

        Lotto lotto = InputView.inputWinNumber();
        LottoNumber bonusBall = LottoNumber.of(InputView.inputBonusBall());
        LottoWin lottoWin = autoLottoList.result(lotto, bonusBall);
        ResultView.printResult(lottoWin);
        ResultView.printProfit(lottoWin.profit(amount));
    }
}

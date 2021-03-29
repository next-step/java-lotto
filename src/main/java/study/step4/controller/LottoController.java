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
    private static Lottos lottos;

    public LottoController() {
    }

    public void play() {
        Amount amount = new Amount(InputView.inputPurchaseAmount(), InputView.inputManualCount());
        lottos = LottoFactory.purchase(amount);
        ResultView.printPurchaseLottoCount(amount.totalCount());
        ResultView.printLottoNumbers(lottos.getLottos());

        Lotto lotto = new Lotto(InputView.inputWinNumber());
        LottoNumber bonusBall = LottoNumber.of(InputView.inputBonusBall());
        LottoWin lottoWin = lottos.result(lotto, bonusBall);
        ResultView.printResult(lottoWin);
        ResultView.printProfit(lottoWin.profit(amount));
    }
}

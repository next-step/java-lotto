package study.step3.controller;

import study.step3.domain.LottoNumber;
import study.step3.view.InputView;
import study.step3.view.ResultView;
import study.step3.domain.Amount;
import study.step3.domain.Lotto;
import study.step3.domain.LottoFactory;
import study.step3.domain.LottoWin;
import study.step3.domain.Lottos;

public class LottoController {
    private static Lottos lottos;

    public LottoController() {
    }

    public void play() {
        Amount amount = new Amount(InputView.inputPurchaseAmount());
        lottos = LottoFactory.purchase(amount);
        ResultView.printPurchaseCount(lottos.getLottos().size());
        ResultView.printLottoNumbers(lottos.getLottos());

        Lotto lotto = new Lotto(InputView.inputWinNumber());
        LottoNumber bonusBall = LottoNumber.of(InputView.inputBonusBall());
        LottoWin lottoWin = lottos.result(lotto, bonusBall);
        ResultView.printResult(lottoWin);
        ResultView.printProfit(lottoWin.profit(amount));
    }
}

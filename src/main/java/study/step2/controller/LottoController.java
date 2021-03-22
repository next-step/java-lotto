package study.step2.controller;

import study.step2.domain.Amount;
import study.step2.domain.Lotto;
import study.step2.domain.LottoFactory;
import study.step2.domain.Lottos;
import study.step2.domain.LottoWin;
import study.step2.view.InputView;
import study.step2.view.ResultView;

public class LottoController {
    private static Lottos lottos;

    public LottoController() {
    }

    public void play() {
        Amount amount = new Amount(InputView.inputPurchaseAmount());
        lottos = LottoFactory.purchase(amount.getAmount());
        ResultView.printPurchaseCount(lottos.getLottos().size());
        ResultView.printLottoNumbers(lottos.getLottos());

        LottoWin lottoWin = lottos.result(new Lotto(InputView.inputWinNumber()));
        ResultView.printResult(lottoWin);
        ResultView.printProfit(amount.getAmount(), lottoWin);
    }
}

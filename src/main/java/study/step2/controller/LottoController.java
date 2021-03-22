package study.step2.controller;

import study.step2.domain.Amount;
import study.step2.domain.Lotto;
import study.step2.domain.LottoMachine;
import study.step2.domain.LottoWin;
import study.step2.view.InputView;
import study.step2.view.ResultView;

public class LottoController {

    private final LottoMachine lottoMachine;

    public LottoController() {
        lottoMachine = new LottoMachine();
    }

    public void play() {
        Amount amount = new Amount(InputView.inputPurchaseAmount());
        ResultView.printPurchaseCount(lottoMachine.purchase(amount.getAmount()));
        ResultView.printLottoNumbers(lottoMachine.getLottos());

        String[] winNumbers = InputView.inputWinNumber();
        Lotto winLotto = new Lotto(winNumbers);

        LottoWin lottoWin = lottoMachine.result(winLotto);
        ResultView.printResult(lottoWin);
        ResultView.printProfit(amount.getAmount(), lottoWin);
    }
}

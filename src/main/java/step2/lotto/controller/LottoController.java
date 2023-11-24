package step2.lotto.controller;

import step2.lotto.domain.LottoMachine;
import step2.lotto.domain.LottoScore;
import step2.lotto.domain.LottoWin;
import step2.lotto.strategy.LottoNumberRandomGenerator;
import step2.lotto.utility.NumberSplitter;
import step2.lotto.view.InputView;
import step2.lotto.view.ResultView;

public class LottoController {

    public static void run() {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        int inputMoney = inputView.inputMoney();

        LottoMachine lottoMachine = new LottoMachine(inputMoney, new LottoNumberRandomGenerator());
        resultView.printPurchase(lottoMachine.getLottoPurchaseInfo());
        resultView.printPurchaseLottoTicketNumbers(lottoMachine.getPurchaseLottos());

        LottoWin lottoWin = new LottoWin(
            NumberSplitter.splitNumber(inputView.inputWinNumbers()), inputView.inputBonusNumber());
        resultView.printResultStatics(lottoMachine.calculateLottoStatistics(lottoWin), lottoMachine.getLottoPurchaseInfo());
    }
}

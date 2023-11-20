package step2.lotto.controller;

import java.util.Set;
import step2.lotto.domain.LottoMachine;
import step2.lotto.domain.LottoWinNumberInfo;
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

        LottoWinNumberInfo lottoWinNumberInfo = new LottoWinNumberInfo(
            NumberSplitter.splitNumber(inputView.inputWinNumbers()));
        lottoMachine.calculateLottoStatistics(lottoWinNumberInfo);

        resultView.printResultStatics(lottoMachine.getLottoScore());
    }
}

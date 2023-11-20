package step2.lotto.controller;

import java.util.Set;
import step2.lotto.domain.LottoMachine;
import step2.lotto.domain.LottoNumberRandomGenerator;
import step2.lotto.utility.NumberSplitter;
import step2.lotto.view.InputView;
import step2.lotto.view.ResultView;

public class LottoController {

    public static void run() {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        int inputMoney = inputView.inputMoney();

        LottoMachine lottoMachine = new LottoMachine(inputMoney, new LottoNumberRandomGenerator());
        resultView.printPurchaseResultMessage(lottoMachine.getLottoPurchaseInfo());
        resultView.printPurchaseLottoTicketNumbers(lottoMachine.getPurchaseLottos());

        Set<Integer> winNumbers = NumberSplitter.splitNumber(inputView.inputWinNumbers());



    }
}

package step2.lotto.controller;

import java.util.List;
import step2.lotto.domain.LottoMachine;
import step2.lotto.domain.LottoPurchase;
import step2.lotto.domain.LottoWin;
import step2.lotto.strategy.LottoNumberManualGenerator;
import step2.lotto.strategy.LottoNumberRandomGenerator;
import step2.lotto.utility.NumberSplitter;
import step2.lotto.view.InputView;
import step2.lotto.view.ResultView;

public class LottoController {

    public static void run() {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        int inputMoney = inputView.inputMoney();
        int inputCountOfManualLotto = inputView.inputCountOfManualLotto();
        List<String> inputManualNumbers = inputView.inputManualLottoNumbers(inputCountOfManualLotto);

        LottoPurchase lottoPurchase = new LottoPurchase(inputMoney, inputManualNumbers);

        LottoMachine lottoMachine = new LottoMachine(lottoPurchase);

        resultView.printPurchase(lottoMachine.getLottoPurchase().getLottoTicketCount());
        resultView.printPurchaseLottoTicketNumbers(lottoMachine.getUserPurchaseLottos());

        LottoWin lottoWin = new LottoWin(
            NumberSplitter.splitNumber(inputView.inputWinNumbers()), inputView.inputBonusNumber());
        resultView.printResultStatics(lottoMachine.calculateLottoStatistics(lottoWin), lottoMachine.getLottoPurchase());
    }
}

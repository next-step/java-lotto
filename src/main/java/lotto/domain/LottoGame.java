package lotto.domain;

import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoGame {

    public static void start() {
        ResultView.printInputMsg();
        InputMoney inputMoney = new InputMoney(InputView.inputText());
        ResultView.printManualCount();
        int manualCount = InputView.inputInt();
        ResultView.printManualNumber();

        LottoStore lottoStore = new LottoStore(InputView.inputManualLotto(manualCount), inputMoney.getPaperCount());
        LottoPapers lottoPapers = lottoStore.makeLottoPapers();

        ResultView.showBuyCount(lottoStore.getManuaCount(), lottoStore.getAutoCount());
        ResultView.showLottoNumbersList(lottoPapers.getLottoPapers());
        ResultView.showInputWinningNumber();
        String winningLottoNumbers = InputView.inputText();
        ResultView.showInputBonusNumber();
        String bonusNumber = InputView.inputText();

        WinningResult winningResult = new WinningResult(winningLottoNumbers, bonusNumber);
        WinningTable winningTable = winningResult.makeWinningTable(lottoPapers.getLottoPapers());

        ResultView.showResult(winningTable.getMatchCountTable());
        ResultView.showDelimiter();

        WinningEarningsRate winningEarningsRate = inputMoney.makeWinningEarningsRate(winningTable.getTotalWinningMoney());
        ResultView.showEarningsRate(winningEarningsRate.getEarningsRate());
    }
}

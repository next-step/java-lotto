package lotto.domain;

import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    public static void start() {
        ResultView.printInputMsg();
        InputMoney inputMoney = new InputMoney(InputView.inputText());
        ResultView.printManualCount();
        int manualCount = InputView.inputInt();

        ResultView.printManualNumber();
        List<String> autoText = new ArrayList<>();
        for (int i = 0; i < manualCount; i++) {
            autoText.add(InputView.inputText());
        }
        LottoStore lottoStore = new LottoStore(autoText, inputMoney.getPaperCount());
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

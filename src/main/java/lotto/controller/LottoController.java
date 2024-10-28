package lotto.controller;

import lotto.model.WinningRecord;
import lotto.service.LottoBuyer;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Map;

public class LottoController {
    public static void main(String[] args) {
        LottoBuyer lottoBuyer = new LottoBuyer();

        int buyAmount = InputView.inputBuyAmount();

        int manualLottoCount = InputView.inputManualLottoCount(buyAmount);
        int autoLottoCount = LottoBuyer.calculateAutoLottoCount(buyAmount, manualLottoCount);

        InputView.printPromptForManualLottoNumbers();
        for (int count = 1; count <= manualLottoCount; count++) {
            lottoBuyer.buyManualLotto(InputView.inputManualLottoNumbers());
        }

        for (int count = 1; count <= autoLottoCount; count++) {
            lottoBuyer.buyAutoLotto();
        }

        ResultView.printBuyLottoCount(manualLottoCount, autoLottoCount);
        ResultView.printBoughtLottos(lottoBuyer.getBoughtLottos());

        String winningNumbers = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusNumber(winningNumbers);

        Map<Integer, WinningRecord> winningStatistics = lottoBuyer.checkLottoResult(winningNumbers, bonusNumber);
        ResultView.printWinningStatics(winningStatistics);

        float returnRate = lottoBuyer.checkReturnRate(buyAmount, winningStatistics);
        ResultView.printReturnRate(returnRate);
    }
    
}
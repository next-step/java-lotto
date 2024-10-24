package lotto.controller;

import lotto.model.WinningInfo;
import lotto.service.LottoBuyer;
import lotto.service.LottoSeller;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Map;

public class LottoController {
    public static void main(String[] args) {
        LottoBuyer lottoBuyer = new LottoBuyer();

        int buyAmount = InputView.inputBuyAmount();
        int canBuyLottoCount = lottoBuyer.canBuyLottoCount(buyAmount);
        ResultView.printCanBuyLottoCount(canBuyLottoCount);

        for (int count = 0; count < canBuyLottoCount; count++) {
            List<Integer> lotto = lottoBuyer.buyLotto(LottoSeller.sellLotto());
            ResultView.printLottoNumber(lotto);
        }

        String lastWeekWinningNumbers = InputView.inputLastWeekWinningNumbers();
        int bonusNumber = InputView.inputBonusNumber(lastWeekWinningNumbers);

        Map<Integer, WinningInfo> winningStatics = lottoBuyer.checkLottoResult(lastWeekWinningNumbers, bonusNumber);
        ResultView.printWinningStatics(winningStatics);

        float returnRate = lottoBuyer.checkReturnRate(buyAmount);
        ResultView.printReturnRate(returnRate);
    }
}

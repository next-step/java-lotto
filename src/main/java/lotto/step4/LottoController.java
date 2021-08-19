package lotto.step4;

import lotto.step4.domain.*;
import lotto.step4.view.InputView;
import lotto.step4.view.ResultView;

public class LottoController {
    public static void main(String[] args) {
        int money = InputView.inputLottoPrice();
        int manualLottoCount = InputView.inputManualLottoCount();
        LottoShop lottoShop = new LottoShop(manualLottoCount);
        Lotteries lotteries = lottoShop.receiveMoney(money);
        InputView.inputManualLottoNumbers(manualLottoCount);
        ResultView.printLottoInfo(money, lotteries);
        Lottery winningNumbers = InputView.inputLastWinningNumbers();
        LottoNumber bonusBall = InputView.inputBonusBall();
        Winning winning = new Winning(winningNumbers, bonusBall);
        LottoStatistics lottoStatistics = lotteries.compareLottoWith(winning);
        ResultView.printLottoStatistics(lottoStatistics);
        double earningRate = lottoStatistics.calculateLottoStatistics(money);
        ResultView.printEarningRate(earningRate);
    }
}

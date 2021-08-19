package lotto.step3;

import lotto.step3.domain.*;
import lotto.step3.view.InputView;
import lotto.step3.view.ResultView;

public class LottoController {
    public static void main(String[] args) {
        int money = InputView.inputLottoPrice();
        LottoShop lottoShop = new LottoShop();
        Lotteries lotteries = lottoShop.receiveMoney(money);
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

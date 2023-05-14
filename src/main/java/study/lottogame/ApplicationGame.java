package study.lottogame;

import study.lottogame.domain.GameResult;
import study.lottogame.domain.Lotteries;
import study.lottogame.domain.Lottery;
import study.lottogame.domain.LottoNumber;
import study.lottogame.domain.Money;
import study.lottogame.domain.WinningLottery;
import study.lottogame.factory.LotteriesFactory;
import study.lottogame.ui.InputView;
import study.lottogame.ui.OutputView;

public class ApplicationGame {

  public static void main(String[] args) {
    Money inputMoney = InputView.inputPurchaseMoney();
    Lotteries lotteries = LotteriesFactory.create(inputMoney);

    int inputCount = InputView.inputManualLotteryCount();
    InputView.inputManualLotteries(inputCount, lotteries);
    OutputView.printLotteries(inputCount, lotteries);

    Lottery prizeLottery = InputView.inputPrizeLottery();
    LottoNumber bonusLottoNumber = InputView.inputBonusLottoNumber();
    WinningLottery winningLottery = new WinningLottery(prizeLottery, bonusLottoNumber);

    GameResult gameResult = lotteries.calculateGameResult(winningLottery);
    OutputView.printGameResult(inputMoney, gameResult);
  }
}

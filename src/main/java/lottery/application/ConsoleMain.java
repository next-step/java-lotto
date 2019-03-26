package lottery.application;

import lottery.domain.Lottery;
import lottery.domain.LotteryMachine;
import lottery.domain.LotteryNumber;
import lottery.domain.LotteryResult;
import lottery.view.InputView;
import lottery.view.OutputView;

public class ConsoleMain {
    public static void main(String[] args) {
        LotteryMachine lotteryMachine = new LotteryMachine();

        OutputView.printPurchasedLotties(lotteryMachine.purchaseLotteries(InputView.inputMoney()));

        LotteryNumber winningNumber = new LotteryNumber(InputView.inputWinningNumbers(), InputView.inputBonusNumber());
        LotteryResult lotteryResult = lotteryMachine.checkWinning(lotteryMachine.getLotteries(), new Lottery(winningNumber));
        OutputView.printWinningResult(lotteryResult);
    }
}
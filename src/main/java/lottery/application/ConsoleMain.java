package lottery.application;

import lottery.domain.Lottery;
import lottery.domain.LotteryMachine;
import lottery.domain.LotteryResult;
import lottery.view.InputView;
import lottery.view.OutputView;

public class ConsoleMain {
    public static void main(String[] args) {
        LotteryMachine lotteryMachine = new LotteryMachine();

        OutputView.printPurchasedLotties(lotteryMachine.purchaseLotteries(InputView.inputMoney()));

        LotteryResult lotteryResult = lotteryMachine.checkWinning(lotteryMachine.getLotteries(), new Lottery(InputView.inputWinningNumbers(), InputView.inputBonusNumber()));
        OutputView.printWinningResult(lotteryResult);
    }
}
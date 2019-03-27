package lottery.application;

import lottery.domain.*;
import lottery.view.InputView;
import lottery.view.OutputView;

public class ConsoleMain {
    public static void main(String[] args) {
        LotteryMachine lotteryMachine = new LotteryMachine();

        int inputMoney = InputView.inputMoney();
        int inputManualValue = 0;
        if(inputMoney != 0) {
            inputManualValue = InputView.inputManualValue();
        }

        OutputView.printPurchasedLotties(lotteryMachine.purchaseLotteries(new Money(inputMoney), inputManualValue, InputView.inputManualNumbers(inputManualValue)));

        LotteryNumber winningNumber = new LotteryNumber(InputView.inputWinningNumbers(), InputView.inputBonusNumber());
        LotteryResult lotteryResult = lotteryMachine.checkWinning(lotteryMachine.getLotteries(), new Lottery(winningNumber));
        OutputView.printWinningResult(lotteryResult);
    }
}
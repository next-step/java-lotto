package lottery.application;

import lottery.domain.LotteryMachine;
import lottery.domain.LotteryNumberSet;
import lottery.domain.LotteryResult;
import lottery.view.InputView;
import lottery.view.OutputView;

public class ConsoleMain {
    public static void main(String[] args) {
        LotteryMachine lotteryMachine = new LotteryMachine(new LotteryNumberSet());
        
        OutputView.printPurchasedLotties(lotteryMachine.purchaseLotteries(InputView.inputMoney()));

        LotteryResult lotteryResult = lotteryMachine.checkWinning(lotteryMachine.getLotteries(), InputView.inputWinningNumbers());
        OutputView.printWinningResult(lotteryResult);

        


    }
}
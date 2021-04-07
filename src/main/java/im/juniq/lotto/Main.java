package im.juniq.lotto;

import im.juniq.lotto.domain.LotteryMachine;
import im.juniq.lotto.domain.WinningNumbers;
import im.juniq.lotto.view.InputView;
import im.juniq.lotto.view.ResultView;

public class Main {

    public static void main(String[] args) {
        LotteryMachine lotteryMachine = LotteryMachine.withManualNumbers(InputView.purchaseAmount(), InputView.manualLottoes());
        ResultView.lottoes(lotteryMachine.lottoes());
        WinningNumbers winningNumbers = new WinningNumbers(InputView.winningNumbers(), InputView.bonusNumber());
        ResultView.winningStatus(lotteryMachine.lottoes(), winningNumbers, lotteryMachine.price());
    }
}

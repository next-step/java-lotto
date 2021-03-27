package im.juniq.lotto;

import im.juniq.lotto.view.InputView;
import im.juniq.lotto.view.ResultView;

public class Main {
	public static void main(String[] args) {
		LotteryMachine lotteryMachine = new LotteryMachine(InputView.purchaseAmount());
		ResultView.lottoes(lotteryMachine.lottoes());
		WinningNumbers winningNumbers = InputView.winningNumbers();
		ResultView.winningStatus(lotteryMachine, winningNumbers);
	}
}

package lotto;

import lotto.domain.LottoRunner;
import lotto.domain.WinningNumber;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {
	public static void main(String[] args) {
		long payment = InputView.scanPayment();
		LottoRunner runner = new LottoRunner(payment);
		ResultView.printLottoNumbers(runner.getAutoLottoNumbers());

		WinningNumber winningNumber = InputView.scanWinningNumber();
		ResultView.printMatchResult(runner.match(winningNumber));
	}
}

package lotto;

import lotto.factory.WinningBallsFactory;
import lotto.input.InputView;
import lotto.output.OutputView;
import lotto.result.Statistics;

public class LottoApplication {

	public static void main(String[] args) {
		LottoPayAmounts lottoPayAmounts = LottoPayAmounts.of(InputView.inputPurchase());
		Lottos lottosOfCustomer = LottoKiosk.issue(lottoPayAmounts);
		OutputView.outputPurchaseLottos(lottosOfCustomer);

		WinningBalls winningBalls = WinningBallsFactory.create(InputView.inputWinning());
		OutputView.outputStatistics(Statistics.from(lottosOfCustomer, winningBalls));
	}
}

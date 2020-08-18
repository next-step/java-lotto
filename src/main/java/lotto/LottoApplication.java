package lotto;

import lotto.factory.WinningFactory;
import lotto.input.InputView;
import lotto.output.OutputView;
import lotto.result.Statistics;

public class LottoApplication {

	public static void main(String[] args) {
		Lottos lottosOfCustomer = LottoKiosk.issue(InputView.inputPurchase());
		OutputView.outputPurchaseLottos(lottosOfCustomer);

		LottoNumbers winningNumbers = WinningFactory.create(InputView.inputWinning());
		OutputView.outputStatistics(Statistics.from(lottosOfCustomer, winningNumbers));
	}
}

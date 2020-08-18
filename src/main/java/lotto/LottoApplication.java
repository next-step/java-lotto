package lotto;

import lotto.factory.WinningFactory;
import lotto.input.InputView;
import lotto.output.OutputView;
import lotto.result.Statistics;

public class LottoApplication {

	public static void main(String[] args) {
		LottoPayAmounts lottoPayAmounts = LottoPayAmounts.of(InputView.inputPurchase());
		Lottos lottosOfCustomer = LottoKiosk.issue(lottoPayAmounts);
		OutputView.outputPurchaseLottos(lottosOfCustomer);

		LottoNumbers winningNumbers = WinningFactory.create(InputView.inputWinning());
		OutputView.outputStatistics(Statistics.from(lottosOfCustomer, winningNumbers));
	}
}

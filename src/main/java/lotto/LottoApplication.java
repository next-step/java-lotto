package lotto;

import static java.util.stream.Collectors.toList;

import java.util.List;

import lotto.factory.LottoNumbersFactory;
import lotto.factory.WinningBallsFactory;
import lotto.input.InputView;
import lotto.output.OutputView;
import lotto.result.Statistics;

public class LottoApplication {

	public static void main(String[] args) {
		LottoPayAmounts lottoPayAmounts = LottoPayAmounts.of(InputView.inputPurchase());
		ManualLottoCount lottoCount = ManualLottoCount.of(lottoPayAmounts, InputView.inputManualLottoCount());
		List<String> manualLottosString = InputView.inputManualLottos(lottoCount);
		LottoPurchaseArgument argument = LottoPurchaseArgument.of(lottoPayAmounts, manualLottosString.stream()
																									 .map(LottoNumbersFactory::create)
																									 .collect(toList()));
		Lottos lottosOfCustomer = LottoKiosk.issue(argument);
		OutputView.outputPurchaseLottos(lottosOfCustomer);

		WinningBalls winningBalls = WinningBallsFactory.create(InputView.inputWinning(), InputView.inputBonusBall());
		OutputView.outputStatistics(Statistics.from(lottosOfCustomer, winningBalls));
	}
}

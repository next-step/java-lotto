package lotto;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lotto.domain.ListOfLottoNumbers;
import lotto.domain.LotteryMachine;
import lotto.domain.LottoNum;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.Reward;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.ResultView;
import lotto.view.dto.LottoStringsDto;
import lotto.view.dto.PurchaseCountDto;
import lotto.view.dto.WinningStatisticDto;

public class LotteryApp {

	public static void main(String[] args) {
		final InputView inputView = new InputView();
		final ResultView resultView = new ResultView();
		final LotteryMachine lotteryMachine = new LotteryMachine();

		try {
			final int purchaseAmount = inputView.askMoney();
			final Money money = new Money(purchaseAmount);

			final int manualLottoCount = inputView.askManualLottoCount();

			final List<List<LottoNum>> inputManualLottoNumbers = inputView.askManualLottoNumbers(manualLottoCount)
				.stream()
				.map(value ->
					value.stream()
						.map(LottoNum::of)
						.collect(Collectors.toList()))
				.collect(Collectors.toList());

			final ListOfLottoNumbers manualLottoNumbers = ListOfLottoNumbers.of(inputManualLottoNumbers);

			final Lottos lottos = lotteryMachine.issue(money, manualLottoNumbers);
			final PurchaseCountDto purchaseCountDto = PurchaseCountDto.of(lottos.getCount());
			resultView.printPurchaseCount(purchaseCountDto);

			final LottoStringsDto lottosStringDto = LottoStringsDto.of(lottos.lottoStrings());
			resultView.printLottosString(lottosStringDto);

			final List<LottoNum> numbers = inputView.askWinningNumbers()
				.stream()
				.map(LottoNum::of)
				.collect(Collectors.toList());
			final LottoNum bonusNumber = LottoNum.of(inputView.askBonusNumber());
			final WinningLotto winningLotto = new WinningLotto(numbers, bonusNumber);

			final Map<Reward, Integer> rewardStatistic = lottos.getRewardStatistic(winningLotto);
			resultView.printWinningStatistic(WinningStatisticDto.of(rewardStatistic, purchaseAmount));
		} catch (Exception exception) {
			resultView.printExceptionMessage(exception);
		}
	}
}

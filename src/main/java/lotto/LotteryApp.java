package lotto;

import java.util.List;
import java.util.Map;

import lotto.domain.LotteryMachine;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
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

		final int purchaseAmount = inputView.askMoney();
		final Money money = new Money(purchaseAmount);

		final Lottos lottos = lotteryMachine.issue(money);
		final PurchaseCountDto purchaseCountDto = PurchaseCountDto.of(lottos.getCount());
		resultView.printPurchaseCount(purchaseCountDto);

		final LottoStringsDto lottosStringDto = LottoStringsDto.of(lottos.lottoStrings());
		resultView.printLottosString(lottosStringDto);

		final List<Integer> numbers = inputView.askWinningNumbers();
		final Lotto winningLotto = new Lotto(numbers);

		final Map<Integer, Integer> matchCountsMap = lottos.getMatchingCountsMap(winningLotto);
		resultView.printWinningStatistic(WinningStatisticDto.of(matchCountsMap, purchaseAmount));
	}
}

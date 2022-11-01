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

		int purchaseAmount = inputView.askMoney();
		Money money = new Money(purchaseAmount);

		Lottos lottos = lotteryMachine.issue(money);
		PurchaseCountDto purchaseCountDto = PurchaseCountDto.of(lottos.getCount());
		resultView.printPurchaseCount(purchaseCountDto);

		LottoStringsDto lottosStringDto = LottoStringsDto.of(lottos.lottoStrings());
		resultView.printLottosString(lottosStringDto);

		List<Integer> numbers = inputView.askWinningNumbers();
		Lotto winningLotto = new Lotto(numbers);

		Map<Integer, Integer> matchCountsMap = lottos.getMatchingCountsMap(winningLotto);

		resultView.printWinningStatistic(WinningStatisticDto.of(matchCountsMap, purchaseAmount));
	}
}

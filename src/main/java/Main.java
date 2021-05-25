import java.util.List;

import lotto.Lottos;
import lotto.Money;
import lotto.Prize;
import lotto.Statistics;
import lotto.Store;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class Main {

	public static void main(String[] args) {
		InputView inputView = new InputView();
		ResultView resultView = new ResultView();

		long amount = inputView.askAmount();
		Lottos lottos = Store.buy(new Money(amount));

		// TODO 이 부분을 어떻게 빼야 할지 모르겠습니다.
		// for (Lotto lotto : lottos.findAll()) {
		// 	resultView.printNumbers(lotto.numbers());
		// }

		List<Integer> prizeNumbers = inputView.askPrizeNumbers();
		Statistics statistics = lottos.statistics(prizeNumbers);

		resultView.outputIntro();
		resultView.outputStatistics(Prize.SIX.count(), Prize.SIX.win().amount(), statistics.status(Prize.SIX));
		resultView.outputStatistics(Prize.FIVE.count(), Prize.FIVE.win().amount(), statistics.status(Prize.FIVE));
		resultView.outputStatistics(Prize.FOUR.count(), Prize.FOUR.win().amount(), statistics.status(Prize.FOUR));
		resultView.outputStatistics(Prize.THREE.count(), Prize.THREE.win().amount(), statistics.status(Prize.THREE));
		resultView.outputProfit(Prize.profit(statistics).rate());
	}
}

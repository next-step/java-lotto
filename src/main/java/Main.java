import java.util.List;

import lotto.Lotto;
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

		/*
		 * 사용자 입력 : 구입금액
		 */
		long amount = inputView.askAmount();
		Lottos lottos = buy(amount);

		/*
		 * 결과 출력 : 구입 로또
		 */
		for (Lotto lotto : lottos.findAll()) {
			resultView.printNumbers(lotto.numbers());
		}

		/*
		 * 사용자 입력 : 지난주 당첨 번호
		 */
		List<Integer> prizeNumbers = inputView.askPrizeNumbers();
		Statistics statistics = lottos.statistics(prizeNumbers);

		/*
		 * 결과 출력 : 통계, 수익률
		 */
		resultView.outputIntro();
		resultView.outputStatistics(Prize.SIX.count(), Prize.SIX.win().amount(), statistics.status(Prize.SIX));
		resultView.outputStatistics(Prize.FIVE.count(), Prize.FIVE.win().amount(), statistics.status(Prize.FIVE));
		resultView.outputStatistics(Prize.FOUR.count(), Prize.FOUR.win().amount(), statistics.status(Prize.FOUR));
		resultView.outputStatistics(Prize.THREE.count(), Prize.THREE.win().amount(), statistics.status(Prize.THREE));
		resultView.outputProfit(statistics.profit().rate());
	}

	private static Lottos buy(long amount) {
		return Store.buy(new Money(amount));
	}

	private static Statistics analyze(List<Integer> prizeNumbers, Lottos lottos) {
		Statistics statistics = new Statistics(new Lotto(prizeNumbers));
		statistics.analyze(lottos);
		return statistics;
	}

}

package lotto;

import java.util.List;

public class Application {

	public static void main(String[] args) {
		Money money = InputView.pay();
		Lottos lottos = new Lottos(money);
		ResultView.printBuyResult(lottos);

		List<Number> winningNumbers = InputView.winningNumbers();
		ResultView.printWinningResult(lottos);
	}
}

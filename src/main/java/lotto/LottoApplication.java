package lotto;

import java.util.List;

import lotto.domain.Lottery;
import lotto.domain.LotteryResults;
import lotto.domain.Lottos;
import lotto.utils.StringUtils;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {
	public static void main(String[] args) {
		Lottos lottos = purchaseLotto();
		drawLotto(lottos);
	}

	private static Lottos purchaseLotto() {
		int amount = InputView.inputAmount();
		Lottos lottos = new Lottos(amount);
		ResultView.outputPurchaseLotto(lottos);
		return lottos;
	}

	private static void drawLotto(Lottos lottos) {
		String strWinningNumbers = InputView.inputWinningNumbers();
		List<Integer> winningNumbers = StringUtils.convertToNumberList(strWinningNumbers);
		Lottery lottery = new Lottery(winningNumbers);
		lottery.draw(lottos);
		LotteryResults results = lottery.getLotteryResults();
		ResultView.outputWinningStatistics(results);
	}
}

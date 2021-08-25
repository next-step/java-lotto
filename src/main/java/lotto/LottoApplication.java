package lotto;

import java.util.List;

import lotto.domain.Lottery;
import lotto.domain.LotteryResults;
import lotto.domain.Lotto;
import lotto.domain.Wallet;
import lotto.utils.StringUtils;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {
	public static void main(String[] args) {
		Wallet wallet = purchaseLotto();
		drawLotto(wallet.getLottos());
	}

	private static Wallet purchaseLotto() {
		int amount = InputView.inputAmount();
		Wallet wallet = new Wallet(amount);
		ResultView.outputPurchaseLotto(wallet.getLottos());
		return wallet;
	}

	private static void drawLotto(List<Lotto> lottos) {
		String strWinningNumbers = InputView.inputWinningNumbers();
		List<Integer> winningNumbers = StringUtils.convertToNumberList(strWinningNumbers);
		Lottery lottery = new Lottery(winningNumbers);
		lottery.draw(lottos);
		LotteryResults results = lottery.getLotteryResults();
		ResultView.outputWinningStatistics(results);
	}
}

package lotto;

import lotto.domain.LottoGenerator;
import lotto.domain.Lottos;
import lotto.domain.WinnerLotto;
import lotto.domain.WinnerStatics;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMain {
	public static void main(String[] args) {
		Lottos boughtLottos = buy(InputView.getBuyAmount());

		ResultView.printBoughtLottos(boughtLottos);

		WinnerStatics winnerStatics = getWinnerStatics(boughtLottos);

		ResultView.printWinnerStatics(winnerStatics);
		ResultView.printProfit(winnerStatics);
	}

	private static WinnerStatics getWinnerStatics(Lottos boughtLottos) {
		return new WinnerStatics(boughtLottos,
			new WinnerLotto(InputView.getLastWinLotto(), InputView.getBonusNumber()));
	}

	private static Lottos buy(int buyAmount) {
		LottoGenerator lottoGenerator = new LottoGenerator();

		return lottoGenerator.buy(buyAmount);
	}
}

package automaticLotto;

import automaticLotto.domain.LottoGenerator;
import automaticLotto.domain.Lottos;
import automaticLotto.domain.WinnerLotto;
import automaticLotto.domain.WinnerStatics;
import automaticLotto.view.InputView;
import automaticLotto.view.ResultView;

public class automaticLottoMain {
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

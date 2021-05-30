package lotto;

import java.util.List;

import lotto.domain.Budget;
import lotto.domain.Lotto;
import lotto.domain.LottoShop;
import lotto.domain.Lottos;
import lotto.domain.WinnerLotto;
import lotto.domain.WinnerStatics;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMain {
	public static void main(String[] args) {
		Lottos boughtLottos = buy(InputView.getBuyAmount(), InputView.getManualLottos(InputView.getManualLottoCount()));

		ResultView.printBoughtLottos(boughtLottos);

		WinnerStatics winnerStatics = getWinnerStatics(boughtLottos);

		ResultView.printWinnerStatics(winnerStatics);
		ResultView.printProfit(winnerStatics);
	}

	private static WinnerStatics getWinnerStatics(Lottos boughtLottos) {
		return new WinnerStatics(boughtLottos,
			new WinnerLotto(InputView.getLastWinLotto(), InputView.getBonusNumber()));
	}

	private static Lottos buy(int buyAmount, List<Lotto> manualLottos) {
		return LottoShop.buy(new Budget(buyAmount), manualLottos);
	}
}

package lotto;

import lotto.view.InputView;
import lotto.view.ResultView;

import java.math.BigDecimal;
import java.util.List;

public class LottoApplication {
	public static void main(String[] args) {
		BigDecimal receivedMoney = InputView.inputMoney();
		Lottos lottos = LottoDrawer.draw(receivedMoney);

		ResultView.printBoughtLottos(lottos);
		List<Integer> winningNumber = InputView.inputWinningNumber();
		LottoResult lottoResult = lottos.getWinningResult(winningNumber);
		ResultView.printWinningStatistics(lottoResult);
	}
}

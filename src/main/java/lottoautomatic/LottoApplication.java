package lottoautomatic;

import lottoautomatic.domain.LottoNumberShuffle;
import lottoautomatic.domain.Lottos;
import lottoautomatic.ui.InputView;
import lottoautomatic.ui.ResultView;

public class LottoApplication {

	public static void main(String[] args) {
		InputView inputView = new InputView();

		Lottos lottos = new Lottos();
		lottos.buy(inputView.getMoney(), new LottoNumberShuffle());

		ResultView resultView = new ResultView(lottos);
		resultView.printLottos();

		inputView.inputLastWinningNumbers();

		resultView.printResult(inputView.getWinningNumbers());
	}
}

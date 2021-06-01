package kht2199.lotto;

import kht2199.lotto.entity.LottoGame;
import kht2199.lotto.view.InputView;
import kht2199.lotto.view.RandomLottoUI;
import kht2199.lotto.view.ResultView;

/**
 *
 * @author heetaek.kim
 */
public class LottoApplication {

	public static void main(String[] args) {
		ResultView resultView = new ResultView();
		InputView inputView = new InputView();
		LottoGame game = new LottoGame();
		RandomLottoUI randomLottoUI = new RandomLottoUI(inputView, resultView);
		randomLottoUI.start(game);
	}

}

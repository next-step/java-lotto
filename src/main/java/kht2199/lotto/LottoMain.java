package kht2199.lotto;

import kht2199.lotto.view.InputView;
import kht2199.lotto.view.ResultView;

/**
 *
 * @author heetaek.kim
 */
public class LottoMain {

	public static void main(String[] args) {
		InputView inputView = new InputView();
		ResultView resultView = new ResultView();
		RandomLotto randomLotto = new RandomLotto(inputView, resultView);
		randomLotto.start();
	}
}

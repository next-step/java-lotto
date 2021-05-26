package kht2199.lotto;

import kht2199.lotto.exception.LottoListNotEmptyException;
import kht2199.lotto.exception.assets.AssetsNotEnoughException;
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
		start(randomLotto, resultView);
	}

	/**
	 * 예외발생시, 프로그램을 재시작하거나 종료, 조정을 한다.
	 */
	private static void start(RandomLotto randomLotto, ResultView resultView) {
		try {
			randomLotto.start();
		} catch (LottoListNotEmptyException | AssetsNotEnoughException e) {
			resultView.printException(e);
			start(randomLotto, resultView);
		}
	}
}

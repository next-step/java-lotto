package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.RandomGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class MainController {

	public static void main(String[] args) {
		InputView input = new InputView();
		OutputView outputView = new OutputView();

		Lotto lotto = new Lotto(input.money(), new RandomGenerator(), new LottoResult(0, 0));

		outputView.printLotto(lotto.lotto());

		lotto.winningNumber(input.winningNumber());
		lotto.drawLotto();

		outputView.printStatistics(lotto.totalWinningStatistics(), lotto.returnRate());
	}
}

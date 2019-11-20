package step2;

import step2.view.InputView;
import step2.view.ResultView;

public class Main {
	public static void main(String[] args) {
		InputView inputView = new InputView();
		ResultView resultView;

		int money = inputView.inputMoney();
		LottoGame lottoGame = new LottoGame(money);
		resultView = new ResultView(lottoGame);
		resultView.showStatistic(inputView.inputResult(), money);
	}
}

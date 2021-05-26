package lotto;

public class Application {

	public static void main(String[] args) {
		Money money = InputView.pay();
		Lottos lottos = new Lottos(money);
		ResultView.printBuyResult(lottos);

		Lotto win = InputView.winLotto();
		WinningResult result = new WinningResult(win, lottos);
		ResultView.printWinningResult(result);
	}
}

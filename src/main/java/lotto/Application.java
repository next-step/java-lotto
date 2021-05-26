package lotto;

public class Application {

	public static void main(String[] args) {
		Money money = InputView.pay();
		Lottos lottos = new Lottos(money);
		ResultView.printBuyResult(lottos);

		Lotto winLotto = InputView.winLotto();
		LottoNumber bonusBall = InputView.bonusBall();
		WinningNumber winningNumber = new WinningNumber(winLotto, bonusBall);
		GameResult result = new GameResult(winningNumber, lottos);
		ResultView.printWinningResult(result);
	}
}

package lotto;

public class Application {

	public static void main(String[] args) {
		Money money = InputView.pay();
		Lottos lottos = money.buyAll();
		ResultView.printBuyResult(lottos);

		Lotto winLotto = InputView.winLotto();
		LottoNumber bonusBall = InputView.bonusBall();
		WinningLotto winningLotto = new WinningLotto(winLotto, bonusBall);
		GameResult result = new GameResult(winningLotto, lottos);
		ResultView.printWinningResult(result);
	}
}

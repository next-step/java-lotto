package lotto;

public class Application {

	public static void main(String[] args) {
		Wallet wallet = InputView.pay();
		Lottos lottos = wallet.buyAll();
		ResultView.printBuyResult(lottos);

		Lotto winLotto = InputView.winLotto();
		LottoNumber bonusBall = InputView.bonusBall();
		WinningLotto winningLotto = new WinningLotto(winLotto, bonusBall);
		GameResult result = new GameResult(winningLotto, lottos);
		ResultView.printWinningResult(result);
	}
}

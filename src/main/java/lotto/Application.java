package lotto;

public class Application {

	public static void main(String[] args) {
		Wallet wallet = InputView.pay();
		Lottos beforeBuy = InputView.manualBuy(wallet);

		Lottos afterBuy = wallet.buyManual(beforeBuy);
		Lottos afterBuyAll = afterBuy.mergeWith(wallet.buyAutoAll());
		ResultView.printBuyResult(afterBuyAll);

		Lotto winLotto = InputView.winLotto();
		LottoNumber bonusBall = InputView.bonusBall();

		WinningLotto winningLotto = new WinningLotto(winLotto, bonusBall);
		GameResult result = new GameResult(winningLotto, afterBuyAll);
		ResultView.printWinningResult(result);
	}
}

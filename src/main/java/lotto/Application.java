package lotto;

public class Application {

	public static void main(String[] args) {
		Money money = InputView.pay();
		Lottos lottos = new Lottos(money);
		ResultView.printBuyResult(lottos);

		Lotto winLotto = InputView.winLotto();
		LottoNumber bonusBall = InputView.bonusBall();
		WinningResult result = new WinningResult(winLotto, lottos);
		ResultView.printWinningResult(result);
	}
}

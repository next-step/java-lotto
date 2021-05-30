package lotto;

import java.util.List;

public class Application {

	public static void main(String[] args) {
		LottoShop shop = new LottoShop();

		Wallet wallet = InputView.initWallet();

		List<String> lottoStrings = InputView.lottoStrings(wallet);

		Lottos lottos = shop.buyLottos(wallet, lottoStrings);
		ResultView.printBuyResult(lottos);

		Lotto winningNumber = InputView.winningNumber();
		LottoNumber bonusBall = InputView.bonusBall();

		WinningLotto winningLotto = new WinningLotto(winningNumber, bonusBall);
		GameResult result = new GameResult(winningLotto, lottos);
		ResultView.printWinningResult(result);
	}
}

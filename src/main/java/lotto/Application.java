package lotto;

import lotto.shop.LottoShop;
import lotto.shop.Lottos;

public class Application {

	public static void main(String[] args) {
		LottoShop shop = new LottoShop();

		Wallet wallet = InputView.wallet();

		Lottos beforeBuy = InputView.manualLottos(wallet);

		Lottos lottos = shop.buyLottos(wallet, beforeBuy);
		ResultView.printBuyResult(lottos, beforeBuy.count());

		Lotto winningNumber = InputView.winningNumber();
		LottoNumber bonusBall = InputView.bonusBall();

		WinningLotto winningLotto = new WinningLotto(winningNumber, bonusBall);
		GameResult result = new GameResult(winningLotto, lottos);
		ResultView.printWinningResult(result);
	}
}

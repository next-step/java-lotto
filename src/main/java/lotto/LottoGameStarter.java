package lotto;

import lotto.view.LottoGameView;
import lotto.view.LottoOptionInputView;

public class LottoGameStarter {

	public static void main(String[] args) {
		LottoGameView lottoGameView = new LottoGameView();
		LottoOptionInputView lottoOptionInputView = new LottoOptionInputView();
		LottoGame lottoGame = new LottoGame(lottoOptionInputView, lottoGameView);
		lottoGame.play();
	}
}

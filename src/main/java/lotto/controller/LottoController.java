package lotto.controller;

import java.util.List;
import java.util.Map;

import lotto.model.LottoGame;
import lotto.model.LottoPurchase;
import lotto.model.Prize;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoController {

	public static void main(String[] args) {
		int money = LottoInputView.buyRequestView();
		LottoPurchase lottoPurchase = new LottoPurchase(money);

		List<LottoGame> resultLottoGame = lottoPurchase.resultLottoGame();

		LottoOutputView.resultLottoNumbers(resultLottoGame);

		String lastWinNumber = LottoInputView.lastWinLottoNumberView();
		Map<Prize, Integer> winPrize = lottoPurchase.confirmWinLottoNumber(lastWinNumber);
		LottoOutputView.resultLottoView(winPrize, money);
	}
}

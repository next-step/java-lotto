package lotto.controller;

import java.util.List;
import java.util.Map;

import lotto.model.LottoGame;
import lotto.model.LottoPurchase;
import lotto.model.Prize;
import lotto.service.SearchPrize;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoController {

	public static void main(String[] args) {
		int money = LottoInputView.buyRequestView();
		LottoPurchase lottoPurchase = new LottoPurchase();

		List<LottoGame> resultLottoGame = lottoPurchase.lottoTicketPurchase(money);

		LottoOutputView.lottoNumbersList(resultLottoGame);

		String lastWinNumber = LottoInputView.lastWinLottoNumberView();
		SearchPrize searchPrize = new SearchPrize();
		Map<Prize, Integer> winPrize = searchPrize.confirmWinLottoNumber(resultLottoGame, lastWinNumber);
		LottoOutputView.resultLottoPrizeView(winPrize, money);
	}
}

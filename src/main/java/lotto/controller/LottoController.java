package lotto.controller;

import java.util.List;

import lotto.model.Lotto;
import lotto.model.LottoPurchase;
import lotto.model.WinPrizes;
import lotto.service.SearchPrize;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoController {

	public static void main(String[] args) {
		int money = LottoInputView.buyRequestView();

		List<Lotto> resultLottoGame = LottoPurchase.lottoTicketPurchase(money);

		LottoOutputView.lottoNumbersList(resultLottoGame);

		String lastWinNumber = LottoInputView.lastWinLottoNumberView();

		SearchPrize searchPrize = new SearchPrize();
		WinPrizes winPrizes = searchPrize.confirmWinLottoNumber(resultLottoGame, lastWinNumber);
		LottoOutputView.resultLottoPrizeView(winPrizes, money);
	}
}

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
		int money = LottoInputView.buyRequest();

		List<Lotto> lotteries = LottoPurchase.buyLotteries(money);

		LottoOutputView.printTicketCount(money);
		LottoOutputView.printLottoList(lotteries);

		String lastWinNumber = LottoInputView.requestLastWinLottoNumber();

		WinPrizes winPrizes = SearchPrize.confirmWinLottoNumber(lotteries, lastWinNumber);
		LottoOutputView.displayLottoPrize(winPrizes, money);
	}
}

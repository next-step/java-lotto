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

		List<Lotto> obtainLotteries = LottoPurchase.buyLotteries(money);

		LottoOutputView.lottoNumbersList(obtainLotteries);

		String lastWinNumber = LottoInputView.lastWinLottoNumberView();

		WinPrizes winPrizes = SearchPrize.confirmWinLottoNumber(obtainLotteries, lastWinNumber);
		LottoOutputView.resultLottoPrizeView(winPrizes, money);
	}
}

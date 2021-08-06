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
		int lottoCount = LottoInputView.buyLottos();

		List<Lotto> lottos = LottoPurchase.buyLottos(lottoCount);

		LottoOutputView.printLottoTicketCount(lottoCount);
		LottoOutputView.printLottoList(lottos);

		String lastWinNumber = LottoInputView.inputLastWinningNumbers();

		WinPrizes winPrizes = SearchPrize.confirmWinLottoNumber(lottos, lastWinNumber);
		LottoOutputView.displayLottoPrize(winPrizes, lottoCount);
	}
}

package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

/**
 * Created by hspark on 06/11/2018.
 */
public class LottoMain {
	public static void main(String[] args) {
		try {
			int lottoPurchaseAmount = InputView.inputLottoPurchaseAmount();
			int manualLottoCount = InputView.inputManualLottoCount();
			List<LottoTicket> manualLottoTickets = InputView.inputManualLottoNumbers(manualLottoCount);

			Lotto lotto = new Lotto(new ShuffleLottoMachine());
			PurchaseLottoTickets purchaseLottoTickets = lotto.purchaseLottoTickets(lottoPurchaseAmount, manualLottoTickets);
			ResultView.printLottoTickets(purchaseLottoTickets);

			WinningLottoTicket previousWinningTicket = InputView.inputWinningLottoNumbers();
			LottoMatchingResult lottoMatchingResult = lotto.matchNumber(previousWinningTicket);

			ResultView.printResult(lottoMatchingResult);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

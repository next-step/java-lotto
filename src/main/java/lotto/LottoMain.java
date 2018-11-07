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

			Lotto lotto = new Lotto(new ShuffleLottoMachine());
			List<LottoNumber> lottoTicketList = lotto.purchaseLottoTickets(lottoPurchaseAmount);
			ResultView.printLottoTickets(lottoTicketList);

			List<Integer> lottoNumber = InputView.inputLottoNumbers();
			int bonusNumber = InputView.inputLottoBonusNumber();
			WinningLottoTicket previousWinningTicket = WinningLottoTicket.newInstance(lottoNumber, bonusNumber);

			LottoMatchingResult lottoMatchingResult = lotto.matchNumber(previousWinningTicket);
			ResultView.printResult(lottoMatchingResult);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

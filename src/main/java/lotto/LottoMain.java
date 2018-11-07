package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoMatchingResult;
import lotto.domain.LottoTicket;
import lotto.domain.ShuffleLottoMachine;
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
			List<LottoTicket> lottoTicketList = lotto.purchaseLottoTickets(lottoPurchaseAmount);
			ResultView.printLottoTickets(lottoTicketList);

			LottoTicket previousWinningTicket = LottoTicket.newInstanceByManual(InputView.inputLottoNumbers());
			LottoMatchingResult lottoMatchingResult = lotto.matchNumber(previousWinningTicket);
			ResultView.printResult(lottoMatchingResult);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

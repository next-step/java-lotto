package lotto.view.console;

import lotto.domain.*;
import lotto.domain.common.Money;
import lotto.domain.generator.LottoTicketDispenser;
import lotto.domain.generator.PurchaseLottoTicketRequestInfo;
import lotto.domain.generator.PurchaseLottoTicketResultInfo;
import lotto.domain.generator.ShuffleLottoTicketDispenser;

import java.util.List;

/**
 * Created by hspark on 06/11/2018.
 */
public class LottoMain {
	public static void main(String[] args) {
		try {
			Money lottoPurchaseAmount = Money.of(InputView.inputLottoPurchaseAmount());
			int manualLottoCount = InputView.inputManualLottoCount();
			List<LottoTicket> manualLottoTickets = InputView.inputManualLottoNumbers(manualLottoCount);

			// 로또 구입
			LottoTicketDispenser lottoTicketDispenser = new ShuffleLottoTicketDispenser(new ShuffleLottoMachine());
			PurchaseLottoTicketRequestInfo requestInfo = new PurchaseLottoTicketRequestInfo(lottoPurchaseAmount, manualLottoTickets);
			PurchaseLottoTicketResultInfo purchaseLottoTicketResultInfo = lottoTicketDispenser.purchase(requestInfo);
			ResultView.printLottoTickets(purchaseLottoTicketResultInfo);

			// 매칭할 로또 번호 생성
			WinningLottoTicket previousWinningTicket = InputView.inputWinningLottoNumbers();

			//로또 매칭
			Lotto lotto = new Lotto(purchaseLottoTicketResultInfo.getTickets());
			LottoMatchingResult lottoMatchingResult = lotto.matchNumber(previousWinningTicket);
			ResultView.printResult(lottoMatchingResult);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

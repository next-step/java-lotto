package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoMain {

	public static void main(String[] args) {
		Money money = InputView.inputMoney();
		int manualLottoTicketsCount = InputView.inputManualLottoTicketsCount();
		List<LottoNumbers> manualLottoTicketNumbers = InputView.inputManualLottoNumbers(manualLottoTicketsCount);

		LottoMachine lottoMachine = new LottoMachine();
		LottoTickets lottoTickets = lottoMachine.issueLottoTickets(money, manualLottoTicketNumbers);
		ResultView.showLottoTicketsCount(money.availableLottoTicketsCount(), manualLottoTicketsCount);
		ResultView.showLottoTickets(lottoTickets);

		LottoNumbers winningLottoNumbers = InputView.inputWinningLottoNumbers();
		int bonusNumber = InputView.inputBonusNumber();
		WinningLottoTicket winningLottoTicket = WinningLottoTicket.from(winningLottoNumbers, bonusNumber);
		LottoPrizes lottoPrizes = lottoTickets.getLottoPrizes(winningLottoTicket);
		ResultView.showLottoPrizes(lottoPrizes);
		ResultView.showEarningsRate(money.earningsRate(lottoPrizes.winningMoney()));
	}

}

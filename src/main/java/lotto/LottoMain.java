package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.LottoPrizes;
import lotto.domain.LottoTickets;
import lotto.domain.WinningLottoNumbers;
import lotto.domain.WinningLottoTicket;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMain {

	public static void main(String[] args) {
		int money = InputView.inputMoney();
		int numberOfManualLottoTickets = InputView.inputNumberOfManualLottoTickets();
		LottoMachine lottoMachine = new LottoMachine();
		LottoTickets lottoTickets = lottoMachine.issueLottoTickets(money);
		ResultView.showLottoTickets(lottoTickets);

		WinningLottoNumbers winningLottoNumbers = InputView.inputWinningNumbers();
		int bonusNumber = InputView.inputBonusNumber();
		WinningLottoTicket winningLottoTicket = WinningLottoTicket.from(winningLottoNumbers, bonusNumber);
		LottoPrizes lottoPrizes = lottoTickets.getLottoPrizes(winningLottoTicket);
		ResultView.showLottoPrizes(lottoPrizes);
		ResultView.showEarningsRate(lottoPrizes.earningsRate(money));
	}

}

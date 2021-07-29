package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.LottoPrizes;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.WinningLottoNumbers;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMain {

	public static void main(String[] args) {
		int money = InputView.inputMoney();
		LottoMachine lottoMachine = new LottoMachine();
		LottoTickets lottoTickets = lottoMachine.issueLottoTickets(money);
		ResultView.showLottoTickets(lottoTickets);

		String winningNumbers = InputView.inputWinningNumbers();
		LottoTicket winningLottoTicket = LottoTicket.from(WinningLottoNumbers.from(winningNumbers));

		LottoPrizes lottoPrizes = lottoTickets.getLottoPrizes(winningLottoTicket);
		ResultView.showLottoPrizes(lottoPrizes);
		ResultView.showProfitRate(lottoPrizes.profitRate(money));
	}

}

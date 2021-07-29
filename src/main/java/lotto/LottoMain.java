package lotto;

import java.util.List;

import lotto.domain.LottoMachine;
import lotto.domain.LottoPrize;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.WinningLottoNumbers;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMain {

	public static void main(String[] args) {
		LottoMachine lottoMachine = new LottoMachine();
		LottoTickets lottoTickets = lottoMachine.issueLottoTickets(InputView.inputMoney());
		ResultView.showLottoTickets(lottoTickets);

		String winningNumbers = InputView.inputWinningNumbers();
		LottoTicket winningLottoTicket = LottoTicket.from(WinningLottoNumbers.from(winningNumbers));

		List<LottoPrize> lottoPrizes = lottoTickets.getLottoPrizes(winningLottoTicket);
	}

}

package lotto;

import java.util.List;

import lotto.domain.LottoMachine;
import lotto.domain.LottoTicket;
import lotto.view.InputView;

public class LottoMain {

	public static void main(String[] args) {
		LottoMachine lottoMachine = new LottoMachine();
		List<LottoTicket> lottoTickets = lottoMachine.issueLottoTickets(InputView.inputPrice());
		InputView.showLottoTickets(lottoTickets);
	}

}

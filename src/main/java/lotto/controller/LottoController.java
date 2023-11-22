package lotto.controller;
import java.util.Set;

import lotto.domain.LottoTickets;
import lotto.domain.LottoChecker;
import lotto.domain.LottoShop;
import lotto.domain.strategy.AutoGenerateStrategy;
import lotto.domain.util.StringSplitter;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
	public static void main(String[] args) {
		InputView inputView = new InputView();
		ResultView resultView = new ResultView();

		int totalPrice = inputView.inputTotalAmount();
		int ticketQuantity = new LottoShop().sellTicket(totalPrice);
		resultView.showHowManyBuyTicket(ticketQuantity);

		LottoTickets lottoTickets = new LottoTickets(ticketQuantity, new AutoGenerateStrategy());
		resultView.showLottoTickets(lottoTickets.getLottoTickets());

		Set<Integer> winningNums = StringSplitter.convertToIntegerSet(inputView.inputWinningNumbers());
		resultView.showResultStatics(lottoTickets.checkTicket(new LottoChecker(winningNums)));

		resultView.showReturnRate(lottoTickets.calcReturnRate(totalPrice));
	}
}

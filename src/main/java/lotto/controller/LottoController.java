package lotto.controller;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.LottoShop;
import lotto.domain.LottoTicket;
import lotto.domain.strategy.AutoGenerateStrategy;
import lotto.domain.strategy.GenerateStrategy;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
	public static void main(String[] args) {
		int ticketQuantity = new LottoShop().sellTicket(
			new InputView().inputTotalAmount()
		);

		new ResultView().showHowManyBuyTicket(ticketQuantity);

		GenerateStrategy strategy = new AutoGenerateStrategy();
		List<LottoTicket> lottoTickets = new ArrayList<>();
		for (int i = 0; i < ticketQuantity; i++) {
			lottoTickets.add(new LottoTicket(strategy));
		}
		new ResultView().showLottoTickets(lottoTickets);
	}
}

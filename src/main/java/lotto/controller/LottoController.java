package lotto.controller;

import java.util.List;

import lotto.domain.LottoTickets;
import lotto.domain.WinningInfo;
import lotto.domain.LottoShop;
import lotto.domain.LottoTicket;
import lotto.domain.WinningInfos;
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
		List<LottoTicket> tickets = lottoTickets.getLottoTickets();
		resultView.showLottoTickets(tickets);

		List<Integer> winningNums = StringSplitter.convertToIntegerList(inputView.inputWinningNumbers());
		lottoTickets.validTicket(winningNums);
		List<WinningInfo> results = lottoTickets.convertToWinningInfo();
		resultView.showResultStatics(results);

		WinningInfos winningInfos = new WinningInfos(results);
		Double returnRate = lottoTickets.calcReturnRate(winningInfos.sumAmountEachRank(), totalPrice);
		
		resultView.showReturnRate(returnRate);

	}
}

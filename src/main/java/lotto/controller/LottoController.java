package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lotto.domain.WinningInfo;
import lotto.domain.LottoShop;
import lotto.domain.LottoTicket;
import lotto.domain.LottoValidator;
import lotto.domain.Rank;
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

		String winningNumbers = new InputView().inputWinningNumbers();
		String[] winningNums = winningNumbers.split(", ");
		List<Integer> winningNumList = new ArrayList<>();
		for (String num : winningNums) {
			winningNumList.add(Integer.parseInt(num));
		}

		List<LottoTicket> updatedTicket = new ArrayList<>();
		for (LottoTicket ticket : lottoTickets) {
			updatedTicket.add(new LottoValidator(winningNumList).valid(ticket));
		}

		Map<Rank, Long> lottoResults = updatedTicket.stream()
			.collect(Collectors.groupingBy(LottoTicket::getRank, Collectors.counting()));
		List<WinningInfo> results = lottoResults.entrySet().stream()
			.map(r -> new WinningInfo(r.getKey(), r.getValue().intValue()))
			.collect(Collectors.toList());
		new ResultView().showResultStatics(results);
	}
}

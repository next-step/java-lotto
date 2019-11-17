package lotto.service;

import lotto.domain.LottoResult;
import lotto.domain.LottoTickets;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.io.IOException;

public class LottoService {

	private LottoTickets lottoTickets;
	private WinningNumbers winningNumbers;
	private LottoResult lottoResult;

	private static final int LOTTO_TICKET_PRICE = 1000;

	public static void main(String[] args) throws IOException {
		LottoService lottoService = new LottoService();
		lottoService.start();
	}

	private void start() throws IOException {
		int purchaseAmount = InputView.getPurchaseAmount();
		int ticketCount = purchaseAmount / LOTTO_TICKET_PRICE;
		ResultView.printTicketCount(ticketCount);

		lottoTickets = new LottoTickets(ticketCount);
		ResultView.printLottoTickets(lottoTickets);

		winningNumbers = new WinningNumbers(InputView.getWinningNumbers());
		ResultView.printWinningNumbers(winningNumbers);

		LottoResult lottoResult = new LottoResult();
		lottoResult.makeResult(lottoTickets, winningNumbers, purchaseAmount);

		ResultView.printResult(lottoResult);
	}

}

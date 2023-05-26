package step2.lotto;

import java.util.List;

import step2.lotto.domain.LottoTicket;
import step2.lotto.domain.LottoTickets;
import step2.lotto.domain.LottoWinningStatistic;
import step2.lotto.domain.LottoWinningStatisticDto;

public class Application {

	public static void main(String[] args) {
		start();
	}

	public static void start() {
		int lottoCount = ready();

		LottoWinningStatisticDto lottoWinningStatisticDto = run(lottoCount);

		terminate(lottoWinningStatisticDto);
	}

	private static LottoWinningStatisticDto run(int lottoCount) {

		LottoTickets lottoTickets = LottoTickets.create();
		lottoTickets.createManualTickets(lottoCount);

		LottoUI.printLottoTickets(lottoTickets);

		List<Integer> winningNumbers = LottoUI.uiForWinningNumbers();

		LottoWinningStatisticDto lottoWinningStatisticDto = lottoTickets.calculateStatistic(winningNumbers);

		return lottoWinningStatisticDto;
	}

	private static int ready() {
		int lottoCount = LottoUI.uiForLottoPurchase();

		return lottoCount;
	}

	private static void terminate(LottoWinningStatisticDto lottoWinningStatisticDto) {
		LottoUI.printLottoWinningStatistic(lottoWinningStatisticDto);
	}
}

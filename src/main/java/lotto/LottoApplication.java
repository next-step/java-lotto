package lotto;

import lotto.domain.AutoLottoTicketsStrategy;
import lotto.domain.LottoTickets;
import lotto.domain.ManualLottoTicketsStrategy;
import lotto.domain.WinningLottoTicket;
import lotto.view.BuyInfo;
import lotto.view.InputView;
import lotto.view.ResultView;

/**
 * @author : byungkyu
 * @date : 2020/12/14
 * @description :
 **/
public class LottoApplication {
	public static void main(String[] args) {
		//LottoTickets lottoTickets = InputView.requireCash();
		BuyInfo buyInfo = InputView.requireBuyInfo();

		Game manualChoiceLottoGame = new Game(new ManualLottoTicketsStrategy());
		LottoTickets manualChoiceLottoTickets = manualChoiceLottoGame.play(buyInfo);

		Game autoChoiceLottoGame = new Game(new AutoLottoTicketsStrategy());
		LottoTickets autoChoiceLottoTickets = autoChoiceLottoGame.play(buyInfo);

		//ResultView.printTicketCount(lottoTickets.getTicketCount());
		//ResultView.printTickets(lottoTickets.getLottoTickets());

		ResultView.printTicket(manualChoiceLottoTickets, autoChoiceLottoTickets);

		WinningLottoTicket winningLottoTicket = InputView.requireWinningNumber();
		//ResultView.printWinningStatistics(lottoTickets, winningLottoTicket);
	}
}

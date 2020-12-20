package lotto;

import lotto.domain.lottoTicketsStrategy.AutoLottoTicketsStrategy;
import lotto.domain.LottoTickets;
import lotto.domain.LottoWallet;
import lotto.domain.lottoTicketsStrategy.ManualLottoTicketsStrategy;
import lotto.domain.WinningLottoTicket;
import lotto.domain.BuyInfo;
import lotto.view.InputView;
import lotto.view.ResultView;

/**
 * @author : byungkyu
 * @date : 2020/12/14
 * @description :
 **/
public class LottoApplication {
	public static void main(String[] args) {
		BuyInfo buyInfo = InputView.requireBuyInfo();

		Game manualChoiceLottoGame = new Game(new ManualLottoTicketsStrategy());
		LottoTickets manualChoiceLottoTickets = manualChoiceLottoGame.play(buyInfo);

		Game autoChoiceLottoGame = new Game(new AutoLottoTicketsStrategy());
		LottoTickets autoChoiceLottoTickets = autoChoiceLottoGame.play(buyInfo);

		ResultView.printTicket(manualChoiceLottoTickets, autoChoiceLottoTickets);

		WinningLottoTicket winningLottoTicket = InputView.requireWinningNumber();

		LottoWallet lottoWallet = new LottoWallet(manualChoiceLottoTickets, autoChoiceLottoTickets);

		ResultView.printWinningStatistics(lottoWallet, winningLottoTicket);
	}
}

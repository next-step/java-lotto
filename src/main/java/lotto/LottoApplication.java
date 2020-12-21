package lotto;

import lotto.domain.lottoTicketsStrategy.AutoLottoTicketsStrategy;
import lotto.domain.LottoTickets;
import lotto.domain.LottoWallet;
import lotto.domain.lottoTicketsStrategy.LottoTicketsStrategy;
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

		LottoTicketsStrategy manualLottoGame = new ManualLottoTicketsStrategy();
		LottoTickets manualChoiceLottoTickets = manualLottoGame.play(buyInfo);

		LottoTicketsStrategy autoLottoGame = new AutoLottoTicketsStrategy();
		LottoTickets autoChoiceLottoTickets = autoLottoGame.play(buyInfo);

		ResultView.printTicket(manualChoiceLottoTickets, autoChoiceLottoTickets);

		WinningLottoTicket winningLottoTicket = InputView.requireWinningNumber();

		LottoWallet lottoWallet = new LottoWallet(manualChoiceLottoTickets, autoChoiceLottoTickets);

		ResultView.printWinningStatistics(lottoWallet, winningLottoTicket);
	}
}

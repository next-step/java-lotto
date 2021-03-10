package camp.nextcamp.edu.lotto.controller;

import java.util.List;
import java.util.Map;

import camp.nextcamp.edu.lotto.entity.Lotto;
import camp.nextcamp.edu.lotto.entity.LottoTicket;
import camp.nextcamp.edu.lotto.module.LottoModule;
import camp.nextcamp.edu.lotto.module.LottoScoreBoardModule;
import camp.nextcamp.edu.lotto.module.WinningScore;
import camp.nextcamp.edu.lotto.views.InputView;
import camp.nextcamp.edu.lotto.views.OutputView;

public class LottoController {
	private final LottoModule lottoModule;
	private final LottoScoreBoardModule scoreBoardModule;

	public LottoController() {
		this.lottoModule = LottoModule.getInstance();
		this.scoreBoardModule = LottoScoreBoardModule.getInstance();
	}

	public void run() {
		final InputView inputView = new InputView();
		final OutputView outputView = new OutputView();

		String money = inputView.getMoneyString();
		LottoTicket ticket = lottoModule.getLottoTicket(money);
		outputView.showLottoTicketCount(ticket);

		List<Lotto> purchasedLottos = lottoModule.getLottos(ticket);
		outputView.showPurchasedLottos(purchasedLottos);

		Lotto winningLotto = lottoModule.makeWinningLotto(inputView.getWinningLottoNumbers());

		Map<WinningScore, Long> winning = scoreBoardModule.getWinningScoreBoard(purchasedLottos, winningLotto);
		outputView.showResultStatistics(winning);

		double profit = scoreBoardModule.getProfit(winning, ticket);
		outputView.showProfit(profit);
	}
}

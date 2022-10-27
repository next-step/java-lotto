package step2.controller;

import java.util.HashMap;
import step2.model.Lotteries;
import step2.model.LottoFactory;
import step2.model.Payment;
import step2.model.Rank;
import step2.view.InputView;
import step2.view.OutputView;

public class LottoController {

	private static final OutputView OUTPUT_VIEW = new OutputView();
	private static final InputView INPUT_VIEW = new InputView();

	private Payment payment = new Payment();

	public void startLotto(LottoFactory lottoFactory) {
		int money = INPUT_VIEW.askMoneyForLotto();
		int totalTicket = payment.amountOfTicket(money);

		OUTPUT_VIEW.showTotalTicket(totalTicket);

		Lotteries lotteries = Lotteries.of(totalTicket, lottoFactory);
		OUTPUT_VIEW.showLotteries(totalTicket, lotteries);

		HashMap<Rank, Integer> totalCount = lotteries.isMatch(INPUT_VIEW.winNumber(),INPUT_VIEW.askBonusNumber());

		OUTPUT_VIEW.resultView(totalCount, lotteries.countOfMatchBonus());
		OUTPUT_VIEW.showRate(payment.calculateBenefit(money, totalCount));
	}
}

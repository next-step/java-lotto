package step2.controller;

import java.util.HashMap;
import step2.model.Lotteries;
import step2.model.Payment;
import step2.model.Rank;
import step2.view.InputView;
import step2.view.OutputView;

public class LottoController {

	private static final OutputView OUTPUT_VIEW = new OutputView();
	private static final InputView INPUT_VIEW = new InputView();
	private Payment payment = new Payment();


	public void startLotto() {

		int money = INPUT_VIEW.askMoneyForLotto();
		int totalTicket = payment.amountOfTicket(money);
		int handTicket = INPUT_VIEW.askForHand();
		payment.isValid(handTicket, totalTicket);

		int autoTicket = payment.autoTicket(totalTicket, handTicket);
		INPUT_VIEW.askHandNumber();// 수동 로또
		Lotteries lotteries = Lotteries.of(INPUT_VIEW.handNumber(), autoTicket);
		OUTPUT_VIEW.showTotalTicket(handTicket, autoTicket);
		OUTPUT_VIEW.showLotteries(totalTicket, lotteries);

		HashMap<Rank, Integer> totalCount =
			lotteries.isMatch(
				INPUT_VIEW.winNumber(),
				INPUT_VIEW.askBonusNumber());

		OUTPUT_VIEW.resultView(totalCount);

		OUTPUT_VIEW.showRate(
			payment.calculateBenefit(money, totalCount));
	}

}
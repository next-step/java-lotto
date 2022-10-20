package step2.controller;

import java.util.HashMap;
import step2.model.Lotteries;
import step2.model.LottoFactory;
import step2.model.Payment;
import step2.view.InputView;
import step2.view.OutputView;

public class LottoController {
	private static final OutputView OUTPUT_VIEW = new OutputView();
	private InputView inputView = new InputView();
	private Payment payment = new Payment();

	public void startLotto(LottoFactory lottoFactory) {

		int money = inputView.askMoneyForLotto();
		int totalTicket = payment.lottoAmount(money);
		OUTPUT_VIEW.showTotalTicket(totalTicket);

		Lotteries lotteries = Lotteries.of(totalTicket, lottoFactory);

		OUTPUT_VIEW.showLotteries(totalTicket, lotteries);

		HashMap<Integer, Integer> totalMatchMap = lotteries.isMatch(inputView.winnerNumList());

		OUTPUT_VIEW.resultView(totalMatchMap);
		OUTPUT_VIEW.showRate(payment.rateBenefit(money, totalMatchMap));

	}
}

package lotto;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;
import utils.IntegerUtils;

import java.util.ArrayList;
import java.util.List;

/*
 * 뷰에게 구입 금액을 요청한다
 * 구입 금액만큼 로또를 발급한다
 * 뷰에게 당첨 번호를 요청한다
 * 당첨 번호를 로또모델에게 전달하고 당첨된 번호 갯수를 받는다
 * 당첨된 로또 번호를 받아서 통계 모델에게 전달하여 수익률을 받는다
 * 뷰에게 수익률 출력을 요청한다
 */

public class LottoGame {
	private static InputView inputView = new InputView();
	private static OutputView outputView = new OutputView();
	private LottoStatistics lottoStatistics = new LottoStatistics();
	private LottoFactory lottoFactory = new LottoFactory();

	public void makeWish() {
		int budget = setBudget();
		int numberOfTickets = setTicketNumber(budget);
		List<LottoTicket> tickets = buyTickets(numberOfTickets);
		LottoNumbers winningNumbers = setWinningNumbers();
		LottoNumber bonusBall = setBonusBall();
		int prize = lottoFactory.calcPrize(new LottoNumberBonus(winningNumbers, bonusBall), tickets);
		double profit = lottoStatistics.calcProfit(prize, budget);

		showResult(profit);
	}

	public List<LottoTicket> buyTickets(int numberOfTickets) {
		List<LottoTicket> tickets = new ArrayList<>();

		for (int i = 0; i < numberOfTickets; i++) {
			tickets.add(new LottoTicket());
			outputView.printLottoNumbersView(tickets.get(i).getMyNumbers());
		}

		return tickets;
	}

	public int setTicketNumber(int budget) {
		int numberOfTickets = lottoStatistics.buyLottos(budget);
		outputView.howManyLottoTicketsView(numberOfTickets);
		return numberOfTickets;
	}

	private void showResult(double profit) {
		outputView.winningResultView();
		outputView.printEarningRateView(profit);
	}

	private int setBudget() {
		return inputView.inputBudgetView();
	}

	private LottoNumbers setWinningNumbers() {
		String str = inputView.inputWinningNumbersView();
		return IntegerUtils.splitAndParseLottoNumber(str);
	}

	private LottoNumber setBonusBall() {
		return inputView.inputBonusBallView();
	}
}

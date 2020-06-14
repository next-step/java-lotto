package lotto;

import lotto.model.LottoStatic;
import lotto.model.LottoTicket;
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

public class LottoStart {
	private static InputView inputView = new InputView();
	private static OutputView outputView = new OutputView();
	private LottoStatic lottoStatic = new LottoStatic();

	private static int budget;
	private static int numberOfTickets;
	private static int[] winningNumbers;
	private List<LottoTicket> tickets = new ArrayList<>();

	public void makeWish() {
		setBudget();
		setTicketNumber(budget);
		tickets = buyTickets();
		setWinningNumbers();

		for (int i = 0; i < numberOfTickets; i++) {
			tickets.get(i).announceRank(winningNumbers);
		}
	}

	public List<LottoTicket> buyTickets() {
		for (int i = 0; i < numberOfTickets; i++) {
			tickets.add(new LottoTicket());
			outputView.printLottoNumbersView(tickets.get(i).getMyNumbers());
		}

		return tickets;
	}

	public int setTicketNumber(int budget) {
		numberOfTickets = lottoStatic.buyLottos(budget);
		outputView.howManyLottoTicketsView(numberOfTickets);
		return numberOfTickets;
	}

	private void setBudget() {
		budget = inputView.inputBudgetView();
	}

	private void setWinningNumbers() {
		String str = inputView.inputWinningNumbersView();
		winningNumbers = IntegerUtils.splitAndParseInt(str);
	}
}

package lotto.controllers;

import java.util.List;

import lotto.Bank;
import lotto.Lotto;
import lotto.Ticket;
import lotto.enums.Message;
import lotto.enums.Prize;
import lotto.views.Display;

public class ResultController extends SimpleController {

	private List<Integer> scores;
	private long totalPrizeMoney;
	private float earningRate;

	public ResultController(Lotto lotto) {
		super(lotto);

		compute(loadTickets(), loadWinningTicket(), loadPayment());
	}

	@Override
	protected void show() {
		Display.show(Message.RESULT_HEAD);
		Display.show(Message.RESULT_3, scoreIn(Prize.THREE.getIndex()));
		Display.show(Message.RESULT_4, scoreIn(Prize.FOUR.getIndex()));
		Display.show(Message.RESULT_5, scoreIn(Prize.FIVE.getIndex()));
		Display.show(Message.RESULT_6, scoreIn(Prize.SIX.getIndex()));
		Display.show(Message.RESULT_TOTAL, this.totalPrizeMoney);
		Display.show(Message.RESULT_TAIL, this.earningRate);
	}

	private int scoreIn(int index) {
		return this.scores.get(index);
	}

	protected Ticket loadWinningTicket() {
		return this.lotto.storage().loadWinningTicket();
	}

	protected List<Ticket> loadTickets() {
		return this.lotto.storage().loadAutomatedTickets();
	}

	protected int loadPayment() {
		return this.lotto.storage().loadPurchase().payment();
	}

	protected void compute(List<Ticket> tickets, Ticket winningTicket, int payment) {
		this.scores = Bank.countScores(tickets, winningTicket);
		this.totalPrizeMoney = Bank.sumPrizeMoney(this.scores);
		this.earningRate = Bank.convertToEarningRate(this.totalPrizeMoney, payment);
	}

	protected void toNextController() {
		this.lotto.toEndController();
	}
}

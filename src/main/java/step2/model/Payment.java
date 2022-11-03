package step2.model;

import java.util.HashMap;
import step2.exception.MoneyException;

public class Payment {

	private static final int LOTTO_PRICE = 1000;
	private static final int DEFAULT_PRICE = 0;

	public int amountOfTicket(int cash) {
		if (cash < LOTTO_PRICE) {
			throw new MoneyException("금액이 부족합니다");
		}
		return cash / LOTTO_PRICE;
	}

	public double calculateBenefit(int cash, HashMap<Rank, Integer> totalCount) {
		int benefit = DEFAULT_PRICE;

		for (Rank rank : Rank.values()) {
			benefit += (rank.getWinningMoney() * totalCount.get(rank));
		}

		return benefit / (double) cash;
	}

	public int autoTicket(int totalTicket, int handCount) {
		return totalTicket - handCount;
	}

	public void isValid(int handTicket, int totalTicket) {
		if (handTicket > totalTicket) {
			throw new MoneyException("금액이 부족합니다");
		}
	}
}

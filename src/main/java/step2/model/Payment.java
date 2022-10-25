package step2.model;

import java.util.HashMap;
import step2.exception.MoneyException;

public class Payment {

	private static final int LOTTO_PRICE = 1000;
	private static final int MIN_MATCH = 3;
	private static final int MAX_MATCH = 6;
	private static final int DEFAULT_PRICE = 0;

	public int lottoAmount(int cash) {
		if (cash < LOTTO_PRICE) {
			throw new MoneyException("금액이 부족합니다");
		}

		if ((cash % LOTTO_PRICE) > DEFAULT_PRICE) {
			throw new MoneyException("1000원 단위로만 입력해주세요");
		}
		return cash / LOTTO_PRICE;
	}

	public double isProfit(int cash, HashMap<Integer, Integer> totalCount) {
		int benefit = DEFAULT_PRICE;

		for (int matchNumber = MIN_MATCH; matchNumber <= MAX_MATCH; matchNumber++) {
			Rank rank = Rank.of(matchNumber);
			benefit += (rank.getWinningMoney() * totalCount.get(matchNumber));
		}

		return benefit / (double) cash;

	}

}

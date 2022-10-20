package step2.model;

import java.util.HashMap;
import step2.exception.LackOfMoneyException;

public class Payment {

	private static final int LOTTO_PRICE = 1000;
	private static final int MIN_MATCH = 3;
	private static final int MAX_MATCH = 6;
	private static int benefit = 0;

	public int lottoAmount(int cash) {
		if (cash < LOTTO_PRICE) {
			throw new LackOfMoneyException("금액이 부족합니다");
		}
		return cash / LOTTO_PRICE;
	}

	public String rateBenefit(int cash, HashMap<Integer, Integer> totalCountMap) {

		for (int i = MIN_MATCH; i < MAX_MATCH + 1; i++) {
			calculate(i, totalCountMap);
		}

		return String.format("%.2f", benefit / (double) cash);

	}

	private void calculate(int matchNum, HashMap<Integer, Integer> totalCountMap) {

		if (matchNum == 3) {
			benefit += (5000 * totalCountMap.get(3));
		}
		if (matchNum == 4) {
			benefit += (50000 * totalCountMap.get(4));
		}
		if (matchNum == 5) {
			benefit += (1500000 * totalCountMap.get(5));
		}
		if (matchNum == 6) {
			benefit += (2000000000 * totalCountMap.get(6));
		}

	}
}

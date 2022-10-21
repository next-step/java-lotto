package step2.model;

import java.util.HashMap;
import step2.exception.MoneyException;

public class Payment {

	private static final int LOTTO_PRICE = 1000;
	private static final int MIN_MATCH = 3;
	private static final int MAX_MATCH = 6;
	private static final int DEFAULT = 0;
	private static int benefit = 0;


	public int lottoAmount(int cash) {
		if (cash < LOTTO_PRICE) {
			throw new MoneyException("금액이 부족합니다");
		}

		if ((cash % LOTTO_PRICE) > DEFAULT) {
			throw new MoneyException("1000원 단위로만 입력해주세요");
		}
		return cash / LOTTO_PRICE;
	}

	public double rateBenefit(int cash, HashMap<Integer, Integer> totalCountMap) {

		for (int i = MIN_MATCH; i < MAX_MATCH + 1; i++) {
			calculate(i, totalCountMap);
		}

		return benefit / (double) cash;

	}

	private void calculate(int matchNum, HashMap<Integer, Integer> totalCountMap) {

		if (matchNum == MIN_MATCH) {
			benefit += (5000 * totalCountMap.get(3));
		}
		if (matchNum == MIN_MATCH + 1) {
			benefit += (50000 * totalCountMap.get(4));
		}
		if (matchNum == MIN_MATCH + 2) {
			benefit += (1500000 * totalCountMap.get(5));
		}
		if (matchNum == MAX_MATCH) {
			benefit += (2000000000 * totalCountMap.get(6));
		}

	}
}

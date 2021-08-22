package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoCard {
	private static final int LOTTO_START_NUMBER = 1;
	private static final int LOTTO_END_NUMBER = 45;
	public static List<Integer> NUMBERS = new ArrayList<>();

	static {
		for (int i = LOTTO_START_NUMBER; i <= LOTTO_END_NUMBER; i++) {
			NUMBERS.add(i);
		}
	}
}

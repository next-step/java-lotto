package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {

	private static final int LOTTO_END_SIZE = 6;
	private static final int LOTTO_START_SIZE = 0;
	private static final int LOTTO_START_NUMBER = 1;
	private static final int LOTTO_END_NUMBER = 46;

	private LottoMachine() {
	}

	public static List<Integer> createLottoNumber() {
		List<Integer> lottoBalls = new ArrayList<>();
		for (int i = LOTTO_START_NUMBER; i < LOTTO_END_NUMBER; i++) {
			lottoBalls.add(i);
		}
		Collections.shuffle(lottoBalls);
		return lottoBalls.subList(LOTTO_START_SIZE, LOTTO_END_SIZE);
	}
}

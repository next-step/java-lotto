package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {

	private static final int LOTTO_END_SIZE = 6;
	private static final int LOTTO_START_SIZE = 0;
	private static final int LOTTO_START_NUMBER = 1;
	private static final int LOTTO_END_NUMBER = 46;
	public static final String LOTTO_MACHINE_CREATE_MESSAGE = "로또기계 생성은 불가능 합니다.";
	public static final List<Integer> lottoBalls = new ArrayList<>();

	static {
		for (int i = LOTTO_START_NUMBER; i < LOTTO_END_NUMBER; i++) {
			lottoBalls.add(i);
		}
	}

	private LottoMachine() {
		throw new AssertionError(LOTTO_MACHINE_CREATE_MESSAGE);
	}

	public static List<Integer> createLottoNumber() {
		Collections.shuffle(lottoBalls);
		return lottoBalls.subList(LOTTO_START_SIZE, LOTTO_END_SIZE);
	}

}

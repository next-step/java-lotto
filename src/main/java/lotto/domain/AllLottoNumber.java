package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class AllLottoNumber {
	private static final int MIN_LOTTO_NUMBER = 1;
	private static final int MAX_LOTTO_NUMBER = 45;
	private static final int LOTTO_SIZE = 6;

	private static final List<LottoNumber> allLottoNumber;

	static {
		allLottoNumber = initializeAllLottoNumber();
	}

	private static List<LottoNumber> initializeAllLottoNumber() {
		List<LottoNumber> allLottoNumber = new ArrayList<>();

		for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
			allLottoNumber.add(new LottoNumber(i));
		}

		return allLottoNumber;
	}

	public static Set<LottoNumber> randomLottoNumber() {
		Collections.shuffle(allLottoNumber);

		return new HashSet<>(allLottoNumber.subList(0, LOTTO_SIZE));
	}
}

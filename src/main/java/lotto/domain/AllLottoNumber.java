package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllLottoNumber {
	private static final int MIN_LOTTO_NUMBER = 1;
	private static final int MAX_LOTTO_NUMBER = 45;
	private static final int LOTTO_NUMBERS_LENGTH = 6;

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

		return limitLength(toSet());
	}

	private static Set<LottoNumber> toSet() {
		return new HashSet<>(AllLottoNumber.allLottoNumber);
	}

	private static Set<LottoNumber> limitLength(final Set<LottoNumber> lottoNumbers) {
		if (lottoNumbers.size() != LOTTO_NUMBERS_LENGTH) {
			throw new IllegalArgumentException("로또넘버 개수는 6개여야 합니다.");
		}

		return lottoNumbers;
	}
}

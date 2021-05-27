package lotto.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public class LottoGenerator {

	private LottoGenerator() {
	}

	public static Lotto generate() {
		List<LottoNumber> allNumbers = getAllLottoNumbers();
		shuffleAllNumbers(allNumbers);
		return getAutoLotto(allNumbers);
	}

	private static List<LottoNumber> getAllLottoNumbers() {
		List<LottoNumber> allNumbers = new ArrayList<>();
		int number = LottoNumber.MIN_LOTTO_NUMBER;
		while (number < LottoNumber.MAX_LOTTO_NUMBER) {
			LottoNumber lottoNumber = LottoNumber.of(number);
			allNumbers.add(lottoNumber);
			number++;
		}
		return allNumbers;
	}

	private static void shuffleAllNumbers(List<LottoNumber> allNumbers) {
		Collections.shuffle(allNumbers);
	}

	private static Lotto getAutoLotto(List<LottoNumber> allNumbers) {
		return new Lotto(allNumbers.subList(0, Lotto.LOTTO_NUMBER_SIZE));
	}

}

package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoNumberAutoGenerator{

	private static final List<Integer> LOTTO_TOTAL_NUMBERS = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
		11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34,
		35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45);

	private LottoNumberAutoGenerator() {
		throw new AssertionError();
	}

	public static LottoNumber generate() {
		shuffle();
		List<Integer> lottoNumbers = subList();
		sort(lottoNumbers);
		return new LottoNumber(lottoNumbers);
	}

	private static void shuffle() {
		Collections.shuffle(LOTTO_TOTAL_NUMBERS);
	}

	private static List<Integer> subList() {
		return new ArrayList<>(LOTTO_TOTAL_NUMBERS.subList(0, 6));
	}

	private static void sort(List<Integer> numbers) {
		Collections.sort(numbers);
	}
}

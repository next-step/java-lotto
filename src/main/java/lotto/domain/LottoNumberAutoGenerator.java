package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberAutoGenerator{

	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 45;
	private static final List<Integer> LOTTO_TOTAL_NUMBERS = new ArrayList<>();

	static {
		for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
			LOTTO_TOTAL_NUMBERS.add(i);
		}
	}

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

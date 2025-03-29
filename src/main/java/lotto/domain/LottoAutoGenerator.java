package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoAutoGenerator {
	private static final int LOTTO_SIZE = 6;
	private static final int LOTTO_MIN_NUMBER = 1;
	private static final int LOTTO_MAX_NUMBER = 45;
	private static final List<Integer> BASE_NUMBERS = generateBaseNumbers();

	private static List<Integer> generateBaseNumbers() {
		List<Integer> numbers = new ArrayList<>();
		for (int i = LOTTO_MIN_NUMBER; i <= LOTTO_MAX_NUMBER; i++) {
			numbers.add(i);
		}
		return List.copyOf(numbers);
	}

	public List<Integer> generateLottoTicket() {
		List<Integer> numbers = new ArrayList<>(BASE_NUMBERS);
		Collections.shuffle(numbers);
		List<Integer> lottoNumbers = numbers.subList(0, LOTTO_SIZE);
		Collections.sort(lottoNumbers);
		return lottoNumbers;
	}
}

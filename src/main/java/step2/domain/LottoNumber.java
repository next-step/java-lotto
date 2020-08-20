package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumber {
	private static final int MAX_LOTTO_VALUE = 45;
	private static final int MAX_LOTTO_NUMBER = 6;
	private static final List<Integer> lottoValues;

	static {
		lottoValues = new ArrayList<>();
		for (int i = 0; i < MAX_LOTTO_VALUE; i++) {
			lottoValues.add(i+1);
		}
	}

	public List<Integer> getRandomNumbers() {
		Collections.shuffle(lottoValues);
		List<Integer> randomValues = new ArrayList<>(lottoValues.subList(0, MAX_LOTTO_NUMBER));
		Collections.sort(randomValues);
		return randomValues;
	}
}

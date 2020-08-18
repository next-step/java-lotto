package step2;

import java.util.Arrays;
import java.util.Collections;

public class LottoNumber {
	private static final int MAX_LOTTO_VALUE = 45;
	private static final int MAX_LOTTO_NUMBER = 6;
	private static Integer[] lottoValues;

	public LottoNumber() {
		lottoValues = new Integer[MAX_LOTTO_VALUE];
		for (int i = 0; i < MAX_LOTTO_VALUE; i++) {
			lottoValues[i] = i+1;
		}
	}

	public Integer[] getAutoLotto() {
		Integer[] randomValues = new Integer[MAX_LOTTO_NUMBER];
		Collections.shuffle(Arrays.asList(lottoValues));
		System.arraycopy(lottoValues, 0, randomValues, 0, MAX_LOTTO_NUMBER);
		Arrays.sort(randomValues);
		return randomValues;
	}
}

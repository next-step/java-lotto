package domain;

import java.util.*;

public class LottoNumberGenerator {

	private static final Integer LOTTO_ALL_NUMBER_RANGE = 45;
	private static final Integer LOTTO_NUMBER_RANGE = 6;
	private static final Integer INIT_NUMBER = 1;

	private List<Number> lottoAllNumber;

	public LottoNumberGenerator() {
		lottoAllNumber = new ArrayList<>();
		for (int number = INIT_NUMBER ; number <= LOTTO_ALL_NUMBER_RANGE ; ++number) {
			lottoAllNumber.add(new Number(number));
		}
	}

	public Lotto getLottoNumber() {
		List<Number> lottoNumber = new ArrayList<>();
		Collections.shuffle(lottoAllNumber);
		for (int number = INIT_NUMBER ; number <= LOTTO_NUMBER_RANGE ; ++number) {
			lottoNumber.add(lottoAllNumber.get(number));
		}
		Collections.sort(lottoNumber);
		return new Lotto(lottoNumber);
	}
}

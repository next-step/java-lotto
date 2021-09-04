package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator {

	private static final Integer LOTTO_ALL_NUMBER_RANGE = 45;
	private static final Integer LOTTO_NUMBER_RANGE = 6;
	private static final Integer INIT_NUMBER = 1;

	private List<Integer> lottoAllNumber;

	public LottoNumberGenerator() {
		lottoAllNumber = new ArrayList<>();
		for (int i = INIT_NUMBER ; i <= LOTTO_ALL_NUMBER_RANGE ; ++i) {
			lottoAllNumber.add(i);
		}
	}

	public Lotto getLottoNumber() {
		List<Integer> lottoNumber = new ArrayList<>();
		Collections.shuffle(lottoAllNumber);
		for (int i = INIT_NUMBER ; i <= LOTTO_NUMBER_RANGE ; ++i) {
			lottoNumber.add(lottoAllNumber.get(i));
		}
		Collections.sort(lottoNumber);
		System.out.println(lottoNumber);
		return new Lotto(lottoNumber);
	}
}

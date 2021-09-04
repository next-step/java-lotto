package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberGenerator {

	private static final Integer LOTTO_ALL_NUMBER_RANGE = 45;
	private static final Integer LOTTO_NUMBER_RANGE = 6;

	private List<Integer> lottoAllNumber;

	public LottoNumberGenerator() {
		lottoAllNumber = new ArrayList<>();
		for (int i = 1 ; i <= LOTTO_ALL_NUMBER_RANGE ; ++i) {
			lottoAllNumber.add(i);
		}
	}

	public List<Integer> getLottoNumber() {
		List<Integer> lottoNumber = new ArrayList<>();
		Collections.shuffle(lottoAllNumber);
		for (int i = 1 ; i <= LOTTO_NUMBER_RANGE ; ++i) {
			lottoNumber.add(lottoAllNumber.get(i));
		}
		Collections.sort(lottoNumber);
		return lottoNumber;
	}
}

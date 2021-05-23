package lotto.generator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lotto.LottoNumber;
import lotto.LottoNumbers;
import lotto.converter.NumberToLotto;

public class AutoLottoNumberGenerator implements Generator {

	private static final int LOTTO_START = 1;
	private static final int LOTTO_END = 46;

	private static final int RANDOM_RANGE_START = 0;
	private static final int RANDOM_RANGE_END = 6;

	private final List<Integer> LOTTO_RANDOM_SET;

	public AutoLottoNumberGenerator() {
		LOTTO_RANDOM_SET = new ArrayList<>(LOTTO_END);
		init();
	}

	public AutoLottoNumberGenerator(List<Integer> numbers) {
		LOTTO_RANDOM_SET = numbers;
	}

	private void init() {
		for (int i = LOTTO_START; i <= LOTTO_END; i++) {
			LOTTO_RANDOM_SET.add(i);
		}
	}

	@Override
	public LottoNumbers generate() {
		List<Integer> pickedNumbers = pickNumbers();
		Collections.sort(pickedNumbers);
		List<LottoNumber> lottoNumberList = NumberToLotto.convert(pickedNumbers);
		return appendLottoNumber(lottoNumberList);
	}

	private LottoNumbers appendLottoNumber(List<LottoNumber> lottoNumberList) {
		LottoNumbers result = new LottoNumbers();
		for (LottoNumber lottoNumber : lottoNumberList) {
			result.add(lottoNumber);
		}
		return result;
	}

	private List<Integer> pickNumbers() {
		shuffle();
		return LOTTO_RANDOM_SET.subList(RANDOM_RANGE_START, RANDOM_RANGE_END);
	}

	private void shuffle() {
		Collections.shuffle(LOTTO_RANDOM_SET);
	}

}

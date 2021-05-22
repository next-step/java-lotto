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

	private static final List<Integer> LOTTO_RANDOM_SET = new ArrayList<>(LOTTO_END);

	public AutoLottoNumberGenerator() {
		init();
	}

	private void init() {
		for (int i = LOTTO_START; i <= LOTTO_END; i++) {
			LOTTO_RANDOM_SET.add(i);
		}
	}

	@Override
	public void generate(LottoNumbers lottoNumbers) {
		List<Integer> pickedNumbers = pickNumbers();
		Collections.sort(pickedNumbers);
		List<LottoNumber> lottoNumberList = NumberToLotto.convert(pickedNumbers);
		for (LottoNumber lottoNumber : lottoNumberList) {
			lottoNumbers.add(lottoNumber);
		}
	}

	private List<Integer> pickNumbers() {
		shuffle();
		return LOTTO_RANDOM_SET.subList(RANDOM_RANGE_START, RANDOM_RANGE_END);
	}

	private void shuffle() {
		Collections.shuffle(LOTTO_RANDOM_SET);
	}

}

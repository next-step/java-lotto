package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbers {

	private static final int LOTTO_SIZE = 6;

	private final List<LottoNumber> lottoNumbers;

	public LottoNumbers() {
		lottoNumbers = new ArrayList<>(LOTTO_SIZE);
	}

	public void add(LottoNumber lottoNumber) {
		if (!isLessThan()) {
			return;
		}
		lottoNumbers.add(lottoNumber);
	}

	public boolean isComplete() {
		return lottoNumbers.size() == LOTTO_SIZE;
	}

	private boolean isLessThan() {
		return lottoNumbers.size() <= LOTTO_SIZE && !isComplete();
	}
}

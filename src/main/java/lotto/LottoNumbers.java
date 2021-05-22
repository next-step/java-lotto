package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbers {

	private static final int LOTTO_SIZE = 6;

	private List<LottoNumber> lottoNumbers;

	public LottoNumbers() {
		lottoNumbers = new ArrayList<>(LOTTO_SIZE);
	}

	public void add(LottoNumber lottoNumber) {
		lottoNumbers.add(lottoNumber);
		Collections.shuffle(lottoNumbers);
	}

	public boolean isComplete() {
		return lottoNumbers.size() == 6;
	}
}

package lotto.model;

import java.util.Collections;
import java.util.List;

public class Lotto {

	private final List<Integer> lottoNumbers;

	public Lotto(List<Integer> lottoNumbers) {
		this.lottoNumbers = lottoNumbers;
		Collections.sort(this.lottoNumbers);
	}

	public List<Integer> getLotto() {
		return lottoNumbers;
	}
}

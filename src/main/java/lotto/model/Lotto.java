package lotto.model;

import java.util.Collections;
import java.util.List;

public class Lotto {

	private final List<Integer> lottoNumbers;

	public Lotto(List<Integer> lottoNumbers) {
		Collections.sort(lottoNumbers);
		this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
	}

	public List<Integer> getLottoNumbers() {
		return lottoNumbers;
	}
}

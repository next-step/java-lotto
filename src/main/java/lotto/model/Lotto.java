package lotto.model;

import java.util.Collections;
import java.util.List;

public class Lotto {

	private final List<LottoNumber> lottoNumbers;

	public Lotto(List<LottoNumber> lottoNumbers) {
		this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
	}

	public List<LottoNumber> getLottoNumbers() {
		return lottoNumbers;
	}
}

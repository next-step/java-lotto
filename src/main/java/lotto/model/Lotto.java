package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

	private final List<Integer> lottoNumbers;

	public Lotto(List<Integer> lottoNumbers) {
		Collections.sort(lottoNumbers);
		this.lottoNumbers = new ArrayList<>();
		this.lottoNumbers.addAll(Collections.unmodifiableList(lottoNumbers));
	}

	public List<Integer> getLotto() {
		return lottoNumbers;
	}
}

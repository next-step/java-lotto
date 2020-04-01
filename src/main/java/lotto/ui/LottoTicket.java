package lotto.ui;

import java.util.Collections;
import java.util.List;

public class LottoTicket {
	private final List<Integer> lottoNumbers;

	public LottoTicket(List<Integer> lottoNumbers) {
		this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
	}

	public List<Integer> getLottoNumbers() {
		return lottoNumbers;
	}
}

package lotto;

import java.util.Collections;
import java.util.List;

public class LottoList {
	private final List<Lotto> lottoList;

	public LottoList(List<Lotto> lottoList) {
		this.lottoList = lottoList;
	}

	public List<Lotto> lottoList() {
		return Collections.unmodifiableList(this.lottoList);
	}
}

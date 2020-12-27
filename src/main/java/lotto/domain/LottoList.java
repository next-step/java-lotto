package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoList {

	private List<Lotto> lottoList = new ArrayList<>();

	public LottoList() {
	}

	public void add(Lotto lotto) {
		this.lottoList.add(lotto);
	}

	public List<Lotto> getLottoList() {
		return lottoList;
	}
}

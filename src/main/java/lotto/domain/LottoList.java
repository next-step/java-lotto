package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoList {

	private List<Lotto> lottosList = new ArrayList<>();

	public LottoList() {
	}

	public void add(Lotto lotto) {
		this.lottosList.add(lotto);
	}

	public List<Lotto> getLottosList() {
		return lottosList;
	}
}

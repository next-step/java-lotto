package lotto.domain.result;

import lotto.domain.result.MatchResultPerLotto;

import java.util.ArrayList;
import java.util.List;

public class LottoMatchResultList {
	List<MatchResultPerLotto> matchResultPerLottos = new ArrayList<>();

	public LottoMatchResultList() {
	}

	public LottoMatchResultList(List<MatchResultPerLotto> matchResultPerLottos) {
		this.matchResultPerLottos = matchResultPerLottos;
	}

	public void add(MatchResultPerLotto matchResultPerLotto) {
		this.matchResultPerLottos.add(matchResultPerLotto);
	}

	public List<MatchResultPerLotto> getLottoMatchResults() {
		return matchResultPerLottos;
	}
}

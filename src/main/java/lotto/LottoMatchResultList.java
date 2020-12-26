package lotto;

import lotto.domain.LottoMatchResult;

import java.util.ArrayList;
import java.util.List;

public class LottoMatchResultList {
	List<LottoMatchResult> lottoMatchResults = new ArrayList<>();

	public void add(LottoMatchResult lottoMatchResult) {
		this.lottoMatchResults.add(lottoMatchResult);
	}

	public List<LottoMatchResult> getLottoMatchResults() {
		return lottoMatchResults;
	}
}

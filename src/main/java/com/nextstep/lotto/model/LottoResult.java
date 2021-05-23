package com.nextstep.lotto.model;

import java.util.List;

public class LottoResult {

	private List<LottoMatch> lottoMatches;

	public LottoResult(List<LottoMatch> lottoMatches) {
		this.lottoMatches = lottoMatches;
	}

	public List<LottoMatch> lottoMatches() {
		return this.lottoMatches;
	}
}

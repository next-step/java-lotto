package com.nextstep.lotto.result;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoResult {
	private List<LottoRank> results = new ArrayList<>();

	public void addResult(LottoRank lottoRank) {
		this.results.add(lottoRank);
	}

	public int size() {
		return this.results.size();
	}

	public double revenueRatio(int money) {
		double sumReward = 0;
		for (LottoRank lottoRank : results) {
			sumReward += lottoRank.getReward();
		}
		return sumReward / money;
	}

	public Map<LottoRank, Long> statistics() {
		return this.results.stream()
			.filter(lottoRank -> lottoRank.getMatchCount() > 0)
			.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	}
}

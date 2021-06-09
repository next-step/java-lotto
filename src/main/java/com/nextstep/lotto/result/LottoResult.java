package com.nextstep.lotto.result;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LottoResult {
	private List<LottoRank> results = new ArrayList<>();

	public void addResult(LottoRank lottoRank) {
		this.results.add(lottoRank);
	}

	public int size() {
		return this.results.size();
	}

	public double revenueRatio(int money) {
		int sumReward = 0;
		for (LottoRank lottoRank : results) {
			sumReward += lottoRank.getReward();
		}
		return sumReward / money;
	}

	public Map<LottoRank, Integer> statistics() {
		Map<LottoRank, Integer> resultMap = setUpMap();
		this.results.stream()
			.filter(lottoRank -> lottoRank.getMatchCount() > 0)
			.forEach(lottoRank -> resultMap.put(lottoRank, resultMap.getOrDefault(lottoRank, 0) + 1));

		return resultMap;
	}

	private Map<LottoRank, Integer> setUpMap() {
		Map<LottoRank, Integer> map = new TreeMap<>();
		Arrays.asList(LottoRank.values())
			.stream()
			.filter(lottoRank -> lottoRank.getMatchCount() > 0)
			.forEach(lottoRank -> map.put(lottoRank, 0));

		return map;
	}
}

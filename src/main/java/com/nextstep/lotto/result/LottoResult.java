package com.nextstep.lotto.result;

import java.util.ArrayList;
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

	public Map<Integer, Integer> statistics() {
		Map<Integer, Integer> resultMap = setUpMap();
		for (LottoRank lottoRank : this.results) {
			if (lottoRank.getMatchCount() > 0) {
				resultMap.put(lottoRank.getMatchCount(), resultMap.getOrDefault(lottoRank.getMatchCount(), 0) + 1);
			}
		}
		return resultMap;
	}

	private Map<Integer, Integer> setUpMap() {
		Map<Integer, Integer> map = new TreeMap<>();
		for (int i = LottoRank.FIFTH_RANK.getMatchCount(); i <= LottoRank.FIRST_RANK.getMatchCount(); i++) {
			map.put(i, 0);
		}
		return map;
	}
}

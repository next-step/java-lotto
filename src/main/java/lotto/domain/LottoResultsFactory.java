package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoResultsFactory {
	public static LottoResults create(List<LottoRank> lottoRanks) {
		return new LottoResults(mapToResults(lottoRanks));
	}

	private static List<LottoResult> mapToResults(List<LottoRank> lottoRanks) {
		return mapToResults(mapToCountMap(lottoRanks));
	}

	private static List<LottoResult> mapToResults(Map<LottoRank, Integer> lottoRankCountMap) {
		return lottoRankCountMap.entrySet()
			.stream()
			.map(entry -> new LottoResult(entry.getKey(), entry.getValue()))
			.collect(Collectors.toList());
	}

	private static Map<LottoRank, Integer> mapToCountMap(List<LottoRank> lottoRanks) {
		return lottoRanks.stream()
			.collect(
				Collectors.groupingBy(
					Function.identity(), Collectors.reducing(0, lottoRank -> 1, Integer::sum)
				));
	}
}

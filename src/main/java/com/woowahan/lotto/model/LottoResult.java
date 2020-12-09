package com.woowahan.lotto.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

	private final List<Lotto> lottos;
	private final Map<LottoResultType, Integer> results;

	private LottoResult(WinNumberInput winInput, List<Lotto> lottos) {
		this.lottos = lottos;
		this.results = new HashMap<>();
		Arrays.stream(LottoResultType.values())
			.forEach(resultType -> results.put(resultType, 0));
		compareWinNumber(winInput, lottos);
	}

	public static LottoResult analyze(
		WinNumberInput winInput,
		List<Lotto> lottos
	) {
		return new LottoResult(winInput, lottos);
	}

	private void compareWinNumber(WinNumberInput winInput, List<Lotto> lottos) {
		List<Integer> winNumbers = winInput.getWinNumbers();
		for (Lotto lotto : lottos) {
			List<Integer> lottoNumbers = lotto.getNumbers();
			int matchCount = (int)lottoNumbers.stream()
				.filter(winNumbers::contains)
				.count();
			LottoResultType resultType = LottoResultType.getResultTypeByMatchCount(matchCount);
			increaseCntByResultType(resultType);
		}
	}

	private void increaseCntByResultType(LottoResultType resultType) {
		Integer value = results.get(resultType);
		results.put(resultType, ++value);
	}

	public List<Lotto> getLottos() {
		return lottos;
	}

	public Map<LottoResultType, Integer> getResults() {
		return results;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("LottoResult{");
		sb.append("lottos=").append(lottos);
		sb.append(", results=").append(results);
		sb.append('}');
		return sb.toString();
	}
}

package lotto;

import java.util.List;
import java.util.Objects;

public class LottoResults {
	private final List<LottoResult> lottoResults;

	private LottoResults(List<LottoResult> lottoResults) {
		this.lottoResults = lottoResults;
	}

	public static LottoResults of(List<LottoResult> lottoResults) {
		return new LottoResults(lottoResults);
	}

	public Money sumResultMoney() {
		Integer sum = lottoResults.stream()
			.map(LottoResult::getMoney)
			.reduce(0, ((partialResult, money2) -> money2.sum(partialResult)), Integer::sum);
		return Money.of(sum);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		LottoResults that = (LottoResults)obj;
		return Objects.equals(lottoResults, that.lottoResults);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lottoResults);
	}
}

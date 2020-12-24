package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoResults {
	private final List<LottoResult> lottoResults;

	private LottoResults(List<LottoResult> lottoResults) {
		this.lottoResults = Collections.unmodifiableList(lottoResults);
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

	public double calculateReturnRate(int money) {
		ReturnRate returnRate = ReturnRate.calculate(money, this);
		return returnRate.get();
	}

	public int count(LottoResult lottoResult) {
		return (int) lottoResults.stream()
			.filter(lottoResult::equals)
			.count();
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

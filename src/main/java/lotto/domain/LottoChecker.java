package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoChecker {
	private final LottoNumber winningNumbers;
	private final long spentMoney;

	public LottoChecker(LottoNumber winningNumbers, long spentMoney) {
		this.winningNumbers = winningNumbers;
		this.spentMoney = spentMoney;
	}

	public LottoResult getWinningResult(LottoNumber... applyNumbers) {
		return getWinningResult(Arrays.asList(applyNumbers));
	}

	public LottoResult getWinningResult(List<LottoNumber> applyNumbers) {
		Map<LottoRank, Long> map = applyNumbers.stream()
				.map(lottoNumber -> lottoNumber.matchLottoNumber(winningNumbers))
				.filter(Objects::nonNull)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		return new LottoResult(map, spentMoney);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		LottoChecker that = (LottoChecker) o;
		return Objects.equals(winningNumbers, that.winningNumbers);
	}

	@Override
	public int hashCode() {
		return Objects.hash(winningNumbers);
	}
}

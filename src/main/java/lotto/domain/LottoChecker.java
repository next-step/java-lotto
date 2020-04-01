package lotto.domain;

import lotto.dto.LottoNumberDto;
import lotto.dto.LottoStatisticsDto;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoChecker {
	private final LottoWinningNumber wonNumbers;
	private final long spentMoney;

	public LottoChecker(LottoNumberDto wonNumbers, int wonBonusNumber, long spentMoney) {
		this.wonNumbers = new LottoWinningNumber(new LottoNumber(wonNumbers.getNumbers()), LottoNo.getInstance(wonBonusNumber));
		this.spentMoney = spentMoney;
	}

	LottoStatisticsDto getWinningResult(LottoNumberDto... applyNumbers) {
		return getWinningResult(Arrays.asList(applyNumbers));
	}

	public LottoStatisticsDto getWinningResult(List<LottoNumberDto> applyNumbers) {
		Map<LottoRank, Long> map = applyNumbers.stream()
				.map(LottoNumberDto::getNumbers)
				.map(LottoNumber::new)
				.map(wonNumbers::matchLottoNumber)
				.filter(Objects::nonNull)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		return new LottoStatisticsDto(map, spentMoney);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		LottoChecker that = (LottoChecker) o;
		return Objects.equals(wonNumbers, that.wonNumbers);
	}

	@Override
	public int hashCode() {
		return Objects.hash(wonNumbers);
	}
}

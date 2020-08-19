package step2.domain;

import step2.constants.PrizeGrade;
import step2.constants.RateOfReturn;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import static step2.constants.MessageConstant.RATE_OF_RETURN_FORMAT;

public class ConfirmResults {

	private final Map<PrizeGrade, Integer> groupedByPrizeGrade;

	private static final int ZERO = 0;
	private static final int INCREASE = 1;

	public ConfirmResults(List<PrizeGrade> prizeGrades) {
		this.groupedByPrizeGrade = getGroupByPrizeGrade(prizeGrades);
	}

	public Map<PrizeGrade, Integer> getGroupedByPrizeGrade() {
		return groupedByPrizeGrade;
	}

	public long getPrizeRewardSum() {
		return groupedByPrizeGrade.keySet()
				.stream()
				.mapToLong(PrizeGrade::getReward)
				.reduce(ZERO, Long::sum);
	}

	public String computeRateOfReturn(PurchaseStandBy purchaseStandBy) {
		long prizeRewardSum = this.getPrizeRewardSum();
		double rateOfReturn = (double) prizeRewardSum / (double) purchaseStandBy.getPurchasePrice();
		return String.format(RATE_OF_RETURN_FORMAT, rateOfReturn, RateOfReturn.of(rateOfReturn).getMessage());
	}

	private Map<PrizeGrade, Integer> getGroupByPrizeGrade(List<PrizeGrade> prizeGrades) {
		return prizeGrades.stream()
							.filter(prizeGrade -> prizeGrade != PrizeGrade.FAIL)
							.collect(Collectors.groupingBy(Function.identity(),
										Collectors.summingInt(confirmResult -> INCREASE)));
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ConfirmResults that = (ConfirmResults) o;
		return groupedByPrizeGrade.equals(that.groupedByPrizeGrade);
	}

	@Override
	public int hashCode() {
		return Objects.hash(groupedByPrizeGrade);
	}
}

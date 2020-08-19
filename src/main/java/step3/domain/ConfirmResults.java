package step3.domain;

import step3.constants.PrizeGrade;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

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
		return groupedByPrizeGrade.entrySet()
				.stream()
				.filter(entry -> entry.getValue() > ZERO)
				.mapToLong(entry -> entry.getKey().getReward())
				.reduce(ZERO, Long::sum);
	}

	public double computeRateOfReturn(PurchaseStandBy purchaseStandBy) {
		long prizeRewardSum = this.getPrizeRewardSum();
		return (double) prizeRewardSum / (double) purchaseStandBy.getPurchasePrice();
	}

	private Map<PrizeGrade, Integer> getGroupByPrizeGrade(List<PrizeGrade> prizeGrades) {
		return Arrays.stream(PrizeGrade.values())
				.filter(prizeGrade -> prizeGrade != PrizeGrade.FAIL)
				.collect(Collectors.toMap(Function.identity(),
											prizeGrade -> countGivenPrizeGrade(prizeGrades, prizeGrade)));
	}

	private Integer countGivenPrizeGrade(List<PrizeGrade> prizeGrades, PrizeGrade prizeGrade) {
		return prizeGrades.stream()
				.filter(result -> result == prizeGrade)
				.map(result -> INCREASE)
				.reduce(ZERO, Integer::sum);
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

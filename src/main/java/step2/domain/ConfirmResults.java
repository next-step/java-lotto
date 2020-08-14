package step2.domain;

import step2.constants.PrizeGrade;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import static step2.constants.MessageConstant.PRIZE_STATISTICS_FORMAT;

public class ConfirmResults {

	private final List<ConfirmResult> confirmResults;

	private static final int ZERO = 0;
	private static final int INCREASE = 1;

	public ConfirmResults(List<ConfirmResult> confirmResults) {
		this.confirmResults = confirmResults;
	}

	public String getStatistics() {
		Map<PrizeGrade, Integer> group = getGroupByPrizeGrade();
		return getReportOfStatisticsEachGroup(group);

	}

	public int getPrizeRewardSum() {
		return confirmResults.stream()
							.mapToInt(ConfirmResult::getReward)
							.reduce(ZERO, Integer::sum);
	}

	private Map<PrizeGrade, Integer> getGroupByPrizeGrade() {
		return confirmResults.stream()
							.filter(confirmResult -> confirmResult.getPrizeGrade() != PrizeGrade.FAIL)
							.collect(Collectors.groupingBy(ConfirmResult::getPrizeGrade,
										Collectors.summingInt(confirmResult -> INCREASE)));
	}

	private String getReportOfStatisticsEachGroup(Map<PrizeGrade, Integer> group) {
		return group.entrySet()
				.stream()
				.sorted(Comparator.comparing(entry -> entry.getKey().getPrintOrder()))
				.map(entry -> {
					PrizeGrade prizeGrade = entry.getKey();
					return String.format(PRIZE_STATISTICS_FORMAT, prizeGrade.getMatchCount(), prizeGrade.getReward(), entry.getValue());
				})
				.collect(Collectors.joining("\n"));
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ConfirmResults that = (ConfirmResults) o;
		return confirmResults.equals(that.confirmResults);
	}

	@Override
	public int hashCode() {
		return Objects.hash(confirmResults);
	}
}

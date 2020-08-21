package lotto.ui;

import lotto.constants.RateOfReturn;
import lotto.domain.ConfirmResults;
import lotto.domain.LottoGames;
import lotto.domain.PrizeGrade;
import lotto.domain.PurchaseStandBy;
import lotto.ui.output.OutputChannel;

import java.util.Map;
import java.util.stream.Collectors;

import static lotto.constants.MessageConstant.*;

public class DisplayHere {

	private final OutputChannel outputChannel;

	public DisplayHere() {
		this.outputChannel = OutputChannel.getSystemOutChannel();
	}

	public void printPurchasedGames(PurchaseStandBy purchaseStandBy, LottoGames lottoGames) {
		outputChannel.printLine(String.format(PURCHASED_N_MANUAL_N_AUTO, purchaseStandBy.getManualGameCount(), purchaseStandBy.getAutoGameCount()));
		lottoGames.getLottoGames()
				.forEach(lottoGame -> outputChannel.printLine(lottoGame.toString()));
		outputChannel.printLine(NEW_LINE);
	}

	public void printPrizeStatistics(PurchaseStandBy purchaseStandBy, ConfirmResults confirmResults) {
		outputChannel.printLine(PRIZE_STATISTICS_HEADER);
		outputChannel.printLine(getReportOfStatisticsEachGroup(confirmResults.getGroupedByPrizeGrade()));
		double rateOfReturn = confirmResults.computeRateOfReturn(purchaseStandBy);
		outputChannel.printLine(String.format(RATE_OF_RETURN_FORMAT, rateOfReturn, RateOfReturn.of(rateOfReturn).getMessage()));
	}

	public void printErrorMessage(String message) {
		outputChannel.printError(message);
	}

	private String getReportOfStatisticsEachGroup(Map<PrizeGrade, Integer> group) {
		return group.entrySet()
				.stream()
				.sorted((entry1, entry2) -> Integer.compare(entry2.getKey().ordinal(),entry1.getKey().ordinal()))
				.map(entry -> {
					PrizeGrade prizeGrade = entry.getKey();
					return String.format(PRIZE_STATISTICS_FORMAT, formatPrizeExplain(prizeGrade), entry.getValue());
				})
				.collect(Collectors.joining(NEW_LINE));
	}

	private String formatPrizeExplain(PrizeGrade prizeGrade) {
		if(prizeGrade == PrizeGrade.SECOND) {
			return String.format(SECOND_PRIZE_EXPLAIN_FORMAT, prizeGrade.getMatchCount(), prizeGrade.getReward());
		}
		return String.format(PRIZE_EXPLAIN_FORMAT, prizeGrade.getMatchCount(), prizeGrade.getReward());
	}
}

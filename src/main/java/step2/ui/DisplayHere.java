package step2.ui;

import step2.constants.PrizeGrade;
import step2.domain.ConfirmResults;
import step2.domain.LottoGames;
import step2.domain.PurchaseStandBy;
import step2.ui.output.OutputChannel;

import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

import static step2.constants.MessageConstant.*;

public class DisplayHere {

	private final OutputChannel outputChannel;

	public DisplayHere() {
		this.outputChannel = OutputChannel.getSystemOutChannel();
	}

	public void printPurchasedGames(LottoGames lottoGames) {
		outputChannel.printLine(String.format(PURCHASED_N_COUNT, lottoGames.getGameSize()));
		lottoGames.getLottoGames()
				.forEach(lottoGame -> outputChannel.printLine(lottoGame.toString()));
		outputChannel.printLine(NEW_LINE);
	}

	public void printPrizeStatistics(PurchaseStandBy purchaseStandBy, ConfirmResults confirmResults) {
		outputChannel.printLine(PRIZE_STATISTICS_HEADER);
		outputChannel.printLine(getReportOfStatisticsEachGroup(confirmResults.getGroupedByPrizeGrade()));
		outputChannel.printLine(confirmResults.computeRateOfReturn(purchaseStandBy));
	}

	private String getReportOfStatisticsEachGroup(Map<PrizeGrade, Integer> group) {
		return group.entrySet()
				.stream()
				.sorted(Comparator.comparing(entry -> entry.getKey().getPrintOrder()))
				.map(entry -> {
					PrizeGrade prizeGrade = entry.getKey();
					return String.format(PRIZE_STATISTICS_FORMAT, prizeGrade.getMatchCount(), prizeGrade.getReward(), entry.getValue());
				})
				.collect(Collectors.joining(NEW_LINE));
	}
}
